package com.ons.spring.springbootwebappdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tobinj on 31/05/2018.
 */
@Controller
public class LoginContoller {
    @RequestMapping(value = "/login")
    public String loginMessage(){
        return "login";
    }

}
