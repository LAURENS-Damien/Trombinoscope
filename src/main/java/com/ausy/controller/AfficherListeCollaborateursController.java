package com.ausy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ausy.bean.Collaborateurs;
import com.ausy.services.IServiceCollaborateurs;

@Controller
public class AfficherListeCollaborateursController {

    @Autowired
    private IServiceCollaborateurs service;
    
    @RequestMapping(value="/afficherListeCollaborateurs", method = RequestMethod.GET)
    public String afficherListeCollaborateurs(ModelMap pModel) {
        final List<Collaborateurs> lListeCollaborateurs = service.rechercherCollaborateurs();        
        pModel.addAttribute("listeCollaborateurs", lListeCollaborateurs);
        
        return "listeCollaborateurs";
    }
    
    @RequestMapping(value="/supprimerCollaborateur", method = RequestMethod.GET)
    public String supprimerCollaborateur(@RequestParam(value="idCollaborateur") final Integer pIdCollaborateur, final ModelMap pModel) {

        service.supprimerCollaborateur(pIdCollaborateur);
        
        return afficherListeCollaborateurs(pModel);
    }
}
