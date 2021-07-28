package com.jay.exception;

public class UserNotExistException extends RuntimeException {

	public UserNotExistException(){
		super("用戶不存在");
	}
}
