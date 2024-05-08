package com.baha.vetements.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
@Entity
public class Vetement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVetement;
	@NotNull
	@Size (min = 4,max = 15)
	private String nomVetement;
	@Min(value = 10)
	@Max(value = 10000)
	private Double prixVetement;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateCreation;
	
	
	public Long getIdVetement() {
		return idVetement;
	}
	public void setIdVetement(Long idVetement) {
		this.idVetement = idVetement;
	}
	public String getNomVetement() {
		return nomVetement;
	}
	public void setNomVetement(String nomVetement) {
		this.nomVetement = nomVetement;
	}
	public Double getPrixVetement() {
		return prixVetement;
	}
	public void setPrixVetement(Double prixVetement) {
		this.prixVetement = prixVetement;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	@Override
	public String toString() {
		return "Vetement [idVetement=" + idVetement + ", nomVetement=" + nomVetement + ", prixVetement=" + prixVetement
				+ ", dateCreation=" + dateCreation + "]";
	}
	public Vetement(String string,double d, Date date) {
		super();
		this.nomVetement = string;
		this.prixVetement = d;
		this.dateCreation = date;
	}
	public Vetement() {
		super();
	}
	
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	@ManyToOne
	private Type type;
	
	
}
