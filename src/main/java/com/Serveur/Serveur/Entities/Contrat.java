package com.Serveur.Serveur.Entities;


import lombok.*;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
public class Contrat implements Serializable {
    public Contrat(String type) {
		super();
		this.type = type;
	}
	public Contrat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contrat(Long id, String type, String mission, String commentaire) {
		super();
		this.id = id;
		this.type = type;
		this.mission = mission;
		this.commentaire = commentaire;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private String mission;
    private String commentaire;
    /*@ManyToOne
    @JoinColumn(name="ressource_id")
    private Ressource ressource ;*/
  
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMission() {
		return mission;
	}
	public void setMission(String mission) {
		this.mission = mission;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	@Override
	public String toString() {
		return "Contrat [id=" + id + ", type=" + type + ", mission=" + mission + ", commentaire=" + commentaire
				+ "]";
	}
	

}