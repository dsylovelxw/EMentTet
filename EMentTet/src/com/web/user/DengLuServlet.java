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
			// �жϸ��û��Ƿ�ע�ᣡ��
			return result.returnFail("�û�������");
		} else {
			// ע�����ж��û��Ƿ�������ȷ���룡
			if (user.getUserCode().equals(loginName) && user.getUserPassword()==password) {
				// ��½�ɹ����˺�����ƥ�䣡��
				
				  List<Meun> de=new MeunServiceImpl().DengluUser(Integer.valueOf(user.getLode_id()));
				 request.getSession().setAttribute("user", user);
				  request.getSession().setAttribute("de", de);
				  request.getSession().setAttribute("userid", user.getId());  //在session存储用户ID
				  request.getSession().setAttribute("lodeid", user.getLode_id()); //在session存储角色id
				return result.returnSuccess("��½�ɹ�");
			} else {
				return result.returnFail("������û������������");
			}
		
		}
	 
		}
}
