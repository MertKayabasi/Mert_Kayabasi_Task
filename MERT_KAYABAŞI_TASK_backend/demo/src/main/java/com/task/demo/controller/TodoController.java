package com.task.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.demo.entity.TodoEntity;
import com.task.demo.repository.TodoRepository;
import com.task.demo.service.TodoService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController{
	private final TodoService service;

    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }
    @GetMapping("/")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<TodoEntity> getAllTodos() {
        return service.listAllTasks();
    }
    @PostMapping("/addnew")
    public void addnew(@RequestBody TodoEntity task) {
        service.addTodo(task);
    }
	@PutMapping("/update/{id}")
	public void update(@PathVariable Integer id,@RequestBody TodoEntity task) {
		service.updateTodo(id, task);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable Integer id) {
	    try {
	        service.deleteTodoById(id);
	        return ResponseEntity.ok().build();
	    } catch (EntityNotFoundException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	    }
	}
}
