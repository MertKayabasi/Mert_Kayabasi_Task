package com.task.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.demo.entity.TodoEntity;
@Repository
public interface TodoRepository extends JpaRepository<TodoEntity,Integer>{

}
