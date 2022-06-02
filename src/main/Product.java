package main;

import java.util.Objects;

public class Product  {
	String bcode;
	String title;
	Integer quantity;
	double price;

	public Product() {

	}

	public Product(String bcode, String title, Integer quantity, double price) {
		this.bcode = bcode;
		this.title = title;
		this.quantity = quantity;
		this.price = price;
	}

	public String getBcode() {
		return bcode;
	}

	public void setBcode(String bcode) {
		this.bcode = bcode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {

		return bcode + " | " + title + " | " + quantity + " | " + price + "\n";

	}

	@Override
	public int hashCode() {
		return Objects.hash(bcode, price, quantity, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (Objects.equals(bcode, other.bcode)) {
			return false;
		}
		return true;

	}

	
}
