package infortic.chat.projection;

import java.time.Instant;
import java.util.List;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.stereotype.Component;
import infortic.chat.coreapi.events.CriarSalaEvent;
import infortic.chat.coreapi.events.EntrarSalaEvent;
import infortic.chat.coreapi.events.PostarMensagemEvent;
import infortic.chat.coreapi.events.SairSalaEvent;
import infortic.chat.entity.EntrouNaSala;
import infortic.chat.entity.MensagensChat;
import infortic.chat.entity.SaiuDaSala;
import infortic.chat.entity.SalaChat;
import infortic.chat.query.MensagemSalaQuery;
import infortic.chat.query.ParticipantesSalaQuery;
import infortic.chat.query.SaiuDaSalaQuery;
import infortic.chat.query.SalaChatQuery;
import infortic.chat.repository.EntrouNaSalaRepository;
import infortic.chat.repository.MensagensChatRepository;
import infortic.chat.repository.SairDaSalaRepository;
import infortic.chat.repository.SalaChatRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SaiuDaSalaProjection {

	
	private final SairDaSalaRepository SairDaSalaRepository;
	private final QueryUpdateEmitter updateEmitter;
	

	@QueryHandler
	public List<SaiuDaSala> handle(SaiuDaSalaQuery query){
		return SairDaSalaRepository.findAllBySalaIdOrderByTimestamp(query.getSalaId());		
	}
	
	
	@EventHandler
	public void on(SairSalaEvent evt, @Timestamp Instant timestamp){
		SaiuDaSala sairSalaEvent = new SaiuDaSala();
		sairSalaEvent.setTimestamp(timestamp.toEpochMilli());
		sairSalaEvent.setParticipante(evt.getParticipante());
		sairSalaEvent.setSalaId(evt.getSalaId());
		SairDaSalaRepository.save(sairSalaEvent);
		updateEmitter.emit(SaiuDaSalaQuery.class, query -> query.getSalaId().equals(evt.getSalaId()),  sairSalaEvent );
	}
	
}
