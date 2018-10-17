package my.demo.eshop.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.joda.time.DateTime;
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

	public void testGetOffers(){
		ArrayList<Offer> expectedOffers = new ArrayList<Offer>();
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.S");
		expectedOffers.add(new Offer(1, "offer1", "mplampla", "150", new Timestamp(formatter.parseDateTime("2018-10-16 23:51:12.0").getMillis()) , "active"));
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
			assertEquals(actualOffers.get(0).getStatus(), expectedOffers.get(0).getStatus());
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
			Offer offer = new Offer(2, "offer2", "simple description", "200", new Timestamp(formatter.parseDateTime("2018-10-15 22:21:11.0").getMillis()), "active");
			databaseManager.setOffer(conn, offer);
			
			ArrayList<Offer> actualOffers = databaseManager.getOffers(conn);
			
			assertEquals(actualOffers.get(1).getOfferId(), 2);
			assertEquals(actualOffers.get(1).getDescription(), "simple description");
			assertEquals(actualOffers.get(1).getName(), "offer2");
			assertEquals(actualOffers.get(1).getPrice(), "200");
			assertEquals(actualOffers.get(1).getStatus(), "active");
			assertEquals(actualOffers.get(1).getExpirationDate().toString(), "2018-10-15T22:21:11.000+01:00");
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
	
	public void testGetOffer(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/demoeshop","root","sotiria");
			Offer actualOffer = databaseManager.getOfferById(conn, 2);
			
			assertEquals(actualOffer.getOfferId(), 2);
			assertEquals(actualOffer.getDescription(), "simple description");
			assertEquals(actualOffer.getName(), "offer5");
			assertEquals(actualOffer.getPrice(), "200");
			assertEquals(actualOffer.getStatus(), "canceled");
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
	
	public void testCancelOfferById(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/demoeshop","root","sotiria");
			databaseManager.cancelOfferById(conn, 2);
			
			Offer actualOffer = databaseManager.getOfferById(conn, 2);
			
			assertEquals(actualOffer.getStatus(), "canceled");
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
