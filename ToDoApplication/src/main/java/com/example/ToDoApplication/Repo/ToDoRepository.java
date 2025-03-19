package com.example.ToDoApplication.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ToDoApplication.model.ToDoModel;

@Repository
public interface ToDoRepository  extends JpaRepository<ToDoModel, Long>{

}
