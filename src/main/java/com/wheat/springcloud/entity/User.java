package com.wheat.springcloud.entity;

public class User {

	private int id;
	private String userName;
	private String password;
	private int port;

	public User() {
		super();
	}

	public User(int id, String userName, String password, int port) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.port = port;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
