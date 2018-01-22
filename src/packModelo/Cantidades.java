package packModelo;

public class Cantidades {
	private int misil;
	private int misilNS;
	private int misilEO;
	private int misilBOOM;
	private int escudo;

	public Cantidades() {}

	public void iniciarAlmacen() {
		misil = Nivel.CANT_MISIL;
		misilNS = Nivel.CANT_MISIL_NS;
		misilEO = Nivel.CANT_MISIL_EO;
		misilBOOM = Nivel.CANT_MISIL_BOOM;
		escudo = Nivel.CANT_ESCUDO;
	}

	public void iniciarJugador() {
		misil = Nivel.INI_MISIL;
		misilNS = Nivel.INI_MISIL_NS;
		misilEO = Nivel.INI_MISIL_EO;
		misilBOOM = Nivel.INI_MISIL_BOOM;
		escudo = Nivel.INI_ESCUDO;
	}

	public int getMisil() {
		return misil;
	}

	public void addMisil() {
		this.misil++;
	}

	public void rmvMisil() {
		this.misil--;
	}

	public int getMisilNS() {
		return misilNS;
	}

	public void addMisilNS() {
		this.misilNS++;
	}

	public void rmvMisilNS() {
		this.misilNS--;
	}

	public int getMisilEO() {
		return misilEO;
	}

	public void addMisilEO() {
		this.misilEO++;
	}

	public void rmvMisilEO() {
		this.misilEO--;
	}

	public int getMisilBOOM() {
		return misilBOOM;
	}

	public void addMisilBOOM() {
		this.misilBOOM++;
	}

	public void rmvMisilBOOM() {
		this.misilBOOM--;
	}

	public int getEscudo() {
		return escudo;
	}

	public void addEscudo() {
		this.escudo++;
	}

	public void rmvEscudo() {
		this.escudo--;
	}
}