package com.example.ToDoApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ToDoApplication.model.ToDoModel;
import com.example.ToDoApplication.service.ToDoService;

@Controller
public class ToDoController {
	
	@Autowired
	private ToDoService service;
	
	
	@GetMapping("/vieToDoList")
	public String viewAllToDoItems(Model model, @ModelAttribute("message") String message) {
		model.addAttribute("list",service.getAllToDoItems());
		model.addAttribute("message",message);
		return "ViewToDoList";
		
		
	}
	
	@PostMapping("/updateToDoStatus/{id}")
	public String updateToDoSatus(@PathVariable Long id,RedirectAttributes redirect) {
		if(service.updateStatus(id)) {
			redirect.addFlashAttribute("message","Updatd sucessfully");
			return "redirect:/ViewToDoList";
		}
		redirect.addFlashAttribute("message","Not Updated ");
		return "redirect:/ViewToDoList";
	}
	
	@GetMapping("/addToDoItems")
	public String addToDoItems(Model model) {
		model.addAttribute("todo", new ToDoModel());
		return "AddToDoItem";//this is page name
		
	}
	
	@PostMapping("/saveToDoItem")
	public String saveToDoItem(ToDoModel todo,RedirectAttributes redirect) {
		if(service.saveOrUpdateToDoItems(todo)) {
			redirect.addFlashAttribute("message", "Save Sucess");
			return "redirect:/ViewToDoList";
		}
		redirect.addFlashAttribute("message", "Save Failure");
		return "redirect:/addToDoList";
	}
	@GetMapping("/editToDoItems/{id}")
	public String editToDoItems(@PathVariable Long id,Model model) {
		model.addAttribute("todo", 	service.getToDoItemsById(id));
		return"EditToDoItems";
		
	}
	@PostMapping("/editSaveToDoItems")
	public String editSaveToDoItems(ToDoModel todo,RedirectAttributes redirect) {
		
		if(service.saveOrUpdateToDoItems(todo)) {
			redirect.addFlashAttribute("message", "Edit Sucess");
			return "redirect:/ViewToDoList";
		}
		redirect.addFlashAttribute("message", "Edit Failure");
		return "redirect:/addToDoList";
		
	}
	@GetMapping("/deleteToDoItems/{id}")
	public String deleteToDoItems(@PathVariable Long id,RedirectAttributes redirect) {
		
		if(service.deleteToDoItems(id)) {
			redirect.addFlashAttribute("message", "Delete Sucess");
		}
		redirect.addFlashAttribute("message", "Delete Failure");
		return "redirect:/ViewToDoList";
	}
	
	
	
	
	

}
