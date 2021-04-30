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
import com.utils.ReturnResult;
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
		String lode=""+request.getSession().getAttribute("lodeid");
		int lodeid=Integer.parseInt(lode);
		 List<Meun> meunq =new MeunServiceImpl().QuanxianFind(10,lodeid);
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
		String user=""+request.getSession().getAttribute("userid");
		int userid=Integer.parseInt(user);
		String lode=""+request.getSession().getAttribute("lodeid");
		int lodeid=Integer.parseInt(lode);
		Layui<User> layui = new Layui<User>();
		List<User> list = new SignServiceImpl().getUsers(userid,lodeid);
		layui.setData(list);
		layui.setCode(0);
		layui.setMsg("");
		layui.setCount(list.size());
		PrintUtil.write(layui, response);
	}
	
	/**
	 * 我要签到
	 * @param request
	 * @param response
	 * @return
	 */
	public ReturnResult isSgin(HttpServletRequest request ,HttpServletResponse response) {
		ReturnResult result=new ReturnResult();
		String user=""+request.getSession().getAttribute("userid");
		int userid=Integer.parseInt(user);
		int row=0;  //是否签到成功
		int isSign=new SignServiceImpl().signCount(userid);  //获取你当天是否已签到
		if (isSign==0) {  
		row=new SignServiceImpl().addSign(userid);  //签到成功
		}else {
			row=2;
		}
		result.setData(row);
		return result;
		
		
	}
	
	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return SignServlet.class;
	}

}
