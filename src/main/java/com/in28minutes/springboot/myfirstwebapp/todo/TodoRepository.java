package com.in28minutes.springboot.myfirstwebapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Integer>{
	public List<Todo> findByUsername(String Username); // Here I make one custom method to get the details of the user by its name	
}
