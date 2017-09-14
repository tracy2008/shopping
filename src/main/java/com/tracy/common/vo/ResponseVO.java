package com.tracy.common.vo;

import java.io.Serializable;

public class ResponseVO<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3455421162977198250L;

	private String token;
	
	private int code;
	
	private String message;
	
	private T data;

	public ResponseVO(){
		this.code = 1;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
