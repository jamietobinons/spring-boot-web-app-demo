package com.ons.spring.springbootwebappdemo.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by tobinj on 09/06/2018.
 */
public class GetLoggedInUser {

    static public String getLoggedInUserName(){

        Object principal = SecurityContextHolder.getContext().
                getAuthentication().getPrincipal();

        if (principal instanceof UserDetails){
            return ((UserDetails) principal).getUsername();
        }


        return principal.toString();
    }
}
