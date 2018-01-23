package packControlador.retar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.json.simple.JSONArray;
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

    //constructora privada
    private Gestor_Retos(){
        retos=new ArrayList<>();
        cargar();
    }

    //patrón Singletn
    public static Gestor_Retos getInstancia() {
        if(instancia ==null){
            instancia=new Gestor_Retos();
        }
        return instancia;
    }

    public boolean crearReto(String elRetador, String elRetado, Date laFecha, String laLIstaBarcosO, String laLIstaBarcosH,int laPuntuacion, int elIdNivel){
        Calendar c = new GregorianCalendar();
        String cod =Long.toString (System.currentTimeMillis());
        //insertar un nuevo reto, actualmente en objetos posteriormente se almacenará en la BD
        GestorBD.getGestorBD().Update("Insert into retos values('"+cod+"','"+Integer.toString(c.get(Calendar.YEAR))+"-"+Integer.toString(c.get(Calendar.MONTH))+"-"+ Integer.toString(c.get(Calendar.DATE))+"','"+elIdNivel+"','"+elRetador+"','"+elRetado+"','"+laPuntuacion+"','"+laLIstaBarcosH+"','"+laLIstaBarcosO+"')");
        Reto tmp = new Reto(elRetador,elRetado,laFecha,laLIstaBarcosO,laLIstaBarcosH,laPuntuacion,elIdNivel,cod);
        return retos.add(tmp);
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
                String flotaO=res.getString("idFlotaO");
                String flotaH=res.getString("idFlotaH");
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
    public JSONArray obtenerMisRetos(String usr){
        Iterator<Reto> it=retos.iterator();
        JSONArray json= new JSONArray();
        String retador,cod;
        int nivel,puntos;

        while(it.hasNext()){
            Reto act=it.next();
            if(act.coincideUsr(usr)){
                retador=act.getRetador();
                nivel=act.getConfig();
                puntos=act.getPuntuacion();
                cod=act.getCod();
                json.add("retador: "+retador+" nivel: "+nivel+" puntos: "+puntos+","+cod);
            }
        }
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

    public String getFlotaH(String cod){
        Reto elReto=buscar(cod);
        if(elReto==null){
            //no encontrado
            return null;
        }else{
            return elReto.getFlotaH();
        }
    }

    public String getFlotaO(String cod){
        Reto elReto=buscar(cod);
        if(elReto==null){
            //no encontrado
            return null;
        }else{
            return elReto.getFlotaO();
        }
    }
}
