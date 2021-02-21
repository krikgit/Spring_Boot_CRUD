package com.krish.webapp.WebApplication.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.krish.webapp.WebApplication.model.Todo;
import com.krish.webapp.WebApplication.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@RequestMapping(value="/list-todo",method=RequestMethod.GET)
	public String showTodo(ModelMap model) {
		String name = (String) model.get("name");
		model.put("activities", todoService.listTodos(name));
		return "todo";
	}
	//reading data
	@RequestMapping(value="/add-todo",method=RequestMethod.GET)
	public String addTodo(ModelMap model) {
		String name = (String) model.get("name");
		model.addAttribute("todo", new Todo(0, name, "Default Desc",new Date(), false));
		return "add";
	}
	//creating data
	@RequestMapping(value="/add-todo",method=RequestMethod.POST)
	public String storeTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "add";
		}
		
		String name = (String) model.get("name");
		todoService.addTodo(name, todo.getDesc(),todo.getTargetDate(), false);
		return "redirect:/list-todo";
	}
	
	//delete for id
	@RequestMapping(value="/deleteAct",method=RequestMethod.GET)
	public String delTodo(ModelMap model,@RequestParam long id) {
		todoService.deleteTodo(id);
		return "redirect:/list-todo";
	}
	
	//update data
	@RequestMapping(value="/updateAct",method=RequestMethod.GET)
	public String showUpdateTodo(@RequestParam long id, ModelMap model) {
		Todo todo = todoService.updateTodo(id);
		model.put("todo", todo );
		return "add";
	}
	
	@RequestMapping(value="/updateAct",method=RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "add"; 
		}
		
		todo.setUser((String)model.get("name"));		
		todoService.updateTodo(todo);
		return "redirect:/list-todo";
	}
	//adding update of target date i.e. date binder
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
}
