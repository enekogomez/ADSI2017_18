package packVista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.simple.JSONArray;


import packControlador.ContSeleccionNivel.CBtnAceptar;

import packModelo.Battleship;

public class SeleccionarNivel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static SeleccionarNivel miSeleccionarNivel;
	private JComboBox<Integer> comboBox = new JComboBox<Integer>();

	
	/**
	 * Create the frame.
	 */
	public SeleccionarNivel() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		comboBox.setBounds(187, 96, 64, 24);
		contentPane.add(comboBox);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(175, 215, 89, 25);
		contentPane.add(btnAceptar);
		btnAceptar.addMouseListener(new CBtnAceptar());
		buscarNiveles();
		addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent e) {
				SeleccionarNivel.getSeleccionarNivel().dispose();
	     		MenuPrincipal frame = MenuPrincipal.getMenuPrincipal();
	     		frame.empezar();
	     		frame.setLocationRelativeTo(null);
	     		frame.setVisible(true); 
	     		
	         }
	    });
		
	}

	public static SeleccionarNivel getSeleccionarNivel(){
		if (miSeleccionarNivel==null) {
			miSeleccionarNivel=new SeleccionarNivel();
		}
		return miSeleccionarNivel;
	}
	
	private void buscarNiveles(){
		JSONArray json= Battleship.getBattleship().buscarNiveles();
			
			for(int i= json.size()-1; i >= 0;i--) {
				
				comboBox.addItem((int)json.get(i));
			}
	}
	
	public int getSelected() {
		return (int)comboBox.getSelectedItem();
	}
}
