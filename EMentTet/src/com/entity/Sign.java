package com.entity;

/*
 * 签到实体类
 */
public class Sign {
	private int id; // 签到id
	private int userid; // 用户id
	private String date; // 签到日期

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Sign() {

	}

	public Sign(int id, int userid, String date) {
		this.id = id;
		this.userid = userid;
		this.date = date;
	}
}
