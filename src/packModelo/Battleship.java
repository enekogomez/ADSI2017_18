package packModelo;

import java.util.Date;
import java.util.Observable;

import org.json.simple.JSONArray;

import packControlador.retar.Gestor_Retos;
import packControlador.retar.Gestor_Usuario;
import packGestores.GestorNiveles;
import packModelo.packBarcos.Barco;
import packModelo.packBarcos.BarcoNoEncException;
import packModelo.packBarcos.BarcosFactory;
import packModelo.packBarcos.ListaBarcos;
import packModelo.packCoordenada.Coordenada;
import packModelo.packJugador.Ordenador;
import packModelo.packJugador.Usuario;

public class Battleship extends Observable {

	private static Battleship theBattleship;
	private Usuario usuario;
	private Ordenador ordenador;
	private boolean turno; // true = Usuario, false = Ordenador
	private boolean juegoFinalizado;
	private boolean avisar = true;

	private Battleship() {}

	public static Battleship getBattleship() {
		if (theBattleship == null) {
			theBattleship = new Battleship();
		}
		return theBattleship;
	}
	
	public void inicializarReto(String nombre) {
		usuario = new Usuario(nombre,Partida.getInstancia().getFlotaH());
		ordenador = new Ordenador(Partida.getInstancia().getFlotaO());
		
		//ordenador.imprimirTablero();
		turno = true;
		juegoFinalizado = false;
	}

	public void inicializar(String nombre) {
		usuario = new Usuario(nombre);
		ordenador = new Ordenador();
		ordenador.colocarBarcosAleatorios();
		//ordenador.imprimirTablero();
		turno = true;
		juegoFinalizado = false;
	}

	public void colocarBarcoUs(String pTipo, Coordenada pC, boolean pVertical) {
		
		Barco unBarco = BarcosFactory.getBarcoFactory().crearBarco(pTipo, pC, pVertical);
		usuario.anadirAdyacentesBarco(unBarco);
		usuario.colocarBarco(unBarco);
	}

	public boolean puedeColocar(String pTipo, Coordenada pC, boolean pVertical) {
		boolean puede = false;
		Barco unBarco = BarcosFactory.getBarcoFactory().crearBarco(pTipo, pC, pVertical);
		if (usuario.puedePonerUs(unBarco) && usuario.puedeColocar(unBarco)) {
			puede = true;
		}
		return puede;
	}

	public boolean getTurno() {
		return turno;
	}

	public void setTurno(boolean pTurno) throws BarcoNoEncException {
		turno = pTurno;
		if (!turno) {
			ordenador.jugar();
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Ordenador getOrdenador() {
		return ordenador;
	}

	public void imprimirTableroUsuario() {
		usuario.imprimirTablero();
	}

	public boolean hasPerdido() {
		boolean perdido = false;
		if (ordenador.haGanado()) {
			juegoFinalizado = true;
			perdido = true;
		}
		return perdido;
	}

	public boolean hasGanado() {
		boolean ganado = false;
		if (usuario.haGanado()) {
			juegoFinalizado = true;
			ganado = true;
		}
		return ganado;
	}

	public boolean usarEscudo(Coordenada pCoordenada) {
		boolean puesto = false;
		if (usuario.ponerEscudo(pCoordenada)) {
			notificarEscudo(pCoordenada);
			puesto = true;
		}
		return puesto;
	}

	public void usarBomba(Coordenada pCoordenada) {
		usuario.usarBomba(pCoordenada);
	}

	public void usarMisil(Coordenada pCoordenada) {
		usuario.usarMisil(pCoordenada);
	}

	public void usarMisilNS(Coordenada pCoordenada) {
		usuario.usarMisilNS(pCoordenada);
	}

	public void usarMisilEO(Coordenada pCoordenada) {
		usuario.usarMisilEO(pCoordenada);
	}

	public void usarMisilBOOM(Coordenada pCoordenada) {
		usuario.usarMisilBOOM(pCoordenada);
	}

	public boolean puedeUsar(int pArma) {
		return usuario.puedeUsar(pArma);
	}

	public void moverRadar(Coordenada pCoordenada) {
		ordenador.moverRadar(pCoordenada);
	}

	public boolean usarRadar() {
		boolean usado = false;
		if (usuario.getRadar().puedeUsarRadar()) {
			ordenador.recibirEscaRadar();
			usuario.getRadar().restarUsoRadar();
			usado = true;
		}
		return usado;
	}

	private void notificarEscudo(Coordenada pCoordenada) {
		Barco barco;
		try {
			barco = usuario.getListaBarcos().buscarBarco(pCoordenada);
			String cambios = "escudo";
			for (Coordenada co : barco.getPosicion().getCoordenadas()) {
				cambios += ";" + co.getX() + "," + co.getY();
			}
			setChanged();
			notifyObservers(cambios);
		} catch (BarcoNoEncException e) {}
	}

	public boolean hayBarcoUsu(Coordenada pC) {
		return usuario.hayBarco(pC);
	}

	public boolean todosBarcosUsPuestos() {
		
		return usuario.getListaBarcos().numBarcos() >= Nivel.NUM_BARCOS;
	}

	public int getDineroUsuario() {
		return usuario.getDinero();
	}

	public boolean comprarArma(int pArma) {
		return usuario.comprarArma(pArma);
	}

	public void ponerBarcosUsuario() {
		usuario.colocarBarcosAleatorios();
	}

	public boolean juegoFinalizado() {
		return juegoFinalizado;
	}

	public boolean getAvisar() {
		return avisar;
	}

	public void noAvisarMas() {
		avisar = false;
	}

	public boolean repararBarco(Coordenada pCoordenada) {
		boolean reparado = false;
		if (usuario.repararBarco(pCoordenada)) {
			try {
				ordenador.usuarioReparado(pCoordenada, usuario.getListaBarcos().buscarBarco(pCoordenada));
			} catch (BarcoNoEncException e) {}
			notificarReparar(pCoordenada);
			reparado = true;
		}
		return reparado;
	}

	private void notificarReparar(Coordenada pCoordenada) {

		Barco barco;
		try {
			barco = usuario.getListaBarcos().buscarBarco(pCoordenada);
			String cambios = "reparar";
			for (Coordenada co : barco.getPosicion().getCoordenadas()) {
				cambios += ";" + co.getX() + "," + co.getY();
			}
			setChanged();
			notifyObservers(cambios);
		} catch (BarcoNoEncException e) {}
	}

	
	/*
	  * recoge los niveles que haya introducido en el sistema para mostrarlos
	  * en la interfaz de "Seleccion de nivel"
	  */
	public JSONArray buscarNiveles() {
		return GestorNiveles.getGestorNiveles().buscarNiveles();
	}
	/*
	 * Carga los datos del nivel en el sistema
	 */
	public void conseguiDatos (int nivel) {
		GestorNiveles.getGestorNiveles().conseguirNiveles(nivel);
	}

	public String obtenerUsuarios(){
		return Gestor_Usuario.getInstancia().obtenerUsuarios();
	}

	public boolean retar(String UsrSeleccionado){
		//recogemos la informaci�n de la partida actual
		Partida act=Partida.getInstancia();
		Date laFecha=new Date();
		ListaBarcos laLIstaBarcosO=act.getFlotaO();
		ListaBarcos laLIstaBarcosH=act.getFlotaH();
		int laPuntuacion=act.getPuntuacion();
		int elNivel=act.getConfig();
		//creamos un nuevo reto
		return Gestor_Retos.getInstancia().crearReto(act.getRetador(),UsrSeleccionado,laFecha,laLIstaBarcosO,laLIstaBarcosH,laPuntuacion,elNivel);
	}

	public String obtenerMisRetos(String usr){
		return Gestor_Retos.getInstancia().obtenerMisRetos(usr);
	}

	public boolean cargarReto(String cod){
		GestorNiveles.getGestorNiveles().conseguirNiveles(Gestor_Retos.getInstancia().getNivel(cod));
		ListaBarcos barcosH=Gestor_Retos.getInstancia().getFlotaH(cod);
		ListaBarcos barcosO=Gestor_Retos.getInstancia().getFlotaO(cod);
		if(barcosH==null || barcosO==null){
			//ocurrio un error
			return false;
		}else {
			return Partida.getInstancia().cargarSituacionInicial(barcosO, barcosH);
		}
	}
}