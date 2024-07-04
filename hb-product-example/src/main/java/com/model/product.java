package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="productdetails")

public class product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="slno")
	private int slno;
	@Column(name="productname")
	private String productname;
	@Column(name="quantity")
	private int quantity;
	@Column(name="price")
	private int price;
	public product(int slno, String productname, int quantity, int price) {
		super();
		this.slno = slno;
		this.productname = productname;
		this.quantity = quantity;
		this.price = price;
	}
	public product() {
		super();
	}
	public int getSlno() {
		return slno;
	}
	public void setSlno(int slno) {
		this.slno = slno;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
