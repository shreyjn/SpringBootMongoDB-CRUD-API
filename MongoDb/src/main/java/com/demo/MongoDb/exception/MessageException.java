package com.demo.MongoDb.exception;

public class MessageException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public MessageException(String message){
		super(message);
	}
	public static String NotFoundException(String id) {
		return "Todo with "+id+" not Found!";
	}

	public static String TodoAlreadyExists() {
		return "Todo with given name already exists";
	}
}
