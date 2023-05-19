package entities;

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
@Table(name = "location")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Location {
	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private String citta;

	// DA ELIMINARE
	// una location può avere più eventi
	// FORMULA CHE POTREBBE PORTARE ALL'ERRORE
	// SOTTO QUELLA CORRETTA
	@OneToMany(mappedBy = "location")
	private Set<Evento> listaEventi;

	// Costruttore
	public Location(String nome, String citta) {
		this.nome = nome;
		this.citta = citta;
	}

}
