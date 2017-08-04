package com.ausy.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="COLLABORATEURS")
public class Collaborateurs {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;
    private String nom;
    private String prenom;
    
    @Lob()
    private byte[] photo;
    
    private String photoFormatee;
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
    

    public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] pPhoto) {
		photo = pPhoto;
	}	

	public String getPhotoFormatee() {
		return photoFormatee;
	}

	public void setPhotoFormatee(String pPhotoFormatee) {
		photoFormatee = pPhotoFormatee;
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