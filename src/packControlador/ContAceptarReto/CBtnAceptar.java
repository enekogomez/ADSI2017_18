package packControlador.ContAceptarReto;

import packControlador.retar.Gestor_Retos;
import packModelo.Battleship;
import packVista.AceptarReto;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class CBtnAceptar implements MouseListener{



	@Override
	public void mouseClicked(MouseEvent e) {
		AceptarReto.getFrame().aceptarReto();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//TODO Crear la nueva partida segun especificaciones seleccionadas
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
