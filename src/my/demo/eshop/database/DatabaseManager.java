package my.demo.eshop.database;


import org.joda.time.DateTime;

import my.demo.eshop.Offer;

public class DatabaseManager {
	public Offer getOffer(String name){
		
		Offer offer = new Offer(1, name, "simple description", "120", new DateTime());
		return offer;
	}
}
