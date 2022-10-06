package com.glx.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Product {

	@Id

	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "Name is Mandatory.")
	@Pattern(regexp = "[A-Za-z0-9 ]*", message = "Only Alphanumeric characters are allowed.")
	@Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters long.")
	private String name;
	@Pattern(regexp = "[A-Za-z0-9. ]*", message = "Only Alphanumeric characters are allowed.")
	@Size(min = 3, max = 200, message = "Description must be between 4 and 200 characters long.")
	@NotNull(message = "Description can't be Null.")
	private String description;
	// @NotEmpty(message = "Price is required.")
	@Min(value = 1, message = "Price needs to be greater than 0")
	private Double price;
	@Min(value = 1, message = "Product quantity must be atleast 1.")

	private Integer productQuantity;
	@Column(columnDefinition = "integer default 0")
	private Integer orderQuantity;
	@ManyToOne
	private Category category;

	public Product() {
		super();
	}

	public Product(Integer id, String name, String description, Double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product(Integer id, String name, String description, Double price, Integer productQuantity, Integer orderQuantity, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.productQuantity = productQuantity;
		this.orderQuantity = orderQuantity;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Integer getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	@Override
	public String toString() {
		return "Product [category=" + category + ", description=" + description + ", id=" + id + ", name=" + name
				+ ", orderQuantity=" + orderQuantity + ", price=" + price + ", productQuantity=" + productQuantity
				+ "]";
	}

}
