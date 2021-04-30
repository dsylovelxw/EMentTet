package com.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.dao.BaseDao;
import com.dao.DengluDao;
import com.entity.User;
import com.utils.DataBaseUtil;

 

public class DengLuDaoImpl  extends BaseDao implements DengluDao{

	public DengLuDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	public static Logger logger = Logger.getLogger(BaseDao.class.getName());
	@Override
	public User DengluName(String loginName) {
		// TODO Auto-generated method stub
		String sql = "SELECT id,userCode,userName, userPassword,gender,birthday,phone,address,bumeng_id,age,zhicheng_id,lode_id FROM lr_user  WHERE userCode=?";
        ResultSet set=null;
        Object [] parms= {loginName};
        set=super.excuteQuery(sql, parms);
        User user=new User();
        try {
			while (set.next()) {
				
				 user.setId(set.getInt("id"));
				 user.setUserCode(set.getString("userCode"));
				 user.setUserName(set.getString("userName"));
				 user.setUserPassword(set.getInt("userPassword"));
				 user.setGender(set.getInt("gender"));
				 user.setBirthday(set.getString("birthday"));
				 user.setPhone(set.getString("phone"));
				 user.setAddress(set.getString("address"));
				user.setBumeng_id(set.getString("bumeng_id"));
				user.setAge(set.getInt("age"));
				user.setZhicheng_id(set.getString("zhicheng_id"));
				user.setLode_id(set.getString("lode_id"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}finally {
			// 释放资源�?
			DataBaseUtil.closeAll(set, null, null);
		}
        
        return user;
		
	 
	}

}
