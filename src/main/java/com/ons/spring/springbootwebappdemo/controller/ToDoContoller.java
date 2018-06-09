package com.ons.spring.springbootwebappdemo.controller;

import com.ons.spring.springbootwebappdemo.service.ToDoService;
import com.ons.spring.springbootwebappdemo.web.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
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
    ToDoService todoService;

    /* From now on use this Date format wherever a Date Binding is formed.
    *  This will be used for the Date class.
    * */
    @InitBinder
    public void initBinder(WebDataBinder binder){
        // Specify the date format for use.
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }

    @RequestMapping(value = "/list-todos", method= RequestMethod.GET)
    public String showToDos(ModelMap model){

        String name = getLoggedInUserName(model);
        model.put("todos", todoService.retrieveToDos(name));

        return "list-todos";
    }

    private String getLoggedInUserName(ModelMap model) {
        return (String) model.get("name");
    }

    @RequestMapping(value = "/add-todo", method= RequestMethod.GET)
    public String navigateAddToDo(ModelMap model){
        model.addAttribute("todo", new Todo(0, (String) model.get("name"),
                "", new Date(), false));
        return "todo";
    }

    @RequestMapping(value = "/update-todo", method= RequestMethod.GET)
    public String showUpdateToDo(@RequestParam int id, ModelMap model){
        Todo todo = todoService.retrieveToDo(id);
        System.out.println("showUpdateTodo :: id = [" + id + "]");
        model.put("todo", todo);

        return "todo";
    }

    @RequestMapping(value = "/update-todo", method= RequestMethod.POST)
    public String updateToDo(ModelMap model, @Valid Todo todo,
    BindingResult result){

        if(result.hasErrors()){
            System.out.println("Binding result = " + result.toString());
            return "todo";
        }

        todo.setUser((String) model.get("name"));

        todoService.updateToDo(todo);
        todoService.sortTodos();

        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/delete-todo", method= RequestMethod.GET)
    public String deleteToDo(@RequestParam int id){

        todoService.deleteToDo(id);

        return "redirect:/list-todos";
    }

    // Now using a form bean (for Todo) instead of using RequesParams
    @RequestMapping(value = "/add-todo", method= RequestMethod.POST)
    public String addToDo(ModelMap model, @Valid Todo todo, BindingResult result){

        if(result.hasErrors()){
            System.out.println("Binding result = " + result.toString());
            return "todo";
        }

        // Add a new Todo
        String name = getLoggedInUserName(model);
        todoService.addToDo(name, todo.getDesc(), todo.getTargetDate(), false);

        return "redirect:/list-todos";
    }
}
