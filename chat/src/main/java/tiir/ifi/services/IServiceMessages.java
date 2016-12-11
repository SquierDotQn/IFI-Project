package tiir.ifi.services;


import java.util.List;

import tiir.ifi.bean.Message;


public interface IServiceMessages {
	List<Message> listerMessages();
	void creerMessage(final String pAuthor, final String pContent, final Integer pUnixstamp);
	void supprimerMessage(final Integer pIdMessage);
	void modifierMessages(final List<Message> pListeMessages);
}
