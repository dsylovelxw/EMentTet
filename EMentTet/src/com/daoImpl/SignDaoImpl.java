package com.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.dao.BaseDao;
import com.dao.SignDao;
import com.entity.Meun;
import com.entity.User;
import com.utils.DataBaseUtil;

/*
 * 访问权限数据实现层
 */
public class SignDaoImpl extends BaseDao implements SignDao {

	private static final Logger LOGGER = Logger.getLogger(BaseDao.class.getName());

	public SignDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 签到列表
	 */
	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		// 创建字符集
		ResultSet set = null;
		List<User> list = new ArrayList<User>();
		// sql语句
		String sql = " SELECT `id`,`userCode`,`userName`,`userPassword`,`gender`,`birthday`,`phone`,`address`,`bumeng_id`,`age`,`zhicheng_id`,`lode_id` FROM `lr_user` WHERE `lode_id` !=1 AND `lode_id` !=2";
		set = super.excuteQuery(sql, null);
		try {
			while (set.next()) {
				User user = new User();
				user.setId(set.getInt(1));
				user.setUserCode(set.getString(2));
				user.setUserName(set.getString(3));
				user.setUserPassword(set.getInt(4));
				user.setGender(set.getInt(5));
				user.setPhone(set.getString(7));
				user.setAddress(set.getString(8));
				user.setBumeng_id(set.getString(9));
				user.setAge(set.getInt(10));
				user.setZhicheng_id(set.getString(11));
				user.setLode_id(set.getString(12));
				user.setSoignid(signCount(user.getId())); // 获取是否签到
				user.setDate(getDate(user.getId())); // 获取签到日期
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * 我要签到
	 */
	@Override
	public int addSign(int userid) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		int count = -1;
		try {
			String sql = " INSERT INTO `lr_sign`(`userid`,`signTime`) VALUES(?,CURDATE())";
			Object[] obj = {userid};
			count = excuteUpdate(sql, obj);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
		} finally {
			DataBaseUtil.closeAll(rs, null, null);
		}
		return count;
	}

	/**
	 * 查询是否已签到
	 */
	@Override
	public int signCount(int userid) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		int count = -1;
		try {
			String sql = " SELECT COUNT(*) FROM `lr_sign` WHERE  `userid`=?";
			Object[] obj = {userid};
			count = excuteUpdate(sql, obj);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
		} finally {
			DataBaseUtil.closeAll(rs, null, null);
		}
		return count;
	}

	/**
	 * 获取当前学生签到日期
	 */
	@Override
	public String getDate(int userid) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		String date = null;
		try {
			String sql = " SELECT `signTime` FROM `lr_sign` WHERE signTime =CURDATE() AND `userid` =?";
			rs = super.excuteQuery(sql, null);
			Object[] obj = {userid};
			if (rs!=null) {
			while (rs.next()) {
			date=rs.getString(1);	
			}
			}
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
		} finally {
			DataBaseUtil.closeAll(rs, null, null);
		}
		return date;
	}

	/**
	 * 签到按钮
	 */
	@Override
	public List<Meun> getBtn(int fuid,int id) {
		// TODO Auto-generated method stub
		String sql=" SELECT id,mName,fatherid,mbetn,resUrl FROM lr_meun WHERE `fatherid`=? AND id IN( SELECT meunId FROM lode_meun WHERE lodeId=?)";
		ResultSet set=null;
		Object[] parms= {fuid,id};
		List<Meun> list=new ArrayList<Meun>();
		set=super.excuteQuery(sql, parms);
		try {
			while (set.next()) {
				Meun meun=new Meun();
				meun.setId(set.getInt(1));
				meun.setmName(set.getString(2));
				meun.setFatherid(set.getInt(3));
				meun.setMben(set.getString(4));
				meun.setResUrl(set.getString(5));
				list.add(meun);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

      return list;
	}

}
