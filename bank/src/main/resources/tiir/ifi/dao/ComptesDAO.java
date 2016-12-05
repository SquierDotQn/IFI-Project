package tiir.ifi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import tiir.ifi.bean.Compte;

@Repository
public class ComptesDAO implements IComptesDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Compte> listerComptes() {
        final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<Compte> lCriteriaQuery = lCriteriaBuilder.createQuery(Compte.class);
        final Root<Compte> lRoot = lCriteriaQuery.from(Compte.class);
        lCriteriaQuery.select(lRoot);
        final TypedQuery<Compte> lTypedQuery = entityManager.createQuery(lCriteriaQuery);

        return lTypedQuery.getResultList();
    }
    
    
    public void creerCompte(final Compte pCompte) {
        entityManager.persist(pCompte);
    }
    
    public void supprimerCompte(final Compte pCompte) {
        final Compte lCompte = entityManager.getReference(Compte.class, pCompte.getId());
        entityManager.remove(lCompte);
    }
    
    public void modifierCompte(final Compte pCompte) {
        final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaUpdate<Compte> lCriteriaUpdate = lCriteriaBuilder.createCriteriaUpdate(Compte.class);
        final Root<Compte> lRoot = lCriteriaUpdate.from(Compte.class);
        final Path<Compte> lPath = lRoot.get("id");
        final Expression<Boolean> lExpression = lCriteriaBuilder.equal(lPath, pCompte.getId());
        lCriteriaUpdate.where(lExpression);
        lCriteriaUpdate.set("balance", pCompte.getBalance());
        final Query lQuery = entityManager.createQuery(lCriteriaUpdate);
        final int lRowCount = lQuery.executeUpdate();

        if (lRowCount != 1) {
            final org.hibernate.Query lHQuery = lQuery.unwrap(org.hibernate.Query.class);
            final String lSql = lHQuery.getQueryString();
            throw new RuntimeException("Nombre d'occurences (" + lRowCount + 
                    ") modifiés différent de 1 pour " + lSql);
        }
    }
}