package packControlador.ContFin;

import java.awt.event.MouseListener;

import javax.swing.JFrame;

import packVista.Compartir;

public class CBtnCompartir implements MouseListener {
	private JFrame vista;
	public CBtnCompartir(JFrame pVista) {
		this.vista=pVista;
	}
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		new Compartir();
		this.vista.dispose();
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
