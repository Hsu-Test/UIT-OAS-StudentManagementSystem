package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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

import Util.DatabaseException;

@WebServlet(name="StudentList",urlPatterns="/studentList.do")
public class StudentListServlet extends HttpServlet {

	private static final String URL = "jdbc:h2:tcp://localhost/~/student";
    private String SQL;
	//private String SQL;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);

		String loc = (String)req.getParameter("location");


		List<Map<String, String>> results = new ArrayList<Map<String, String>>();

    	System.out.println("showALL");
		  // do 'B' stuff
	SQL = "SELECT * FROM STUDENTS";
			//showList();
    req.setCharacterEncoding("UTF-8");
     		      try {
		          Class.forName("org.h2.Driver");
		      } catch (ClassNotFoundException e) {
		          e.printStackTrace();
		          throw new DatabaseException(e.getMessage());
		      }
		      System.out.println(results.size());

    try (
    	Connection conn = DriverManager.getConnection(URL, "demo", "demo");
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(SQL);) {
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
      }

    resp.setCharacterEncoding("UTF-8");
    req.setAttribute("location",loc);
    resp.setCharacterEncoding("UTF-8");
    req.setAttribute("results", results);
    resp.setCharacterEncoding("UTF-8");
    req.setAttribute("results", results);
    System.out.println("size"+results.size());
    System.out.println("size"+resp.toString());

    ServletContext sc = getServletContext();
    RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/jsp/studentList.jsp");
	rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//req.setCharacterEncoding("UTF-8");

    	String searchKey = (String)req.getParameter("search_key");
        String specificKey = null;
        String loc = (String)req.getParameter("location");

    	if(null != req.getParameter("search")){
    		  // do 'A' stuff
    		List<Map<String, String>> results = new ArrayList<Map<String, String>>();


            if(searchKey!=null){
            	switch(searchKey){
            	case "name" :{
            		specificKey = (String) req.getParameter("name");
            		System.out.println(specificKey);
            		SQL = "SELECT * FROM STUDENTS WHERE s_name like '"+specificKey+"%';";
            		break;
            	}
            	case "year" :{
            		specificKey = (String) req.getParameter("year");
            		SQL = "SELECT * FROM STUDENTS WHERE s_year='"+specificKey+"';";
            		break;
            	}
            	case "major" :{
            		specificKey = (String) req.getParameter("major");
            		SQL = "SELECT * FROM STUDENTS WHERE s_major='"+specificKey+"';";
            		break;
            	}
            	}
            	if(specificKey!=null){

                		      try {
                		          Class.forName("org.h2.Driver");
                		      } catch (ClassNotFoundException e) {
                		          e.printStackTrace();
                		          throw new DatabaseException(e.getMessage());
                		      }

                    try (
                    	Connection conn = DriverManager.getConnection(URL, "demo", "demo");
                         Statement stmt = conn.createStatement();
                         ResultSet rs = stmt.executeQuery(SQL);) {
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

                	}catch (SQLException e) {
                          e.printStackTrace();
                          throw new DatabaseException(e.getMessage());
                      }



                		/*}

                		else if(null != req.getParameter("back")){
                		  // do 'C' stuff
                		}*/

                    resp.setCharacterEncoding("UTF-8");
                    req.setAttribute("location",loc);
                    resp.setCharacterEncoding("UTF-8");
                    req.setAttribute("specificKey",specificKey);
                    resp.setCharacterEncoding("UTF-8");
                    req.setAttribute("searchKey",searchKey);
                    resp.setCharacterEncoding("UTF-8");
                    req.setAttribute("results", results);
                    resp.setCharacterEncoding("UTF-8");
                    req.setAttribute("results", results);

                	}


    	}
            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/jsp/studentList.jsp");
    		rd.forward(req, resp);
    		}
    		else if(null != req.getParameter("showAll")){
        List<Map<String, String>> results = new ArrayList<Map<String, String>>();

        	System.out.println("showALL");
    		  // do 'B' stuff
    	SQL = "SELECT * FROM STUDENTS";
    			//showList();
        req.setCharacterEncoding("UTF-8");
         		      try {
    		          Class.forName("org.h2.Driver");
    		      } catch (ClassNotFoundException e) {
    		          e.printStackTrace();
    		          throw new DatabaseException(e.getMessage());
    		      }
    		      System.out.println(results.size());

        try (
        	Connection conn = DriverManager.getConnection(URL, "demo", "demo");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL);) {
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
          }

        resp.setCharacterEncoding("UTF-8");
        req.setAttribute("location",loc);
        resp.setCharacterEncoding("UTF-8");
        req.setAttribute("results", results);
        resp.setCharacterEncoding("UTF-8");
        req.setAttribute("results", results);
        System.out.println("size"+results.size());
        System.out.println("size"+resp.toString());

        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/jsp/studentList.jsp");
		rd.forward(req, resp);
        }


	}

}
