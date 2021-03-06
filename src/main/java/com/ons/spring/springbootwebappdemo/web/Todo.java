package com.ons.spring.springbootwebappdemo.web;

/**
 * Created by tobinj on 01/06/2018.
 */

import javax.validation.constraints.Size;
import java.util.Comparator;
import java.util.Date;

public class Todo{

    private int id;
    private String user;
    @Size(min = 10, max = 35, message = "Must be between 10 and 35 characters")
    private String desc;
    private Date targetDate;
    private boolean isDone;

    public Todo(){
        super();
    }

    public Todo(int id, String user, String desc, Date targetDate,
                boolean isDone) {
        super();
        this.id = id;
        this.user = user;
        this.desc = desc;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Todo other = (Todo) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "Todo [id=%s, user=%s, desc=%s, targetDate=%s, isDone=%s]", id,
                user, desc, targetDate, isDone);
    }

    public static Comparator<Todo> descComparator = new Comparator<Todo>() {
        @Override
        public int compare(Todo todo1, Todo todo2) {
            return (int) (todo1.getDesc().compareTo(todo2.getDesc()));
        }
    };

}