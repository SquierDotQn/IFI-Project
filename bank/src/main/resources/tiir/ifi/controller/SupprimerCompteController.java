package tiir.ifi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tiir.ifi.bean.Compte;
import tiir.ifi.IServiceComptes;

@Controller
public class SupprimerCompteController {

    @Autowired
    private IServiceComptes service;

    @RequestMapping(value="/afficherSuppressionCompte", method = RequestMethod.GET)
    public String afficher(final ModelMap pModel) {
        final List<Compte> lListeComptes = service.listerComptes();
        pModel.addAttribute("listeComptes", lListeComptes);
        return "suppression";
    }

    @RequestMapping(value="/supprimerSuppressionComptes", method = RequestMethod.GET)
    public String supprimer(@RequestParam(value="idCompte") final Integer pIdCompte, final ModelMap pModel) {

        service.supprimerCompte(pIdCompte);;
        return afficher(pModel);
    }
}