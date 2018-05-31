package com.ons.spring.springbootwebappdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by tobinj on 31/05/2018.
 */
@Controller
public class LoginContoller {


    @RequestMapping(value = "/login", method= RequestMethod.GET)
    public String showLoginPage(){
        return "login";
    }

    @RequestMapping(value = "/login", method= RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String name){
        model.put("name",name);
        return "welcome";
    }

}
