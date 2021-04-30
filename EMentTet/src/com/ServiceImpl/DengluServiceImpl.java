package com.ServiceImpl;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.dao.BaseDao;
import com.daoImpl.DengLuDaoImpl;
import com.entity.User;
import com.service.DengLuSerivce;
import com.utils.DataBaseUtil;





public class DengluServiceImpl  implements DengLuSerivce{

	public static Logger logger = Logger.getLogger(BaseDao.class.getName());
	@Override
	public User DengluName(String loginName) {
		// TODO Auto-generated method stub
				// 获得连接对象！
				Connection conn = null;
				User user=new User();
			
				try {
				conn = DataBaseUtil.getConnection();
				
				 user=new DengLuDaoImpl(conn).DengluName(loginName);
				
				} catch (Exception e) {
					logger.error(e.getMessage());
				} finally {
					// 释放资源！
					DataBaseUtil.closeAll(null, null, conn);
				}
				return user;
	}

}
