package com.ausy.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ausy.services.IServiceCollaborateurs;

@Controller
public class CreerCollaborateurController {
	
	private static final Logger logger = Logger.getLogger(CreerCollaborateurController.class);
	
    @Autowired
    private IServiceCollaborateurs service;

    @RequestMapping(value="/creationCollaborateur", method = RequestMethod.GET)
    public String creationCollaborateur(final ModelMap pModel) {

        if (pModel.get("creationCollaborateur") == null) {
            pModel.addAttribute("creationCollaborateur", new CreationCollaborateurForm());
        }
        return "creationCollaborateur";
    }

    @RequestMapping(value="/creerCollaborateur", method = RequestMethod.POST)
    public ModelAndView creerCollaborateur(@Valid @ModelAttribute(value="creationCollaborateur") final CreationCollaborateurForm pCreation, 
            final BindingResult pBindingResult, @RequestParam("photo") MultipartFile pPhoto, final ModelMap pModel) {
    	
        if (!pBindingResult.hasErrors()) {
        	InputStream photo;
			try {
				photo = pPhoto.getInputStream();
	            service.creerCollaborateur(pCreation.getNom(), pCreation.getPrenom(), photo, pCreation.getPoste(), pCreation.getDateEntree(), pCreation.getNumeroTelephone(), pCreation.getEmail());
			} catch (IOException e) {
				e.printStackTrace();
			}
        } else {
        	logger.error("Une erreur s'est produite lors de la création du collaborateur : " + pCreation.getNom() + " " + pCreation.getPrenom());
        }
        
        return new ModelAndView("redirect:/afficherListeCollaborateurs");
    }
}
