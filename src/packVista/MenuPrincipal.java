package packVista;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import packControlador.ContMenuPrincipal.CBtnIniPart;
import packControlador.ContMenuPrincipal.CBtnSalir;


public class MenuPrincipal extends JFrame {

	String usr;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static MenuPrincipal miMenuprincipal;

	/**
	 * Launch the application.
	 */
	public void empezar(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = getMenuPrincipal();
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
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton iniciarPartida = new JButton("Iniciar Partida");
		iniciarPartida.setBounds(144, 72, 179, 25);
		iniciarPartida.addMouseListener(new CBtnIniPart());
		contentPane.add(iniciarPartida);
		
		JButton btnNewButton_1 = new JButton("Cambiar Contraseña");
		btnNewButton_1.setBounds(144, 146, 179, 25);
		contentPane.add(btnNewButton_1);
		
		
		
		JButton btnNewButton_3 = new JButton("Aceptar reto");
		btnNewButton_3.setBounds(144, 35, 179, 25);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Contrarreloj");
		btnNewButton_4.setBounds(144, 109, 179, 25);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.setBounds(144, 183, 179, 25);
		btnNewButton_2.addMouseListener(new CBtnSalir());
		contentPane.add(btnNewButton_2);
	}
	public void setUsr(String pNombre){
		usr=pNombre;
	}
	
	public static MenuPrincipal getMenuPrincipal() {
		if (miMenuprincipal == null) {
			miMenuprincipal = new MenuPrincipal();
		}
		return miMenuprincipal;
	}
}
