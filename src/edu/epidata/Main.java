package edu.epidata;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import edu.epidata.jpa.Persona;

public class Main {

	public static void main(String[] args) {
		// Crea el Entity manager factory con la configuración
		// llamada editorial
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Editorial");
		EntityManager em = emf.createEntityManager();

		// Inicia la transacción con la DBs
		// Persiste una persona
		// Hace el commit
		/*
		 * em.getTransaction().begin(); em.persist(new Persona("Juan", "Perez",
		 * "juan@perez.com")); em.getTransaction().commit(); em.close();
		 */

		// Inicio otra session
		/*
		 * em = emf.createEntityManager(); em.getTransaction().begin();
		 * 
		 * // Pregunto por todas las Personas. Persona en este caso // es la clase
		 * Persona, ya que la query es sobre JPQL TypedQuery<Persona> qp =
		 * em.createQuery("SELECT p FROM Persona p", Persona.class);
		 * 
		 * for (Persona p : qp.getResultList()) { System.out.println(p); }
		 * em.getTransaction().commit();
		 */

		//Cuantos libros editó cada persona en un año dado
		em.getTransaction().begin();
		TypedQuery<Reporte1DTO> consulta1 = em.createQuery("SELECT new " + "edu.epidata.Reporte1DTO(p.id, count(*))"
				+ " FROM Libro l JOIN l.editores p" + " WHERE l.anio = :anio" + " GROUP BY p.id ", Reporte1DTO.class);
		consulta1.setParameter("anio", 2017);
		List<Reporte1DTO> respuesta1 = consulta1.getResultList();
		// Imprime los resultados
		respuesta1.forEach(r -> System.out.println(r));
		em.getTransaction().commit();
		
		
		//Cuantas paginas reviso cada persona en un año dado
		em.getTransaction().begin();
		TypedQuery<Reporte2DTO> consulta2 = em.createQuery(
				"SELECT new " + "edu.epidata.Reporte2DTO(p.id, SUM(c.paginas)) "+
				"FROM Capitulo c JOIN c.revisor p JOIN c.libro l "+
				"WHERE l.anio = :anio GROUP BY p.id", Reporte2DTO.class);
		consulta2.setParameter("anio", 2017);
		List<Reporte2DTO> respuesta2 = consulta2.getResultList();
		// Imprime los resultados
		respuesta2.forEach(r -> System.out.println(r));
		em.getTransaction().commit();
		
		
		//En cuantos libros participó cada persona como autor de capítulo.
		em.getTransaction().begin();
		TypedQuery<Reporte3DTO> consulta3 = em.createQuery(
				"SELECT new " + "edu.epidata.Reporte3DTO(a.id, count(distinct c.libro)) "+
				"FROM Capitulo c JOIN c.autores a "+
				"GROUP BY a.id", Reporte3DTO.class);
		List<Reporte3DTO> respuesta3 = consulta3.getResultList();
		// Imprime los resultados
		respuesta3.forEach(r -> System.out.println(r));
		em.getTransaction().commit();
		
		

		em.close();
		emf.close();

	}
}
