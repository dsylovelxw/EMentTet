package com.entity;

import java.util.List;

public class Juese {
   
	private int id;  //id
	private String lodName;  //
	private List<User> user;
	
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLodName() {
		return lodName;
	}
	public void setLodName(String lodName) {
		this.lodName = lodName;
	}
	
}
