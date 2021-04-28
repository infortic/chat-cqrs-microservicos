package infortic.chat.entity;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.google.type.DateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EntrouNaSala {

	@Id
	@GeneratedValue
	private Long id;
	
	private Long timestamp;
	private String salaId;
	private String participante;
	private ZonedDateTime momnetoSaida = ZonedDateTime.now();
	
}
