package infortic.chat.coreapi.commads;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SairSalaCommad {
	@TargetAggregateIdentifier
	private String salaId;
	private String participante;	
}
