package com.ons.spring.springbootwebappdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by tobinj on 31/05/2018.
 */
@Controller
public class LoginContoller {


    @RequestMapping(value = "/login")
    public String loginMessage(@RequestParam String name, ModelMap model){
        model.put("name", name);
        System.out.println("Name is " + name);
        return "login";
    }

}
