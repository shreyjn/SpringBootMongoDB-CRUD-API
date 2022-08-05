package com.demo.MongoDb.service;

public class MessageService extends Exception {

	public MessageService(String message){
		super(message);
	}
	public static String NotFoundException(String id) {
		return "Todo with "+id+" not Found!";
	}

	public static String TodoAlreadyExists() {
		return "Todo with given name already exists";
	}
}
