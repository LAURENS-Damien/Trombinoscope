package com.ausy.dao;

import java.util.List;

import com.ausy.bean.Collaborateurs;

public interface ICollaborateursDAO {
	
    List<Collaborateurs> rechercherCollaborateurs();
    
    Collaborateurs rechercherCollaborateur(final Integer pId);
	
	void creerCollaborateur(final Collaborateurs pCollaborateur);
	
	void supprimerCollaborateur(final Collaborateurs pCollaborateur);
	
	void modifierCollaborateur(final Collaborateurs pCollaborateur);
}