package packControlador.ContSeleccionNivel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import packModelo.Battleship;
import packVista.Inicio;
import packVista.SeleccionarNivel;


public class CBtnAceptar implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		SeleccionarNivel.getSeleccionarNivel().dispose();
		int nivel=SeleccionarNivel.getSeleccionarNivel().getSelected();
		Battleship.getBattleship().conseguiDatos(nivel);
		Inicio.getInicio().empezar();
		Inicio.getInicio().crearTablero();
		
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
