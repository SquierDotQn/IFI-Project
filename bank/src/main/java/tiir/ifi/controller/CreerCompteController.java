package tiir.ifi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tiir.ifi.bean.Compte;
import tiir.ifi.services.IServiceComptes;

@Controller
public class CreerCompteController {

    @Autowired
    private IServiceComptes service;

    @RequestMapping(value="/afficherCreationCompte", method = RequestMethod.GET)
    public String afficher(final ModelMap pModel) {
        final List<Compte> lListeComptes = service.listerComptes();
        pModel.addAttribute("listeComptes", lListeComptes);
        if (pModel.get("creation") == null) {
            pModel.addAttribute("creation", new CreationForm());
        }
        return "creation";
    }

    @RequestMapping(value="/creerCreationCompte", method = RequestMethod.POST)
    public String creer(@Valid @ModelAttribute(value="creation") final CreationForm pCreation, 
            final BindingResult pBindingResult, final ModelMap pModel) {

        if (!pBindingResult.hasErrors()) {
            final Integer lIntBalance = Integer.valueOf(pCreation.getBalance());
            service.creerCompte(pCreation.getNom(), lIntBalance);
        }
        return afficher(pModel);
    }
}