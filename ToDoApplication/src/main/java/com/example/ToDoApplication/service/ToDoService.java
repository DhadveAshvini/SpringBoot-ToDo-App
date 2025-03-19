package com.example.ToDoApplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToDoApplication.Repo.ToDoRepository;
import com.example.ToDoApplication.model.ToDoModel;

@Service
public class ToDoService {
	
	@Autowired
	public ToDoRepository repo;
	
	 public List<ToDoModel> getAllToDoItems(){
		ArrayList<ToDoModel>	todoList=new ArrayList<>();
		repo.findAll().forEach(todo -> todoList.add(todo));
		return todoList;
	}
	
	public ToDoModel getToDoItemsById(Long id){
		
		return repo.findById(id).get();
		
	}
	
	 public boolean updateStatus(Long id) {
		 ToDoModel todo= getToDoItemsById(id);
		 todo.setStatus("Completed....");
		 
		 return saveOrUpdateToDoItems(todo);
		}
		
	
	 
public	boolean saveOrUpdateToDoItems(ToDoModel todo){
	ToDoModel updatedObj =repo.save(todo);
	if (getToDoItemsById(updatedObj.getId())!=null){
		return true;
	}
	return false;
	}
	
	public  boolean deleteToDoItems(Long id){
		repo.deleteById(id);
		
		if(getToDoItemsById(id)==null) {
			return true;
		}
		return false;
	}
	

}
