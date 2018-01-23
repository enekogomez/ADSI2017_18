package packVista;

import org.json.simple.JSONArray;
import packControlador.ContAceptarReto.CBtnAceptar;

import packModelo.Battleship;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.util.ArrayList;


public class AceptarReto extends JFrame {
	private JComboBox comboBox;
	private JPanel contentPane;
	private ArrayList<String> losCodigos;
	private static AceptarReto instancia;
	private String Nombre;

	public static AceptarReto getFrame(){
		if(instancia == null){
			instancia = new AceptarReto();
		}
		return instancia;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Battleship.getBattleship().inicializar("unai");
					AceptarReto.getFrame().setNombre("Edgar");
					AceptarReto.getFrame().setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private AceptarReto() {
		losCodigos=new ArrayList<>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		comboBox = new JComboBox();
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton aceptarReto = new JButton("Aceptar Reto");
		aceptarReto.addMouseListener(new CBtnAceptar());
		panel_1.add(aceptarReto);

		getSeleccionMisRetos();
	}

	private void getSeleccionMisRetos(){
		JSONArray json= Battleship.getBattleship().obtenerMisRetos();
		for(int i= json.size()-1; i >= 0;i--) {
			String tmp= (String) json.get(i);
			String[] res=tmp.split(",");
			comboBox.addItem(res[0]);
			losCodigos.add(res[1]);
		}
	}

	public void setNombre(String nombre){
		Nombre=nombre;
	}

	public void aceptarReto(){
		String pCod=losCodigos.get(comboBox.getSelectedIndex());
		Battleship.getBattleship().cargarReto(pCod);
		Battleship.getBattleship().inicializarReto(Nombre);
		TableroJuego frame = TableroJuego.getTableroJuego();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);


	}

}
