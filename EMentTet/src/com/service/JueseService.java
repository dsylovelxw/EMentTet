package com.service;

import java.util.List;

import com.entity.Juese;
import com.entity.Layui;
import com.entity.Lr_bumeng;
import com.entity.Lr_zhicheng;
import com.entity.Meun;
import com.entity.User;

public interface JueseService {
	 //所有角色查询
    public List<Juese> jueseList();
    //角色的个数
	   public int CountJuese();
	   //所有部门查询
	   public List<Lr_bumeng> Lr_bumengList();
		//部门的个数
	   public int CountLr_bumeng();
	   //所有职称查询
		public List<Lr_zhicheng> Lr_zhichengList();
	   //职称的个数
		public int CountLr_zhicheng();
	 
		Layui<User>  jueseLists( );
}
