package web.db.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp01")
public class jsp01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public jsp01() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>파라미터 값 받기 실험</h1>");
		String name = request.getParameter("name");
		String blog = request.getParameter("blog");
		
		out.println("<b>");
		out.println("<p> 이름: " + name + "</p>");
		out.println("<p> 블로그: " + blog + "</p>");
		out.println("</b>");
		
		//파라미터 값 더하기
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
		out.println("<p>" + su1 + " + " + su2 + " = " + (su1+su2) + "</p>");
	}

}
