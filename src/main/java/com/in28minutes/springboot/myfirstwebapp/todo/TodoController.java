package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
//@SessionAttributes("name")
public class TodoController {
   /// list-todos
	
	private TodoService todoService;
	
//	here i do the autowiing
	public TodoController(TodoService todoService) {
	super();
	this.todoService = todoService;
}
	
//	method to fetch the list of all the users
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) { //modelMap basically we use for the 
		String username=getLoggedInUsername(model);
	List<Todo> todos=	todoService.findByUsername(username);
	model.addAttribute("todos",todos);
		return "listTodos";
	}

	
	@RequestMapping(value="add-todo",method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username=getLoggedInUsername(model);
		Todo todo=new Todo(0,username,"Default description",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "todo";
	}
	
//	@RequestMapping(value="add-todo",method=RequestMethod.POST)
//	public String addNewTodoPage(@RequestParam String description,ModelMap model) {
//		String username=(String)model.get("name");
//		todoService.addTodo(username, description, LocalDate.now().plusYears(1), false);
//		return "redirect:list-todos";
//	}
	
	
	
	
	
//	here i do the concept of two-way binding (form backing object)
	@RequestMapping(value="add-todo",method=RequestMethod.POST)
	public String addNewTodoPage(ModelMap model,@Valid Todo todo,BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username=getLoggedInUsername(model);
		todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todos";
	}
	
	
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		
//		here i write the logc to delete the todo
		todoService.deleteById(id);
	 return "redirect:list-todos";
	}
	
	
	@RequestMapping(value="update-todo",method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id,ModelMap model) {
		
//		here i write the logic for updating the todo
		Todo todo=todoService.findById(id);
		model.addAttribute("todo",todo);
	 return "todo";
	}
	
//	here i write the logic for the saving the update 
	@RequestMapping(value="update-todo",method=RequestMethod.POST)
	public String updateTodo(ModelMap model,@Valid Todo todo,BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username=getLoggedInUsername(model);
		todo.setUsername(username);
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
	private String getLoggedInUsername(ModelMap model) {
		org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
}
