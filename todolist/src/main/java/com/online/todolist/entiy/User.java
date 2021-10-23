package com.online.todolist.entiy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_details")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;

	@Column(name = "name")
	private String name;

	@Column(name = "email_id")
	private String emailId;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_task", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"), inverseJoinColumns = @JoinColumn(name = "task_id", referencedColumnName = "task_id"))
	private Set<Todo> todos = new HashSet<>();

	public void addTask(Todo todo) {
		this.todos.add(todo);
		todo.getUsers().add(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(emailId, other.emailId) && Objects.equals(name, other.name)
				&& Objects.equals(todos, other.todos) && user_id == other.user_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(emailId, name, user_id);
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", emailId=" + emailId + ", todos=" + "]";
	}

}
