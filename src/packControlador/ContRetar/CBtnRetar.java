package packControlador.ContRetar;

import packVista.Retar;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class CBtnRetar implements MouseListener {
	private JFrame vista;
	
	public CBtnRetar(JFrame pVista){
		this.vista=pVista;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Retar.getFrame().realizarReto();
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
		// TODO
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
