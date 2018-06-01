package com.ons.spring.springbootwebappdemo.service;

import com.ons.spring.springbootwebappdemo.web.ToDo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Business Service for toDos
@Service
public class ToDoService {
    private static List<ToDo> toDos = new ArrayList<ToDo>();
    private static int todoCount = 3;

    static {
        toDos.add(new ToDo(1, "test", "Learn Spring MVC", new Date(),
                false));
        toDos.add(new ToDo(2, "test", "Learn Struts", new Date(), false));
        toDos.add(new ToDo(3, "test", "Learn Hibernate", new Date(),
                false));
    }

    public List<ToDo> retrieveToDos(String user) {
        List<ToDo> filteredToDos = new ArrayList<ToDo>();
        for (ToDo todo : toDos) {
            if (todo.getUser().equals(user)) {
                filteredToDos.add(todo);
            }
        }
        return filteredToDos;
    }

    public void addToDo(String name, String desc, Date targetDate,
            boolean isDone) {
        toDos.add(new ToDo(++todoCount, name, desc, targetDate, isDone));
    }

    public void deleteToDo(int id) {
        Iterator<ToDo> iterator = toDos.iterator();
        while (iterator.hasNext()) {
            ToDo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }
}