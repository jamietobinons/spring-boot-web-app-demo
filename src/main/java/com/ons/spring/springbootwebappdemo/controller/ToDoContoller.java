package com.ons.spring.springbootwebappdemo.controller;

import com.ons.spring.springbootwebappdemo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by tobinj on 31/05/2018.
 */
@Controller
public class ToDoContoller {

    // traditional way to initialise service.  Otherwise when try to use would
    // get a NULL pointer exception.
    //LoginService loginService = new LoginService();

    /* The dependency injection method requires the service to be
     * declared as a bean with the @Component annotation.
     * Then the LoginService can be injected using the Autowired annotation.
     */
    @Autowired
    ToDoService toDoService;

    @RequestMapping(value = "/list-todos", method= RequestMethod.GET)
    public String showToDos(ModelMap model){
        model.put("toDos", toDoService.retrieveToDos("test"));

        return "list-todos";
    }



}
