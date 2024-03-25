package com.dev.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class LoginController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Parameter 추출
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
			request.setAttribute("error", "ID를 입력해주시기 바랍니다!");
			HttpUtil.forward(request, response, path);
			return;
		}
		
		else if (passwd.isEmpty()) {
			request.setAttribute("error", "비밀번호를 입력해주시기 바랍니다!");
			HttpUtil.forward(request, response, path);
			return;
		}
		
		// Service 객체의 메서드 호출
		MemberService service = MemberService.getInstance();
		MemberVO member = service.login(id, passwd);
		
		// Output View 페이지로 이동
		if (member == null) request.setAttribute("result", "아이디와 비밀번호를 다시 확인해주세요.");
		request.setAttribute("member", member);
		
		if(job.equals("login")) path="/result/loginOutput.jsp";
		HttpUtil.forward(request, response, path);
		

	}
	
}
