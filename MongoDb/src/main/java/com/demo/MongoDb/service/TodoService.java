package com.demo.MongoDb.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import com.demo.MongoDb.entity.TodoDTO;
import com.demo.MongoDb.exception.MessageException;

public interface TodoService {
	public void createTodo(TodoDTO todo) throws MessageException, ConstraintViolationException;

	public List<TodoDTO> getAllTodos();

	public TodoDTO getSingleTodo(String id) throws MessageException;

	public void updateTodo(String id, TodoDTO todo) throws MessageException;

	public void deleteTodo(String id) throws MessageException;
}
