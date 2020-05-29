
package tools;


public class Session 
{
    private static int nbClients;

    public static int getNbClients() {
        return nbClients;
    }

    public static void setNbClients(int nbClients) {
        Session.nbClients = nbClients;
    }
}
