package my.demo.eshop;

import java.sql.Timestamp;

public class Offer {
	
	private int offerId;
	private String name;
	private String description;
	private String price;
	private Timestamp expirationDate;
	private String status;
	
	public Offer(int offerId, String name, String description, String price, Timestamp expirationDate, String status) {
		super();
		this.name = name;
		this.offerId = offerId;
		this.description = description;
		this.price = price;
		this.expirationDate = expirationDate;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Timestamp getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Timestamp expirationDate) {
		this.expirationDate = expirationDate;
	}
	
}
