package tiir.ifi.controller;


import java.util.List;

import javax.validation.Valid;

public class ModificationForm {

    @Valid
    private List<ModificationCompte> listeComptes;

    public void setListeComptes(final List<ModificationCompte> pListeComptes) {
        listeComptes = pListeComptes;
    }

    public List<ModificationCompte> getListeComptes() {
        return listeComptes;
    }
}