package packVista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import packControlador.ContInicio.CBtnBarc;
import packControlador.ContInicio.CBtnDest;
import packControlador.ContInicio.CBtnFrag;
import packControlador.ContInicio.CBtnOrient;
import packControlador.ContInicio.CBtnPort;
import packControlador.ContInicio.CBtnSub;
import packControlador.ContInicio.CBtnsColocar;
import packModelo.Battleship;
import packModelo.Nivel;
import packModelo.packCoordenada.Coordenada;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panel;
	private JButton[][] tablero;
	private JPanel panel_1;
	private JLabel lblFragata;
	private JButton btnBtnfragata;
	private JLabel lblDestructor;
	private JButton btnBtndestructor;
	private JLabel lblSubmarino;
	private JButton btnBtnsubmarino;
	private JLabel lblPortaviones;
	private JButton btnBtnportaviones;
	private JPanel panel_2;
	private JLabel lblColoqueTodosLos;
	private JButton btnBtnOrientacion;
	private JLabel lblOrientacion;
	private String tipo;
	private boolean vertical;
	private static Inicio miInicio;
	private Icon iHorizontal = new ImageIcon(Inicio.class.getResource("/packImages/horizontal.png"));
	private Icon iVertical = new ImageIcon(Inicio.class.getResource("/packImages/vertical.png"));
	private JButton btnColocarBarcos;

	public void empezar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = getInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private Inicio() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 540, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		crearTablero();
		vertical = false;
		tipo = null;
		int ancho = 540;
		int alto = 370;
		Dimension d = new Dimension(ancho, alto);
		this.setMinimumSize(d);
		addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent e) {
	        	
	        	Inicio.getInicio().dispose();
	     		MenuPrincipal frame = MenuPrincipal.getMenuPrincipal();
	     		frame.empezar();
	     		frame.setLocationRelativeTo(null);
	     		frame.setVisible(true); 
	     		
	         }
	    });
	}

	public boolean isVertical() {
		return vertical;
	}

	public void setVertical() {
		this.vertical = !vertical;
		if (vertical) {
			btnBtnOrientacion.setIcon(iVertical);
		} else {
			btnBtnOrientacion.setIcon(iHorizontal);
		}
	}

	public static Inicio getInicio() {
		if (miInicio == null) {
			miInicio = new Inicio();
		}
		return miInicio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String pTipo) {
		tipo = pTipo;
	}

	public void crearTablero() {
		if (panel != null) {
			contentPane.remove(panel);
		}
		panel = new JPanel();
		panel.setLayout(new GridLayout(Nivel.FILAS_TABLERO, Nivel.COLUMNAS_TABLERO, 0, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(getPanel_1(), BorderLayout.EAST);
		contentPane.add(getPanel_2(), BorderLayout.NORTH);
		tablero = new JButton[Nivel.COLUMNAS_TABLERO][Nivel.FILAS_TABLERO];

		for (int i = 0; i < Nivel.FILAS_TABLERO; i++) {
			for (int j = 0; j < Nivel.COLUMNAS_TABLERO; j++) {
				JButton btn = new JButton();
				btn.setName(j + "," + i);
				tablero[j][i] = btn;
				btn.addMouseListener(new CBtnsColocar());
				panel.add(btn);
			}
		}
		
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			{
				lblFragata = new JLabel(String.valueOf(Nivel.getNUM_FRAGATA()));
			}
			{
				btnBtnfragata = new JButton("Fragata");
				btnBtnfragata.addMouseListener(new CBtnFrag());
			}
			lblDestructor = new JLabel(String.valueOf(Nivel.getNUM_DESTRUCTOR()));
			GroupLayout gl_panel_1 = new GroupLayout(panel_1);
			gl_panel_1
					.setHorizontalGroup(
							gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
									.createSequentialGroup().addGap(5).addGroup(gl_panel_1
											.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_panel_1.createSequentialGroup().addComponent(getLblSubmarino())
													.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(
															getBtnBtnsubmarino()))
											.addGroup(gl_panel_1.createSequentialGroup()
													.addGroup(gl_panel_1
															.createParallelGroup(Alignment.LEADING)
															.addComponent(lblFragata).addComponent(lblDestructor))
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
															.addComponent(btnBtnfragata).addComponent(
																	getBtnBtndestructor())))
											.addGroup(gl_panel_1.createSequentialGroup()
													.addComponent(getLblPortaviones())
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(getBtnBtnportaviones()))
											.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
													.addComponent(getBtnColocarBarcos()).addGroup(gl_panel_1
															.createSequentialGroup().addComponent(getLblOrientacion())
															.addGap(24).addComponent(getbtnBtnOrientacion(),
																	GroupLayout.PREFERRED_SIZE, 66,
																	GroupLayout.PREFERRED_SIZE))))
									.addContainerGap(37, Short.MAX_VALUE)));
			gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
					.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup().addGap(9).addComponent(lblFragata))
							.addGroup(gl_panel_1.createSequentialGroup().addGap(5).addComponent(btnBtnfragata)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblDestructor)
							.addComponent(getBtnBtndestructor()))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(getLblSubmarino())
							.addComponent(getBtnBtnsubmarino()))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(getLblPortaviones())
							.addComponent(getBtnBtnportaviones()))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup().addGap(49).addComponent(getLblOrientacion()))
							.addGroup(gl_panel_1.createSequentialGroup().addGap(32).addComponent(getbtnBtnOrientacion(),
									GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addComponent(getBtnColocarBarcos()).addGap(28)));
			panel_1.setLayout(gl_panel_1);
		}
		return panel_1;
	}

	private JButton getBtnBtndestructor() {
		if (btnBtndestructor == null) {
			btnBtndestructor = new JButton("Destructor");
			btnBtndestructor.addMouseListener(new CBtnDest());
		}
		return btnBtndestructor;
	}

	private JLabel getLblSubmarino() {
		if (lblSubmarino == null) {
			lblSubmarino = new JLabel(String.valueOf(Nivel.getNUM_SUBMARINO()));
		}
		return lblSubmarino;
	}

	private JButton getBtnBtnsubmarino() {
		if (btnBtnsubmarino == null) {
			btnBtnsubmarino = new JButton("Submarino");
			btnBtnsubmarino.addMouseListener(new CBtnSub());
		}
		return btnBtnsubmarino;
	}

	private JLabel getLblPortaviones() {
		if (lblPortaviones == null) {
			lblPortaviones = new JLabel(String.valueOf(Nivel.getNUM_PORTAAVIONES()));
		}
		return lblPortaviones;
	}

	private JButton getBtnBtnportaviones() {
		if (btnBtnportaviones == null) {
			btnBtnportaviones = new JButton("Portaviones");
			btnBtnportaviones.addMouseListener(new CBtnPort());
		}
		return btnBtnportaviones;
	}

	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_2.add(getLblColoqueTodosLos());
		}
		return panel_2;
	}

	private JLabel getLblColoqueTodosLos() {
		if (lblColoqueTodosLos == null) {
			lblColoqueTodosLos = new JLabel("Coloque TODOS los barcos");
		}
		return lblColoqueTodosLos;
	}

	private JButton getbtnBtnOrientacion() {
		if (btnBtnOrientacion == null) {
			btnBtnOrientacion = new JButton("");
			btnBtnOrientacion.setIcon(new ImageIcon(Inicio.class.getResource("/packImages/horizontal.png")));
			vertical = false;
			btnBtnOrientacion.addMouseListener(new CBtnOrient());
		}
		return btnBtnOrientacion;
	}

	private JLabel getLblOrientacion() {
		if (lblOrientacion == null) {
			lblOrientacion = new JLabel("Orientacion:");
		}
		return lblOrientacion;
	}

	public void pintarBarcoMoviendo(JButton pBtn) {
		String coor[] = pBtn.getName().split(",");
		int i = Integer.parseInt(coor[0]);
		int j = Integer.parseInt(coor[1]);
		int k = 0;

		if (Battleship.getBattleship().puedeColocar(tipo, new Coordenada(i, j), vertical)) {
			if (!vertical) {
				while (k < Nivel.getLongDeTipo(tipo) && i < Nivel.COLUMNAS_TABLERO) {
					if (tablero[i][j].isEnabled()) {
						tablero[i][j].setBackground(Color.GREEN);
					}
					i++;
					k++;
				}
			} else {
				while (k < Nivel.getLongDeTipo(tipo) && j < Nivel.FILAS_TABLERO) {
					if (tablero[i][j].isEnabled()) {
						tablero[i][j].setBackground(Color.GREEN);
					}
					j++;
					k++;
				}
			}
		} else {
			if (!vertical) {
				while (k < Nivel.getLongDeTipo(tipo) && i < Nivel.COLUMNAS_TABLERO) {
					if (tablero[i][j].isEnabled()) {
						tablero[i][j].setBackground(Color.RED);
					}
					i++;
					k++;
				}
			} else {
				while (k < Nivel.getLongDeTipo(tipo) && j < Nivel.FILAS_TABLERO) {
					if (tablero[i][j].isEnabled()) {
						tablero[i][j].setBackground(Color.RED);
					}
					j++;
					k++;
				}
			}
		}
	}

	public void pintarBarcoPuesto(JButton pBtn) {
		String coor[] = pBtn.getName().split(",");
		int i = Integer.parseInt(coor[0]);
		int j = Integer.parseInt(coor[1]);
		int k = 0;
		if (!vertical) {
			while (k < Nivel.getLongDeTipo(tipo) && i < Nivel.COLUMNAS_TABLERO) {
				tablero[i][j].setBackground(Color.PINK);
				i++;
				k++;
			}
		} else {
			while (k < Nivel.getLongDeTipo(tipo) && j < Nivel.FILAS_TABLERO) {
				tablero[i][j].setBackground(Color.PINK);
				j++;
				k++;
			}
		}
	}

	public void despintarBarco(JButton pBtn) {
		String coor[] = pBtn.getName().split(",");
		int i = Integer.parseInt(coor[0]);
		int j = Integer.parseInt(coor[1]);
		int k = 0;
		if (!vertical) {
			while (k < Nivel.getLongDeTipo(tipo) && i < Nivel.COLUMNAS_TABLERO) {
				if (tablero[i][j].isEnabled()) {
					tablero[i][j].setBackground(null);
				}
				i++;
				k++;
			}
		} else {
			while (k < Nivel.getLongDeTipo(tipo) && j < Nivel.FILAS_TABLERO) {
				if (tablero[i][j].isEnabled()) {
					tablero[i][j].setBackground(null);
				}
				j++;
				k++;
			}
		}
	}

	public void decrementarCont() {
		int i;
		switch (tipo) {
		case "Fragata":
			i = Integer.parseInt(lblFragata.getText());
			i--;
			lblFragata.setText(i + "");
			if (i < 1) {
				btnBtnfragata.setEnabled(false);
				tipo = null;
			}
			break;
		case "Destructor":
			i = Integer.parseInt(lblDestructor.getText());
			i--;
			lblDestructor.setText(i + "");
			if (i < 1) {
				btnBtndestructor.setEnabled(false);
				tipo = null;
			}
			break;
		case "Submarino":
			i = Integer.parseInt(lblSubmarino.getText());
			i--;
			lblSubmarino.setText(i + "");
			if (i < 1) {
				btnBtnsubmarino.setEnabled(false);
				tipo = null;
			}
			break;
		case "Portaaviones":
			i = Integer.parseInt(lblPortaviones.getText());
			i--;
			lblPortaviones.setText(i + "");
			if (i < 1 ) {
				btnBtnportaviones.setEnabled(false);
				tipo = null;
			}
			break;
		}
	}

	public void deshabilitarBotones(JButton pBtn) {
		String coor[] = pBtn.getName().split(",");
		int i = Integer.parseInt(coor[0]);
		int j = Integer.parseInt(coor[1]);
		int k = 0;
		if (!vertical) {
			while (k < Nivel.getLongDeTipo(tipo) && i < Nivel.COLUMNAS_TABLERO) {
				tablero[i][j].setEnabled(false);
				i++;
				k++;
			}
		} else {
			while (k < Nivel.getLongDeTipo(tipo) && j < Nivel.FILAS_TABLERO) {
				tablero[i][j].setEnabled(false);
				j++;
				k++;
			}
		}
	}

	public JButton getBtnColocarBarcos() {
		if (btnColocarBarcos == null) {
			btnColocarBarcos = new JButton("Colocar aleatoriamente");
			btnColocarBarcos.addMouseListener(new CBtnBarc());
		}
		return btnColocarBarcos;
	}
}
