package com.ausy.services;

import java.io.InputStream;
import java.sql.Date;
import java.util.List;

import com.ausy.bean.Collaborateurs;


public interface IServiceCollaborateurs {
	
    List<Collaborateurs> rechercherCollaborateurs();
    
    Collaborateurs rechercherCollaborateur(final Integer pId);
    
    void creerCollaborateur(final String pNom, final String pPrenom, final InputStream photo, final String poste, final Date dateEntree, final String numeroTelephone, final String email);
    
    void supprimerCollaborateur(final Integer pId);
    
    void modifierCollaborateur(final Collaborateurs pCollaborateur);
}