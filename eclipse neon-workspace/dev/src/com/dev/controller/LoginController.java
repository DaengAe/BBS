package com.dev.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class LoginController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Parameter ����
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String job = request.getParameter("job");
		
		String path = null;
		if (job.equals("login"))
			path = "/login.jsp";
		else if (job.equals("search"))
			path = "/memberSearch.jsp";
		else if (job.equals("update"))
			path = "/memberUpdate.jsp";
		else if (job.equals("delete"))
			path = "/memberDelete.jsp";	
		
		
		if (id.isEmpty()) {
			request.setAttribute("error", "ID�� �Է����ֽñ� �ٶ��ϴ�!");
			HttpUtil.forward(request, response, path);
			return;
		}
		
		else if (passwd.isEmpty()) {
			request.setAttribute("error", "��й�ȣ�� �Է����ֽñ� �ٶ��ϴ�!");
			HttpUtil.forward(request, response, path);
			return;
		}
		
		// Service ��ü�� �޼��� ȣ��
		MemberService service = MemberService.getInstance();
		MemberVO member = service.login(id, passwd);
		
		// Output View �������� �̵�
		if (member == null) request.setAttribute("result", "���̵�� ��й�ȣ�� �ٽ� Ȯ�����ּ���.");
		request.setAttribute("member", member);
		
		if(job.equals("login")) path="/result/loginOutput.jsp";
		HttpUtil.forward(request, response, path);
		

	}
	
}
