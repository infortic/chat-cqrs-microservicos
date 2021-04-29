package infortic.chat.coreapi.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CriarSalaEvent {
	
	private String salaId;
	private String nome;
	
}
