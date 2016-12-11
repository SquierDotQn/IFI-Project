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

import tiir.ifi.bean.Message;
import tiir.ifi.services.IServiceMessages;

@Controller
public class CreerMessageController {

    @Autowired
    private IServiceMessages service;

    @RequestMapping(value="/afficherCreationMessage", method = RequestMethod.GET)
    public String afficher(final ModelMap pModel) {
        final List<Message> lListeMessages = service.listerMessages();
        pModel.addAttribute("listeMessages", lListeMessages);
        if (pModel.get("creation") == null) {
            pModel.addAttribute("creation", new CreationForm());
        }
        return "creation";
    }

    @RequestMapping(value="/creerCreationMessage", method = RequestMethod.POST)
    public String creer(@Valid @ModelAttribute(value="creation") final CreationForm pCreation, 
            final BindingResult pBindingResult, final ModelMap pModel) {

        if (!pBindingResult.hasErrors()) {
            service.creerMessage(pCreation.getAuthor(), pCreation.getContent(), pCreation.getUnixstamp());
        }
        return afficher(pModel);
    }
}