package com.ausy.controller;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class CreationCollaborateurForm {

    @NotEmpty
    private String nom;
    @NotEmpty
    private String prenom;
    
    private MultipartFile photo;
    
	private String poste;
    private Date dateEntree;
    private String numeroTelephone;
    private String email;

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
    
    public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile pPhoto) {
		photo = pPhoto;
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
