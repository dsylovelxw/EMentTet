package com.web.user;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ServiceImpl.BuMenServiceImplDSY;
import com.entity.Lr_bumeng;
import com.utils.PrintUtil;
import com.web.AbstractServlet;

@WebServlet("/BuMenSerlvetDSY")
public class BuMenSerlvetDSY  extends AbstractServlet{

	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return BuMenSerlvetDSY.class;
	}
public void isUname(HttpServletRequest request,HttpServletResponse response) {
	String uname=  request.getParameter("uname");
	int cout=new BuMenServiceImplDSY().NameLr_bumen(uname);
	PrintUtil.write(cout, response);
	
}
public void updateUserByAdmin(HttpServletRequest request,HttpServletResponse response) {
	String name=  request.getParameter("name");
	String id=  request.getParameter("id");
	String renshu=  request.getParameter("renshu");
	String userid=  request.getParameter("userid");
	
	Lr_bumeng bum=new Lr_bumeng();
	bum.setId(Integer.valueOf(id));
	bum.setMeng_name(name);
	 bum.setRenshu_id(Integer.valueOf(renshu));
	 bum.setUserId(Integer.valueOf(userid));
	int cout=new BuMenServiceImplDSY().UpdateLr_bumeng(bum);
	PrintUtil.write(cout, response);
	
}
public void  allUserByUserid(HttpServletRequest request,HttpServletResponse response) {
	String id=  request.getParameter("userid");
 
	Lr_bumeng bum =new BuMenServiceImplDSY().Lr_bumengFind(Integer.valueOf(id));
PrintUtil.write(bum, response);
}

}
