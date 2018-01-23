public class GestorRSFacebook implements RRSSInterface{


    private GestorRSFacebook unGestorRSFacebook;
    private static GestorFacebook gestorFacebook = null;

    public GestorRSFacebook(){

    }

    public GestorRSFacebook getGestorRSFacebook(){
        if(unGestorRSFacebook == null){
            return new GestorRSFacebook();
        }else return this;
    }

    @Override
    public boolean login() {
        gestorFacebook = GestorFacebook.init();
        return GestorFacebook.login();
    }

    @Override
    public boolean post(String message, String token) {
         return gestorFacebook.publish(message, token);
    }

    @Override
    public void close() {
        GestorFacebook.disconnect();
        gestorFacebook = null;
    }
}
