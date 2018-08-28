package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="welcome",urlPatterns="/welcome.do")
public class Welcome extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//resp.sendRedirect("/StudentManagement/WEB-INF/jsp/welcome.jsp");

		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp");
		rd.forward(req, resp);
		}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Successfully Submitted");
		String helloworld = "Hello world";
		req.setAttribute("helloworld", helloworld);
		req.setAttribute("location", "welcome");

		System.out.println("studid"+req.getParameter("studid"));

		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/jsp/studentList.jsp");
		rd.forward(req, resp);
	}



}
