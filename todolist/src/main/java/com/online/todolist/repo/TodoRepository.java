package com.online.todolist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.todolist.entiy.Todo;


@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>{

}
