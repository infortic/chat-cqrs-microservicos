package infortic.chat.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class CriarSalaDTO {

	private String 	salaId;
	@NotEmpty
	private String nome;
	
	
}
