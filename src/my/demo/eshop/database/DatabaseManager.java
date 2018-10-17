package my.demo.eshop.database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


import my.demo.eshop.Offer;

public class DatabaseManager {
	public ArrayList<Offer> getOffers(Connection conn) throws SQLException {
		
		ArrayList<Offer> offers = new ArrayList<Offer>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			String query = "SELECT * FROM demoeshop.OFFERS WHERE status='active'";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()){
				int offerId = rs.getInt("offerid");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String price = rs.getString("price");
				Timestamp expirationDate = rs.getTimestamp("expirationDate");
				
				Offer offer = new Offer(offerId, name, description, price, expirationDate, "active"); 
				offers.add(offer);
			}

			return offers;

		}finally {
			try {
				rs.close();
			} catch (Exception e) {}
			try {
				ps.close();
			} catch (Exception e) {}
		}
	}
	
	public void setOffer(Connection conn, Offer offer) throws SQLException {
			
			PreparedStatement ps = null;
			try {
				String query = "INSERT INTO OFFERS (name, description, price, expirationDate, status) VALUES (?,?,?,?,?)";
				ps = conn.prepareStatement(query);
	
				ps.setString(1, offer.getName());
				ps.setString(2, offer.getDescription());
				ps.setString(3, offer.getPrice());
				ps.setTimestamp(4, offer.getExpirationDate());
				ps.setString(5, offer.getStatus());
	
				ps.executeUpdate();
	
			}finally {
				try {
					ps.close();
				} catch (Exception e) {}
			}
		}
	
	public void cancelOfferById(Connection conn, int offerid) throws SQLException {
		
		PreparedStatement ps = null;
		try {
			String query = "UPDATE OFFERS\n" + 
					"SET status='canceled'\n" + 
					"WHERE offerid=?";
			
			ps = conn.prepareStatement(query);
			ps.setInt(1, offerid);
			
			ps.executeUpdate();

		}finally {
			try {
				ps.close();
			} catch (Exception e) {}
		}
	}
		
	public Offer getOfferById(Connection conn, int offerid) throws SQLException {
		
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			String query = "SELECT * FROM demoeshop.OFFERS WHERE offerid=?";
			
			ps = conn.prepareStatement(query);
			ps.setInt(1, offerid);
			rs = ps.executeQuery();
				
			String name = rs.getString("name");
			String description = rs.getString("description");
			String price = rs.getString("price");
			String status = rs.getString("status");
			Timestamp expirationDate = rs.getTimestamp("expirationDate");
			
			Offer offer = new Offer(offerid, name, description, price, expirationDate, status); 
			
			return offer;
			
		}finally {
			try {
				rs.close();
			} catch (Exception e) {}
			try {
				ps.close();
			} catch (Exception e) {}
		}
	}
}
