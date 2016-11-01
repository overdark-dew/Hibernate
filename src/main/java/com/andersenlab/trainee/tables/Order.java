package com.andersenlab.trainee.tables;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8805009378318881593L;
	
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer order_id;
	
	@Column(name = "stat")
	private Integer status;
	
	@Column(name = "user_id")
	private Integer user_id;

	
	public Integer getId() {
		return order_id;
	}

	public void setId(Integer id) {
		this.order_id = id;
	}

	public Integer getUserId() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
