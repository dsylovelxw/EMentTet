package com.ServiceImpl;

 
import java.sql.Connection;
 
import java.util.List;

import org.apache.log4j.Logger;

import com.dao.BaseDao;
import com.daoImpl.MeunDaoImpl;
import com.daoImpl.UserDaoImpl;
import com.entity.Layui;
import com.entity.Lr_bumeng;
import com.entity.Lr_zhicheng;
import com.entity.User;
import com.service.UserService;
import com.utils.DataBaseUtil;

 
public class UserServiceImpl implements UserService{
	public static Logger logger=Logger.getLogger(BaseDao.class.getName());
	 
	public  Layui<User> UserList() {
		// TODO Auto-generated method stub
		Layui<User> user=new  Layui<User>();
		Connection conn = null;
		 List<User> list=null;
		
		int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			/* count=new QuanDaoImpl(conn).CountEasybuyUser(); */
			 list=new UserDaoImpl(conn).UserList();
			
			 	
		}  catch (Exception e) {
			// 捕获异常�?
			logger.error(e.getMessage());
		} finally {
			// 释放资源�?
			DataBaseUtil.closeAll(null, null, conn);
		}
		 user.setCode(0);
		 user.setMsg("");
		 user.setCount(count);
		 user.setData(list);	
		return user;
	}

	@Override
	public List<User> UserListss() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lr_bumeng> Lr_bumengList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lr_zhicheng> Lr_zhichengList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateUserByAdmin(User user) {
		// TODO Auto-generated method stub
		Connection conn = null;
		 int count=0;
		try {
			// 获取连接对象�?
			conn = DataBaseUtil.getConnection();
			// 调用更新方法�?
			count = new UserDaoImpl(conn).updateUserByAdmin(user);
		} catch (Exception e) {
			// 捕获异常�?
			logger.error(e.getMessage());
		} finally {
			// 释放资源�?
			DataBaseUtil.closeAll(null, null, conn);
		}
		return count;
	}

	@Override
	public int CountUser(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int InsertaddUser(User user) {
		Connection conn = null;
		 int count=0;
		try {
			// 获取连接对象�?
			conn = DataBaseUtil.getConnection();
			// 调用更新方法�?
			count = new UserDaoImpl(conn).InsertaddUser(user);
		} catch (Exception e) {
			// 捕获异常�?
			logger.error(e.getMessage());
		} finally {
			// 释放资源�?
			DataBaseUtil.closeAll(null, null, conn);
		}
		return count;
	}

	@Override
	public int DeleteaddUser(int userid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		 int count=0;
		try {
			// 获取连接对象�?
			conn = DataBaseUtil.getConnection();
			// 调用更新方法�?
			count = new UserDaoImpl(conn).DeleteaddUser(userid);
		} catch (Exception e) {
			// 捕获异常�?
			logger.error(e.getMessage());
		} finally {
			// 释放资源�?
			DataBaseUtil.closeAll(null, null, conn);
		}
		return count;
	}

	@Override
	public int InsertaddUser(int userid, int mentid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User UserFind(int userid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		User count=null;
		try {
			// 获取连接对象�?
			conn = DataBaseUtil.getConnection();
			// 调用更新方法�?
			count = new UserDaoImpl(conn).UserFinde(userid);
		} catch (Exception e) {
			// 捕获异常�?
			logger.error(e.getMessage());
		} finally {
			// 释放资源�?
			DataBaseUtil.closeAll(null, null, conn);
		}
		return count;
	}
	 

}
