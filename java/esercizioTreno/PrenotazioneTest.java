public class PrenotazioneTest {
    public static void main(String[] args) {
        Cliente clienti[] = new Cliente[100];
        Treno t1  = new Treno(50, 50);

        int i = 0;
        // Istanzio 5 clienti ricchi che prenotano 10 posti ciascuno
        for(; i<5; i++) clienti[i] = new Cliente(10, false,t1);
        // Istanzio 9 clienti poveri che prenotano 4 posti ciascuno
        for(; i<9; i++) clienti[i] = new Cliente(4, true,t1);
        // Istanzio 10 clienti poveri che prenotano -6 posti ciascuno
        for(; i<10; i++) clienti[i] = new Cliente(-6, true,t1);


        for (int j = 0; j < i; j++) clienti[j].start();

        try {
            Thread.sleep(2000);
        } catch(InterruptedException ex) {
            System.out.println(ex);
        }

        System.out.println(t1);
    } // main
}
