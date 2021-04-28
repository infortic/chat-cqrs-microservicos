package infortic.chat.projection;

import java.time.Instant;
import java.util.List;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.stereotype.Component;

import infortic.chat.coreapi.events.CriarSalaEvent;
import infortic.chat.coreapi.events.SairSalaEvent;
import infortic.chat.entity.SaiuDaSala;
import infortic.chat.entity.SalaChat;
import infortic.chat.query.SaiuDaSalaQuery;
import infortic.chat.query.SalaChatQuery;
import infortic.chat.repository.SairDaSalaRepository;
import infortic.chat.repository.SalaChatRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SalasCriadas {
	
	private final SalaChatRepository salaChatRepository;
	private final QueryUpdateEmitter updateEmitter;
	

	@QueryHandler
	public Iterable<SalaChat> handle(SalaChatQuery query){
		return salaChatRepository.findAll();
	}
	
	
	@EventHandler
	public void on(CriarSalaEvent evt, @Timestamp Instant timestamp){
		SalaChat salaChat = new SalaChat();
		salaChat.setTimestamp(timestamp.toEpochMilli());
		salaChat.setSalaId(evt.getSalaId());
		salaChat.setNomeSala(evt.getNome());
		salaChatRepository.save(salaChat);
		updateEmitter.emit(SalaChatQuery.class, query -> query.getVerdadeiro() == true,  salaChat );
	}
	

}
