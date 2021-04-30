package com.ServiceImpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.daoImpl.JueseDaoImpl;
import com.daoImpl.MeunDaoImpl;
import com.entity.Juese;
import com.entity.Layui;
import com.entity.Lr_bumeng;
import com.entity.Lr_zhicheng;
import com.entity.Meun;
import com.entity.User;
import com.service.JueseService;
import com.utils.DataBaseUtil;

public class JueseServiceImpl implements JueseService{

	@Override
	public List<Juese> jueseList() {
		// TODO Auto-generated method stub
		Connection conn=null;
		conn=DataBaseUtil.getConnection();
		 List<Juese> list=new ArrayList<Juese>();
		 list=new JueseDaoImpl(conn).jueseList();
	
		return list;
	}

	@Override
	public int CountJuese() {
		// TODO Auto-generated method stub
		Connection conn=null;
		conn=DataBaseUtil.getConnection();
		int count=0;
		count =new JueseDaoImpl(conn).CountJuese();
		return count;
	}

	@Override
	public List<Lr_bumeng> Lr_bumengList() {
		// TODO Auto-generated method stub
		Connection conn=null;
		conn=DataBaseUtil.getConnection();
		 List<Lr_bumeng> list=new ArrayList<Lr_bumeng>();
		 list=new JueseDaoImpl(conn).Lr_bumengList();
				 
	
		return list;
	}

	@Override
	public int CountLr_bumeng() {
		// TODO Auto-generated method stub
		Connection conn=null;
		conn=DataBaseUtil.getConnection();
		int count=0;
		count =new JueseDaoImpl(conn).CountLr_bumeng();
		return count;
	}

	@Override
	public List<Lr_zhicheng> Lr_zhichengList() {
		// TODO Auto-generated method stub
		Connection conn=null;
		conn=DataBaseUtil.getConnection();
		 List<Lr_zhicheng> list=new ArrayList<Lr_zhicheng>();
		 list=new JueseDaoImpl(conn).Lr_zhichengList();
				 
	
		return list;
	}

	@Override
	public int CountLr_zhicheng() {
		// TODO Auto-generated method stub
		Connection conn=null;
		conn=DataBaseUtil.getConnection();
		int count=0;
		count =new JueseDaoImpl(conn).CountLr_zhicheng();
		return count;
	}

	@Override
	public Layui<User> jueseLists() {
		// TODO Auto-generated method stub
		Layui<User> user=new  Layui<User>();
		Connection conn = null;
		 List<User> list=null;
		
		int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			 count=new JueseDaoImpl(conn).CountJuese();
			 list=new  JueseDaoImpl(conn).jueseLists();
			
			 	
		}  catch (Exception e) {
			 
			 
		} finally {
		 
			DataBaseUtil.closeAll(null, null, conn);
		}
		 user.setCode(0);
		 user.setMsg("");
		 user.setCount(count);
		 user.setData(list);	
		return user;
	}

}
