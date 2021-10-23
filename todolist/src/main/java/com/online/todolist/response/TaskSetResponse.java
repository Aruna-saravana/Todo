package com.online.todolist.response;

import java.util.Set;

import com.online.todolist.dto.TodoDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class TaskSetResponse extends TodoResponse{
	
	private int userId;
	
	private Set<TodoDto> todoSet;

}
