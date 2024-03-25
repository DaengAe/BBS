package web.db.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/jsp04")
public class jsp04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public jsp04() {
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
		
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math"));
		
		int total = kor + eng + math ;
		double avg =  (int)(total /3.0 *10) /10.0 ;
		String hak = "";
		if(avg>=90) {
			hak = "A";
		}else if(avg>=80) {
			hak = "B";
		}else if(avg>=70) {
			hak = "C";
		}else{
			hak = "F";
		}
		
		out.println("<h3><ul>");
		out.println("<li> 이름 : "+ name + "</li>" );
		out.println("<li> 국어 : "+ kor + "</li>" );
		out.println("<li> 영어 : "+ eng + "</li>" );
		out.println("<li> 수학 : "+ math + "</li>" );
		out.println("<li> 총점 : "+ total + "</li>" );
		out.println("<li> 평균 : "+ avg + "</li>" );
		out.println("<li> 학점 : "+ hak + "</li>" );
		out.println("</ul></h3>");
	}

}