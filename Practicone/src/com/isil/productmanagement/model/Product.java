package com.isil.productmanagement.model;

/**
 * User.java
 * This is a model class represents a User entity
 * @author Abel Huarca [Isil]
 *
 */
public class Product {
	protected int id;
	protected String nameproduct;
	protected String nameprov;
	protected String producttype;
	
	public Product() {
	}
	
	public Product(String name, String proveedor, String producttype) {
		super();
		this.nameproduct = name;
		this.nameprov = proveedor;
		this.producttype = producttype;
	}

	public Product(int id, String name, String proveedor, String producttype) {
		super();
		this.id = id;
		this.nameproduct = name;
		this.nameprov = proveedor;
		this.producttype = producttype;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameproduct() {
		return nameproduct;
	}

	public void setNameproduct(String nameproduct) {
		this.nameproduct = nameproduct;
	}

	public String getNameprov() {
		return nameprov;
	}

	public void setNameprov(String nameprov) {
		this.nameprov = nameprov;
	}

	public String getProducttype() {
		return producttype;
	}

	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}

}
