package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

// GUI!!!
public class Demo2 {
	//realizar una actualizacion
	
	
	public static void main(String[] args) {
		//1. obtener la conexion --> llamar a la unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		
		//2. crear un manejador de entidades segun la conexion
		EntityManager em = fabrica.createEntityManager();
		
		//proceso
		//update into tb_xx set campo =?,?,whee
		
		//Usuario u = new Usuario(611,"ander", "rodriguez", "zbaca", "2403","2000/01/15",1,1, null);
		//Usuario u = new Usuario(123,"carlos", "berrocal", "presi", "1234","2000/08/19",2,3);
		
		//ojo.... al reg/act/elim se tendra que usar transact begin y commit
		em.getTransaction().begin();
		//em.merge(u);
		em.getTransaction().commit();
		System.out.println("Actualizacion Ok");
		
		em.close();
		
		
	}
}
