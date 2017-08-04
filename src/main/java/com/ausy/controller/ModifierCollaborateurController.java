package com.ausy.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ausy.bean.Collaborateurs;
import com.ausy.services.IServiceCollaborateurs;

@Controller
public class ModifierCollaborateurController {

    @Autowired
    private IServiceCollaborateurs service;

    @RequestMapping(value="/modificationCollaborateur", method = RequestMethod.GET)
    public String afficherModificationCollaborateur(@RequestParam(value="idCollaborateur") final Integer pIdCollaborateur, final ModelMap pModel) {
        
    	if (pModel.get("modificationCollaborateur") == null) {
        	final Collaborateurs collaborateur = service.rechercherCollaborateur(pIdCollaborateur);
            final ModificationCollaborateurForm lModificationForm = new ModificationCollaborateurForm();
            final ModificationCollaborateur lModificationCollaborateur = new ModificationCollaborateur();
            lModificationCollaborateur.setId(collaborateur.getId());
            lModificationCollaborateur.setNom(collaborateur.getNom());
            lModificationCollaborateur.setPrenom(collaborateur.getPrenom());        
            lModificationCollaborateur.setDateEntree(collaborateur.getDateEntree());
            lModificationCollaborateur.setNumeroTelephone(collaborateur.getNumeroTelephone());
            lModificationCollaborateur.setEmail(collaborateur.getEmail());  
            lModificationForm.setCollaborateur(lModificationCollaborateur);
            pModel.addAttribute("modificationCollaborateur", lModificationForm);
        }
        return "modificationCollaborateur";
    }

    @RequestMapping(value="/modifierCollaborateur", method = RequestMethod.POST)
    public ModelAndView modifierCollaborateur(@Valid @ModelAttribute(value="modificationCollaborateur") final ModificationCollaborateurForm pModificationCollaborateur, 
            final BindingResult pBindingResult, final ModelMap pModel) {

        if (!pBindingResult.hasErrors()) {
            final Collaborateurs lCollaborateur = new Collaborateurs();
            final ModificationCollaborateur lModificationCollaborateur = pModificationCollaborateur.getCollaborateur();
            lCollaborateur.setId(lModificationCollaborateur.getId());
            lCollaborateur.setNom(lModificationCollaborateur.getNom());
            lCollaborateur.setPrenom(lModificationCollaborateur.getPrenom());            
            lCollaborateur.setDateEntree(lModificationCollaborateur.getDateEntree());
            lCollaborateur.setNumeroTelephone(lModificationCollaborateur.getNumeroTelephone());
            lCollaborateur.setEmail(lModificationCollaborateur.getEmail());

            service.modifierCollaborateur(lCollaborateur);
        }

        return new ModelAndView("redirect:/afficherListeCollaborateurs");
    }
}
