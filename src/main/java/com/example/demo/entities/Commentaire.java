package com.example.demo.entities;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NaturalIdCache;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="commentaire")
@NaturalIdCache
public class Commentaire implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="Commentaire_id")
	private long id;
	
	@Column(name="userid" )
	@NotNull(message = "*Please provide the user_id")
	private long userid;

	@Column(name = "contained")
	@NotEmpty(message = "*Please write your commentaire")
	private String contained;
	
	@Column(name = "time")
	//@NotEmpty(message = "*Please provide the time")
	private LocalTime time;
	
	@Column(name = "date")
	//@NotEmpty(message = "*Please provide the date")
	private Date date;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getContained() {
		return contained;
	}

	public void setContained(String contained) {
		this.contained = contained;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	/*
	 * ----> jointure de publication to user :ManyToOne
	 * 
	 * ----> L’annotation @ManyToOne implique que la table 
     * Commentaire contient une colonne qui est une clé étrangère
	 * contenant la clé d’un User
	 * 
	 * ----> il est également possible d’indiquer à JPA qu’il doit passer par 
	 * une table d’association pour établir la relation entre les deux entités 
	 * avec l’annotation @JoinTable
	 */
	@Autowired
	@ManyToOne
	// déclaration d'une table d'association Commentaire - user
	@JoinTable(name = "User_Commentaire", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "Commentaire_id"))
	private User user;
	
	// déclaration d'une table d'association Commentaire to publication 
			@JoinTable(name = "User_Publication", joinColumns = @JoinColumn(name = "Publication_id"), inverseJoinColumns = @JoinColumn(name = "Commentaire_id"))
			private Publication publication;
	
	

	

}
