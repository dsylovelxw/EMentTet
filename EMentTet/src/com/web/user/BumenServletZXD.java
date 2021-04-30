package com.web.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ServiceImpl.BumenServiceImplZXD;
import com.ServiceImpl.MeunServiceImpl;
import com.entity.Layui;
import com.entity.Lr_bumeng;
import com.entity.Meun;
import com.utils.PrintUtil;
import com.web.AbstractServlet;

@SuppressWarnings("serial")
@WebServlet("/BumenServletZXD")
public class BumenServletZXD extends AbstractServlet{

	
	public String BumenBtn(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		List<Meun> meunj =new MeunServiceImpl().QuanxianFind(30,1);
		  request.getSession().setAttribute("meunj", meunj);
	      return "/jsp/bumen/xingxi";
    }
	
	public void BumenAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		Layui<Lr_bumeng>layui=new Layui<Lr_bumeng>();
		List<Lr_bumeng>list=new BumenServiceImplZXD().gitBumens();
		layui.setCode(0);;
		layui.setCount(list.size());
		layui.setMsg("");
		layui.setData(list);
		PrintUtil.write(layui, response);
    }
	
	
	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return BumenServletZXD.class;
	}

}
