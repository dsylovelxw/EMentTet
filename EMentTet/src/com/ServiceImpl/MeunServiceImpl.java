package com.ServiceImpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.dao.BaseDao;
import com.daoImpl.MeunDaoImpl;
import com.daoImpl.UserDaoImpl;
import com.entity.Juese;
import com.entity.Layui;
import com.entity.Meun;
import com.entity.User;
 
import com.service.MeunService;
import com.utils.Butn;
import com.utils.DataBaseUtil;

 
public class MeunServiceImpl implements MeunService{

	public static Logger logger=Logger.getLogger(BaseDao.class.getName());
	@Override
	public List<Meun> QuanxianFind(int id,int idd) {
		// TODO Auto-generated method stub
		Connection conn=null;
		conn=DataBaseUtil.getConnection();
		 List<Meun> list=new ArrayList<Meun>();
		 list=new MeunDaoImpl(conn).QuanxianFind(id,idd);
	
		return list;
	}

	@Override
	public List<Meun> DengluUser(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		conn=DataBaseUtil.getConnection();
		 List<Meun> list=new ArrayList<Meun>();
		 list=new MeunDaoImpl(conn).DengluUser(id);
	
		return list;
	}

	@Override
	public int CountDengluUser() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Layui<Meun> QaunxianMeun(int id) {
		// TODO Auto-generated method stub
		Layui<Meun> user=new  Layui<Meun>();
		Connection conn = null;
		 List<Meun> list=null;
		
		int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			/* count=new QuanDaoImpl(conn).CountEasybuyUser(); */
			 list=new MeunDaoImpl(conn).DengluUser(id);
			
			 	
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
	public User DengluYong(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int CountEasybuyUser() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> EasybuyUserList(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Juese> JueseList(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int QuanxianCount(String name) {
		// TODO Auto-generated method stub
	 
		Connection conn = null;
		 
		
		int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			 
			 
			count=new MeunDaoImpl(conn).QuanxianCount(name);
			 	
		}  catch (Exception e) {
			// 捕获异常�?
			logger.error(e.getMessage());
		} finally {
			// 释放资源�?
			DataBaseUtil.closeAll(null, null, conn);
		}
		  return count;
	}

	@Override
	public int isMenuUrl(String mbtn) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addDenglu(Meun deng) {
		// TODO Auto-generated method stub
		Connection conn = null;
		 int count=0;
		try {
			// 获取连接对象�?
			conn = DataBaseUtil.getConnection();
			// 调用更新方法�?
			count = new MeunDaoImpl(conn).addDenglu(deng);
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
	public int UpdateDenglu(Meun deng) {
		// TODO Auto-generated method stub
		Connection conn = null;
		 int count=0;
		try {
			// 获取连接对象�?
			conn = DataBaseUtil.getConnection();
			// 调用更新方法�?
			count = new MeunDaoImpl(conn).UpdateDenglu(deng);
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
	public int DeleteDenglu(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		 int count=0;
		try {
			// 获取连接对象�?
			conn = DataBaseUtil.getConnection();
			// 调用更新方法�?
			count = new MeunDaoImpl(conn).DeleteDenglu(id);
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
	public List<Meun> DengluUserID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Butn> ButnFan(int id) {
		// TODO Auto-generated method stub
				 
				List<Butn> data=new ArrayList<Butn>();
			 
				Connection conn = null;
				
				try {
				
				conn = DataBaseUtil.getConnection();
				 
				data=new MeunDaoImpl(conn).ButnFan(id);
			}  catch (Exception e) {
				// 捕获异常�?
				logger.error(e.getMessage());
			} finally {
				// 释放资源�?
				DataBaseUtil.closeAll(null, null, conn);
			}
				 
				return data;
	}
	//根据type类型查询信息
		@Override
		public List<Meun> menuByBtn3(int type) {
			List<Meun> menuBtn = new ArrayList<Meun>();
			Connection conn = null;	
			conn = DataBaseUtil.getConnection();
			menuBtn=new MeunDaoImpl(conn).menuByBtn3(type);
		 
			return menuBtn;
		}

		@Override
		public Meun quanxMeuncha(int deng) {
			Meun menuBtn = new Meun();
			Connection conn = null;	
			conn = DataBaseUtil.getConnection();
			menuBtn=new MeunDaoImpl(conn).quanxMeuncha(deng);
		 
			return menuBtn;
		}


	 
	 

}
