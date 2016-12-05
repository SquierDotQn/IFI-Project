package tiir.ifi.services;


import java.util.List;

import tiir.ifi.bean.Compte;


public interface IServiceComptes {
	List<Compte> listerComptes();
	void creerCompte(final String pNom, final Integer pBalance);
	void supprimerCompte(final Integer pIdCompte);
	void modifierComptes(final List<Compte> pListeComptes);
}
