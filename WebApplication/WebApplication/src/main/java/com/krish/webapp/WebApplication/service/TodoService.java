package com.krish.webapp.WebApplication.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Component;
import com.krish.webapp.WebApplication.model.Todo;
@Component
public class TodoService {
	
	//to generate static data as no db connected till now
	private static List<Todo> todos = new ArrayList<Todo>();
	//as I will insert 3 values, then CRUD operation will be executed
	private static long todoCount = 3;
	//Data creation
	static {
		todos.add(new Todo(1,"krik","Learn Spring Boot",new Date(),false));
		todos.add(new Todo(2,"krik","Learn Microservices",new Date(),false));
		todos.add(new Todo(3,"krik","Learn Spring Cloud",new Date(),false));
	}
	
	//CRUD operation logic
	
	//To add activity
	public void addTodo(String name,String desc,Date date,boolean isDone) {
		todos.add(new Todo(++todoCount,name,desc,date,isDone));
	}
	
	//To delete activity
	public void deleteTodo(long id) {
		Iterator<Todo> iterator = todos.iterator();
		while(iterator.hasNext()) {
			Todo todo = iterator.next();
			if(todo.getId() == id) {
				iterator.remove();
			}
		}
	}
	
	//To retrieve list
	public List<Todo> listTodos(String user){
		List<Todo> listOfTodos = new ArrayList<Todo>();
		for(Todo todoObj : todos) {
			if(todoObj.getUser().equalsIgnoreCase(user)) {
				listOfTodos.add(todoObj);
			}
			
		}
		return listOfTodos;
	}
	
	//for update 
	public Todo updateTodo(long id) { 
		Todo flagObj = null; 
		for(Todo todoObj : todos) {
			if(todoObj.getId() == id) { 
				flagObj = todoObj; 
			} 
		} 
		return flagObj; }
	 
	
	public void updateTodo(Todo todo) {
		todos.remove(todo);
		todos.add(todo);
	}

}
