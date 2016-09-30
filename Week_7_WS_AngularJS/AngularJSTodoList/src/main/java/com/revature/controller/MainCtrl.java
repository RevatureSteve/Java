package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.Todo;
import com.revature.service.TodoService;

@RestController
public class MainCtrl {

	@Autowired
	TodoService todoServiceImpl;
	
	@RequestMapping(value={"/save","/update"}, method=RequestMethod.POST,
			
			consumes=MediaType.APPLICATION_JSON_VALUE,
			
			produces=MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<Todo> handleTodo(@RequestBody Todo todo){
		System.out.println("save post " + todo);
		
		todoServiceImpl.save(todo);
		
		return new ResponseEntity<Todo>(todo,HttpStatus.OK);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Exception> handleException(Exception e){
		System.out.println("lol spring...wow catches exceptions");
		return new ResponseEntity<Exception>(e,HttpStatus.CONFLICT);
	}
	
}
