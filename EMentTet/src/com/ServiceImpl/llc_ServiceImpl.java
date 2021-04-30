package com.ServiceImpl;

import java.sql.Connection;

import com.daoImpl.llc_bumenDaoImpl;
import com.entity.Lr_bumeng;
import com.service.llc_bumenService;
import com.utils.DataBaseUtil;

public class llc_ServiceImpl implements llc_bumenService{
	Connection conn=DataBaseUtil.getConnection();
	@Override
	public int addbumen(Lr_bumeng men) {
		// TODO Auto-generated method stub
		return new llc_bumenDaoImpl(conn).addbumen(men);
	}
	@Override
	public int delbumen(int id) {
		// TODO Auto-generated method stub
		return new llc_bumenDaoImpl(conn).delbumen(id);
	}
	
}
