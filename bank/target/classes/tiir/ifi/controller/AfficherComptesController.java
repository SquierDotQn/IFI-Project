package tiir.ifi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.developpez.rpouiller.bean.Compte;
import com.developpez.rpouiller.services.IServiceComptes;

@Controller
@RequestMapping(value="/afficherComptes")
public class AfficherComptesController {

    @Autowired
    private IServiceComptes service;

    @RequestMapping(method = RequestMethod.GET)
    public String afficher(ModelMap pModel) {
        final List<Compte> lListeComptes = service.listerComptes();
        pModel.addAttribute("listeComptes", lListeComptes);
        return "listeComptes";
    }
}