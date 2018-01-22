package packControlador.retar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import packModelo.packJugador.Usuario;

public class Gestor_Usuario {
    //atributos
    private Collection<Usuario> usuarios;
    private static Gestor_Usuario instancia;

    //constructora privada
    private Gestor_Usuario(){
        usuarios=new ArrayList<>();
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
    public String obtenerUsuarios(){
        Iterator<Usuario> it= usuarios.iterator();
        String Json = "[";
        while (it.hasNext()){
            Usuario tmp=it.next();
            String nombre=tmp.getNombre();
            Json+="{nombre:"+nombre+"},";
        }
        Json+="]";
        return Json;
    }
}
