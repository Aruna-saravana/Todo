package com.online.todolist.service;

import org.springframework.stereotype.Service;

import com.online.todolist.request.TodoRequest;
import com.online.todolist.response.TaskSetResponse;
import com.online.todolist.response.TodoResponse;

@Service
public interface TodoService {

	public TodoResponse addTodoList(TodoRequest request);

	public TaskSetResponse getAllTasks(int userId);

	public TodoResponse uncheckTask(int taskId, boolean check);

}
