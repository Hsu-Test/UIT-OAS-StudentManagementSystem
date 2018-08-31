package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.dbo.DatabaseException;

@WebServlet(name = "DatabaseReg", urlPatterns = "/db.do")
public class db extends HttpServlet {
	private static final String URL = "jdbc:h2:tcp://localhost/~/student";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/jsp/welcome_page.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		String sidv = null, phov = null, emailv = null, nrcv = null;

		String sid = req.getParameter("sid");
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		String acyear = req.getParameter("acyear");
		String major = req.getParameter("major");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		String dob = req.getParameter("dob");
		String fname = req.getParameter("fname");
		String nrc = req.getParameter("nrc");
		System.out.println(name);

		req.setAttribute("sid",sid);
		req.setAttribute("name",name);
		req.setAttribute("address",address);
		req.setAttribute("phone",phone);
		req.setAttribute("acyear",acyear);
		req.setAttribute("major",major);
		req.setAttribute("email",email);
		req.setAttribute("gender",gender);
		req.setAttribute("dob",dob);
		req.setAttribute("fname",fname);
		req.setAttribute("nrc",nrc);


		String sql = "SELECT * FROM STUDENTS WHERE S_NRC='" + nrc + "'";
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DatabaseException(e.getMessage());
		}
		try (Connection conn = DriverManager.getConnection(URL, "demo", "demo");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				PreparedStatement ps = conn.prepareStatement("insert into students values(?,?,?,?,?,?,?,?,?,?,?)");) {
			if(rs.next()) {
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Student Register</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1 style='color:red'>Error</h1>");
				out.println("<p style='color:red'>The student with the same NRC number is already registered.</p></br>");
				//out.println("<a href='welcome_page.jsp'><input type='button' name='back' value='BACK'></a>");
				out.println("<input type='button' name='back' value='BACK' onclick='history.back()'>");
				out.println("</body>");
				out.println("</html>");
			}
			else {
				ps.setString(1, sid);
				ps.setString(2, name);
				ps.setString(3, address);
				ps.setString(4, phone);
				ps.setString(5, acyear);
				ps.setString(6, major);
				ps.setString(7, email);
				ps.setString(8, dob);
				ps.setString(9, gender);
				ps.setString(10, fname);
				ps.setString(11, nrc);
				int i = ps.executeUpdate();
				if (i > 0) {
					out.println("<html>");
					out.println("<head>");
					out.println("<title>Student Register</title>");
					out.println("</head>");
					out.println("<body>");
					out.println("<p>Successfully Added</p>");
					out.println("</body>");
					out.println("</html>");
				} else {
					System.out.println("Fail");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException(e.getMessage());
		}
	}

}
