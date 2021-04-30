package com.ServiceImpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.daoImpl.MeunDaoImpl;
import com.daoImpl.UserDaoImpl;
import com.entity.Layui;
import com.entity.Meun;
import com.service.MenuService;
import com.utils.DataBaseUtil;
import com.utils.MenudtreeData;

 
 

public class MenuServiceImpl implements MenuService{

	@Override
	public Layui<MenudtreeData> dtreeJson(int id ) {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<MenudtreeData> dengt = new ArrayList<MenudtreeData>();
	 
			// 鑾峰彇杩炴帴瀵硅薄锟??
			conn = DataBaseUtil.getConnection();
			Layui<MenudtreeData> user=new Layui<MenudtreeData>();
		List<Meun> Deng=new   MeunDaoImpl(conn).DengluUser(0);
		 
				for (Meun menu : Deng) {
					MenudtreeData data = new MenudtreeData();
					data.setId( menu.getId() ); 
					data.setParentId(menu.getFatherid() ); 
					data.setTitle(menu.getmName());
					data.setCheckArr ("0");
					dengt.add(data);
				}
		user.setCode(0);
		user.setCount(10);
		user.setData(dengt);
		user.setMsg("");
		 
		return user;
	}

 
	 
	public List<Meun> DengluUserID(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;		  
			// 鑾峰彇杩炴帴瀵硅薄锟??
			conn = DataBaseUtil.getConnection();		 
		List<Meun> Deng=new   MeunDaoImpl(conn).DengluUserID(id);		 
		return Deng;
	}
	
	
	public int grantMenuByUserid(int id, String[] ee) {
		// TODO Auto-generated method stub
		Connection conn = null;
		 int count=0;
		 
		try {
			// 获取连接对象�?
			conn = DataBaseUtil.getConnection();
			int o=new UserDaoImpl(conn).DeleteaddUser(id);
		 
			// 调用更新方法�?
			for (int i = 0; i < ee.length; i++) {
				
				count+= new  UserDaoImpl(conn).InsertaddUser(id,Integer.valueOf(ee[i]));
			}
			
		} catch (Exception e) {
		 
		} finally {
		 
			DataBaseUtil.closeAll(null, null, conn);
		}
		 
		return count;
		 
	}
}
