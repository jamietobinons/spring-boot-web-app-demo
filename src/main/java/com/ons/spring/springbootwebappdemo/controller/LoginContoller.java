package com.ons.spring.springbootwebappdemo.controller;

import com.ons.spring.springbootwebappdemo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by tobinj on 31/05/2018.
 */
@Controller
@SessionAttributes("name")
public class LoginContoller {

    // traditional way to initialise service.  Otherwise when try to use would
    // get a NULL pointer exception.
    //LoginService loginService = new LoginService();

    /* The dependency injection method requires the service to be
     * declared as a bean with the @Component annotation.
     * Then the LoginService can be injected using the Autowired annotation.
     */
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/", method= RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        model.put("name", "test");

        return "welcome";

    }

}
