package cn.java68.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping
@Controller
public class HelloWorldController {

    @ResponseBody
    @RequestMapping(value = "/hello")
    public String helloworld(){
       return "helloworld,你好世界";
    }
}
