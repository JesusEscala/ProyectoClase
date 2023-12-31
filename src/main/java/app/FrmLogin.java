package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Categoria;
import model.Producto;
import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class FrmLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 146);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnNewButton.setBounds(324, 29, 89, 23);
		contentPane.add(btnNewButton);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(122, 30, 161, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblNewLabel = new JLabel("Usuario :");
		lblNewLabel.setBounds(10, 33, 102, 14);
		contentPane.add(lblNewLabel);

		JLabel lblClave = new JLabel("Clave :");
		lblClave.setBounds(10, 64, 102, 14);
		contentPane.add(lblClave);

		txtClave = new JTextField();
		txtClave.setColumns(10);
		txtClave.setBounds(122, 61, 161, 20);
		contentPane.add(txtClave);

	}

	private JTextField txtClave;



	private String leerUsuario() {
		if (!txtUsuario.getText().matches("[A-Za-z0-9_]+[@]+[a-z0-9]+[.][a-z]{2,3}")) {
			JOptionPane.showMessageDialog(null, "Usuario no coincide");
			return null;
		}
		return txtUsuario.getText();
	}

	void registrar() {
		String usuario = leerUsuario();
		String clave = txtClave.getText();
		
		if(usuario==null || clave==null) {
			return;
		}
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01"); // CREAR LA CONEXION
		EntityManager em = fabrica.createEntityManager();

		// SELECT * FROM tb_usuarios -- LIST

		String jpql = "SELECT u FROM Usuario u WHERE u.usr_usua= :xusr AND u.cla_usua= :xcla";
		try {
			Usuario u = em.createQuery(jpql, Usuario.class).setParameter("xusr", usuario).setParameter("xcla", clave)
					.getSingleResult();

			// Abrir ventana
			FrmManteProd v = new FrmManteProd();
			v.setVisible(true);
			dispose();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Usuario o clave incorrecto");
		}

		em.close();
	}
}


