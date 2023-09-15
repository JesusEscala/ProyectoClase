package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

// GUI!!!
public class Demo01 {
	//realizar el registro de un nuevo Usuario
	
	
	public static void main(String[] args) {
		//1. obtener la conexion --> llamar a la unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		
		//2. crear un manejador de entidades segun la conexion
		EntityManager em = fabrica.createEntityManager();
		
		//proceso
		//insert into tb_xx values (?,?, .... 
		
		Usuario u = new Usuario(677,"Zoila", "baca", "zbaca", "3.1416","2000/01/15",1,1, null);
		//Usuario u = new Usuario(123,"carlos", "berrocal", "presi", "1234","2000/08/19",2,3);
		
		//ojo.... al reg/act/elim se tendra que usar transact
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		System.out.println("Registro Ok");
		
		em.close();
		
		
	}
}
