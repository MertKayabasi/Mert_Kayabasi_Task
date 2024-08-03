package com.task.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class TodoEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
	private int id;
	private String task;
	private boolean completed;
	
	public TodoEntity() {
		
	}
	 public TodoEntity(int id,String task,boolean completed) {
		 this.id = id;
		 this.task = task;
		 this.completed=completed;
	
	}
	 public boolean isCompleted() {
			return completed;
		}
		public void setCompleted(boolean completed) {
			this.completed = completed;
		}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}
	
	

}
