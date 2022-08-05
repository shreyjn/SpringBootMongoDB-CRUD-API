package com.demo.MongoDb.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.MongoDb.Repository.TodoRepository;
import com.demo.MongoDb.entity.TodoDTO;
import com.demo.MongoDb.exception.MessageException;



@Service
public class TodoServiceImpl implements TodoService {
	@Autowired
	private TodoRepository todoRepository;

	@Override
	public void createTodo(TodoDTO todo) throws ConstraintViolationException, MessageException {
		Optional<TodoDTO> todoOptional=todoRepository.findById(todo.getTodo());
		if (todoOptional.isPresent())
			throw new MessageException(MessageException.TodoAlreadyExists());

		else {
			todo.setCreatedAt(new Date(System.currentTimeMillis()));
			todoRepository.save(todo);
		}
	}

	@Override
	public List<TodoDTO> getAllTodos() {
		List<TodoDTO> todos = todoRepository.findAll();
		if (todos.size() > 0) {
			return todos;
		}
		else {
			return new ArrayList<TodoDTO>();
		}
	}

	@Override
	public TodoDTO getSingleTodo(String id) throws MessageException {
		Optional<TodoDTO> optionalTodo = todoRepository.findById(id);
		if (!optionalTodo.isPresent())
			throw new MessageException(MessageException.NotFoundException(id));
		else
			return optionalTodo.get();

	}
	@Override
	public void updateTodo(String id, TodoDTO todo) throws MessageException {

		Optional<TodoDTO> todoWithId = todoRepository.findById(id);
		Optional<TodoDTO> todoWithSameName = todoRepository.findByTodo(todo.getTodo());
		if (todoWithId.isPresent()) {
			if (todoWithSameName.isPresent() && !todoWithSameName.get().getId().equals(id)) {
				throw new MessageException(MessageException.TodoAlreadyExists());
			}

			TodoDTO todoToUpdate = todoWithId.get();
			todoToUpdate.setTodo(todo.getTodo());
			todoToUpdate.setCompleted(todo.getCompleted());
			todoToUpdate.setDescription(todo.getDescription());
			todoToUpdate.setUpdatedAt(new Date(System.currentTimeMillis()));
			todoRepository.save(todoToUpdate);
		}
	}
	@Override
	public void deleteTodo(String id) throws MessageException {

		Optional<TodoDTO> todoOptional = todoRepository.findById(id);
		if (!todoOptional.isPresent()) {
			throw new MessageException(MessageException.NotFoundException(id));
		}
		else {
			todoRepository.deleteById(id);
		}
	}
}