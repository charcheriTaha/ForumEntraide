package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NaturalIdCache;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "user")
@NaturalIdCache

public class User implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private long id;

	@Column(name = "firstName")
	@NotEmpty(message = "*Please provide your first name")
	private String firstName;

	@Column(name = "lastName")
	@NotEmpty(message = "*Please provide your last name")
	private String lastName;

	@Column(name = "email", nullable = false, unique = true)
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide a valid Email")
	private String email;

	@Column(name = "mobile")
	@NotNull(message = "*Please provide your mobile phone number")
	private int mobile;

	@Column(name = "address", nullable = false)
	@NotEmpty(message = "*Please provide an address")
	private String address;

	@Column(name = "Date")
	@NotNull(message = "*Please provide your birthday")
	private Date date;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	


/*
	public long getCin() {
		return cin;
	}

	public void setCin(long cin) {
		this.cin = cin;
	}
*/
	

}
