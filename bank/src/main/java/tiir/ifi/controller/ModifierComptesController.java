package tiir.ifi.controller;


import java.util.LinkedList;
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
public class ModifierComptesController {

    @Autowired
    private IServiceComptes service;

    @RequestMapping(value="/afficherModificationComptes", method = RequestMethod.GET)
    public String afficher(final ModelMap pModel) {
        if (pModel.get("modification") == null) {
            final List<Compte> lListeComptes = service.listerComptes();
            final ModificationForm lModificationForm = new ModificationForm();
            final List<ModificationCompte> lListe = new LinkedList<ModificationCompte>();
            for (final Compte lCompte : lListeComptes) {
                final ModificationCompte lModificationCompte = new ModificationCompte();
                lModificationCompte.setId(lCompte.getId());
                lModificationCompte.setNom(lCompte.getNom());
                lModificationCompte.setBalance(lCompte.getBalance().toString());
                lListe.add(lModificationCompte);
            }
            lModificationForm.setListeComptes(lListe);
            pModel.addAttribute("modification", lModificationForm);
        }
        return "modification";
    }

    @RequestMapping(value="/modifierModificationComptes", method = RequestMethod.POST)
    public String modifier(@Valid @ModelAttribute(value="modification") final ModificationForm pModification, 
            final BindingResult pBindingResult, final ModelMap pModel) {

        if (!pBindingResult.hasErrors()) {
            final List<Compte> lListeComptes = new LinkedList<Compte>();
            for (final ModificationCompte lModificationCompte : pModification.getListeComptes()) {
                final Compte lCompte = new Compte();
                lCompte.setId(lModificationCompte.getId());
                final Integer lBalance = Integer.valueOf(lModificationCompte.getBalance());
                lCompte.setBalance(lBalance);
                lListeComptes.add(lCompte);
            }
            service.modifierComptes(lListeComptes);
        }

        return afficher(pModel);
    }
}