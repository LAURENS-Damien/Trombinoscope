package com.ausy.controller;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class ModificationCollaborateur {
	
    private Integer id;
    
    @NotEmpty(message="{modification.collaborateur.nom.notempty}")
    private String nom;
    
    @NotEmpty(message="{modification.collaborateur.prenom.notempty}")
    private String prenom;
    
	private String poste;
    private Date dateEntree;
    private String numeroTelephone;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer pId) {
        id = pId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(final String pNom) {
        nom = pNom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(final String pPrenom) {
        prenom = pPrenom;
    }
    
    public String getPoste() {
 		return poste;
 	}

 	public void setPoste(String pPoste) {
 		poste = pPoste;
 	}

 	public Date getDateEntree() {
 		return dateEntree;
 	}

 	public void setDateEntree(Date pDateEntree) {
 		dateEntree = pDateEntree;
 	}

 	public String getNumeroTelephone() {
 		return numeroTelephone;
 	}

 	public void setNumeroTelephone(String pNumeroTelephone) {
 		numeroTelephone = pNumeroTelephone;
 	}

 	public String getEmail() {
 		return email;
 	}

 	public void setEmail(String pEmail) {
 		email = pEmail;
 	}
}
