package my.demo.eshop.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import junit.framework.TestCase;
import my.demo.eshop.Offer;
import my.demo.eshop.database.DatabaseManager;

public class DatabaseManagerTest  extends TestCase {
	
	private DatabaseManager databaseManager;
	
	protected void setUp() {
		databaseManager = new DatabaseManager();
	}

	public void testGetOffer(){
		ArrayList<Offer> expectedOffers = new ArrayList<Offer>();
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.S");
		expectedOffers.add(new Offer(1, "offer1", "mplampla", "150", formatter.parseDateTime("2018-10-14 19:07:51.0")));
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/demoeshop","root","sotiria");
			ArrayList<Offer> actualOffers = databaseManager.getOffers(conn);
			
			//for the sake of simplicity I check only the first object in the ArrayList
			assertEquals(actualOffers.get(0).getOfferId(), expectedOffers.get(0).getOfferId());
			assertEquals(actualOffers.get(0).getDescription(), expectedOffers.get(0).getDescription());
			assertEquals(actualOffers.get(0).getName(), expectedOffers.get(0).getName());
			assertEquals(actualOffers.get(0).getPrice(), expectedOffers.get(0).getPrice());
			assertEquals(actualOffers.get(0).getExpirationDate().toString(), expectedOffers.get(0).getExpirationDate().toString());
		}
		catch (SQLException e)
		{
			throw new RuntimeException("SQL error : " + e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException("Exception in generating the report : " + e.getMessage());
		}
		finally 
		{
			try 
			{	if(conn!=null){conn.close();}	
			} catch (SQLException e){}
		}
	}
	
	public void testSetOffer(){
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.S");
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/demoeshop","root","sotiria");
			
			databaseManager.setOffers(conn, new Offer(2, "offer2", "simple description", "200", formatter.parseDateTime("2018-10-15 22:21:11.0"));
			
			ArrayList<Offer> actualOffers = databaseManager.getOffers(conn);
			
			//for the sake of simplicity I check only the first object in the ArrayList
			assertEquals(actualOffers.get(1).getOfferId(), 2);
			assertEquals(actualOffers.get(1).getDescription(), "simple description");
			assertEquals(actualOffers.get(1).getName(), "offer2");
			assertEquals(actualOffers.get(1).getPrice(), "200");
			assertEquals(actualOffers.get(1).getExpirationDate().toString(), "2018-10-15 22:21:11.0");
		}
		catch (SQLException e)
		{
			throw new RuntimeException("SQL error : " + e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException("Exception in generating the report : " + e.getMessage());
		}
		finally 
		{
			try 
			{	if(conn!=null){conn.close();}	
			} catch (SQLException e){}
		}
	}
}
