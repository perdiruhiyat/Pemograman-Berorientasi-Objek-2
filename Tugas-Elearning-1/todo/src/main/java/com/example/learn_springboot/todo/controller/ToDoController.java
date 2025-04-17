package com.example.learn_springboot.todo.controller;

import com.example.learn_springboot.todo.model.ToDo;
import com.example.learn_springboot.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.Date;
 
 @Controller
 @RequestMapping("/")
 public class ToDoController {
 
     @Autowired
     private ToDoService toDoService;
 
     @GetMapping
     public String home(Model model) {
         model.addAttribute("todos", toDoService.getAllTodos());
         model.addAttribute("newTodo", new ToDo());
         return "index";
     }
 
     @PostMapping("/add")
     public String addTodo(@RequestParam String task, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date deadline) {
         ToDo todo = new ToDo();
         todo.setTask(task);
         todo.setDeadline(deadline);
         todo.setCompleted(false);
         toDoService.saveTodo(todo);
         return "redirect:/";
     }
     
     @PostMapping("/delete/{id}")
     public String deleteTodo(@PathVariable Long id) {
         toDoService.deleteTodo(id);
         return "redirect:/";
     }
 
     @PostMapping("/update/{id}")
     public String updateTodo(@PathVariable Long id) {
         Optional<ToDo> todo = toDoService.getTodoById(id);
         todo.ifPresent(t -> {
             t.setCompleted(!t.isCompleted());
             toDoService.saveTodo(t);
         });
         return "redirect:/";
     }
 }