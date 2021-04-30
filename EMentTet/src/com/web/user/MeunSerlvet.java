package com.web.user;

 

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ServiceImpl.MeunServiceImpl;
import com.ServiceImpl.UserServiceImpl;
import com.entity.Layui;
import com.entity.Meun;
import com.entity.User;
 
import com.utils.Butn;
import com.utils.PrintUtil;
import com.utils.ReturnResult;
import com.web.AbstractServlet;

 
@WebServlet("/MeunSerlvet")
public class MeunSerlvet extends AbstractServlet{

	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return MeunSerlvet.class;
	}
	
	public void fingMeundBatton(HttpServletRequest request ,HttpServletResponse response) {	
	}
	
   public void QuanUserList(HttpServletRequest request ,HttpServletResponse response) {
	  Layui<Meun> data=new MeunServiceImpl().QaunxianMeun(1);   	  
      PrintUtil.write(data, response);
	}
    public String  QuanUserLists(HttpServletRequest request ,HttpServletResponse response) {
	     
	  List<Meun> meunq =new MeunServiceImpl().QuanxianFind(4,1);
	  
	  request.getSession().setAttribute("meunq", meunq);
      return "/jsp/quanxian/quanxfenpei";
	}

/**
 * 	选择目录的时候去查询对应的上级目录
 * @param request
 * @param response
 * @return
 * @throws ServletException
 * @throws IOException
 */
       public ReturnResult menuByType2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int type = Integer.parseInt(request.getParameter("type"));
	List<Meun> menuByBtn3 = new MeunServiceImpl().menuByBtn3(type-1);
	ReturnResult result = new ReturnResult();
	result.setData(menuByBtn3);
	return result;
}
/**
 * 新增权限信息
 * @param request
 * @param response
 * @return
 */
  public void addMenu(HttpServletRequest request ,HttpServletResponse response) {
	String mname=request.getParameter("mname");
	String mfunction=request.getParameter("mfunction");
	String type2=request.getParameter("type2");
	String icon=request.getParameter("icon");
	String mbtn=request.getParameter("mbtn");
	String father=request.getParameter("father");
 int count=0;
	Meun deng=new Meun();
	deng.setmName(mname);
	deng.setType(Integer.valueOf(type2));
	 deng.setFatherid(Integer.valueOf(father));
	 deng.setMben(mbtn);
	count =new MeunServiceImpl().addDenglu(deng);
	PrintUtil.write(count, response);
}
  public void 	allButtenType(HttpServletRequest request ,HttpServletResponse response) {
	 
	List<Butn> bt=new ArrayList<Butn>();
	bt=new MeunServiceImpl().ButnFan(0);
	 
	 PrintUtil.write(bt, response);
}
  /**
   * 删除权限
   * @param request
   * @param response
   */
  public void 	delMenu(HttpServletRequest request ,HttpServletResponse response) {
		String menuid=request.getParameter("menuid");
	  int bt=0;
		bt=new MeunServiceImpl().DeleteDenglu(Integer.valueOf(menuid));
		 
		 PrintUtil.write(bt, response);
	  
  }
  /**
   * 根据权限id查询权限信息
   * @param request
   * @param response
   */
  public void 	allMenuById(HttpServletRequest request ,HttpServletResponse response) {
		String menuid=request.getParameter("menuid");
	 
	Meun	data=new MeunServiceImpl().quanxMeuncha(Integer.valueOf(menuid));
		 
		 PrintUtil.write(data, response);
	  
}
  public void isMenuName(HttpServletRequest request ,HttpServletResponse response) {
	  String mname=request.getParameter("mname");
	  int count =new MeunServiceImpl().QuanxianCount(mname);
	  PrintUtil.write(count, response);
  }
  
  /**
   *  修改权限
   * @param request
   * @param response
   * @return
   */
    public void upMenu(HttpServletRequest request ,HttpServletResponse response) {
    	String id =request.getParameter("mid");
  	String mname=request.getParameter("mname");
  	String mfunction=request.getParameter("mfunction");
  	String type2=request.getParameter("type2");
  	String icon=request.getParameter("icon");
  	String mbtn=request.getParameter("mbtn");
  	String father=request.getParameter("father");
   int count=0;
  	Meun deng=new Meun();
  	deng.setId(Integer.valueOf(id));
  	deng.setmName(mname);
  	deng.setType(Integer.valueOf(type2));
  	 deng.setFatherid(Integer.valueOf(father));
  	 deng.setMben(mbtn);
  	count =new MeunServiceImpl().UpdateDenglu(deng);
  	PrintUtil.write(count, response);
  }
}

