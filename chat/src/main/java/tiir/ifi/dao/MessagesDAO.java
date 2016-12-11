package tiir.ifi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import tiir.ifi.bean.Message;

@Repository
public class MessagesDAO implements IMessagesDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Message> listerMessages() {
        final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<Message> lCriteriaQuery = lCriteriaBuilder.createQuery(Message.class);
        final Root<Message> lRoot = lCriteriaQuery.from(Message.class);
        lCriteriaQuery.select(lRoot);
        final TypedQuery<Message> lTypedQuery = entityManager.createQuery(lCriteriaQuery);

        return lTypedQuery.getResultList();
    }
    
    
    public void creerMessage(final Message pMessage) {
        entityManager.persist(pMessage);
    }
    
    public void supprimerMessage(final Message pMessage) {
        final Message lMessage = entityManager.getReference(Message.class, pMessage.getId());
        entityManager.remove(lMessage);
    }
    
    public void modifierMessage(final Message pMessage) {
        final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaUpdate<Message> lCriteriaUpdate = lCriteriaBuilder.createCriteriaUpdate(Message.class);
        final Root<Message> lRoot = lCriteriaUpdate.from(Message.class);
        final Path<Message> lPath = lRoot.get("id");
        final Expression<Boolean> lExpression = lCriteriaBuilder.equal(lPath, pMessage.getId());
        lCriteriaUpdate.where(lExpression);
        lCriteriaUpdate.set("content", pMessage.getContent());
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