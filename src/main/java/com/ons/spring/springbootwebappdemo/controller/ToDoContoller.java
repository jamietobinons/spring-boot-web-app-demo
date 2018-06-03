package com.ons.spring.springbootwebappdemo.controller;

import com.ons.spring.springbootwebappdemo.service.ToDoService;
import com.ons.spring.springbootwebappdemo.web.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;

/**
 * Created by tobinj on 31/05/2018.
 */
@Controller
@SessionAttributes("name")
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

        String name = (String) model.get("name");
        model.put("toDos", toDoService.retrieveToDos(name));

        return "list-todos";
    }

    @RequestMapping(value = "/add-todo", method= RequestMethod.GET)
    public String navigateAddToDo(ModelMap model){
        model.addAttribute("todo", new ToDo(0, (String) model.get("name"),
                "", new Date(), false));
        return "todo";
    }

    @RequestMapping(value = "/delete-todo", method= RequestMethod.GET)
    public String deleteToDo(@RequestParam int id){
        toDoService.deleteToDo(id);
        return "redirect:/list-todos";
    }

    // Now using a form bean (for todo) instead of using RequesParams
    @RequestMapping(value = "/add-todo", method= RequestMethod.POST)
    public String addToDo(ModelMap model, ToDo todo){

        // Add a new Todo
        String name = (String) model.get("name");
        toDoService.addToDo(name, todo.getDesc(), new Date(), false);

        return "redirect:/list-todos";
    }
}
