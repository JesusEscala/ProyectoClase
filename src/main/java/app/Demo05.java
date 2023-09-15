package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

// GUI!!!
public class Demo05 {
	// OBJETIVO: LISTADO DE TODOS LOS USUARIOS
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01"); // CREAR LA CONEXION
		EntityManager em = fabrica.createEntityManager();
		
		
		// SELECT * FROM tb_usuarios -- LIST
		
		String jpql = "SELECT u FROM Usuario u";
		List<Usuario> lstUsuarios = em.createQuery(jpql, Usuario.class).getResultList();
		
		// IMPRIMIR EL LISTADO
		for (Usuario u : lstUsuarios) {
			System.out.println("Codigo...: " + u.getCod_usua());
			System.out.println("Nombre...:" + u.getNom_usua() + " " + u.getApe_usua());
			System.out.println("Tipo...: " + u.getIdtipo());
			System.out.println("----------------------------------------");
		}
		em.close();
		
	}
}
