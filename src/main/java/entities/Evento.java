package entities;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "evento")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Evento {

	// Attributi
	@Id
	@GeneratedValue
	private UUID id;
	private String titolo;
	private LocalDate dataEvento;
	private String descrizione;
	private EventoType tipoEvento;
	private int numeroMassimoPartecipanti;

	// un evento può avere più partecipazioni (un evento può avere più persone)
	@OneToMany(mappedBy = "evento")
	private Set<Partecipazione> partecipazioni;

	// un evento può essere svolto in una solo location MA in una location possiamo svolgere più eventi
	// FORMULA CHE POTREBBE PORTARE ALL'ERRORE
	// SOTTO QUELLA CORRETTA
	// molti eventi diversi possono puntare ad una stessa location
	@ManyToOne
	@JoinColumn(name = "location_id", referencedColumnName = "id", nullable = false)
	private Location location;

	// Costruttore
	//	public Evento() {}

	public Evento(String titolo, LocalDate dataEvento, String descrizione, EventoType tipoEvento,
			int numeroMassimoPartecipanti) {
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
		//		this.partecipazione = partecipazione;
		//		this.location = location;
		//		, Set<Partecipazione> partecipazione, Location location
	}

	//	public Evento(String titolo, LocalDate dataEvento, String descrizione, EventType tipoEvento,
	//			int numeroMassimoPartecipanti) {
	//		this.titolo = titolo;
	//		this.dataEvento = dataEvento;
	//		this.descrizione = descrizione;
	//		this.tipoEvento = tipoEvento;
	//		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	//	}

	//toString()
	//	@Override
	//	public String toString() {
	//		return "Evento [id=" + id + ", titolo=" + titolo + ", dataEvento=" + dataEvento + ", descrizione=" + descrizione
	//				+ ", tipoEvento=" + tipoEvento + ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti + "]";
	//	}

	// Getters & Setters
	//	public String getTitolo() {
	//		return titolo;
	//	}
	//
	//	public void setTitolo(String titolo) {
	//		this.titolo = titolo;
	//	}
	//
	//	public LocalDate getDataEvento() {
	//		return dataEvento;
	//	}
	//
	//	public void setDataEvento(LocalDate dataEvento) {
	//		this.dataEvento = dataEvento;
	//	}
	//
	//	public String getDescrizione() {
	//		return descrizione;
	//	}
	//
	//	public void setDescrizione(String descrizione) {
	//		this.descrizione = descrizione;
	//	}
	//
	//	public EventType getTipoEvento() {
	//		return tipoEvento;
	//	}
	//
	//	public void setTipoEvento(EventType tipoEvento) {
	//		this.tipoEvento = tipoEvento;
	//	}
	//
	//	public int getNumeroMassimoPartecipanti() {
	//		return numeroMassimoPartecipanti;
	//	}
	//
	//	public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
	//		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	//	}

}
