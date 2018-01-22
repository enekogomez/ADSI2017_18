package packControlador.ContMenuPrincipal;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import packVista.MenuPrincipal;
import packVista.SeleccionarNivel;



public class CBtnIniPart implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		MenuPrincipal.getMenuPrincipal().dispose();
		SeleccionarNivel frame = SeleccionarNivel.getSeleccionarNivel();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
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
