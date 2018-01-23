public interface AuthInterface {



    public boolean login();

    public boolean post(String message, String token);

    public void close();


}
