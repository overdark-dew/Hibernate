package com.andersenlab.trainee.tables;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4343384032659833963L;

	@Id
	@Column(name = "user_id")
	@GeneratedValue
	private Integer user_id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="order_id")
	private Set<Order> orders = new HashSet<Order>();

	

	public int getId() {
		return user_id;
	}

	public void setId(Integer user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Order> getUsers() {
		return orders;
	}

	public void setUsers(Set<Order> orders) {
		this.orders = orders;
	}

}
