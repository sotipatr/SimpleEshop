package my.demo.eshop.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import my.demo.eshop.Offer;
import my.demo.eshop.database.DatabaseManager;

/**
 * Servlet implementation class ViewOffers
 */
@WebServlet("/ViewOffers")
public class ViewOffers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="demoeshop")    
	private DataSource dataSource;
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOffers() {
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
		Connection conn = null;
		
		try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/demoeshop","root","sotiria");
				DatabaseManager dbManager = new DatabaseManager();
				ArrayList<Offer> offers = dbManager.getOffers(conn);
				Iterator<Offer> offerIterator = offers.iterator();
				Timestamp nowtimestamp = new Timestamp(System.currentTimeMillis());
            	while (offerIterator.hasNext()) {
            		Offer curr = offerIterator.next();
            		if (nowtimestamp.after(curr.getExpirationDate())){
            			dbManager.cancelOfferById(conn, curr.getOfferId());
            		}
            	}
            	offers = dbManager.getOffers(conn);
				request.setAttribute("offersList", offers);
				
				//redirect to the print page
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/printOffers.jsp");
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
