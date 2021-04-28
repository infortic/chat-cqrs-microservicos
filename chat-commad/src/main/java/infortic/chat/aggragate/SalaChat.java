package infortic.chat.aggragate;

import java.util.HashSet;
import java.util.Set;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import infortic.chat.coreapi.commads.CriarSalaCommad;
import infortic.chat.coreapi.commads.EntrarSalaCommad;
import infortic.chat.coreapi.commads.PostarMensagemCommad;
import infortic.chat.coreapi.commads.SairSalaCommad;
import infortic.chat.coreapi.events.CriarSalaEvent;
import infortic.chat.coreapi.events.EntrarSalaEvent;
import infortic.chat.coreapi.events.PostarMensagemEvent;
import infortic.chat.coreapi.events.SairSalaEvent;

@Aggregate
public class SalaChat {

	@AggregateIdentifier
	private String salaId;
	private Set<String> participantes; 
	private String mensagem;
	private String participate;
	
	public SalaChat() {}

	@CommandHandler
	public SalaChat(CriarSalaCommad cmd) {
		AggregateLifecycle.apply(new CriarSalaEvent(cmd.getSalaId(), cmd.getNome()));
	}
	
	@CommandHandler
	public void handle(EntrarSalaCommad cmd) {
		if(this.participantes.contains(cmd.getParticipante())) throw new IllegalArgumentException("Você já esta na sala");
		AggregateLifecycle.apply(new EntrarSalaEvent(cmd.getSalaId(), cmd.getParticipante()));
	}
	
	@CommandHandler
	public void handle(SairSalaCommad cmd) {
//		if(this.participantes.contains(cmd.getParticipante())) throw new IllegalArgumentException("Você já saiu da sala");
		AggregateLifecycle.apply(new SairSalaEvent(cmd.getSalaId(), cmd.getParticipante()));
	}
	
	@CommandHandler
	public void handle(PostarMensagemCommad cmd) {
	//	if(this.participantes.contains(cmd.getParticipante())) throw new IllegalArgumentException("Você não pode postar mesagem, você ainda nao entrou");
		AggregateLifecycle.apply(new PostarMensagemEvent(cmd.getSalaId(), cmd.getParticipante(), cmd.getMensagem()));
	}
	
	@EventSourcingHandler
	protected void on(CriarSalaEvent evt) {
		this.salaId = evt.getSalaId();
		this.participantes = new HashSet<>();	
	}
	
	@EventSourcingHandler
	protected void on(SairSalaEvent evt) {
		this.salaId = evt.getSalaId();
		this.participantes.remove(evt.getParticipante());
		
	}
	
	@EventSourcingHandler
	protected void on(EntrarSalaEvent evt) {
		this.salaId = evt.getSalaId();
		this.participantes.add(evt.getParticipante());
	}
	
	@EventSourcingHandler
	protected void on(PostarMensagemEvent evt) {
		this.salaId = evt.getSalaId();
		this.participate = evt.getParticipante();
		this.mensagem = evt.getMensagem();
	}

}
