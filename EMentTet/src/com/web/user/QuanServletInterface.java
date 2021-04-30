package com.web.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ServiceImpl.MenuServiceImpl;
import com.entity.Layui;
import com.entity.Meun;
import com.utils.MenudtreeData;
import com.utils.PrintUtil;
import com.utils.ReturnResult;
import com.web.AbstractServlet;

 
@WebServlet("/QuanServletInterface")
public class QuanServletInterface  extends AbstractServlet{

	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return QuanServletInterface.class;
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{	 
			  doPost(request, response);	 
	}
public void allMenuDtree(HttpServletRequest request,HttpServletResponse response) {
 
	Layui<MenudtreeData> menu = new MenuServiceImpl().dtreeJson(0 );
	PrintUtil.write(menu, response);
}
public void menuByUseridType1(HttpServletRequest request,HttpServletResponse response) {
	String id=request.getParameter("userid");
	
	 List<Meun> menu = new MenuServiceImpl().DengluUserID(Integer.valueOf(id));
	 
	PrintUtil.write(menu, response);
}
public ReturnResult menuByUserid(HttpServletRequest request ,HttpServletResponse response) {
	int id=Integer.valueOf(request.getParameter("userid"));
	String[] menuidList = request.getParameterValues("array");
	System.out.println("menuidList"+menuidList);
	ReturnResult result = new ReturnResult();
	int row = new  MenuServiceImpl().grantMenuByUserid(id, menuidList);
	if(row != 0 ) {
		result.returnSuccess("分配权限成功");
	}
	return result;
}
}
