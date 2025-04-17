package com.example.learn_springboot.todo.model;

import jakarta.persistence.*;
import java.util.Date; 
 @Entity
 @Table(name = "todos")
 public class ToDo {
     
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     
     private String task;
     private boolean completed;
 
     public ToDo() {}
 
     public ToDo(String task, boolean completed) {
         this.task = task;
         this.completed = completed;
     }

     @Temporal(TemporalType.DATE)
     private Date deadline;

 
     public Long getId() {
         return id;
     }
 
     public void setId(Long id) {
         this.id = id;
     }
 
     public String getTask() {
         return task;
     }
 
     public void setTask(String task) {
         this.task = task;
     }
 
     public boolean isCompleted() {
         return completed;
     }
 
     public void setCompleted(boolean completed) {
         this.completed = completed;
     }

     public Date getDeadline() {
        return deadline;
    }
    
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
    
 }