package com.hamonize.springjwt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_details")
public class Order_Details{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long order_detail_id;
	@Column(name = "orders_id", nullable = false)
	private Integer orders_id;
	@Column(name = "products_id", nullable = false)
	private Integer products_id;
	@Column(name = "quantity", nullable = false)
	private Integer quantity;
	@Column(name = "currentPrice", nullable = false)
	private Float currentPrice;
	@Column(name = "currentDescription", nullable = false)
	private String currentDescription;
	@Column(name = "actives", nullable = false)
	private Boolean actives;
	
	public long getOrder_detail_id() {
		return order_detail_id;
	}
	public void setOrder_detail_id(long order_detail_id) {
		this.order_detail_id = order_detail_id;
	}
	public Integer getOrders_id() {
		return orders_id;
	}
	public void setOrders_id(Integer orders_id) {
		this.orders_id = orders_id;
	}
	public Integer getProducts_id() {
		return products_id;
	}
	public void setProducts_id(Integer products_id) {
		this.products_id = products_id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Float getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(Float currentPrice) {
		this.currentPrice = currentPrice;
	}
	public String getCurrentDescription() {
		return currentDescription;
	}
	public void setCurrentDescription(String currentDescription) {
		this.currentDescription = currentDescription;
	}
	public Boolean getActives() {
		return actives;
	}
	public void setActives(Boolean actives) {
		this.actives = actives;
	}
	
	
	
	
	
}
