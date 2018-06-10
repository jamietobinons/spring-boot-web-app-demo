package com.ons.spring.springbootwebappdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by tobinj on 10/06/2018.
 */
@Controller("error")
public class ErrorController {

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView handleException(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("Exception", ex.getStackTrace());
        mv.addObject("url", request.getRequestURL());
        mv.setViewName("error");
        return mv;
    }
}
