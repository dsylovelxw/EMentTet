package com.daoImpl;

import java.sql.Connection;

import com.dao.BaseDao;
import com.dao.llc_bumenDao;
import com.entity.Lr_bumeng;

public class llc_bumenDaoImpl extends BaseDao implements llc_bumenDao{

	public llc_bumenDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addbumen(Lr_bumeng men) {
		String sql="INSERT INTO `lr_bumeng`(meng_name,renshu_id,userId) VALUES (?,?,?)";
		Object[] parms= {men.getMeng_name(),men.getRenshu_id(),men.getUserId()};
		return this.excuteUpdate(sql, parms);
	}

	@Override
	public int delbumen(int id) {
		String sql="DELETE FROM `lr_bumeng` WHERE id=?";
		Object[] parms= {id};
		return this.excuteUpdate(sql, parms);
	}
	
}
