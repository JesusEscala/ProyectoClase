package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;
import model.Usuario;

// GUI!!!
public class Demo07 {
	// OBJETIVO: LISTADO DE TODOS LOS PRODUCTOS
	// MOSTRANDO EL NOMBRE DEL PROVEEDOR
	// MOSTRANDO DE SU CATEGORIA

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01"); // CREAR LA CONEXION
		EntityManager em = fabrica.createEntityManager();

		// SELECT * FROM tb_usuarios -- LIST

		String jpql = "SELECT p FROM Producto p";
		List<Producto> lstProductos = em.createQuery(jpql, Producto.class).getResultList();

		// IMPRIMIR EL LISTADO
		for (Producto p : lstProductos) {
			System.out.println("Codigo...: " + p.getId_prod());
			System.out.println("Nombre del producto...: " + p.getDes_prod());
			System.out.println("Categoria...: " + p.getObjCategoria().getDescripcion());
			System.out.println("Proveedor...: " + p.getObjProveedor().getNombre_rs());
			System.out.println("----------------------------------------");
		}
		em.close();

	}
}