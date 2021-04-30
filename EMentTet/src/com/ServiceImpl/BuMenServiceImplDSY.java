package com.ServiceImpl;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.dao.BaseDao;
import com.daoImpl.BumengDaoImplDSY;
 
import com.entity.Lr_bumeng;
 
import com.service.BuMenServiceDSY;
import com.utils.DataBaseUtil;

public class BuMenServiceImplDSY implements BuMenServiceDSY {
	public static Logger logger = Logger.getLogger(BaseDao.class.getName());
	@Override
	public Lr_bumeng Lr_bumengFind(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Lr_bumeng user=new Lr_bumeng();
	
		try {
		conn = DataBaseUtil.getConnection();
		
		 user=new  BumengDaoImplDSY(conn).Lr_bumengFind(id);
		
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return user;
	}

	@Override
	public int UpdateLr_bumeng(Lr_bumeng bumen) {
		// TODO Auto-generated method stub
		Connection conn = null;
		int count=0;
	
		try {
		conn = DataBaseUtil.getConnection();
		
		count=new  BumengDaoImplDSY(conn).UpdateLr_bumeng(bumen);
		
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return count;
	}

	@Override
	public int NameLr_bumen(String name) {
		// TODO Auto-generated method stub
		Connection conn = null;
		int count=0;
	
		try {
		conn = DataBaseUtil.getConnection();
		
		count=new  BumengDaoImplDSY(conn).NameLr_bumen(name);
		
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return count;
	}

}
