package cn.windy.kernel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/400")
    public String badRequest(){
        return "error/400";
    }

    @GetMapping("/500")
    public String serverError(){
        return "error/400";
    }

    @GetMapping("/404")
    public String notFound(){
        return "error/400";
    }

}
