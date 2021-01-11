package com.klinika.pregled.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "dijagnoza")
public class Dijagnoza{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;
	
	@ManyToMany
	@JoinTable(name = "dijagnoza_lek", joinColumns = @JoinColumn(name = "dijagnoza_id"), inverseJoinColumns = @JoinColumn(name = "lek_id"))
	private Set<Lek> lekovi = new HashSet<>();
	
	/*@OneToMany(mappedBy = "dijagnoza")        //, fetch = FetchType.LAZY, cascade = CascadeType.ALL
	private Set<Pregled> pregledi = new HashSet<>();*/

//	@ManyToMany(mappedBy = "dijagnoza")        //, fetch = FetchType.LAZY, cascade = CascadeType.ALL
//	private Set<Test> testovi = new HashSet<>();
	
	@ManyToMany(mappedBy = "dijagnoze")        //, fetch = FetchType.LAZY, cascade = CascadeType.ALL
	private Set<Pregled> pregledi = new HashSet<>();
	
	public Dijagnoza() {
		super();
	}
	public Dijagnoza(String name) {
		super();
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Dijagnoza [name=" + name + "]";
	}

	
	@JsonIgnore
	public Set<Lek> getLekovi() {
		return lekovi;
	}
	public void setLekovi(Set<Lek> lekovi) {
		this.lekovi = lekovi;
	}


}
