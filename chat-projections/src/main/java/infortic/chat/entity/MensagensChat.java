package infortic.chat.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MensagensChat {

	@Id
	@GeneratedValue
	private Long id;
	
	private Long timestamp;
	private String salaId;
	private String mensagem;
	private String participante;
	
	
}
