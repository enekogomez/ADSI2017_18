package packVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import packControlador.ContFin.*;


import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class FinPartida extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinPartida frame = new FinPartida();
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
	public FinPartida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton compartir = new JButton("Compartir por redes sociales");
		panel.add(compartir, BorderLayout.NORTH);
		compartir.addMouseListener(new CBtnCompartir(this));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton retar = new JButton("Retar");
		panel_1.add(retar, BorderLayout.NORTH);
		retar.addMouseListener(new CBtnRetar(this));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JButton ranking = new JButton("Mostrar Ranking");
		panel_2.add(ranking, BorderLayout.NORTH);
		ranking.addMouseListener(new CBtnRanking(this));
		
		JButton principal = new JButton("Volver al Menu principal");
		panel_2.add(principal, BorderLayout.SOUTH);
		principal.addMouseListener(new CBtnPrincipal(this));
	}
}
