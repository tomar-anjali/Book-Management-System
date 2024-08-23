package bms;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Books {
	@Id
	private int id;
	private String title;
	private String date;
	private double price;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Books [id=" + id + ", title=" + title + ", date=" + date + ", price=" + price + "]";
	}
}
