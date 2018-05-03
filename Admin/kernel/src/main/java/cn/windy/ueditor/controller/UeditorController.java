package cn.windy.ueditor.controller;

import cn.windy.kernel.controller.BaseController;
import cn.windy.ueditor.ActionEnter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@RestController
@CrossOrigin
@RequestMapping("/ueditor")
public class UeditorController extends BaseController{

    @RequestMapping(value = "/exec")
    @ResponseBody
    public String exec(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        String rootPath = "D:\\Projects\\icp_web\\icpWeb\\static\\upload\\";//request.getRealPath("/");
        String result = new ActionEnter( request, rootPath).exec();
        return result;
    }

}
