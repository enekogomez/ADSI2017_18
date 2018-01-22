package packModelo;
import java.util.Date;

import packModelo.packBarcos.ListaBarcos;

public class Reto {

    //atributos
    private String cod;
    private int puntuacion;
    private String usrRetador;
    private String usrRetado;
    private Date fecha;
    private ListaBarcos flotaH;
    private ListaBarcos flotaO;
    private int config;

    //constructora de retos

    public Reto(String elRetador,String elRetado,Date laFecha,ListaBarcos laLIstaBarcosO,ListaBarcos laLIstaBarcosH,int laPuntuacion,int elNivel,String pCod){
        //generamos un código en función del reloj del sistema
        cod= pCod;
        //cargamos toda la información del nuevo reto
        puntuacion=laPuntuacion;
        usrRetador=elRetador;
        usrRetado=elRetado;
        fecha=laFecha;
        flotaH=laLIstaBarcosH;
        flotaO=laLIstaBarcosO;
        config=elNivel;
    }

    //getters

    public int getPuntuacion() {
        return puntuacion;
    }

    public ListaBarcos getFlotaH() {

        return flotaH;
    }

    public String getRetador() {
        return usrRetador;
    }

    public ListaBarcos getFlotaO() {

        return flotaO;
    }

    public int getConfig(){return config;}

    public String getCod(){return cod;}

    public Date getFecha() {

        return fecha;
    }

    //métodos de consulta

    public boolean coincideUsr(String pUsrRetado) {
        return usrRetado.equals(pUsrRetado);
    }

    public boolean coincideCod(String pCod) {

        return cod.equals(pCod);
    }
}
