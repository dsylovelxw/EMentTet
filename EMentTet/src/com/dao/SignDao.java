package com.dao;
/*
 * 访问权限数据层
 */

import java.util.List;

import com.entity.Meun;
import com.entity.User;


public interface SignDao{

	
	/*
	 * 获取签到按钮
	 */
	public List<Meun> getBtn(int fuid,int id);
	
	/*
	 * 签到类表
	 */
	public List<User> getUsers(int lodeid,int userid);
	
	/*
	 * 我要签到
	 */
	public int addSign(int userid);
	
	/*
	 * 查询是否已签到
	 */
	public int signCount(int userid);
	
	/*
	 * 获取当前学生签到日期
	 */
	public String getDate(int userid);
}
