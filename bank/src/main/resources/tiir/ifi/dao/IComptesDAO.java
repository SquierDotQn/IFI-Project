package tiir.ifi.dao;


import java.util.List;

import tiir.ifi.bean.Course;


public class IComptesDAO {
	List<Compte> listerComptes();
	void creerCompte(final Compte pCompte);
	void supprimerCompte(final Compte pCompte);
	void modifierCompte(final Course pCompte);
}
