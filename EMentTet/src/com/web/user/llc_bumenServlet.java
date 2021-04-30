package com.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ServiceImpl.llc_ServiceImpl;
import com.entity.Lr_bumeng;
import com.web.AbstractServlet;


@WebServlet("/bumen")
public class llc_bumenServlet extends AbstractServlet {
	
	/**
	 * ��������
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public int addbumen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Lr_bumeng men = new Lr_bumeng();
		men.setMeng_name(request.getParameter("name"));
		men.setRenshu_id(Integer.parseInt(request.getParameter("shu")));
		men.setUserId(Integer.parseInt(request.getParameter("userid")));
		int isYes = 0; // ������Ϣ
		int row = new llc_ServiceImpl().addbumen(men);
		if (row > 0) { // �ж��û��Ƿ����ӳɹ�
			// �����û���¼����ѯ�û�����Ϣ
			isYes = 1;
		}
		return isYes;
	}
	/**
	 * ɾ������
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public int delbumen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("userid"));
		int isYes = 0; // ������Ϣ
		int row = new llc_ServiceImpl().delbumen(id);
		if (row > 0) { // �ж��û��Ƿ����ӳɹ�
			// �����û���¼����ѯ�û�����Ϣ
			isYes = 1;
		}
		return isYes;
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return llc_bumenServlet.class;
	}
}
