package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.dbo.DatabaseException;

@WebServlet(name = "DatabaseDelete", urlPatterns = "/delete.do")
public class delete extends HttpServlet {
	private static final String URL = "jdbc:h2:tcp://localhost/~/student";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String sid=req.getParameter("studidDelete");
		System.out.println(sid);
		//String sql = "DELETE FROM STUDENT WHERE NRC='"+nrc+"'";
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DatabaseException(e.getMessage());
		}
		try (
				Connection conn = DriverManager.getConnection(URL, "demo", "demo");
			    PreparedStatement ps=conn.prepareStatement("DELETE FROM STUDENTS WHERE S_ID="+4+";");
				)
		{
			ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException(e.getMessage());
		}
	}

}
