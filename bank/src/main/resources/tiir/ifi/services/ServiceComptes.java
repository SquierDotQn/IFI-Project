package tiir.ifi.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tiir.ifi.bean.Compte;
import tiir.ifi.dao.IComptesDAO;

@Service
public class ServiceComptes implements IServiceComptes {

    @Autowired
    private IComptesDAO dao;

    @Transactional(readOnly=true)
    public List<Comptes> listerComptes() {
        return dao.listerComptes();
    }
    
    @Transactional
    public void creerCompte(final String pNom, final Integer pBalance) {
        final Compte lCompte = new Compte();
        lCompte.setNom(pNom);
        lCompte.setBalance(pBalance);

        dao.creerCompte(lCompte);
    }
    
    @Transactional
    public void supprimerCompte(final Integer pIdCompte) {
        final Compte lCompte = new Compte();
        lCompte.setId(pIdCompte);

        dao.supprimerCompte(lCompte);
    }
    
    @Transactional
    public void modifierComptes(final List<Comptes> pListeComptes) {
        for (final Compte lCompte : pListeComptes) {
            dao.modifierCompte(lCompte);
        }
    }
}