package com.service;

import java.util.List;

import com.entity.Meun;
import com.entity.User;

/*
 * 访问签到业务层
 */
public interface SignService {
	
	/*
	 * 获取签到按钮
	 */
	public List<Meun> getBtn(int fuid,int id);
	
	/*
	 * 签到类表
	 */
	public List<User> getUsers();
	
	/*
	 * 我要签到
	 */
	public int addSign(int userid);
	
	/*
	 * 查询是否已签到
	 */
	public int signCount(int userid);
}
