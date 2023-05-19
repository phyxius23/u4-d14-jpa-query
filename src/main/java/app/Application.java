package app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.EventoDAO;
import lombok.extern.slf4j.Slf4j;
import utils.JpaUtil;

@Slf4j
public class Application {

	//	private static log log = LoggerFactory.getLogger(Application.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {

		LocalDate data = LocalDate.now();

		log.info("Ciao");

		//		LocalDate data1 = data.

		EntityManager em = emf.createEntityManager();
		EventoDAO ed = new EventoDAO(em);

		//		ESERCIZIO DI MARTEDÌ
		//		Evento cenaColosseo = new Evento("Cena al Colosseo3", data.plusDays(4), "Lorem ipsum dolor sit amet",
		//				EventType.PRIVATO, 1000);
		//		ed.save(cenaColosseo);
		//		System.out.println(ed.getById(3).toString());
		//
		//		ed.delete(1);
		//
		//		ed.refresh(6);
		//
		//		ed.modify(8);

		// ESERCIZIO DI MERCOLEDÌ
		//Evento test1 = new Evento("esercizio pomeridiano", data, "JPA query", EventType.PRIVATO, 30);
		//ed.save(test1);

		//System.out.println(ed.getById(3).toString());

		em.close();
		emf.close();

	}

}
