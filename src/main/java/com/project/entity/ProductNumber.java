package com.project.entity;

import java.util.*;
import javax.persistence.*;
@Entity
@Table(name="product_object")
public class ProductNumber {
	private static int next=1;
	@Id
	@Column(name="id")
	private Integer id;
	@Column(name="number")
	private String number;
	@Column(name="productnumber")
	private String productnumber;
	@Column(name="productname")
	private String productname;
	public ProductNumber() {}	
	public ProductNumber(String productnumber) {
		this.productnumber = productnumber;
	}

	public ProductNumber(String productnumber,String productname) {
		this.id=next++;
		this.number=UUID.randomUUID().toString();
		this.productnumber=productnumber;
		this.productname=productname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getProductnumber() {
		return productnumber;
	}
	public void setProductnumber(String productnumber) {
		this.productnumber = productnumber;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	@Override
	public String toString() {
		return "ProductNumber [id=" + id + ", number=" + number + ", productnumber=" + productnumber + ", productname="
				+ productname + "]";
	}
	
	
	
}
