package packControlador.retar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import packGestores.GestorBD;
import packModelo.Reto;
import packModelo.packBarcos.Barco;
import packModelo.packBarcos.BarcosFactory;
import packModelo.packBarcos.ListaBarcos;
import packModelo.packCoordenada.Coordenada;

public class Gestor_Retos{
    //atributos
    private Collection<Reto> retos;
    private static Gestor_Retos instancia;
    private String cod;

    //constructora privada
    private Gestor_Retos(){
        retos=new ArrayList<>();
        cod="a";
    }

    //patrón Singletn
    public static Gestor_Retos getInstancia() {
        if(instancia ==null){
            instancia=new Gestor_Retos();
        }
        return instancia;
    }

    public boolean crearReto(String elRetador, String elRetado, Date laFecha, ListaBarcos laLIstaBarcosO, ListaBarcos laLIstaBarcosH,int laPuntuacion, int elIdNivel){
        //insertar un nuevo reto, actualmente en objetos posteriormente se almacenará en la BD
        Reto tmp = new Reto(elRetador,elRetado,laFecha,laLIstaBarcosO,laLIstaBarcosH,laPuntuacion,elIdNivel,cod);
        cod+=cod+1;
        return retos.add(tmp);
    }

    /**
     * método que carga las instancias de flotas correspondientes (flota humano / flota ordenador) a la situación inicial del reto
     * @param idFlota
     * @return
     */
    private ListaBarcos cargarBarcos(String idFlota){
        ResultSet res= GestorBD.getGestorBD().Select("SELECT * FROM barco where idFlota="+idFlota+"");
        String idBarco;
        ListaBarcos result=new ListaBarcos();
        Barco tmp;
        try {
            while (res.next()) {
                String tipo=res.getString("tipoBarco");
                Coordenada eje=new Coordenada(res.getInt("ejeX"),res.getInt("ejeY"));
                Boolean vertical=res.getBoolean("vertical");
                tmp= BarcosFactory.getBarcoFactory().crearBarco(tipo,eje,vertical);
                result.addBarco(tmp);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    return result;
    }


    /**
     * método que carga en objetos toda la información almacenada en la BD sobre retos
     */
    private void cargar(){
        ResultSet res= GestorBD.getGestorBD().Select("SELECT * FROM retos");
        int puntos;
        int nivel;
        String cod;
        Date fecha;
        String retador,retado;
        Reto tmp;
        try {
            while (res.next()) {
                ListaBarcos flotaO=cargarBarcos(res.getString("idFlotaO"));
                ListaBarcos flotaH=cargarBarcos(res.getString("idFlotaH"))  ;
                nivel=res.getInt("nivel");
                fecha=res.getDate("fecha");
                puntos=res.getInt("puntuacion");
                retador=res.getString("retador");
                retado=res.getString("retado");
                cod=res.getString("cod");
                tmp=new Reto(retador,retado,fecha,flotaO,flotaH,puntos,nivel,cod);
                retos.add(tmp);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    /**
     * método que devuelve todos los retos del jugadr seleccionado con el formato:
     *[{retador:valor,nivel:valor,puntuacion:valor,codigo:valor},...]
     * @param usr
     * @return
     */
    public String obtenerMisRetos(String usr){
        cargar();
        Iterator<Reto> it=retos.iterator();
        String json="[";
        String retador,cod;
        int nivel,puntos;
        Date fecha;
        while(it.hasNext()){
            Reto act=it.next();
            if(act.coincideUsr(usr)){
                    retador=act.getRetador();
                    nivel=act.getConfig();
                    puntos=act.getPuntuacion();
                    cod=act.getCod();
                    json+="{retador:"+retador+",nivel:"+nivel+",puntuacion:"+puntos+",codigo:"+cod+"},";

            }
        }
        json+="]";
        return json;
    }

    private Reto buscar(String cod){
        Iterator<Reto>it=retos.iterator();
        boolean enc=false;
        Reto act=null;
        while (it.hasNext()&&!enc){
            act=it.next();
            if(act.coincideCod(cod)){
                enc=true;
            }
        }
        return act;
    }

    public int getNivel(String cod){
        Reto elReto=buscar(cod);
        if(elReto==null){
            //no encontrado
            return -1;
        }else{
            return elReto.getConfig();
        }
    }

    public ListaBarcos getFlotaH(String cod){
        Reto elReto=buscar(cod);
        if(elReto==null){
            //no encontrado
            return null;
        }else{
            return elReto.getFlotaH();
        }
    }

    public ListaBarcos getFlotaO(String cod){
        Reto elReto=buscar(cod);
        if(elReto==null){
            //no encontrado
            return null;
        }else{
            return elReto.getFlotaO();
        }
    }
}
