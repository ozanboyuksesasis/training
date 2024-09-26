package com.example.demo.response;

import lombok.Data;

@Data
public class ResponseObj {
	String message;
	boolean success;
	Object data;

	public ResponseObj(String message, boolean success) {
		this.message = message;
		this.success = success;
	}

	public ResponseObj(String message, boolean success,Object data) {
		this.message = message;
		this.success = success;
		this.data = data;
	}
}
