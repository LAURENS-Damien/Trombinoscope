package com.ausy.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ausy.bean.Collaborateurs;

@Repository
public class CollaborateursDAO implements ICollaborateursDAO {
	
	private static final Logger logger = Logger.getLogger(CollaborateursDAO.class);
	
    @PersistenceContext
    private EntityManager entityManager;

    public List<Collaborateurs> rechercherCollaborateurs() {
    	
        final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<Collaborateurs> lCriteriaQuery = lCriteriaBuilder.createQuery(Collaborateurs.class);
        final Root<Collaborateurs> lRoot = lCriteriaQuery.from(Collaborateurs.class);
        lCriteriaQuery.select(lRoot);
        final TypedQuery<Collaborateurs> lTypedQuery = entityManager.createQuery(lCriteriaQuery);
        
        return lTypedQuery.getResultList();
    }
    
    public Collaborateurs rechercherCollaborateur(final Integer pId) {
    	
        final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<Collaborateurs> lCriteriaQuery = lCriteriaBuilder.createQuery(Collaborateurs.class);
        final Root<Collaborateurs> lRoot = lCriteriaQuery.from(Collaborateurs.class);
        lCriteriaQuery.select(lRoot);
        lCriteriaQuery.where(lCriteriaBuilder.equal(lRoot.get("id"), pId));
        final TypedQuery<Collaborateurs> lTypedQuery = entityManager.createQuery(lCriteriaQuery);
        
        return lTypedQuery.getSingleResult();
    }

	public void creerCollaborateur(final Collaborateurs pCollaborateur) {
        
        entityManager.persist(pCollaborateur);		
	}
	
    public void supprimerCollaborateur(final Collaborateurs pCollaborateur) {
        
    	final Collaborateurs lCollaborateur = entityManager.getReference(Collaborateurs.class, pCollaborateur.getId());
        entityManager.remove(lCollaborateur);
    }

	public void modifierCollaborateur(Collaborateurs pCollaborateur) {

		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaUpdate<Collaborateurs> lCriteriaUpdate = lCriteriaBuilder.createCriteriaUpdate(Collaborateurs.class);
        final Root<Collaborateurs> lRoot = lCriteriaUpdate.from(Collaborateurs.class);
        final Path<Collaborateurs> lPath = lRoot.get("id");
        final Expression<Boolean> lExpression = lCriteriaBuilder.equal(lPath, pCollaborateur.getId());
        lCriteriaUpdate.where(lExpression);
        lCriteriaUpdate.set("nom", pCollaborateur.getNom());
        lCriteriaUpdate.set("prenom", pCollaborateur.getPrenom());
        lCriteriaUpdate.set("dateEntree", pCollaborateur.getDateEntree());
        lCriteriaUpdate.set("numeroTelephone", pCollaborateur.getNumeroTelephone());
        lCriteriaUpdate.set("email", pCollaborateur.getEmail());
        final Query lQuery = entityManager.createQuery(lCriteriaUpdate);
        final int lRowCount = lQuery.executeUpdate();

        if (lRowCount != 1) {
            final org.hibernate.Query lHQuery = lQuery.unwrap(org.hibernate.Query.class);
            final String lSql = lHQuery.getQueryString();
            throw new RuntimeException("Nombre d'occurences (" + lRowCount + 
                    ") modifiés différent de 1 pour " + lSql);
        }
		
	}	
}