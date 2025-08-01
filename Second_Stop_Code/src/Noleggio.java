import java.time.LocalDate;
import java.util.ArrayList;

public class Noleggio {
    private Clienti client;
    private Veicolo veicolo;
    private LocalDate dataInizioNoleggio;
    private LocalDate dataFineNoleggio;
    private int giorniNoleggio;
    private double prezzoTotale;


    public Noleggio(Clienti client, Veicolo veicolo, LocalDate dataInizioNoleggio, LocalDate dataFineNoleggio, int giorniNoleggio, double prezzoTotale) {
        this.client = client;
        this.veicolo = veicolo;
        this.dataInizioNoleggio = dataInizioNoleggio;
        this.dataFineNoleggio = dataFineNoleggio;
        this.giorniNoleggio = giorniNoleggio;
        this.prezzoTotale = prezzoTotale;
    }



    @Override
    public String toString() {
        return "Noleggio" + "\n" +
                "cliente: " + client + "\n" +
                "veicolo: " + veicolo + "\n" +
                "dataInizio: " + dataInizioNoleggio + "\n" +
                "dataFine: " + dataFineNoleggio + "\n" +
                "giorniNoleggio: " + giorniNoleggio + "\n" +
                "prezzo: " + prezzoTotale + " € " + "\n"
                ;
    }

}
