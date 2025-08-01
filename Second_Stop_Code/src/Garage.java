import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.util.ArrayList;
import java.util.Scanner;

public class Garage {

    private static final int NUM_POSTI = 15;
    private Veicolo[] veicoli;
    private ArrayList<Clienti> listaClienti = new ArrayList<>();
    private ArrayList<Noleggio> listaNoleggi = new ArrayList<>();
    private Marchi marchio;


    public Garage() {
        veicoli = new Veicolo[NUM_POSTI];
    }

    // inserire veicoli nel garage

    public void inserisciVeicolo(Veicolo veicolo) {
        for (int i = 0; i < veicoli.length; i++) {
            if (veicoli[i] == null) {
                veicoli[i] = veicolo;
                return;
            }
        }

        System.out.println("Nessun posto disponibile, mi dispiace...");
    }

    // estrarre il veicolo dal garage tramite il posto (intero che rappresenta indice array +1)
    public Veicolo estraiVeicolo(int posto) {
        if (posto < 1 || posto >= NUM_POSTI) {
            return null;
        }

        Veicolo veicoloDaEstrarre = veicoli[posto - 1];
        veicoli[posto - 1] = null;
        return veicoloDaEstrarre;
    }

    public void stampa() {
        String retValue = "";
        for (int i = 0; i < veicoli.length; i++) {
            retValue += "Posto n°: " + (i + 1);
            if (veicoli[i] == null) retValue += " - vuoto";
            else retValue += " " + veicoli[i].getClass().getSimpleName() + " " + veicoli[i].getMarchio();
            retValue += "\n";
        }
        System.out.println(retValue);
    }

    public void inserisciCliente(Clienti cliente) {
        listaClienti.add(cliente);
    }

    public void inserisciNoleggio(Noleggio noleggio) {
        listaNoleggi.add(noleggio);
    };

    public void stampaNoleggi(){
        for (int i = 0; i < listaNoleggi.size(); i++) {
            System.out.println(i + " - " + listaNoleggi.get(i));
        }
    }

    public void stampaClienti() {
        for (int i = 0; i < listaClienti.size(); i++) {
            System.out.println(i + " - " + listaClienti.get(i));
        }
    }

    public Clienti selectCliente() {
        Scanner scanner = new Scanner(System.in);
        int indice = scanner.nextInt();
        if (indice < listaClienti.size()) {
            Clienti clienteScelto = listaClienti.get(indice);
            if (!clienteScelto.isAttivo()){
                clienteScelto.setAttivo(true);
                System.out.println(clienteScelto);
                return clienteScelto;
            }
            else{
                System.out.println("Il cliente ha gia noleggiato un veicolo: ");
                return selectCliente();
            }

        } else {
            System.out.println("Inserisci un valore corrispondente a un cliente: ");
            selectCliente();
            return selectCliente();
        }
    }

    public Veicolo selectVeicolo() {
        Scanner scanner = new Scanner(System.in);
        int indice = scanner.nextInt();
        if (indice == 0) {
            return selectVeicolo();
        }
        else if (indice <= veicoli.length) {
            Veicolo veicoloScelto = veicoli[indice - 1];
            System.out.println(veicoloScelto);
            if (veicoloScelto != null){
                estraiVeicolo(indice);
                estraiVeicolo(indice);
                return veicoloScelto;
            }
            else {
                System.out.println("Il parcheggio è vuoto. Devi scegliere un altro veicolo: ");
                return selectVeicolo();
            }

        } else {
            System.out.println("Inserisci un valore corrispondente a un cliente: ");
            return selectVeicolo();        }
    }

    public LocalDate dataInizioNoleggio() {
        System.out.println("Inserisci la data di inizio noleggio nel formato yyyy-MM-dd");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            try {
                Scanner scanner1 = new Scanner(System.in);
                String dataInizio = scanner1.nextLine();

                LocalDate inizio = LocalDate.parse(dataInizio, formatter);
                if (inizio.isBefore(LocalDate.now())) {
                    System.out.println("Hai inserito una data passata, inserisci una data corretta ad esempio domani: " + LocalDate.now().plusDays(1));
                    continue;
                }
                return inizio;
            } catch (DateTimeParseException e) {
                System.out.println("Formato data non valido. Riprova nel seguente formato: yyyy-MM-dd");
            }
        }
    }

    public LocalDate dataFineNoleggio() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            try {
                System.out.println("Inserisci la data di fine noleggio nel formato yyyy-MM-dd");
                Scanner scanner2 = new Scanner(System.in);
                String dataFine = scanner2.nextLine();
                LocalDate fine = LocalDate.parse(dataFine, formatter);
                return fine;
            } catch (DateTimeParseException e) {
                System.out.println("Formato data non valido. Inserisci la fine nel seguente formato: yyyy-MM-dd");
            }
        }
    }


}
