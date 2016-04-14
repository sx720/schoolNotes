/* E
Definire la classe ProcessoLU_Test che simula l'esecuzione "quasi contemporanea"
 di alcuni processi che vogliono accedere alla stessa risorsa.
Il processo, durante la sua esecuzione, usa la risorsa un dato numero di volte
 e la occupa per una data durata di tempo.
*/
public class ProcessoLU_Test {
    public static void main(String[] args) {
        RisorsaLUBase risB = new RisorsaLUBase("prova1");

        int nProcessi = 10;
        int nReq = 3;

        ProcessoLU[] procs = new ProcessoLU[nProcessi];

        int i = 0;
        for (; i < nProcessi/2; i++) procs[i] = new ProcessoLU(i, risB, nReq, 3000);
        for (; i < nProcessi; i++) procs[i] = new ProcessoLU(i, risB, nReq, 5000);

        for (i = 0; i < nProcessi; i++) procs[i].start();
    }
}
