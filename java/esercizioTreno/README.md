Rielaborato di quanto mi ha dato taffa... Ma praticamente e' mio  
Ricordatevi di rielaborarlo...

# Thread

Definire un programma per gestire le prenotazioni sui treni.  
Ogni treno ha: un identificativo; un numero di posti liberi in classe 0; un numero di posti liberi in classe 1, che è più economica della classe 0.  
La classe Treno deve possedere il metodo:  
* `int prenotaDisdici(int nP, boolean isPov)`, che prenota o disdice nP posti; isPov indica se il cliente  
che fa la richiesta è povero.  
  
Se nP < 0, la richiesta è una disdetta; è possibile disdire soltanto i posti di classe 1.  
Se nP > 0, la richiesta è un tentativo di prenotazione di posti tutti sulla stessa classe; il tentativo si fa ini- zialmente in classe 1; se questo tentativo fallisce e se il cliente non è povero, si fa un altro tentativo in clas- se 0.  
Il metodo ritorna un valore che indica l'esito del tentativo.  
Ogni cliente ha: un identificativo; ogni altra informazione necessaria per prenotare o disdire un dato numero di posti. Ogni cliente fa un'unica richiesta (disdetta o tentativo di prenotazione), il cui esito deve essere stam- pato su video.  
  
Il programma deve simulare la seguente situazione:  
* C'è un treno, avente l'identificativo 1, con 50 posti disponibili in classe 0 e 50 in classe 1.
* Ci sono 5 clienti ricchi, aventi gli identificativi da 1 a 5, che provano a prenotare 10 posti ciascuno.
* Ci sono 3 clienti poveri, aventi gli identificativi da 6 a 8, che provano a prenotare 4 posti ciascuno.
* Ci sono 2 clienti poveri, aventi gli identificativi da 9 a 10, che provano a disdire 6 posti ciascuno.
* Le richieste suddette possono avvenire "quasi contemporaneamente".
