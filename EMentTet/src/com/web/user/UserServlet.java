package com.web.user;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ServiceImpl.MeunServiceImpl;
import com.ServiceImpl.UserServiceImpl;
import com.entity.Layui;
import com.entity.Meun;
import com.entity.User;
import com.utils.PrintUtil;
import com.utils.ReturnResult;
import com.web.AbstractServlet;

@WebServlet("/UserServlet")
public class UserServlet extends AbstractServlet {

	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return UserServlet.class;
	}

	/**
	 * 查询全部用户
	 * 
	 * @param request
	 * @param response
	 */
	public String EasybuyUserLists(HttpServletRequest request, HttpServletResponse response) {
		List<Meun> meuny = new MeunServiceImpl().QuanxianFind(2, 1);
		request.getSession().setAttribute("meuny", meuny);
		return "/jsp/yonghu/xingxi";

	}

	public void EasybuyUserList(HttpServletRequest request, HttpServletResponse response) {

		Layui<User> data = new UserServiceImpl().UserList();

		PrintUtil.write(data, response);

	}
	public void DeleteUser(HttpServletRequest request, HttpServletResponse response) {
		
		 String userId= request.getParameter("userid");
		 
		 int count= new UserServiceImpl().DeleteaddUser(Integer.valueOf(userId));
		 
		 PrintUtil.write(count, response);

		
 
	}
	
	public void allUserByUserid(HttpServletRequest request, HttpServletResponse response) {
		 String userId= request.getParameter("userid");
		User data=new UserServiceImpl().UserFind(Integer.valueOf(userId));
		 PrintUtil.write(data, response);
		
	}
	public void  updateUserByAdmin (HttpServletRequest request, HttpServletResponse response) {
		String loginName = request.getParameter("name");
		String password = request.getParameter("pass");
		String userName = request.getParameter("realName");
		String sex = request.getParameter("sex"); 
		String phone = request.getParameter("phone");
		String role = request.getParameter("role");
		String age = request.getParameter("age");
		String zhicheng_id = request.getParameter("zhicheng_id");
		String bumeng_id = request.getParameter("bumeng_id");
		User user = new User();
		   user.setUserCode(loginName);
		   user.setUserName(userName);
		  user.setUserPassword(Integer.valueOf(password));
		  user.setGender(Integer.valueOf(sex));
		   user.setAge(Integer.valueOf(age)); 
		   user.setPhone(phone);
		  user.setLode_id(role);
		  user.setBumeng_id(bumeng_id);
		  user.setZhicheng_id(zhicheng_id);
		  int count=new UserServiceImpl().updateUserByAdmin(user);
		  
		  PrintUtil.write(count, response);
	}
	public void addUser(HttpServletRequest request, HttpServletResponse response) {

		 
		String loginName = request.getParameter("name");
		String password = request.getParameter("pass");
		String userName = request.getParameter("realName");
		String sex = request.getParameter("sex");
		 
		String phone = request.getParameter("phone");
		String role = request.getParameter("role");
		String age = request.getParameter("age");
		String zhicheng_id = request.getParameter("zhicheng_id");
		String bumeng_id = request.getParameter("bumeng_id");
		
		
		User user = new User();

		 
		 
		   user.setUserCode(loginName);
		   user.setUserName(userName);
		  user.setUserPassword(Integer.valueOf(password));
		  user.setGender(Integer.valueOf(sex));
		   user.setAge(Integer.valueOf(age));
		  
		   user.setPhone(phone);
		  user.setLode_id(role);
		  user.setBumeng_id(bumeng_id);
		  user.setZhicheng_id(zhicheng_id);

		  
		   
		 
		  int count=new UserServiceImpl().InsertaddUser(user);
		  
		  PrintUtil.write(count, response);

		 
	}
	public void addUserid(HttpServletRequest request, HttpServletResponse response) {

		 
		String loginName = request.getParameter("name");
		String password = request.getParameter("pass");
		String userName = request.getParameter("realName");
		String sex = request.getParameter("sex");
		 
		String phone = request.getParameter("phone");
		String role = request.getParameter("role");
		String age = request.getParameter("age");
		String zhicheng_id = request.getParameter("zhicheng_id");
		String bumeng_id = request.getParameter("bumeng_id");
		
		
		User user = new User();

		 
		 
		   user.setUserCode(loginName);
		   user.setUserName(userName);
		  user.setUserPassword(Integer.valueOf(password));
		  user.setGender(Integer.valueOf(sex));
		   user.setAge(Integer.valueOf(age));
		  
		   user.setPhone(phone);
		  user.setLode_id(role);
		  user.setBumeng_id(bumeng_id);
		  user.setZhicheng_id(zhicheng_id);

		  
		   
		 
		  int count=new UserServiceImpl().InsertaddUser(user);
		  
		  PrintUtil.write(count, response);
        this.addUserus(request, response);
		 
	}
	
	public String addUserus(HttpServletRequest request, HttpServletResponse response) {

         return "";
	}
}
