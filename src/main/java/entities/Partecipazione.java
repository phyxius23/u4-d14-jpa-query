package entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "partecipazione")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Partecipazione {
	@Id
	@GeneratedValue
	private UUID id;

	// più partecipazioni possono puntare ad una persona
	@ManyToOne
	@JoinColumn(name = "persona_id")
	private Persona persona;

	// più partecipazioni possono puntare ad un evento
	@ManyToOne
	@JoinColumn(name = "evento_id")
	private Evento evento;

	private StatoType stato;

	// Costruttore
	public Partecipazione(Persona persona, StatoType stato, Evento evento) {
		this.persona = persona;
		this.stato = stato;
		this.evento = evento;
	}

}