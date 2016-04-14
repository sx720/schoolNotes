Attenzione ancora non funziona...

```
Exception in thread "Thread-<n>" java.lang.IllegalMonitorStateException  
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.signalAll(AbstractQueuedSynchronizer.java:1954)  
	at RisorsaLU.unlock(RisorsaLU.java:66)  
	at ProcessoLU.run(ProcessoLU.java:36)  
```
  
`<n>` e' il  modo in cui esprimo il numero di thread, lo fa java, ma io lo metto cosi' per generalizzare a tutti i thread.

 --- 
Creato con pazienza da Marco Marchesin

# Testo originale

Definire un insieme di classi per gestire le prenotazioni di una risorsa critica ris mediante alcuni protocolli basati sul principio lock /unlock; quindi, un processo iProc deve invocare:
* il metodo ris.lock(int iProc) prima di usare ris;
* il metodo unlock(iProc) dopo avere usato ris.
  
A. Definire la classe RisorsaLU che gestisce la prenotazione di una risorsa mediante il protocollo lock/unlock "generico" e che possiede le seguenti operazioni pubbliche:
* Costruttore, che ha due parametri: il nome della risorsa; il numero massimo di processi che possono preno-
tare la risorsa.
* getId(), che ritorna il nome della risorsa.
* lock e unlock descritte precedentemente, e che devono essere definite a seconda della politica di gestione
della prenotazione.
RisorsaLU deve opportunamente memorizzare quali tra gli nProc hanno effettivamente prenotato la risorsa.
  
B. Definire la classe RisorsaLUBase che gestisce la prenotazione di una risorsa mediante il protocollo lock/unlock "base". Questo protocollo consente la prenotazione soltanto a un processo. Quindi, un processo non può prenotare quando un altro processo ha prenotato, cioè rischia di attendere la risorsa indefinitamente. RisorsaLUBase possiede le seguenti operazioni pubbliche:
* Costruttore, che ha un parametro contenente il nome della risorsa.
* Gli stessi metodi della classe RisorsaLU.
  
C. Definire la classe RisorsaLUPeterson2 che gestisce la prenotazione di una risorsa mediante il protocollo lock/unlock "Peterson su due processi". Questo protocollo:
* consente al massimo a due processi di prenotare la risorsa $this;
* gestisce una politica di precedenza a rotazione tra i due processi che hanno prenotato $this.
Quindi, nessun processo attende indefinitamente. RisorsaLUPeterson2 possiede le seguenti operazioni pubbliche:
* Costruttore, che ha un parametro: il nome della risorsa.
* Gli stessi metodi della classe RisorsaLU.

D. Definire la classe ProcessoLU che simula un processo che vuole accedere a una risorsa che è gestita mediante uno qualsiasi dei protocolli lock/unlock descritti precedentemente.
Il processo, durante la sua esecuzione, usa la risorsa un dato numero di volte e la occupa per una data durata di tempo.
ProcessoLU possiede il seguente costruttore, che ha quattro parametri:
* l’indice del processo; ogni processo è individuato mediante un intero; quando una risorsa gestisce un processo, lo identifica mediante questo intero;
* la risorsa che il processo vuole usare;
* il numero di usi richiesti da $this sulla risorsa;
* il tempo occupato da $this durante ogni uso della risorsa.

E. Definire la classe ProcessoLU_Test che simula l'esecuzione "quasi contemporanea" di alcuni processi che vogliono accedere alla stessa risorsa. Il processo, durante la sua esecuzione, usa la risorsa un dato numero di volte e la occupa per una data durata di tempo.

