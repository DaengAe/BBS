package com.dev.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberSearchController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Parameter 추출
		String id = request.getParameter("id");
		String job = request.getParameter("job");

		String path = null;
		if (job.equals("search"))
			path = "/memberSearch.jsp";
		else if (job.equals("update"))
			path = "/memberUpdate.jsp";
		else if (job.equals("delete"))
			path = "/memberDelete.jsp";	
		
		// 유효성 체크
		if (id.isEmpty()) {
			request.setAttribute("error", "ID를 입력해주시기 바랍니다!");
			HttpUtil.forward(request, response, path);
			return;
		}

		// Service 객체의 메서드 호출
		MemberService service = MemberService.getInstance();
		MemberVO member = service.memberSearch(id);


		// Output View 페이지로 이동
		if (member == null) request.setAttribute("result", "검색된 정보가 없습니다!");
		request.setAttribute("member", member);

		if(job.equals("search")) path="/result/memberSearchOutput.jsp";
		HttpUtil.forward(request, response, path);

	}
}
