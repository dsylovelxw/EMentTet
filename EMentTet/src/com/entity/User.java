package com.entity;

public class User {

	private int id;// ����ID
	private String userName;// �û�����
	private String userCode;// �û�����

	private int userPassword;// �û�����
	private int gender;// �Ա�1:Ů�� 2:�У�
	private String birthday;// ��������
	private String phone;// �ֻ�
	private String address;// ��ַ
	private String bumeng_id;// ����

	private int age;// ����
	private String zhicheng_id;// ְ��
	private String lode_id;// ��ɫ
	private int soignid; // 签到id
	private String date; // 签到日期


	public int getSoignid() {
		return soignid;
	}

	public void setSoignid(int soignid) {
		this.soignid = soignid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public int getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(int userPassword) {
		this.userPassword = userPassword;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBumeng_id() {
		return bumeng_id;
	}

	public void setBumeng_id(String bumeng_id) {
		this.bumeng_id = bumeng_id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getZhicheng_id() {
		return zhicheng_id;
	}

	public void setZhicheng_id(String zhicheng_id) {
		this.zhicheng_id = zhicheng_id;
	}

	public String getLode_id() {
		return lode_id;
	}

	public void setLode_id(String lode_id) {
		this.lode_id = lode_id;
	}

}
