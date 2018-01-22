package packGestores;

import packModelo.Nivel;
import org.json.simple.JSONArray;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;





public class GestorNiveles {
	private static GestorNiveles miGestorNiveles;
	public Collection<Nivel> niveles;
	
	private GestorNiveles() {
		
	}
	
	
	
	public static GestorNiveles getGestorNiveles() {
		if (miGestorNiveles==null) {
			miGestorNiveles= new GestorNiveles();
		}
		return miGestorNiveles;
	}
	
	
	/*
	 * busca los niveles que existen en la base de datos
	 * lo manda a la interfaz
	 */
	@SuppressWarnings("unchecked")
	public  JSONArray buscarNiveles() {
		int nivel=0;
		JSONArray json= new JSONArray();
		ResultSet res = GestorBD.getGestorBD().Select("SELECT nivel FROM niveles");
		try {
			while (res.next()) {
				nivel=res.getInt("nivel");
				if (nivel != 0) {		
					json.add(nivel);	        
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return json;
		
	}
	
	/*
	 * serie de metodos para conseguir la diferente informacion que tiene el nivel
	 */
	public void conseguirNiveles (int nivel) {
		conseguirNivel(nivel);
		conseguirInicializacion(nivel);
		conseguirStockAlmacen(nivel);
		conseguirAlmacen(nivel);
		conseguirBarcos(nivel);
		conseguirNumeroBarco(nivel);
	}
	
	/*
	 * consigue los datos del nivel fila, columnas, dinero, valor escudo y numero de armas
	 */
	private void conseguirNivel(int nivel) {
		
		ResultSet res = GestorBD.getGestorBD().Select("SELECT * FROM niveles where nivel = "+nivel+"");
		try {
			while (res.next()) {
				Nivel.setFILAS_TABLERO(res.getInt("FilasTablero"));
				Nivel.setCOLUMNAS_TABLERO(res.getInt("ColumnasTablero"));
				Nivel.setDINERO_INICIAL(res.getInt("DineroInicial"));
				Nivel.setVALOR_ESCUDO(res.getInt("ValorEscudo"));
				Nivel.setNUM_ARMAS(res.getInt("NumArmas"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/*
	 * carga datos de los diferentes misiles
	 */
	private void conseguirInicializacion(int nivel) {
		ResultSet res = GestorBD.getGestorBD().Select("SELECT * FROM inicializacion where nivel = "+nivel+"");
		
		try {
			while (res.next()) {
				Nivel.setINI_MISIL(res.getInt("IniMisil"));
				Nivel.setINI_MISIL_NS(res.getInt("IniMisilNS"));
				Nivel.setINI_MISIL_EO(res.getInt("IniMisilEO"));
				Nivel.setINI_MISIL_BOOM(res.getInt("IniMisilBOOM"));
				Nivel.setINI_ESCUDO(res.getInt("IniEscudo"));
				Nivel.setINI_USOS_RADAR(res.getInt("IniRadar"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*
	 * carga los datos de la cantidad que habra en el stock
	 */
	
	private void conseguirStockAlmacen(int nivel) {
		ResultSet res = GestorBD.getGestorBD().Select("SELECT * FROM stockAlmacen where nivel = "+nivel+"");
		
		try {
			while (res.next()) {
				Nivel.setCANT_MISIL(res.getInt("CantMisil"));
				Nivel.setCANT_MISIL_NS(res.getInt("CantMisilNS"));
				Nivel.setCANT_MISIL_EO(res.getInt("CantMisilEO"));
				Nivel.setCANT_MISIL_BOOM(res.getInt("CantMisilBOOM"));
				Nivel.setCANT_ESCUDO(res.getInt("CantEscudo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*
	 * carga lo que costara comprar los misiles
	 */
	private void conseguirAlmacen(int nivel) {
		ResultSet res = GestorBD.getGestorBD().Select("SELECT * FROM almacen where nivel = "+nivel+"");
		
		try {
			while (res.next()) {
				Nivel.setPRECIO_MISIL(res.getInt("PrecioMisil"));
				Nivel.setPRECIO_MISIL_NS(res.getInt("PrecioMisilNS"));
				Nivel.setPRECIO_MISIL_EO(res.getInt("PrecioMisilEO"));
				Nivel.setPRECIO_MISIL_BOOM(res.getInt("PrecioMisilBOOM"));
				Nivel.setPRECIO_ESCUDO(res.getInt("PrecioEscudo"));
				Nivel.setPRECIO_REPARAR(res.getInt("PrecioReparar"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*
	 * carga la longitud de los barcos
	 */
	private void conseguirBarcos(int nivel) {
		ResultSet res = GestorBD.getGestorBD().Select("SELECT * FROM longBarco where nivel = "+nivel+"");
		
		try {
			while (res.next()) {
				Nivel.setLONG_FRAGATA(res.getInt("LongFragata"));
				Nivel.setLONG_DESTRUCTOR(res.getInt("LongDestructor"));
				Nivel.setLONG_SUBMARINO(res.getInt("LongSubmarino"));
				Nivel.setLONG_PORTAAVIONES(res.getInt("LongPortaaviones"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*
	 * carga el numero de barcos que habra que colocar o hundir.
	 */
	
	private void conseguirNumeroBarco(int nivel) {
		ResultSet res = GestorBD.getGestorBD().Select("SELECT * FROM barcos where nivel = "+nivel+"");
		
		try {
			while (res.next()) {
				Nivel.setNUM_BARCOS(res.getInt("NumBarcos"));
				Nivel.setNUM_FRAGATA(res.getInt("NumFragata"));
				Nivel.setNUM_DESTRUCTOR(res.getInt("NumDestructor"));
				Nivel.setNUM_SUBMARINO(res.getInt("NumSubmarino"));
				Nivel.setNUM_PORTAAVIONES(res.getInt("NumPortaaviones"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	

}
