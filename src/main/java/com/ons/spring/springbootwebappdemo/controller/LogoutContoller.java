package com.ons.spring.springbootwebappdemo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by tobinj on 31/05/2018.
 */
@Controller
public class LogoutContoller {



    @RequestMapping(value = "/logout", method= RequestMethod.GET)
    public String showWelcomePage(HttpServletRequest request,
                                  HttpServletResponse response){
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null){
            new SecurityContextLogoutHandler().logout(request,
                    response, authentication);
        }

        return "redirect:/";

    }

}
