/* A
Definire la classe RisorsaLU che gestisce la prenotazione di una risorsa mediante
il protocollo lock/unlock "generico" e che possiede le seguenti operazioni pubbliche:
~ Costruttore, che ha due parametri: il nome della risorsa;
   il numero massimo di processi che possono preno-
tare la risorsa.
~ getId(), che ritorna il nome della risorsa.
~ lock e unlock descritte precedentemente,
   e che devono essere definite a seconda della politica di gestione della prenotazione.
RisorsaLU deve opportunamente memorizzare quali tra gli nProc hanno effettivamente prenotato la risorsa.
*/

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class RisorsaLU {
    private String nomeRis;
    private int nProc = 0;
    private int[] nomiProcessi;
    private final int maxProc;

    public final Lock l = new ReentrantLock();
    public final Condition queueNotFull = l.newCondition();
    // private final Condition queueNotEmpty = l.newCondition();

    public RisorsaLU(String nomeRis, int nProc) {
        this.nomeRis = nomeRis;
        this.maxProc = nProc;
        nomiProcessi = new int[nProc];
        for (int i = 0; i < nProc; i++) nomiProcessi[i] = -1;
    }

    public String getId() {
        return nomeRis;
    }

    public void lock(int iProc) throws InterruptedException {
        try {
            while (nProc == maxProc) {
                System.out.println(iProc + " sta aspettando il lock..");
                queueNotFull.await();
            }
        } finally {
            incrementNProc();
            l.lock();
            System.out.println(iProc + " ha finalmente la risorsa");
            for (int i : nomiProcessi) {
                if (i == -1) {
                    i = iProc;
                    break;
                }
            }
        }
    }

    public void unlock(int iProc) {
        l.unlock();
        for (int i = 0; i < maxProc; i++) {
            if (nomiProcessi[i] == iProc) {
                nomiProcessi[i] = -1;
                break;
            }
        }
        decrementNProc();
        queueNotFull.notifyAll();
        System.out.println(iProc + " ha lasciato la risorsa");
    }

    private synchronized void incrementNProc(){
        nProc++;
    }

    private synchronized void decrementNProc(){
        nProc--;
    }
}
