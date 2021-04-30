package com.service;

import java.util.List;

import com.entity.Layui;
import com.entity.Meun;
import com.utils.MenudtreeData;
 
public interface MenuService {
	
	public Layui<MenudtreeData> dtreeJson(int id);
	//根据用户Id查询权限信息
		public  List<Meun> DengluUserID(int id);
}
