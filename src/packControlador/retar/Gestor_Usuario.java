package packControlador.retar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.json.simple.JSONArray;
import packGestores.GestorBD;
import packModelo.Reto;
import packModelo.packBarcos.ListaBarcos;
import packModelo.packJugador.Usuario;

public class Gestor_Usuario {
    //atributos
    private Collection<Usuario> usuarios;
    private static Gestor_Usuario instancia;

    //constructora privada
    private Gestor_Usuario(){
        usuarios=new ArrayList<>();
        cargar();
    }

    private void cargar(){
        ResultSet res= GestorBD.getGestorBD().Select("SELECT * FROM usuarios");
        String usr;
        Usuario tmp;
        try {
            while (res.next()) {
                usr=res.getString("nombre");
                tmp=new Usuario(usr);
                usuarios.add(tmp);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //patrón Singletn
    public static Gestor_Usuario getInstancia() {
        if(instancia ==null){
            instancia=new Gestor_Usuario();
        }
        return instancia;
    }

    /**
     * se devuelve un String que contiene too los nombres de los usuarios con el formato:
     *[{nombre:valor},{nombre:valor},...]
     * @return
     */
    public JSONArray obtenerUsuarios(){
        Iterator<Usuario> it= usuarios.iterator();
        JSONArray json= new JSONArray();
        while (it.hasNext()){
            Usuario tmp=it.next();
            String nombre=tmp.getNombre();
            json.add(nombre);
        }
        return json;
    }
}
