public class Treno {
    private final int ID;
    private final int MAX_C0;
    private final int MAX_C1;
    public static int nextID = 0;
    private int postiZero;
    private int postiUno;

    /**
        Costruttore Completo
        @param id Identificatore del Treno
        @param postiZero Numero di posti cat 0
        @param postiUno Numero di posti cat 1;
    */
    public Treno(int postiZero, int postiUno) {
        this.ID = ++nextID;
        this.postiZero = postiZero;
        this.MAX_C0 = postiZero;
        this.postiUno = postiUno;
        this.MAX_C1 = postiUno;
    } // Treno

    /**
        prenotaDisdici prenota o disdice nP posti;
        @param nP Numero di posti da prenotare o disdire
        @param isPov Indica se il cliente e` povero
        Se nP < 0 La richiesta e` una disdetta (possibile solo in cat 1).
        Se nP > 0 la richiesta e` una prenotazione sulla stessa cat, inizialmente la richiesta si fa in cat 1.
        Se questa fallisce e il cliente non e` povero  si tenta in cat 0.
        @return esito del tentativo
    */
    public synchronized int prenotaDisdici(int nP, boolean isPov) {
        if( nP <= postiUno && postiUno - nP <= MAX_C1) {
            postiUno -= nP;
            return 1;
        } else if(nP>0 && postiZero - nP >= 0 && !isPov) {
            postiZero -= nP;
            return 0;
        } else
            return -1;
    } // prenotaDisdici

    public int getID() {
        return ID;
    } // getID

    public String toString() {
        return "ID TRENO: " + ID + "\n Posti OCCUPATI in Cat 1: " + (MAX_C1 - postiUno) +  "\n Posti OCCUPATI in Cat 0: " + (MAX_C0 - postiZero);
    } // toString
}// Treno
