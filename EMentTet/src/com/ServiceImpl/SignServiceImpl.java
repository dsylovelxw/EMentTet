package com.ServiceImpl;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.dao.BaseDao;
import com.daoImpl.SignDaoImpl;
import com.entity.Meun;
import com.entity.User;
import com.service.SignService;
import com.utils.DataBaseUtil;

/*
 * 访问签到业务实现层
 */
public class SignServiceImpl implements SignService{

	public static Logger LOGGER=Logger.getLogger(BaseDao.class.getName());
	/**
	 * 签到列表
	 */
	@Override
	public List<User> getUsers(int userid,int lodeid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<User> list = null;
		try {
			conn = DataBaseUtil.getConnection();
			list = new SignDaoImpl(conn).getUsers(userid,lodeid);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
		}

		return list;
	}

	/**
	 * 我要签到
	 */
	@Override
	public int addSign(int userid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			count = new SignDaoImpl(conn).addSign(userid);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
		}

		return count;
	}

	/**
	 * 查看是否已签到
	 */
	@Override
	public int signCount(int userid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			count = new SignDaoImpl(conn).signCount(userid);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
		}

		return count;
	}

	/**
	 * 签到按钮
	 */
	@Override
	public List<Meun> getBtn(int fuid, int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<Meun>list=null;
		try {
			conn = DataBaseUtil.getConnection();
			list = new SignDaoImpl(conn).getBtn(fuid, id);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
		}

		return list;
	}

}
