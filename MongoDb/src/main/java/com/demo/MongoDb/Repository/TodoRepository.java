package com.demo.MongoDb.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.MongoDb.entity.TodoDTO;

@Repository
public interface TodoRepository extends MongoRepository<TodoDTO, String> {
	@Query("{'todo': ?0}")
	Optional<TodoDTO> findByTodo(String todo);
}
