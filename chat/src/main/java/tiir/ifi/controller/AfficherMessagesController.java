package tiir.ifi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tiir.ifi.bean.Message;
import tiir.ifi.services.IServiceMessages;

@Controller
@RequestMapping(value="/afficherMessages")
public class AfficherMessagesController {

    @Autowired
    private IServiceMessages service;

    @RequestMapping(method = RequestMethod.GET)
    public String afficher(ModelMap pModel) {
        final List<Message> lListeMessages = service.listerMessages();
        pModel.addAttribute("listeMessages", lListeMessages);
        return "listeMessages";
    }
}