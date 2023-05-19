package entities;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "persona")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Persona {
	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private String cognome;
	private String email;
	private LocalDate dataNascita;
	private SessoType sesso;

	// una persona può avere più partecipazioni (NO => più persone possono partecipare allo stesso evento)
	@OneToMany(mappedBy = "persona")
	private Set<Partecipazione> listaPartecipazioni;

	// Costruttore
	public Persona(String nome, String cognome, String email, LocalDate dataNascita, SessoType sesso) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataNascita = dataNascita;
		this.sesso = sesso;
	}

}
