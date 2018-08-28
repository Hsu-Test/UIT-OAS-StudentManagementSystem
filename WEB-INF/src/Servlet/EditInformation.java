package Servlet;

import java.io.IOException;
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

import Util.DatabaseException;

@WebServlet(name="WHP",urlPatterns="/Edit.do")
public class EditInformation extends HttpServlet {

	  static final String JDBC_DRIVER = "org.h2.Driver";
	   static final String DB_URL = "jdbc:h2:tcp://localhost/~/student";

	   //  Database credentials
	   static final String USER = "demo";
	   static final String PASS = "demo";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
		Connection conn = null;
	      Statement stmt = null;

	      /*try {
	         // STEP 1: Register JDBC driver
	         Class.forName(JDBC_DRIVER);
	         //STEP 2: Open a connection
	         System.out.println("Connecting to database...");
	         conn = DriverManager.getConnection(DB_URL,USER,PASS);

	         //STEP 3: Execute a query
	         System.out.println("Creating table in given database...");
	         stmt = conn.createStatement();
	      } catch (SQLException e) {
	            e.printStackTrace();
	            throw new DatabaseException(e.getMessage());
	        }catch (ClassNotFoundException c){
	        	c.printStackTrace();
	        }*/

	      int sid=Integer.parseInt(req.getParameter("studidEdit"));
	      System.out.println("sid="+sid);
	      String SQL = "SELECT * FROM STUDENTS WHERE S_ID='"+sid+"';";
	      try {
	          Class.forName("org.h2.Driver");
	      } catch (ClassNotFoundException e) {
	          e.printStackTrace();
	          throw new DatabaseException(e.getMessage());
	      }

	      try {
	    	  conn = DriverManager.getConnection(DB_URL, "demo", "demo");
	    	  stmt = conn.createStatement();
	    	  ResultSet rs = stmt.executeQuery(SQL);
	    	  int i=1;
	    	  while (rs.next()) {
	    	
	    		  req.setAttribute("sname", rs.getString(2));


	    		  i++;
	    	  }

	      }catch (SQLException e) {
	    	  e.printStackTrace();
	    	  throw new DatabaseException(e.getMessage());
	      }


	      req.setAttribute("sid",sid);
	      ServletContext sc = getServletContext();
	      RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/jsp/EditInformationLayout.jsp");
	      rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub

		  String SName=req.getParameter("StName");
		  String SAddress=req.getParameter("StAddress");
		  int SPhNo=Integer.parseInt(req.getParameter("StPhoneNum"));
		  String SYear=req.getParameter("StYear");
		  String SMajor=req.getParameter("StMajor");
		  String SEmail=req.getParameter("email");
		  String SDOB=req.getParameter("dob");
		  String SGender=req.getParameter("gender");
		  String SFatherName=req.getParameter("fatherName");
		  String SNRC=req.getParameter("nrc");

		  int sid=Integer.parseInt(req.getParameter("studid"));

		  System.out.println("NRC"+SNRC);


		  Connection conn = null;
	      Statement stmt = null;
	      try {
	         // STEP 1: Register JDBC driver
	         Class.forName(JDBC_DRIVER);

	         //STEP 2: Open a connection
	         System.out.println("Connecting to database...");
	         conn = DriverManager.getConnection(DB_URL,USER,PASS);

	         //STEP 3: Execute a query
	         System.out.println("Creating table in given database...");
	         //stmt = conn.createStatement();

	         String idr = "UPDATE STUDENTS SET S_NAME=?,S_ADDRESS=?,S_PHONE=?,S_YEAR=?,S_MAJOR=?,S_EMAIL=?,S_DOB=?,S_GENDER=?, S_FATHER_NAME=?,S_NRC=? WHERE S_ID="+sid;
	        		PreparedStatement pst=conn.prepareStatement(idr);
	        		pst.setString(1, SName);
	        		 pst.setString(2, SAddress);
	        		 pst.setInt(3, SPhNo);
	        		 pst.setString(4, SYear);
	        		 pst.setString(5, SMajor);
	        		 pst.setString(6, SEmail);
	        		 pst.setString(7, SDOB);
	        		 pst.setString(8, SGender);
	        		 pst.setString(9, SFatherName);
	        		 pst.setString(10, SNRC);

	        		 pst.executeUpdate();
	        		 conn.setAutoCommit(true);

	         } catch (SQLException e) {
	            e.printStackTrace();
	            throw new DatabaseException(e.getMessage());
	        } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      /*catch (ClassNotFoundException c){
	        	c.printStackTrace();
	        }*/
	      resp.setCharacterEncoding("UTF-8");

	        ServletContext sc = getServletContext();
	        RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/jsp/EditInformationLayout.jsp");
	        rd.forward(req, resp);

	    }
}
