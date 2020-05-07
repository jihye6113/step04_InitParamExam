package ex0410.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamTestServlet extends HttpServlet {
	String id, addr;
	String message, age;
	
	// 필요한 메소드 재정의
	@Override
	public void init() throws ServletException {
		System.out.println("InitParamTestServlet의 init 호출됨");
		id = super.getInitParameter("id");
		addr = super.getInitParameter("addr");
		
		// context-param 가져오기
		ServletContext application = super.getServletContext();
		message = application.getInitParameter("message");
		age = application.getInitParameter("age");
	}
	
	@Override
	protected void service(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		// 기능
		PrintWriter out = response.getWriter();
		out.println("<h2>");
		out.println("아이디: " + id + "<br>");
		out.println("주소: " + addr + "<br>");
		
		out.println("메세지: " + message + "<br>");
		out.println("나이: " + age + "<br>");
		out.println("</h2>");
	}
}
