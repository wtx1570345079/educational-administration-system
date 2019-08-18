package com.bear.pojo;

public class User {
    private int id;
    private String username;
    private String password;
    private String name;
    private int type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
     
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
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

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", type="
				+ type + "]";
	}

    
}
