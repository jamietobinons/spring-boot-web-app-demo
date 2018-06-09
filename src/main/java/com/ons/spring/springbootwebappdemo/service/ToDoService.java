package com.ons.spring.springbootwebappdemo.service;

import com.ons.spring.springbootwebappdemo.web.Todo;
import org.springframework.stereotype.Service;

import java.util.*;

// Business Service for Todos
@Service
public class ToDoService {
    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(1, "test", "Learn Spring MVC", new Date(),
                false));
        todos.add(new Todo(2, "test", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "test", "Learn Hibernate", new Date(),
                false));
        Collections.sort(todos, Todo.descComparator);

    }

    public Todo retrieveToDo(int id) {
        for (Todo todo : todos) {
            if (todo.getId()==(id)) {
                return todo;
            }
        }
        return null; // return null if no matching Todo found
    }

    public List<Todo> retrieveToDos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public void addToDo(String name, String desc, Date targetDate,
            boolean isDone) {
        todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
    }

    public void deleteToDo(int id) {
        System.out.println("[1...");
        Iterator<Todo> iterator = todos.iterator();
        System.out.println("[2...");
        while (iterator.hasNext()) {
            System.out.println("[3...");
            Todo todo = iterator.next();
            System.out.println("[4...");
            if (todo.getId() == id) {
                System.out.println("[5...");
                iterator.remove();
                System.out.println("[6...");
            }
        }
    }

    public void updateToDo(Todo todo) {
        todos.remove(todo);
        todos.add(todo);

    }

    public void sortTodos(){
        Collections.sort(todos, Todo.descComparator);
    }

}