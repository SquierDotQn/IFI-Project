package tiir.ifi.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tiir.ifi.bean.Message;
import tiir.ifi.dao.IMessagesDAO;

@Service
public class ServiceMessages implements IServiceMessages {

    @Autowired
    private IMessagesDAO dao;

    @Transactional(readOnly=true)
    public List<Message> listerMessages() {
        return dao.listerMessages();
    }
    
    @Transactional
    public void creerMessage(final String pAuthor, final String pContent, final Integer pUnixstamp) {
        final Message lMessage = new Message();
        lMessage.setAuthor(pAuthor);
        lMessage.setContent(pContent);
        lMessage.setUnixstamp(pUnixstamp);

        dao.creerMessage(lMessage);
    }
    
    @Transactional
    public void supprimerMessage(final Integer pIdMessage) {
        final Message lMessage = new Message();
        lMessage.setId(pIdMessage);

        dao.supprimerMessage(lMessage);
    }
    
    @Transactional
    public void modifierMessages(final List<Message> pListeMessages) {
        for (final Message lMessage : pListeMessages) {
            dao.modifierMessage(lMessage);
        }
    }
}