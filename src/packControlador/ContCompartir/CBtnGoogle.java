package packControlador.ContCompartir;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import packGestores.GestorCompartir;

public class CBtnGoogle implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		GestorCompartir.getGestorCompartir().compartirPorGoogle();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
