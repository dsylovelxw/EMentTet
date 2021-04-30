package com.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
 

import org.apache.log4j.Logger;

import com.dao.BaseDao;
import com.dao.BumenDaoDSY;
 
import com.entity.Lr_bumeng;

public class BumengDaoImplDSY extends BaseDao implements BumenDaoDSY {

	public static Logger logger = Logger.getLogger(BaseDao.class.getName());
	public BumengDaoImplDSY(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Lr_bumeng Lr_bumengFind(int id) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM lr_bumeng where id=?";
		ResultSet set=null;
		Object []parms= {id};
		Lr_bumeng bu=new Lr_bumeng();
		set=super.excuteQuery(sql, parms);
		try {
			while (set.next()) {					 
				bu.setId(set.getInt(1));
				bu.setMeng_name(set.getString(2));
				bu.setRenshu_id(set.getInt(3));
				bu.setUserId(set.getInt(4));				 							
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return bu;
	}

	@Override
	public int UpdateLr_bumeng(Lr_bumeng bumen) {
		// TODO Auto-generated method stub
		String sql=" update lr_bumeng set meng_name=?,renshu_id=?,userId=? WHERE id=?";
		int set=0;
	
		Object []parms= {bumen.getMeng_name(),bumen.getRenshu_id(),bumen.getUserId(),bumen.getId()};
	
		set=super.excuteUpdate(sql, parms);
                return set;
		
	}

	@Override
	public int NameLr_bumen(String name) {
		// TODO Auto-generated method stub
		String sql="SELECT count(*) FROM lr_bumeng where meng_name=?";
		ResultSet set=null;
		Object []parms= {name};
		 
		int count=0;
		set=super.excuteQuery(sql, parms);
		try {
			while (set.next()) {					 
			  count=set.getInt(1) ;
				 		 							
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return count;
	}

}
