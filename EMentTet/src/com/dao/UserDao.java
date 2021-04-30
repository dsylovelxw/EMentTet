package com.dao;

import java.util.List;

import com.entity.Lr_bumeng;
import com.entity.Lr_zhicheng;
import com.entity.User;

 

public interface UserDao {
	//查询所有用户
public List<User> UserList();
//查询所有部门
public List<Lr_bumeng> Lr_bumengList();
//查询所有部门职称
public List<Lr_zhicheng> Lr_zhichengList();
//修改用户信息
public int updateUserByAdmin(User user);
//查询用户是否存在
public int CountUser(String name);
//新增用户信息
public int InsertaddUser(User user);
//删除用户信息
public int DeleteaddUser(int  userid);

public User  UserFinde(int  userid);
public int InsertaddUser(int userid,int mentid);

}
