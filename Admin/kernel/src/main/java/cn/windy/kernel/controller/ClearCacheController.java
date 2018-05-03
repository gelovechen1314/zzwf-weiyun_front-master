package cn.windy.kernel.controller;


import cn.windy.annotation.Cache;
import cn.windy.kernel.vo.Result;
import cn.windy.util.ScanAllClasses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@RestController
@RequestMapping("/kernel/cache")
public class ClearCacheController extends BaseController {

    @RequestMapping("/clear")
    public Result clear(){
        ScanAllClasses sac = new ScanAllClasses("cn.windy");
        List<Class<?>> list = sac.get();
        for (Class<?> clazz : list) {
            Cache cache = clazz.getAnnotation(Cache.class);
            if(cache!=null){
                try {
                    Method method = clazz.getDeclaredMethod("clear");
                    method.invoke(null); //因为是静态方法，所以这个参数可以传入null

                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        Result result = new Result();
        result.setMessage("已经清除所有缓存。");
        return result;
    }

}
