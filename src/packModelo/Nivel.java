package packModelo;

public class Nivel {

	public static int FILAS_TABLERO ;
	public static int COLUMNAS_TABLERO ;
	public static int DINERO_INICIAL;
	public static int VALOR_ESCUDO;
	public static int NUM_ARMAS ; // Numero de armas diferentes

	// Numero inicializacion armamento
	public static int INI_MISIL;
	public static int INI_MISIL_NS;
	public static int INI_MISIL_EO;
	public static int INI_MISIL_BOOM;
	public static int INI_ESCUDO;
	public static int INI_USOS_RADAR;

	// Numero id arma
	public static final int NUM_MISIL = 1;
	public static final int NUM_MISIL_NS = 2;
	public static final int NUM_MISIL_EO = 3;
	public static final int NUM_MISIL_BOOM = 4;
	public static final int NUM_MOVER_RADAR = 5;
	public static final int NUM_REPARAR = 6;
	public static final int NUM_ESCUDO = 0;
	public static final int NUM_BOMBA = -1;

	// Cantidades inciales stock Almacen
	public static int CANT_MISIL;
	public static int CANT_MISIL_NS;
	public static int CANT_MISIL_EO;
	public static int CANT_MISIL_BOOM;
	public static int CANT_ESCUDO;

	// Precio armas almacen
	public static int PRECIO_MISIL;
	public static int PRECIO_MISIL_NS;
	public static int PRECIO_MISIL_EO;
	public static int PRECIO_MISIL_BOOM;
	public static int PRECIO_ESCUDO;
	public static int PRECIO_REPARAR;

	

	// Longitud tipos barco
	public static int LONG_FRAGATA;
	public static int LONG_DESTRUCTOR;
	public static int LONG_SUBMARINO;
	public static int LONG_PORTAAVIONES;

	// Numero maximo barcos
	public static int NUM_BARCOS ;
	public static int NUM_FRAGATA;
	public static int NUM_DESTRUCTOR;
	public static int NUM_SUBMARINO;
	public static int NUM_PORTAAVIONES;

	public static int Nivel;

	public static void setNivel(int nivel) {
		Nivel = nivel;
	}

	// Devuelve la longitud del tipo de barco
	public static int getLongDeTipo(String pTipo) {
		int longitud = -1;
		if (pTipo.equals("Fragata")) {
			longitud = LONG_FRAGATA;
		} else if (pTipo.equals("Destructor")) {
			longitud = LONG_DESTRUCTOR;
		} else if (pTipo.equals("Submarino")) {
			longitud = LONG_SUBMARINO;
		} else if (pTipo.equals("Portaaviones")) {
			longitud = LONG_PORTAAVIONES;
		}
		return longitud;
	}

	public static int getNUM_FRAGATA() {
		return NUM_FRAGATA;
	}

	public static int getNUM_DESTRUCTOR() {
		return NUM_DESTRUCTOR;
	}

	public static int getNUM_SUBMARINO() {
		return NUM_SUBMARINO;
	}

	public static int getNUM_PORTAAVIONES() {
		return NUM_PORTAAVIONES;
	}

	public static void setFILAS_TABLERO(int fILAS_TABLERO) {
		FILAS_TABLERO = fILAS_TABLERO;
	}

	public static void setCOLUMNAS_TABLERO(int cOLUMNAS_TABLERO) {
		COLUMNAS_TABLERO = cOLUMNAS_TABLERO;
	}

	public static void setDINERO_INICIAL(int dINERO_INICIAL) {
		DINERO_INICIAL = dINERO_INICIAL;
	}

	public static void setVALOR_ESCUDO(int vALOR_ESCUDO) {
		VALOR_ESCUDO = vALOR_ESCUDO;
	}

	public static void setNUM_ARMAS(int nUM_ARMAS) {
		NUM_ARMAS = nUM_ARMAS;
	}

	public static void setINI_MISIL(int iNI_MISIL) {
		INI_MISIL = iNI_MISIL;
	}

	public static void setINI_MISIL_NS(int iNI_MISIL_NS) {
		INI_MISIL_NS = iNI_MISIL_NS;
	}

	public static void setINI_MISIL_EO(int iNI_MISIL_EO) {
		INI_MISIL_EO = iNI_MISIL_EO;
	}

	public static void setINI_MISIL_BOOM(int iNI_MISIL_BOOM) {
		INI_MISIL_BOOM = iNI_MISIL_BOOM;
	}

	public static void setINI_ESCUDO(int iNI_ESCUDO) {
		INI_ESCUDO = iNI_ESCUDO;
	}

	public static void setINI_USOS_RADAR(int iNI_USOS_RADAR) {
		INI_USOS_RADAR = iNI_USOS_RADAR;
	}

	public static void setCANT_MISIL(int cANT_MISIL) {
		CANT_MISIL = cANT_MISIL;
	}

	public static void setCANT_MISIL_NS(int cANT_MISIL_NS) {
		CANT_MISIL_NS = cANT_MISIL_NS;
	}

	public static void setCANT_MISIL_EO(int cANT_MISIL_EO) {
		CANT_MISIL_EO = cANT_MISIL_EO;
	}

	public static void setCANT_MISIL_BOOM(int cANT_MISIL_BOOM) {
		CANT_MISIL_BOOM = cANT_MISIL_BOOM;
	}

	public static void setCANT_ESCUDO(int cANT_ESCUDO) {
		CANT_ESCUDO = cANT_ESCUDO;
	}

	public static void setPRECIO_MISIL(int pRECIO_MISIL) {
		PRECIO_MISIL = pRECIO_MISIL;
	}

	public static void setPRECIO_MISIL_NS(int pRECIO_MISIL_NS) {
		PRECIO_MISIL_NS = pRECIO_MISIL_NS;
	}

	public static void setPRECIO_MISIL_EO(int pRECIO_MISIL_EO) {
		PRECIO_MISIL_EO = pRECIO_MISIL_EO;
	}

	public static void setPRECIO_MISIL_BOOM(int pRECIO_MISIL_BOOM) {
		PRECIO_MISIL_BOOM = pRECIO_MISIL_BOOM;
	}

	public static void setPRECIO_ESCUDO(int pRECIO_ESCUDO) {
		PRECIO_ESCUDO = pRECIO_ESCUDO;
	}

	public static void setPRECIO_REPARAR(int pRECIO_REPARAR) {
		PRECIO_REPARAR = pRECIO_REPARAR;
	}

	public static void setLONG_FRAGATA(int lONG_FRAGATA) {
		LONG_FRAGATA = lONG_FRAGATA;
	}

	public static void setLONG_DESTRUCTOR(int lONG_DESTRUCTOR) {
		LONG_DESTRUCTOR = lONG_DESTRUCTOR;
	}

	public static void setLONG_SUBMARINO(int lONG_SUBMARINO) {
		LONG_SUBMARINO = lONG_SUBMARINO;
	}

	public static void setLONG_PORTAAVIONES(int lONG_PORTAAVIONES) {
		LONG_PORTAAVIONES = lONG_PORTAAVIONES;
	}

	public static void setNUM_BARCOS(int nUM_BARCOS) {
		NUM_BARCOS = nUM_BARCOS;
	}

	public static void setNUM_FRAGATA(int nUM_FRAGATA) {
		NUM_FRAGATA = nUM_FRAGATA;
	}

	public static void setNUM_DESTRUCTOR(int nUM_DESTRUCTOR) {
		NUM_DESTRUCTOR = nUM_DESTRUCTOR;
	}

	public static void setNUM_SUBMARINO(int nUM_SUBMARINO) {
		NUM_SUBMARINO = nUM_SUBMARINO;
	}

	public static void setNUM_PORTAAVIONES(int nUM_PORTAAVIONES) {
		NUM_PORTAAVIONES = nUM_PORTAAVIONES;
	}

	public static int getLvl(){return Nivel;}


	
	
	
	
	
	
	
	
}