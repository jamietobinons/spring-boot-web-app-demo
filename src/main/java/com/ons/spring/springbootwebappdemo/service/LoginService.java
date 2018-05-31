package com.ons.spring.springbootwebappdemo.service;

import org.springframework.stereotype.Component;

/**
 * Created by tobinj on 31/05/2018.
 */
/*
 * Need to tell Spring that this is a bean.
 * This will allow the service to be injected at some point.

 * Could also create this as an interface and then have multiple
 * instances of the interface, which would then be autowired at
 * runtime.
 */
@Component
public class LoginService {

    public boolean validateUser (String username, String password){

        return (username.equalsIgnoreCase("test")
                && password.equalsIgnoreCase("test"));
    }
}
