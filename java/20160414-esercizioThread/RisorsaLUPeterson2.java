/* C
Definire la classe RisorsaLUPeterson2 che gestisce la prenotazione
 di una risorsa mediante il protocollo lock/unlock "Peterson su due processi".
Questo protocollo:
~ consente al massimo a due processi di prenotare la risorsa $this;
~ gestisce una politica di precedenza a rotazione tra i due processi che hanno prenotato $this.
Quindi, nessun processo attende indefinitamente. RisorsaLUPeterson2 possiede le seguenti operazioni pubbliche:
~ Costruttore, che ha un parametro: il nome della risorsa.
~ Gli stessi metodi della classe RisorsaLU.
*/

public class RisorsaLUPeterson2 extends RisorsaLU {
    public RisorsaLUPeterson2(String nomRis, int nProc) {
        super(nomRis, nProc > 2 ? 2 : nProc);
    }
}
