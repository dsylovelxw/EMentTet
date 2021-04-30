package com.web.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ServiceImpl.MeunServiceImpl;
import com.ServiceImpl.SignServiceImpl;
import com.entity.Layui;
import com.entity.Meun;
import com.entity.User;
import com.utils.PrintUtil;
import com.web.AbstractServlet;

@SuppressWarnings("serial")
@WebServlet("/SignServlet")
public class SignServlet extends AbstractServlet{

	/**
	 * 签到按钮
	 * @param request
	 * @param response
	 * @return
	 */
	public String signBtn(HttpServletRequest request ,HttpServletResponse response) {
		
		 List<Meun> meunq =new MeunServiceImpl().QuanxianFind(10,1);
		  request.getSession().setAttribute("meunz", meunq);
	   
	      return "jsp/sign/signList";
		}
	
	/**
	 * 签到列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void signAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Layui<User> layui = new Layui<User>();
		List<User> list = new SignServiceImpl().getUsers();
		layui.setData(list);
		layui.setCode(0);
		layui.setMsg("");
		layui.setCount(list.size());
		PrintUtil.write(layui, response);
	}
	
	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return SignServlet.class;
	}

}
