package com.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.dao.BaseDao;
import com.dao.MeunDao;
import com.entity.Juese;
import com.entity.Meun;
import com.entity.User;
import com.utils.Butn;
import com.utils.DataBaseUtil;

 

 

public class MeunDaoImpl extends BaseDao implements MeunDao{

	public MeunDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	public static Logger logger= Logger.getLogger(BaseDao.class.getName());

	@Override
	public List<Meun> QuanxianFind(int fatherid,int dd ) {
		// TODO Auto-generated method stub
		String sql="SELECT id,mName,fatherid,mbetn,TYPE,resUrl FROM lr_meun WHERE  fatherid=? AND TYPE=3 AND id IN( SELECT meunId FROM lode_meun WHERE lodeId=?)";
		ResultSet set=null;
		Object[] parms= {fatherid,dd};
		List<Meun> list=new ArrayList<Meun>();
		set=super.excuteQuery(sql, parms);
		try {
			while (set.next()) {
				Meun meun=new Meun();
			 
				meun.setId(set.getInt(1));
				meun.setmName(set.getString(2));
				meun.setFatherid(set.getInt(3));
				meun.setMben(set.getString(4));
				meun.setType(set.getInt(5));
			 
				meun.setResUrl(set.getString(6));
				
				list.add(meun);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

return list;
	}

	@Override
	public List<Meun> DengluUser(int id) {
		// TODO Auto-generated method stub
		StringBuilder sql=new StringBuilder("SELECT id ,mName,fatherid,mbetn,TYPE,resurl,js FROM lr_meun ");
		
ResultSet set=null;
if(id==0) {
	 set=super.excuteQuery(sql.toString(), null);
}else {
	Object [] parms= {id};
	 sql.append( "WHERE  id IN(SELECT MeunId FROM lode_meun WHERE lodeId=?)");
	 set=super.excuteQuery(sql.toString(), parms);
}


List<Meun> list=new ArrayList<Meun>();
 
				try {
					while (set.next()) {
						Meun meun=new Meun();
					 
						meun.setId(set.getInt(1));
						meun.setmName(set.getString(2));
						meun.setFatherid(set.getInt(3));
						meun.setMben(set.getString(4));
						meun.setType(set.getInt(5));
					 
						meun.setResUrl(set.getString(6));
						meun.setJs(set.getString(7));
						list.add(meun);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
		return list;
	}

	@Override
	public int CountDengluUser() {
		// TODO Auto-generated method stub
		return 0;
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
		List<Juese> juese=new ArrayList<Juese>();
		ResultSet set=null;
		StringBuilder sql=new StringBuilder("SELECT * FROM lr_lode");
		if(id!=0) {
			sql.append("WHERE id=1");
			Object [] parms= {id};
			set=super.excuteQuery(sql.toString(), parms);	
		}else {
			 
			set=super.excuteQuery(sql.toString(), null);
		}
		try {
			while (set.next()) {
				Juese ju=new Juese();
				ju.setId(set.getInt(1));
				ju.setLodName(set.getString(2));
				juese.add(ju);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		 logger.error(e.getMessage());
		}finally {
			DataBaseUtil.closeAll(set, null, null);
		}
		return juese;
		
		
	}
	@Override
	public int QuanxianCount(String name) {
		// TODO Auto-generated method stub
		 
		 ResultSet set=null;
		 Object [] parms= {name};
		 int count=0;
		 String sql="SELECT COUNT(*) FROM lr_meun WHERE mName=?";
		 set=super.excuteQuery(sql, parms);
		 try {
			while (set.next() ) {
				count=set.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage()); 
		}finally {
			DataBaseUtil.closeAll(set, null, null);
		}
		 return count;
	}
	@Override
	public int isMenuUrl(String mbtn) {
		// TODO Auto-generated method stub
		 ResultSet set=null;
		 int count=0;
		 String sql="SELECT count(*) FROM lr_meun";
		 set=super.excuteQuery(sql, null);
		 try {
			while (set.next() ) {
				count=set.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage()); 
		}finally {
			DataBaseUtil.closeAll(set, null, null);
		}
		 return count;
	}
	@Override
	public int addDenglu(Meun deng) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO    lr_meun   (mName,fatherid,mbetn,TYPE) VALUES(?,?,?,?)";
		Object [] parms= {deng.getmName(),deng.getFatherid(),deng.getMben(),deng.getType() };
		int count =super.excuteUpdate(sql, parms);
		System.out.println(count+"count");
		return count;
		
		
	}
	@Override
	public int UpdateDenglu(Meun deng) {
		   int count=0;
		    String sql="UPDATE  lr_meun SET mName=?,fatherid=?,mbetn=?,TYPE=?,resUrl=? WHERE id=?";
		    Object [] parms= {deng.getmName(),deng.getFatherid(),deng.getMben(),deng.getType(),deng.getResUrl(),deng.getId()};   
		    count=super.excuteUpdate(sql, parms);
			return count;
	}
	@Override
	public int DeleteDenglu(int id) {
		 int count=0;
		    String sql=" DELETE    FROM lr_meun WHERE id=?";
		    Object [] parms= { id };   
		    count=super.excuteUpdate(sql, parms);
			return count;
	}
	@Override
	public List<Meun> DengluUserID(int id) {
		// TODO Auto-generated method stub
		 ResultSet set=null;
		 List<Meun> deng=new ArrayList<Meun>();
		 
		 Object [] parms= {id};
		 String sql="SELECT  meunId FROM lode_meun WHERE lodeId=?";
		 set=super.excuteQuery(sql, parms);
		 try {
			while (set.next() ) {
				Meun deng1=new Meun();
				 deng1.setId(set.getInt(1));
				deng.add(deng1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage()); 
		}finally {
			DataBaseUtil.closeAll(set, null, null);
		}
		 System.out.println("deng"+deng);
		 return deng;
	}
	@Override
	public List<Butn> ButnFan(int id) {
		String sql="SELECT * FROM ls_butten";
		Object [] parms= {0};
		ResultSet set=null;
		List<Butn>  deng=new ArrayList<Butn>();
		try {
			set=super.excuteQuery(sql, null);
			while (set.next()) {
				Butn	den = new Butn();
				den.setId(set.getInt(1));
				 den.setBtntype(set.getString(2));
				deng.add(den);
			}		
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			// 释放资源�?
			DataBaseUtil.closeAll(set, null, null);
		}
		System.out.println("deng"+deng);
		return deng;
	}

	@Override
	public List<Meun> menuByBtn3(int type) {
	 
				 ResultSet set=null;
				 List<Meun> deng=new ArrayList<Meun>();
				 
				 Object [] parms= {type};
				 String sql="SELECT  id,mName,fatherid FROM lr_meun WHERE TYPE=?";
				 set=super.excuteQuery(sql, parms);
				 try {
					while (set.next() ) {
						Meun deng1=new Meun();
						 deng1.setId(set.getInt(1));
						 deng1.setmName(set.getString(2));
						 deng1.setFatherid(set.getInt(3));
						 
						 
						deng.add(deng1);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					logger.error(e.getMessage()); 
				}finally {
					DataBaseUtil.closeAll(set, null, null);
				}
				 
				 return deng;
	}

	@Override
	public Meun quanxMeuncha(int deng) {
		// TODO Auto-generated method stub
				String sql="SELECT id, mName,fatherid,mbetn,TYPE,resurl,js FROM lr_meun WHERE  id=?";
		ResultSet set=null;
		Object [] parms= {deng};
		Meun meun=new Meun();
		 set=super.excuteQuery(sql, parms);
						try {
							while (set.next()) {
								
							 
								meun.setId(set.getInt(1));
								meun.setmName(set.getString(2));
								meun.setFatherid(set.getInt(3));
								meun.setMben(set.getString(4));
								meun.setType(set.getInt(5));
							 
								meun.setResUrl(set.getString(6));
								meun.setJs(set.getString(7));
								 
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			
				return  meun;
	}

}
