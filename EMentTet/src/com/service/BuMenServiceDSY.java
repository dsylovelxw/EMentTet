package com.service;

import com.entity.Lr_bumeng;

public interface BuMenServiceDSY {
	       //单个部门数据的回显
		   public Lr_bumeng Lr_bumengFind(int id);
		
		    //部门的修改
		   public int  UpdateLr_bumeng(Lr_bumeng bumen);
		   //部门名称是否重复
		   public int NameLr_bumen(String name);
}
