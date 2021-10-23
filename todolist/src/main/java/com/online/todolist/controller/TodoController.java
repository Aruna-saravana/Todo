package com.online.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.online.todolist.request.TodoRequest;
import com.online.todolist.response.TaskSetResponse;
import com.online.todolist.response.TodoResponse;
import com.online.todolist.service.TodoService;

@RestController
public class TodoController {

	@Autowired
	TodoService todoService;

	@PostMapping
	public ResponseEntity<TodoResponse> addTask(@RequestBody TodoRequest request) {

		return new ResponseEntity<TodoResponse>(todoService.addTodoList(request), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<TaskSetResponse> getAllTasks(@RequestParam String userId) {
		return new ResponseEntity<TaskSetResponse>(todoService.getAllTasks(Integer.valueOf(userId)), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<TodoResponse> uncheckTask(@RequestParam String taskId, @RequestParam boolean check) {
		return new ResponseEntity<TodoResponse>(todoService.uncheckTask(Integer.valueOf(taskId), check), HttpStatus.OK);
	}

}
