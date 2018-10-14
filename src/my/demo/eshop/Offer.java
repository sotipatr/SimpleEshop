package my.demo.eshop;

import java.text.DateFormat;

public class Offer {
	
	private int offerId;
	private String description;
	private float price;
	private DateFormat expirationDate;
	
	public Offer(int offerId, String description, float price, DateFormat expirationDate) {
		super();
		this.offerId = offerId;
		this.description = description;
		this.price = price;
		this.expirationDate = expirationDate;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public DateFormat getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(DateFormat expirationDate) {
		this.expirationDate = expirationDate;
	}
	
}
