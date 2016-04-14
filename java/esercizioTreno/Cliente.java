public class Cliente extends Thread {
    public static int nextID = 0;

    private final int id;
    private int numPP; // numero posti prenotati
    private boolean isPov;
    private Treno t1;

    /**
        Costruttore Completo
        @param numPP numero Posti  da Prenotare
        @param isPov true se il cliente e` povero, false se e` ricco
        @param t1 Treno su cui effettuare le prenotazioni
    */
    public Cliente(int numPP, boolean isPov, Treno t1) {
        this.id = ++nextID;
        this.numPP = numPP;
        this.isPov = isPov;
        this.t1 = t1;
    } // Cliente

    public int getNumPP() {
        return numPP;
    } // getNumPP

    public boolean getIsPov() {
        return isPov;
    } // getIsPov

    public String toString() {
        return "ID CLIENTE : " + id + " - NUM POSTI PRENOTATI: " + numPP + " \tPOVERO?: "+ isPov + " \tID Treno  " + t1.getID();
    } // toString

    public void run() {

        String res = "";
        switch (t1.prenotaDisdici(numPP, isPov)) {
        case -1:
            res = "non riuscito";
            break;
        case 0:
            res = "classe 0";
            break;
        case 1:
            res = "classe 1";
        }
        System.out.println(toString() + "  ||  Esito Prenotazione: " + res);
    } // run
}
