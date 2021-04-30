package com.web.user;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ServiceImpl.JueseServiceImpl;
import com.ServiceImpl.MeunServiceImpl;
import com.entity.Juese;
import com.entity.Layui;
import com.entity.Lr_bumeng;
import com.entity.Lr_zhicheng;
import com.entity.Meun;
import com.entity.User;
import com.utils.PrintUtil;
import com.web.AbstractServlet;

@WebServlet("/JueseServlet")
public class JueseServlet extends AbstractServlet{

	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return JueseServlet.class;
	}
	 public void JueseList(HttpServletRequest request ,HttpServletResponse response) {
		  Layui<User> data=new JueseServiceImpl().jueseLists()	  ;
	      PrintUtil.write(data, response);
		}
	    public String  JueseLists(HttpServletRequest request ,HttpServletResponse response) {
		     
		  List<Meun> meunj =new MeunServiceImpl().QuanxianFind(5,1);
		  
		  request.getSession().setAttribute("meunj", meunj);
	      return "/jsp/juese/xingxi";
		}
	public void allRole(HttpServletRequest request ,HttpServletResponse response) {	
		List<Juese> juese=new JueseServiceImpl().jueseList();
		
		
		PrintUtil.write(juese, response);
		
	}
	public void allZhicheng(HttpServletRequest request ,HttpServletResponse response) {	
		List<Lr_zhicheng> Lr_zhicheng=new JueseServiceImpl().Lr_zhichengList();
		
		
		PrintUtil.write(Lr_zhicheng, response);
		
	}
	public void allBumeng(HttpServletRequest request ,HttpServletResponse response) {	
		List<Lr_bumeng> Lr_bumeng=new JueseServiceImpl().Lr_bumengList();
		
		
		PrintUtil.write(Lr_bumeng, response);
		
	}
}
