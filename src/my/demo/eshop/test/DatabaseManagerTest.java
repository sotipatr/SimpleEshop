package my.demo.eshop.test;

import org.joda.time.DateTime;

import junit.framework.TestCase;
import my.demo.eshop.Offer;
import my.demo.eshop.database.DatabaseManager;

public class DatabaseManagerTest  extends TestCase {
	
	private DatabaseManager databaseManager;
	
	protected void setUp() {
		databaseManager = new DatabaseManager();
	}

	public void testGetOffer(){
		Offer expectedOffer = new Offer(1, "offer1", "mplampla", "150", new DateTime());
		Offer actualOffer = databaseManager.getOffer("offer1");
		assertEquals(expectedOffer, actualOffer);
	}
}
