package com.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.dao.BaseDao;
import com.dao.UserDao;
import com.entity.Lr_bumeng;
import com.entity.Lr_zhicheng;
import com.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao{
	public static Logger logger= Logger.getLogger(BaseDao.class.getName());
	public UserDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<User> UserList() {
		// TODO Auto-generated method stub
		String sql="SELECT lr_user.id,userCode,userName, userPassword,gender,birthday,phone,address,lr_bumeng.`meng_name`,age,lr_zhicheng.`zhi_nmae`,lr_lode.`lodName` FROM lr_user,lr_bumeng,lr_zhicheng,lr_lode WHERE lr_user.`bumeng_id`=lr_bumeng.`id` AND lr_user.`zhicheng_id`=lr_zhicheng.`id` AND lr_user.`lode_id`=lr_lode.`id`";
		
		ResultSet set=null;
	
		List<User> list=new ArrayList<User>();
		 set=super.excuteQuery(sql, null);
						try {
							while (set.next()) {
								User user=new User();
							 
								 user.setId(set.getInt(1));
								 user.setUserCode(set.getString(2));
								 user.setUserName(set.getString(3));
								 user.setUserPassword(set.getInt(4));
								 user.setGender(set.getInt(5));
								 user.setBirthday(set.getString(6));
								 user.setPhone(set.getString(7));
								 user.setAddress(set.getString(8));
								user.setBumeng_id(set.getString(9));
								user.setAge(set.getInt(10));
								user.setZhicheng_id(set.getString(11));
								user.setLode_id(set.getString(12));
								System.out.println(user.getLode_id());
							list.add(user);
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						 
				return list;
				
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
		String sql="  UPDATE lr_user  SET( userCode=?,userName=?, userPassword=?,gender=?,phone=?,bumeng_id=?,age=?,zhicheng_id=?,lode_id=?) WHERE id=?";
		Object [] parms= {user.getUserCode(),user.getUserName(),user.getUserPassword(),user.getGender(),user.getPhone(),user.getBumeng_id(),user.getAge(),
				user.getZhicheng_id(),user.getLode_id(),user.getId()};
		int count =super.excuteUpdate(sql, parms);
		 
		return count;
	}

	@Override
	public int CountUser(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int InsertaddUser(User user) {
	String sql=" INSERT INTO lr_user ( userCode,userName, userPassword,gender,phone,bumeng_id,age,zhicheng_id,lode_id) VALUES (?,?,?,?,?,?,?,?,?)";
	Object [] parms= {user.getUserCode(),user.getUserName(),user.getUserPassword(),user.getGender(),user.getPhone(),user.getBumeng_id(),user.getAge(),
			user.getZhicheng_id(),user.getLode_id()};
	int count =super.excuteUpdate(sql, parms);
	System.out.println(count+"count");
	return count;
	}

	@Override
	public int DeleteaddUser(int userid) {
		// TODO Auto-generated method stub
		 int count=0;
		    String sql=" Delete    FROM lode_meun WHERE lodeId=?";
		    Object [] parms= { userid };   
		    count=super.excuteUpdate(sql, parms);
			return count;
	}

	@Override
	public int InsertaddUser(int userid,int mentid) {
		// TODO Auto-generated method stub
		 int count=0;
		    String sql="  INSERT INTO   lode_meun  (lodeId,meunId) VALUES(?,?)";
		    Object [] parms= {userid,mentid};   
		    count=super.excuteUpdate(sql, parms);
			return count;
	}

	@Override
	public User UserFinde(int userid) {
		// TODO Auto-generated method stub
String sql=" SELECT id,userCode,userName, userPassword,gender,phone,bumeng_id,age,zhicheng_id,lode_id FROM lr_user where id=?";
		
		ResultSet set=null;
		User user=new User();
		Object [] parms= {userid};   
		 set=super.excuteQuery(sql, parms);
						try {
							while (set.next()) {
							
							 
								 user.setId(set.getInt(1));
								 user.setUserCode(set.getString(2));
								 user.setUserName(set.getString(3));
								 user.setUserPassword(set.getInt(4));
								 user.setGender(set.getInt(5));
								 
								 user.setPhone(set.getString(6));
								 
								user.setBumeng_id(set.getString(7));
								user.setAge(set.getInt(8));
								user.setZhicheng_id(set.getString(9));
								user.setLode_id(set.getString(10));
							 
						 
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						 
				return user;
	}
}
