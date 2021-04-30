package com.web.user;

 

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ServiceImpl.DengluServiceImpl;
import com.ServiceImpl.MeunServiceImpl;
import com.entity.Meun;
import com.entity.User;
import com.utils.ReturnResult;
import com.utils.SecurityUtils;
import com.web.AbstractServlet;

@WebServlet("/DengLuServlet")
public class DengLuServlet extends AbstractServlet{

	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return DengLuServlet.class;
	}
	
	
	
	
	
	public ReturnResult DengluYan(HttpServletRequest request ,HttpServletResponse response) {
		String loginName=request.getParameter("name");
		
		String password1=request.getParameter("pwd");
		int password=Integer.valueOf(password1);
		ReturnResult result=new ReturnResult();
		User user= new DengluServiceImpl().DengluName(loginName);
	
		if (user == null) {
			// 判断该用户是否注册！！
			return result.returnFail("用户不存在");
		} else {
			// 注册了判断用户是否输入正确密码！
			if (user.getUserCode().equals(loginName) && user.getUserPassword()==password) {
				// 登陆成功！账号密码匹配！！
				
				  List<Meun> de=new MeunServiceImpl().DengluUser(Integer.valueOf(user.getLode_id()));
				 request.getSession().setAttribute("user", user);
				  request.getSession().setAttribute("de", de);
				 
				return result.returnSuccess("登陆成功");
			} else {
				return result.returnFail("输入的用户名或密码错误");
			}
		
		}
	 
		}
}
