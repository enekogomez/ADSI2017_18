package packMain;


import packModelo.Battleship;
import packVista.MenuPrincipal;

public class InicioCarga {
	

	public static void main(String[] args) {
		String user ="edgar";

		Battleship.getBattleship().inicializar(user);
		//Battleship.getBattleship().inicializar();
		MenuPrincipal.getMenuPrincipal().empezar();
		//Inicio.getInicio().empezar();
	}
}
