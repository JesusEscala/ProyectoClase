package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.Usuario;

// GUI!!!
public class Demo08 {
	// OBJETIVO: LISTADO DE TODOS LOS USUARIOS SEGUN EL TIPO DE USUARIO (FILTRO)

	public static void main(String[] args) {
		String usuario=JOptionPane.showInputDialog("Ingrese usuario");
		String clave=JOptionPane.showInputDialog("Ingrese clave");
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01"); // CREAR LA CONEXION
		EntityManager em = fabrica.createEntityManager();

		// SELECT * FROM tb_usuarios -- LIST

		String jpql = "SELECT u FROM Usuario u WHERE u.usr_usua= :xusr AND u.cla_usua= :xcla";
		try {
			Usuario u = em.createQuery(jpql, Usuario.class)
					.setParameter("xusr", usuario)
					.setParameter("xcla", clave)
					.getSingleResult();

			//Abrir ventana
			FrmManteProd v=new FrmManteProd();
			v.setVisible(true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Usuario o clave incorrecto");
		}

		em.close();

	}
}