package my.demo.eshop;

import org.joda.time.DateTime;

public class Offer {
	
	private int offerId;
	private String name;
	private String description;
	private String price;
	private DateTime expirationDate;
	
	public Offer(int offerId, String name, String description, String price, DateTime expirationDate) {
		super();
		this.name = name;
		this.offerId = offerId;
		this.description = description;
		this.price = price;
		this.expirationDate = expirationDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public DateTime getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(DateTime expirationDate) {
		this.expirationDate = expirationDate;
	}
	
}
