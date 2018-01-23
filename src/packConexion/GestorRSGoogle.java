public class GestorRSGoogle implements RRSSInterface{


    private GestorRSGoogle unGestorRSGoogle;
    private static GestorGoogle gestorGoogle = null;

    public GestorRSGoogle(){

    }

    public GestorRSGoogle getGestorRSFacebook(){
        if(unGestorRSGoogle == null){
            return new GestorRSGoogle();
        }else return this;
    }

    @Override
    public boolean login() {
        gestorGoogle = GestorGoogle.init();
        return GestorGoogle.login();
    }

    @Override
    public boolean post(String message, String token) {
        return gestorGoogle.publish(message, token);
    }

    @Override
    public void close() {
        GestorGoogle.disconnect();
        gestorGoogle = null;
    }
}
