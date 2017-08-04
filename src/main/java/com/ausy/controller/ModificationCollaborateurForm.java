package com.ausy.controller;

import javax.validation.Valid;

public class ModificationCollaborateurForm {
	
    @Valid
    private ModificationCollaborateur collaborateur;

    public void setCollaborateur(final ModificationCollaborateur pCollaborateur) {
    	collaborateur = pCollaborateur;
    }

    public ModificationCollaborateur getCollaborateur() {
        return collaborateur;
    }
}
