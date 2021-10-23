package com.online.todolist.serviceimpl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.online.todolist.constant.TodoConstant;
import com.online.todolist.dto.TodoDto;
import com.online.todolist.entiy.Todo;
import com.online.todolist.entiy.User;
import com.online.todolist.repo.TodoRepository;
import com.online.todolist.repo.UserRepository;
import com.online.todolist.request.TodoRequest;
import com.online.todolist.response.TaskSetResponse;
import com.online.todolist.response.TodoResponse;
import com.online.todolist.service.TodoService;

@Component
public class TodoSericeImpl implements TodoService {

	@Autowired
	TodoRepository todoRepo;

	@Autowired
	UserRepository userRepo;

	@Override
	@Transactional
	public TodoResponse addTodoList(TodoRequest request) {
		Optional<User> oUser = userRepo.findById(request.getUserId());
		User user = oUser.get();
		Todo todo = new Todo();
		todo.setDescription(request.getDescription());
		todo.setIsActive(request.getIsActive());
		user.getTodos().add(todo);
		todo.getUsers().add(user);
		userRepo.save(user);
		TodoResponse res = new TodoResponse();
		res.setMessage(TodoConstant.TASK_SUCCESS__ADD_MESSAGE);
		return res;
	}

	@Override
	public TaskSetResponse getAllTasks(int userId) {
		TaskSetResponse task = new TaskSetResponse();
		Optional<User> oUser = userRepo.findById(userId);
		User user = oUser.get();
		Set<Todo> todoSet = user.getTodos();
		Set<TodoDto> finalTodo = new HashSet<>();
		if (user != null) {
			for (Todo todo : todoSet) {
				// check active status
				if (todo != null) {
					TodoDto tDto = new TodoDto();
					tDto.setDescription(todo.getDescription());
					tDto.setIsActive(todo.getIsActive());
					tDto.setTask_id(todo.getTask_id());
					finalTodo.add(tDto);
				}

			}
			task.setTodoSet(finalTodo);
			task.setUserId(userId);

		}
		task.setMessage(TodoConstant.TASK_LIST_MESSAGE);
		return task;
	}

	@Override
	@Transactional
	public TodoResponse uncheckTask(int taskId, boolean check) {
		Optional<Todo> oTodo = todoRepo.findById(taskId);
		boolean dbStatus;
		Todo todo = oTodo.get();
		TodoResponse res = new TodoResponse();
		if (todo.getIsActive() == "Y") {
			dbStatus = true;
		} else {
			dbStatus = false;
		}
		if (dbStatus == true && dbStatus == check) {
			res.setMessage(TodoConstant.TASK_ALREADY_CHECKED_MESSAGE);
		} else if (dbStatus == false && dbStatus == check) {
			res.setMessage(TodoConstant.TASK_ALREADY_UNCHECKED_MESSAGE);
		} else {
			if (check) {
				todo.setIsActive("Y");
				todoRepo.save(todo);
				res.setMessage(TodoConstant.TASK_CHECKED_MESSAGE);
			} else {
				todo.setIsActive("N");
				todoRepo.save(todo);
				res.setMessage(TodoConstant.TASK_UNCHECKED_MESSAGE);
			}

		}
		return res;
	}

}
