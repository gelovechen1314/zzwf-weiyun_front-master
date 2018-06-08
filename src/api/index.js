import Axios from "axios";
import Store from "STORE";
import Router from "ROUTER";

export {URL} from './url'

Axios.defaults.timeout = 30000;
Axios.defaults.baseURL = API_URL;

export const api = {
  get(url, is_show_loading = true, loading_msg = ''){ //get请求
    // console.log(is_show_loading);
    let config = {loading_msg: loading_msg, 'is_show_loading': is_show_loading};
    return Axios.get(dealUrl(url), config);
  },
  post(url, data = {}, is_show_loading = true, loading_msg = ''){ //post请求
    // console.log(data);
    let config = {loading_msg: loading_msg, 'is_show_loading': is_show_loading};
    return Axios.post(dealUrl(url), data, config);
  }
}

function dealUrl(url) {
  if (!url) {
    console.log("url未定义", "api");
    return;
  }
  if (url.indexOf("?") == -1) {
    url += "?sessionid=" + localStorage.getItem("sessionid");
  } else {
    url += "&&sessionid=" + localStorage.getItem("sessionid");
  }
  return url;
}

Axios.interceptors.request.use(function (config) {
  if (config.is_show_loading) {
    Store.commit("SHOW_LOADING", config.loading_msg);
  }
  return config;
}, function (error) {
  Store.commit("HIDE_LOADING");
  window.toast("网络请求失败，请检查你的网络!!");
  return Promise.reject(error);
});

Axios.interceptors.response.use(function (response) {
  Store.commit("HIDE_LOADING");
  if (response.status === 200) {  //status >= 200 && status < 300;
    let resultData = response.data; //取出json数据
    if (resultData.response === 'ok') {
      return Promise.resolve(resultData.data);//在此处直接将json内的data取出
    }
    else {  //resultData.response === 'fail'
      if (resultData.error === 'no_user') { //1.账号会话过期，除登陆接口 都可能出现
        console.log('no_user', 'api');
        window.toast(resultData.message);
        Router.replace("/account_auth");
        return Promise.reject('用户不存在！');
      } else {
        if (resultData.error === 'no_attendance') { //未点名
          resultData.message = resultData.error;
        }
        if (resultData.error === 'leave') { //请假
          resultData.message = resultData.error;
        }
        console.log(resultData.message, 'api');
        if (response.config.url.indexOf('auth') == -1) {
          window.toast(resultData.message);
        }
        return Promise.reject(resultData.message);
      }
    }
  }
  else {
    Store.commit("HIDE_LOADING");
    window.toast("网络请求失败，请检查你的网络!!!");    //应该很少会被调用
    return Promise.reject(response);
  }
}, function (error) {   //404、500都走这里，断网也走这里
  Store.commit("HIDE_LOADING");
  window.toast("网络请求失败，请检查你的网络!");
  console.log(error, 'api 404、500；断网；CMCC之类的wifi'); //todo(songyapeng) 2017/5/9 弹出请求失败的响应码
  return Promise.reject();
});
