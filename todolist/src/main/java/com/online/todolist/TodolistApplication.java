package com.online.todolist;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.online.todolist.entiy.User;
import com.online.todolist.repo.UserRepository;

@SpringBootApplication
public class TodolistApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setUser_id(1);
		user.setEmailId("test@db.com");
		user.setName("test");
		user.setTodos(new HashSet<>());
		userRepo.save(user);

		User user1 = new User();
		user1.setUser_id(2);
		user1.setEmailId("test1@db.com");
		user1.setName("test1");
		user1.setTodos(new HashSet<>());
		userRepo.save(user1);
	}

}
