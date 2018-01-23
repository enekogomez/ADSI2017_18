package packModelo;
import java.util.Collection;
import java.util.Date;

import packModelo.packBarcos.ListaBarcos;
import packModelo.packJugador.Ordenador;
import packModelo.packJugador.Usuario;

public class Partida {

    //atributos
    private Radar radar;
    private int puntuacion;
    private Usuario usr;
    private Ordenador ia;
    private Date fecha;
    private ListaBarcos flotaH;
    private ListaBarcos flotaO;
    private Collection<Cantidades> cantidades;
    private static Partida instancia;

    //constructora privada
    private Partida(){}

    //patron singleton
    public static Partida getInstancia() {
        if(instancia ==null){
            instancia=new Partida();
        }
        return instancia;
    }
    public void iniciarPartidaReto(Usuario usu,Ordenador ord,Collection<Cantidades> cant){
        usr=usu;
        ia=ord;
        fecha=new Date();
        cantidades=cant;
        puntuacion=0;
    }

    public void iniciarPartida(ListaBarcos fH,ListaBarcos fO,Usuario usu,Ordenador ord,Collection<Cantidades> cant){
        usr=usu;
        flotaO=fO;
        flotaH=fH;
        ia=ord;
        fecha=new Date();
        cantidades=cant;
        puntuacion=0;
    }

    //getters

    public int getPuntuacion() {
        return puntuacion;
    }

    public ListaBarcos getFlotaH() {
        return flotaH;
    }

    public ListaBarcos getFlotaO() {
        return flotaO;
    }

    public int getConfig() {
        return Nivel.getLvl();
    }

    public String getRetador() {
         return usr.getNombre();
    }

    /**
     * metodo de inicialización de reto
     * @param laLIstaBarcosO
     * @param laLIstaBarcosH
     * @return
     */
    public  boolean cargarSituacionInicial(ListaBarcos laLIstaBarcosO,ListaBarcos laLIstaBarcosH){
        flotaH=laLIstaBarcosH;
        flotaO=laLIstaBarcosO;
        return true;
    }
}
