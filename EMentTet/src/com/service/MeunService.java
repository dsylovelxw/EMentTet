package com.service;

import java.util.List;

import com.entity.Juese;
import com.entity.Layui;
import com.entity.Meun;
import com.entity.User;
import com.utils.Butn;

public interface MeunService {
	//权限三级查询
	public  List<Meun> QuanxianFind(int id,int iddd);
	//权限查询
	List<Meun> DengluUser(int id);
	//权限个数查询
	public int CountDengluUser();
	
	Layui<Meun>  QaunxianMeun(int id );
	 
	 
		 
			//登录用户信息查询
			public User DengluYong(String name);
			
			//用户总个数查询
			public int CountEasybuyUser();
			//用户所有信息查询
			public  List<User> EasybuyUserList(String name);
			
			//用户所扮演的角色
			public List<Juese>  JueseList(int id);
			//查询用户新增权限名是否重复
			public int   QuanxianCount(String name);
			//  验证请求路径是否存在
			public int    isMenuUrl(String mbtn);
			//新增权限信息
			public int addDenglu(Meun deng);
			//修改权限信息
			public int UpdateDenglu(Meun deng);
			//删除权限信息
			public int DeleteDenglu(int id);
			//根据用户角色id查询权限信息
			public  List<Meun> DengluUserID(int id);
			
			public List<Butn> ButnFan(int id);
			public List<Meun> menuByBtn3(int type);
			//权限信息查询
			public Meun quanxMeuncha(int deng);
}
