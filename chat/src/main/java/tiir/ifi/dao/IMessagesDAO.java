package tiir.ifi.dao;


import java.util.List;

import tiir.ifi.bean.Message;


public interface IMessagesDAO {
	List<Message> listerMessages();
	void creerMessage(final Message pMessage);
	void supprimerMessage(final Message pMessage);
	void modifierMessage(final Message pMessage);
}
