package com.online.todolist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.todolist.entiy.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
