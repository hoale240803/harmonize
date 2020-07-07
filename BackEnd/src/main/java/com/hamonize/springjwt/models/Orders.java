package com.hamonize.springjwt.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "orders")
public class Orders{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long order_id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Ho_Chi_Minh")
	@Column(name = "date", nullable = false)
	private Timestamp date;
	@Column(name = "total", nullable = false)
	private float total ;
	@Column(name = "description", nullable = false)
	private String description;
	@Column(name = "users_id", nullable = false)
	private Integer users_id;
	@Column(name = "states", nullable = false)
	private Integer states;
	@Column(name = "actives", nullable = false)
	private Boolean actives;

	public long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getUsers_id() {
		return users_id;
	}
	public void setUsers_id(Integer users_id) {
		this.users_id = users_id;
	}
	public Integer getStates() {
		return states;
	}
	public void setStates(Integer states) {
		this.states = states;
	}
	public Boolean getActives() {
		return actives;
	}
	public void setActives(Boolean actives) {
		this.actives = actives;
	}

}
