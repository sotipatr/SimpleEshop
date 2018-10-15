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
			String query = "SELECT * FROM demoeshop.OFFERS";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.S");
			
			while(rs.next()){
				int offerId = rs.getInt("offerid");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String price = rs.getString("price");
				String expirationDate = rs.getString("expirationDate");
				
				DateTime dt = formatter.parseDateTime(expirationDate);
				Offer offer = new Offer(offerId, name, description, price, dt); 
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
			String query = "INSERT INTO OFFERS (name, description, price, expirationDate) VALUES (?,?,?,?)";
			ps = conn.prepareStatement(query);

			ps.setString(1, offer.getName());
			//System.out.println(offer.getName());
			ps.setString(2, offer.getDescription());
			//System.out.println(offer.getDescription());
			ps.setString(3, offer.getPrice());
			ps.setTimestamp(4, new Timestamp(offer.getExpirationDate().getMillis()));

			ps.executeUpdate();

		}finally {
			try {
				ps.close();
			} catch (Exception e) {}
		}
	}
}
