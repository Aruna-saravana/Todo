package com.online.todolist.request;

import lombok.Data;

@Data
public class TodoRequest {
	
	private int userId;
	
	private String description;
	
	private String isActive;

}
