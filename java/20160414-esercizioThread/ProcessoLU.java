/* D
Definire la classe ProcessoLU che simula un processo che vuole accedere
 a una risorsa che è gestita mediante uno qualsiasi
 dei protocolli lock/unlock descritti precedentemente.
Il processo, durante la sua esecuzione, usa la risorsa un dato numero di volte
 e la occupa per una data durata di tempo.
ProcessoLU possiede il seguente costruttore, che ha quattro parametri:
~ l’indice del processo; ogni processo è individuato mediante un intero;
   quando una risorsa gestisce un processo, lo identifica mediante questo intero;
~ la risorsa che il processo vuole usare;
~ il numero di usi richiesti da $this sulla risorsa;
~ il tempo occupato da $this durante ogni uso della risorsa.
*/

public class ProcessoLU extends Thread {
    private final int idProcesso;
    private int numReq;
    private int timeReq;
    private RisorsaLU ris;

    public ProcessoLU(int id, RisorsaLU ris, int numReq, int timeReq) {
        this.idProcesso = id;
        this.ris = ris;
        this.numReq = numReq;
        this.timeReq = timeReq;
    }

    public void run() {
        for (int i = 0; i < numReq; i++) {
            try {
                ris.lock(idProcesso);
                Thread.sleep(timeReq);
            } catch (InterruptedException e) {
                System.out.println(e);
            } finally {
                ris.unlock(idProcesso);
            }
        }
    }
}
