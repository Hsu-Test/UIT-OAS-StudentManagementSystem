package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.dbo.DatabaseException;



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

	      int sid=Integer.parseInt(req.getParameter("studidEdit"));
	      System.out.println("sid="+sid);
	      String SQL="SELECT*FROM STUDENTS WHERE S_ID="+sid+";";
	      req.setCharacterEncoding("UTF-8");
	      try{
	    	  Class.forName(JDBC_DRIVER);
	      }catch(ClassNotFoundException e)
	      {e.printStackTrace();
	      throw new DatabaseException(e.getMessage());
	      }

	      try{
	    	  conn = DriverManager.getConnection(DB_URL,USER,PASS);
	    	  stmt=conn.createStatement();
	    	  ResultSet rs=stmt.executeQuery(SQL);
	    	  int i=1;
	    	  while(rs.next()){
	    		  req.setAttribute("studid1", rs.getInt(1));
	    		  req.setAttribute("sname", rs.getString(2));
	    		  req.setAttribute("saddress", rs.getString(3));
	    		  req.setAttribute("sphoneno", rs.getString(4));
	    		  req.setAttribute("syear", rs.getString(5));
	    		  req.setAttribute("major", rs.getString(6));
	    		  req.setAttribute("semail", rs.getString(7));
	    		  req.setAttribute("sdob", rs.getString(8));
	    		  req.setAttribute("sgender", rs.getString(9));
	    		  req.setAttribute("sfather", rs.getString(10));
	    		  req.setAttribute("snrc", rs.getString(11));

	    		  i++;
	    	  }
	      }catch(SQLException e){
	    	  e.printStackTrace();
	    	  throw new DatabaseException(e.getMessage());
	      }
	      resp.setCharacterEncoding("UTF-8");
	      req.setAttribute("sid", sid);

		 ServletContext sc = getServletContext();
	        RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/jsp/EditInformationLayout.jsp");
	        rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		  String SName=req.getParameter("StName");
		  String SAddress=req.getParameter("StAddress");
		  String SPhNo=req.getParameter("StPhoneNum");
		  String SYear=req.getParameter("StYear");
		  String SMajor=req.getParameter("StMajor");
		  String SEmail=req.getParameter("email");
		  String SDOB=req.getParameter("dob");
		  String SGender=req.getParameter("gender");
		  String SFatherName=req.getParameter("fatherName");
		  String SNRC=req.getParameter("nrc");

		 /* resp.setContentType("text/html");
		  PrintWriter pwinsert=resp.getWriter();*/

		  Connection conn = null;
	      Statement stmt = null;
	      List<Map<String, String>> results = new ArrayList<Map<String, String>>();

	      req.setCharacterEncoding("UTF-8");
	      try {
	         // STEP 1: Register JDBC driver
	         Class.forName(JDBC_DRIVER);

	         //STEP 2: Open a connection
	         System.out.println("Connecting to database...");
	         conn = DriverManager.getConnection(DB_URL,USER,PASS);

	         //STEP 3: Execute a query
	         System.out.println("Creating table in given database...");
	         stmt = conn.createStatement();
	         int sid=Integer.parseInt(req.getParameter("StID"));
	         //int sid=req.getParameter("stID");

	         System.out.println("sid"+sid);
	         String idr = "UPDATE STUDENTS SET S_NAME=?,S_ADDRESS=?,S_PHONE=?,S_YEAR=?,S_MAJOR=?,S_EMAIL=?,S_DOB=?,S_GENDER=?, S_FATHER_NAME=?,S_NRC=? WHERE S_ID="+sid;
	         //String idr = "UPDATE STUDENTS SET S_NAME=?,S_ADDRESS=? WHERE S_ID="+sid;

	         PreparedStatement pst=conn.prepareStatement(idr);
	        		 pst.setString(1, SName);
	        		 pst.setString(2, SAddress);
	        		 pst.setString(3, SPhNo);
	        		 pst.setString(4, SYear);
	        		 pst.setString(5, SMajor);
	        		 pst.setString(6, SEmail);
	        		 pst.setString(7, SDOB);
	        		 pst.setString(8, SGender);
	        		 pst.setString(9, SFatherName);
	        		 pst.setString(10, SNRC);
	        		 pst.executeUpdate();





	        	    String SQL = "SELECT * FROM STUDENTS WHERE s_name like '"+SName+"%';";
	        				//showList();

	        	    ResultSet rs = stmt.executeQuery(SQL);
	        	    		int i=1;
	        	          while (rs.next()) {
	        	        	  String j=Integer.toString(i);
	        	              results.add(new LinkedHashMap<String, String>() {
	        	                  {
	        	                      put("#",j);
	        	                      put("SID", rs.getString(1));
	        	                      put("Name", rs.getString(2));
	        	                      put("Address", rs.getString(3));
	        	                      put("PhoneNo.", rs.getString(4));
	        	                      put("Academic Year.", rs.getString(5));
	        	                      put("Major.", rs.getString(6));
	        	                      put("Email.", rs.getString(7));
	        	                      put("Date of Birth.", rs.getString(8));
	        	                      put("Gender.", rs.getString(9));
	        	                      put("Father's Name.", rs.getString(10));
	        	                      put("NRC", rs.getString(11));

	        	                  }
	        	              });
	        	              i++;
	        	          }
	        	          System.out.println(results.size());

	        		}catch (SQLException e) {
	        	          e.printStackTrace();
	        	          throw new DatabaseException(e.getMessage());
	        	      } catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

	        	    resp.setCharacterEncoding("UTF-8");
	        	    //req.setAttribute("location",loc);
	        	    resp.setCharacterEncoding("UTF-8");
	        	    //req.setAttribute("results", results);
	        	    resp.setCharacterEncoding("UTF-8");
	        	    //req.setAttribute("results", results);
	        	    //System.out.println("size"+results.size());
	        	    System.out.println("size"+resp.toString());
	        	    resp.setCharacterEncoding("UTF-8");
	        	    //req.setAttribute("location",loc);
	        	    //resp.setCharacterEncoding("UTF-8");
	        	    req.setAttribute("results", results);
	        	    resp.setCharacterEncoding("UTF-8");
	        	    req.setAttribute("results", results);
	        	    System.out.println("size"+results.size());
	        	    System.out.println("size"+resp.toString());


	        	    ServletContext sc = getServletContext();
	        	    RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/jsp/studentList.jsp");
	        		rd.forward(req, resp);

	        		 //resp.sendRedirect("St/WEB-INF/jsp/studentList.jsp");
	        		  return;
	        		 //resp.sendRedirect("/studentList.do");


	      /*catch (ClassNotFoundException c){
	        	c.printStackTrace();
	        }*/

	    }
}
