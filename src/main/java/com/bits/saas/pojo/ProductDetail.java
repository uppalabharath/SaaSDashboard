package com.bits.saas.pojo;

import java.io.Serializable;

public class ProductDetail implements Serializable {
	
	private static final long serialVersionUID = -1306698373436195490L;

	private long id;
	
	private String block1;
	
	private String block2;
	
	private String block3;
	
	private Product product;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBlock1() {
		return block1;
	}

	public void setBlock1(String block1) {
		this.block1 = block1;
	}

	public String getBlock2() {
		return block2;
	}

	public void setBlock2(String block2) {
		this.block2 = block2;
	}

	public String getBlock3() {
		return block3;
	}

	public void setBlock3(String block3) {
		this.block3 = block3;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
