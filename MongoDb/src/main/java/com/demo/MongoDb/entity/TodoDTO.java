package com.demo.MongoDb.entity;

import java.sql.Date;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="todos")
public class TodoDTO {
	public TodoDTO() {
		// TODO Auto-generated constructor stub
	}
	public TodoDTO(String id, String todo, String description, Boolean completed, Date createdAt, Date updatedAt) {
		this.id = id;
		this.todo = todo;
		this.description = description;
		this.completed = completed;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	@Id
	private String id;

	@NotNull(message="todo cannot be null")
	private String todo;

	@NotNull(message="Description cannot be null")
	private String description;

	@NotNull(message="Completed cannot be null")
	private Boolean completed;

	private Date createdAt;
	private Date updatedAt;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
