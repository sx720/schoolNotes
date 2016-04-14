/* B
Definire la classe RisorsaLUBase che gestisce la prenotazione
 di una risorsa mediante il protocollo lock/unlock "base".
Questo protocollo consente la prenotazione soltanto a un processo.
Quindi, un processo non può prenotare quando un altro processo ha prenotato,
 cioè rischia di attendere la risorsa indefinitamente.
RisorsaLUBase possiede le seguenti operazioni pubbliche:
~ Costruttore, che ha un parametro contenente il nome della risorsa.
~ Gli stessi metodi della classe RisorsaLU.
*/
public class RisorsaLUBase extends RisorsaLU {
    public RisorsaLUBase(String nomeRis) {
        super(nomeRis, 1);
    }
}
