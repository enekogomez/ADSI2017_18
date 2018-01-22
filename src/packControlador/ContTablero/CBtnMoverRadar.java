package packControlador.ContTablero;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import packModelo.Nivel;
import packVista.TableroJuego;

public class CBtnMoverRadar implements MouseListener {
	@Override
	public void mousePressed(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn.isEnabled()) {
			TableroJuego.getTableroJuego().setArma(Nivel.NUM_MOVER_RADAR);
			TableroJuego.getTableroJuego().getLblArmamento().setText("Armamento seleccionado: Mover Radar");
		}
		TableroJuego.getTableroJuego().actualizarCantidades();
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}
