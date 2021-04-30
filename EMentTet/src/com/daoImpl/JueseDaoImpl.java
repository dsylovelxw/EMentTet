package com.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.JueseDao;
import com.entity.Juese;
import com.entity.Lr_bumeng;
import com.entity.Lr_zhicheng;
import com.entity.Meun;
import com.entity.User;

public class JueseDaoImpl extends BaseDao implements JueseDao
{

	
	public JueseDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Juese> jueseList() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM lr_lode";
		ResultSet set=null;
	 
		List<Juese> list=new ArrayList<Juese>();
		set=super.excuteQuery(sql, null);
		try {
			while (set.next()) {
				Juese juese=new Juese();
			 
				juese.setId(set.getInt(1));
				juese.setLodName(set.getString(2));
				 
				 
				 
				list.add(juese);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

return list;
	}

	@Override
	public int CountJuese() {
		// TODO Auto-generated method stub
		String sql="SELECT count(*) FROM lr_lode";
		ResultSet set=null;	 
		int count=0;
		set=super.excuteQuery(sql, null);
		try {
			while (set.next()) {				 
			 count= set.getInt(1);							 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
return count;
	}
	

 
	 
	 

	@Override
	public List<Lr_bumeng> Lr_bumengList() {
		// TODO Auto-generated method stub
		 
			 
			String sql="SELECT * FROM lr_bumeng ";
			ResultSet set=null;
		 
			List<Lr_bumeng> list=new ArrayList<Lr_bumeng>();
			set=super.excuteQuery(sql, null);
			try {
				while (set.next()) {
					Lr_bumeng juese=new Lr_bumeng();
				 
					juese.setId(set.getInt(1));
					juese.setMeng_name(set.getString(2));
					juese.setRenshu_id(set.getInt(3));
					juese.setUserId(set.getInt(4));
					 
					 
					 
					list.add(juese);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	return list;
		}
	 

	@Override
	public int CountLr_bumeng() {
		// TODO Auto-generated method stub
		String sql="SELECT count(*) FROM lr_bumeng";
		ResultSet set=null;	 
		int count=0;
		set=super.excuteQuery(sql, null);
		try {
			while (set.next()) {				 
			 count= set.getInt(1);							 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
return count;
	}

	@Override
	public List<Lr_zhicheng> Lr_zhichengList() {
		 
		String sql="SELECT * FROM Lr_zhicheng ";
		ResultSet set=null;
	 
		List<Lr_zhicheng> list=new ArrayList<Lr_zhicheng>();
		set=super.excuteQuery(sql, null);
		try {
			while (set.next()) {
				Lr_zhicheng juese=new Lr_zhicheng();
			 
				juese.setId(set.getInt(1));
				juese.setZhi_name(set.getString(2));
				 
				 
				 
				list.add(juese);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

return list;
	}

	@Override
	public int CountLr_zhicheng() {
		// TODO Auto-generated method stub
		String sql="SELECT count(*) FROM lr_zhicheng";
		ResultSet set=null;	 
		int count=0;
		set=super.excuteQuery(sql, null);
		try {
			while (set.next()) {				 
			 count= set.getInt(1);							 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
return count;
	}

	@Override
	public List<User> jueseLists() {
		// TODO Auto-generated method stub
		String sql="SELECT lr_lode.id, lr_lode.`lodName`,userCode,userName,age FROM lr_user, lr_lode WHERE lr_lode.id=lr_user.lode_id ";
		ResultSet set=null;
	 
		List<User> list=new ArrayList<User>();
		set=super.excuteQuery(sql, null);
		try {
			while (set.next()) {
				User juese=new User();
				juese.setId(set.getInt(1));
				juese.setLode_id(set.getString(2));
				juese.setUserCode(set.getString(3));
				juese.setUserName(set.getString(4));
				juese.setAge(set.getInt(5));
				 
				 
				 
				list.add(juese);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

return list;
	}

}
