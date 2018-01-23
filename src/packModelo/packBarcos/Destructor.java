package packModelo.packBarcos;

import packModelo.Nivel;
import packModelo.packCoordenada.Coordenada;

public class Destructor extends Barco {

	public Destructor(Coordenada pC, boolean pVertical) {
		super(pC,pVertical);
		setTipo("Destructor");
		getPosicion().addCoordenada(pC);
		int i = 0;
		if (pVertical) {
			i = pC.getY() + 1;
			while (getPosicion().numCoordenadas() < Nivel.LONG_DESTRUCTOR) {
				getPosicion().addCoordenada(new Coordenada(pC.getX(), i++));
			}
		} else {
			i = pC.getX() + 1;
			while (getPosicion().numCoordenadas() < Nivel.LONG_DESTRUCTOR) {
				getPosicion().addCoordenada(new Coordenada(i++, pC.getY()));
			}
		}
	}

	public boolean puedePonerse(ListaBarcos listaBarcos) {
		return listaBarcos.getNumBarcosRestantes(this.getTipo()) < Nivel.NUM_DESTRUCTOR;
	}
}