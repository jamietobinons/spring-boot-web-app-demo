package com.ons.spring.springbootwebappdemo.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by tobinj on 31/05/2018.
 */
@Controller
public class WelcomeContoller {

    // traditional way to initialise service.  Otherwise when try to use would
    // get a NULL pointer exception.
    //LoginService loginService = new LoginService();

    /* The dependency injection method requires the service to be
     * declared as a bean with the @Component annotation.
     * Then the LoginService can be injected using the Autowired annotation.
     */

    @RequestMapping(value = "/", method= RequestMethod.GET)
    public String showWelcomePage(ModelMap model){
        model.put("name", getLoggedInUserName());

        return "welcome";

    }

    private String getLoggedInUserName(){

        Object principal = SecurityContextHolder.getContext().
                getAuthentication().getPrincipal();

        if (principal instanceof UserDetails){
            return ((UserDetails) principal).getUsername();
        }

        return principal.toString();
    }

}
