package com.task.demo.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.demo.entity.TodoEntity;
import com.task.demo.repository.TodoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TodoService {
	private final TodoRepository repo;
	 @Autowired
	    public TodoService(TodoRepository repo) {
	        this.repo = repo;
	    }
	 
	 	public TodoEntity addTodo(TodoEntity todoEntity) {
	        return repo.save(todoEntity);
	 	}
	 	

	 	 
	 	public List<TodoEntity> listAllTasks() {
	 	    List<TodoEntity> todoEntities = repo.findAll();
	 	    return todoEntities.stream()
	 	                       .sorted(Comparator.comparingInt(TodoEntity::getId))
	 	                       .collect(Collectors.toList());
	 	}
	 	
	 	public void deleteTodoById(Integer id) {
	 	    Optional<TodoEntity> todoEntity = repo.findById(id);
	 	    if (todoEntity.isPresent()) {
	 	        repo.delete(todoEntity.get());
	 	    } else {
	 	        throw new EntityNotFoundException("TodoEntity not found with id " + id);
	 	    }
	 	}
	     
	     public TodoEntity updateTodo(int id, TodoEntity newD) {
	    	 TodoEntity exist = repo.findById(id).orElse(null);
	         if (exist != null) {
	             exist.setTask(newD.getTask());
	             exist.setCompleted(newD.isCompleted());
	             return repo.save(exist);
	         } else {
	             throw new EntityNotFoundException("job not found with id: " + id);
	         }
	    	 
	    	 
	    	
	     }

}
