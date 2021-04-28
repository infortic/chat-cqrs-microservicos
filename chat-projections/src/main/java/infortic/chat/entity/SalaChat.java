package infortic.chat.entity;

import java.util.List;

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
public class SalaChat {

	@Id
	@GeneratedValue
	private Long id;
	
	private String salaId;
	private String nomeSala;
	private Long timestamp;
}
