package packControlador.ContTablero;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import packModelo.Battleship;
import packModelo.Nivel;
import packVista.TableroJuego;

public class CBtnCompMisilNS implements MouseListener {
	@Override
	public void mousePressed(MouseEvent e) {
		if (!Battleship.getBattleship().comprarArma(Nivel.NUM_MISIL_NS)) {
			JOptionPane.showMessageDialog(null, "�No es posible comprar misiles NS!", "Alerta",
					JOptionPane.WARNING_MESSAGE);
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
