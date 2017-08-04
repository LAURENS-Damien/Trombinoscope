package com.ausy.services;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ausy.bean.Collaborateurs;
import com.ausy.dao.ICollaborateursDAO;

@Service
public class ServiceCollaborateurs implements IServiceCollaborateurs {
	
    @Autowired
    private ICollaborateursDAO dao;

    @Transactional(readOnly=true)
    public List<Collaborateurs> rechercherCollaborateurs() {
    	
        return dao.rechercherCollaborateurs();
    }
    
    @Transactional(readOnly=true)
    public Collaborateurs rechercherCollaborateur(final Integer pId) {
    	
        return dao.rechercherCollaborateur(pId);
    }
    
    @Transactional
	public void creerCollaborateur(String pNom, String pPrenom, InputStream pPhoto, final String pPoste, final Date pDateEntree, final String pNumeroTelephone, final String pEmail) {
        
    	final Collaborateurs lCollaborateur = new Collaborateurs();
    	lCollaborateur.setNom(pNom);
    	lCollaborateur.setPrenom(pPrenom);
    	lCollaborateur.setPoste(pPoste);
    	lCollaborateur.setDateEntree(pDateEntree);
    	lCollaborateur.setNumeroTelephone(pNumeroTelephone);
    	lCollaborateur.setEmail(pEmail);

    	byte[] lImageHibernate;
    	
		try {
			// Conversion au format byte[]
			lImageHibernate = IOUtils.toByteArray(pPhoto);
			lCollaborateur.setPhoto(lImageHibernate);
			
			// Conversion en base64 pour être prêt pour un futur affichage
    		byte[] encodeBase64 = Base64.encodeBase64(lImageHibernate);
    		lCollaborateur.setPhotoFormatee(new String(encodeBase64, "UTF-8"));	
		} catch (IOException e) {
			e.printStackTrace();
		}    	

        dao.creerCollaborateur(lCollaborateur);		
	}
    
    @Transactional
    public void supprimerCollaborateur(final Integer pIdCollaborateur) {
        
    	final Collaborateurs lCollaborateur = new Collaborateurs();
        lCollaborateur.setId(pIdCollaborateur);

        dao.supprimerCollaborateur(lCollaborateur);
    }
    
    @Transactional
	public void modifierCollaborateur(Collaborateurs pCollaborateur) {

		dao.modifierCollaborateur(pCollaborateur);
	}


}
