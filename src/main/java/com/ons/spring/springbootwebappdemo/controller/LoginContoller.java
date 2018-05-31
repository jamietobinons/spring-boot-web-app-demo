package com.ons.spring.springbootwebappdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tobinj on 31/05/2018.
 */
@Controller
public class LoginContoller {
    @RequestMapping(value = "/login")
    @ResponseBody
    public String sayHello(){
        return "Dummy landing login page......";
    }

}
