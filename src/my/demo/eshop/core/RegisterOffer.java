package my.demo.eshop.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.joda.time.DateTime;

//import org.joda.time.DateTime;
//import org.joda.time.format.DateTimeFormat;
//import org.joda.time.format.DateTimeFormatter;

import my.demo.eshop.Offer;
import my.demo.eshop.database.DatabaseManager;

/**
 * Servlet implementation class RegisterOffer
 */
@WebServlet("/RegisterOffer")
public class RegisterOffer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="demoeshop")    
	private DataSource dataSource;
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterOffer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = (String) request.getParameter("name");
		String description = (String) request.getParameter("description");
		String price = (String) request.getParameter("price");
		String time = (String) request.getParameter("time");
		System.out.println("recieved ok");
		//DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.S");
		Connection conn = null;
		
		try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/demoeshop","root","sotiria");
				DatabaseManager dbManager = new DatabaseManager();
				
				DateTime date = new DateTime();
				date = date.plusHours(Integer.parseInt(time));
				//System.out.println(date.toString());
				Offer offer = new Offer(1, name, description, price, date, "active");
				dbManager.setOffer(conn, offer);
												
				//get the newclient's ID?
				//request.setAttribute("userId",userId);
				
				//redirect to the order page
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/success.jsp");
				requestDispatcher.forward(request, response);
			
			
				
		}catch (SQLException e)
		{
			throw new RuntimeException("SQL error : " + e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException("Exception in generating the report : " + e.getMessage());
		}
		finally 
		{
			try 
			{	if(conn!=null){conn.close();}	
			} catch (SQLException e) 
			{
				throw new ServletException("Problems closing the connection" + e.getMessage(), e);
			}
	   }
	}

}
