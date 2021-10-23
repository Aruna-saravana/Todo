package com.online.todolist.entiy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "task_details")
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int task_id;

	@Column
	private String description;

	@Column
	private String isActive;

	@ManyToMany(mappedBy = "todos")
	private Set<User> users = new HashSet<>();

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		return Objects.equals(description, other.description) && Objects.equals(isActive, other.isActive)
				&& task_id == other.task_id && Objects.equals(users, other.users);
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, isActive, task_id);
	}

	@Override
	public String toString() {
		return "Todo [task_id=" + task_id + ", description=" + description + ", isActive=" + isActive + ", users="
				+ "]";
	}

}
