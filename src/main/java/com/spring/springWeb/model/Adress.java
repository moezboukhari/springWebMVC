package com.spring.springWeb.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;
@Entity
public class Adress {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@Column(name="adress_name")
	private String adressName;
	@ManyToMany
	//@JoinColumn(name="d")
	@Column(name="adr_usr")
	private Set<User> fkUser;
	public Adress() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Adress(Long id, String adressName) {
		super();
		this.id = id;
		this.adressName = adressName;
	}
	
	public Set<User> getFkUser() {
		return fkUser;
	}
	public void setFkUser(Set<User> fkUser) {
		this.fkUser = fkUser;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAdressName() {
		return adressName;
	}
	public void setAdressName(String adressName) {
		this.adressName = adressName;
	}

}
