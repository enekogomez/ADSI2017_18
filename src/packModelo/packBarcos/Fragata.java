package packModelo.packBarcos;

import packModelo.Nivel;
import packModelo.packCoordenada.Coordenada;

public class Fragata extends Barco {

	public Fragata(Coordenada pC) {
		super(pC,true);
		setTipo("Fragata");
		getPosicion().addCoordenada(pC);
	}

	public boolean puedePonerse(ListaBarcos listaBarcos) {
		return listaBarcos.getNumBarcosRestantes(this.getTipo()) < Nivel.NUM_FRAGATA;
	}
}