package com.pycredit.system.model;

import java.io.Serializable;

public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5250332305461184009L;

	private String name;
	
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "[user:name="+ name+",password="+password+"]";
	}
	
}
