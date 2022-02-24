package com.example.restaurant.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "food_details")
public class RestaurantData {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column (name="food_name")
	private String foodName;
	@Column (name="food_type")
	private String foodType;
	private Long price;
	@Column (name="created_at")
	private Date createdAt;
	@Column (name="updated_at")
	private Date updatedAt;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	

	

}
