import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestioneGarage {
    public static void main(String[] args) {

        ArrayList<String> listaNoleggi = new ArrayList<>();

        Opzioni listaOpzioni = new Opzioni();
        Garage garage = new Garage();


        Automobile automobile = new Automobile(
                1999,
                Marchi.FIAT,
                "Panda",
                "AA123BB",
                "Benzina",
                1000,
                5,
                100.0
        );

        String[] dim = {"300", "200", "100"};
        Furgone furgone = new Furgone(
                2005,
                Marchi.FIAT,
                "Iveco",
                "CC987BB",
                "Diesel",
                1300,
                6,
                150.0,
                dim
        );

        Motocicletta moto = new Motocicletta(
                2012,
                Marchi.KAWASAKI,
                "Ninja",
                "KW456NJ",
                "Elettrica",
                600,
                4,
                50.0
        );

        Clienti c0 = new Clienti(
                "Emanuele",
                "Spataro",
                "AB123456CD",
                false
        );

        Clienti c1 = new Clienti(
                "Mario",
                "Rossi",
                "AD987654VB",
                false
        );

        garage.inserisciCliente(c0);
        garage.inserisciCliente(c1);

        garage.inserisciVeicolo(automobile);
        garage.inserisciVeicolo(furgone);
        garage.inserisciVeicolo(moto);

//        garage.estraiVeicolo(1);
//        garage.inserisciVeicolo(automobile);

        garage.stampa();
        listaOpzioni.stampaOpzioni();

        boolean bool = true;

        System.out.println("Scegli l'opzione desiderata:");
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                int scelta = scanner.nextInt();

                switch (scelta) {
                    case 1:
                        Automobile nuovaAuto = Automobile.InputAuto();
                        garage.inserisciVeicolo(nuovaAuto);
                        System.out.println("Scegli un altra opzione o premi 0 per uscire: ");
                        break;
                    case 2:
                        Furgone nuovoFurgone = Furgone.InputFurgone();
                        garage.inserisciVeicolo(nuovoFurgone);
                        System.out.println("Scegli un altra opzione o premi 0 per uscire: ");
                        break;
                    case 3:
                        Motocicletta nuovaMoto = Motocicletta.InputMoto();
                        garage.inserisciVeicolo(nuovaMoto);
                        System.out.println("Scegli un altra opzione o premi 0 per uscire: ");
                        break;
                    case 4:
                        Clienti nuovoCliente = Clienti.InputCliente();
                        garage.inserisciCliente(nuovoCliente);
                        garage.stampaClienti();
                        System.out.println("Scegli un altra opzione o premi 0 per uscire: ");
                        break;
                    case 5:

                        boolean valBool = true;
                        garage.stampaClienti();
                        Clienti cliente = garage.selectCliente();
                        garage.stampa();
                        Veicolo veicolo = garage.selectVeicolo();

                        LocalDate inizio = garage.dataInizioNoleggio();
                        LocalDate fine = null;
                        long giorniNoleggio = 0;

                        while (valBool) {
                            fine = garage.dataFineNoleggio();
                            if (inizio.isBefore(fine)) {
                                giorniNoleggio = ChronoUnit.DAYS.between(inizio, fine) + 1;
                                System.out.println(giorniNoleggio + " giorni");
                                System.out.println(fine);
                                valBool = false;
                            } else {
                                System.out.println("Hai inserito un giorno non valido. " +
                                        "Riprova inserendo una data maggiore a quella d'inizio noleggio es: "
                                        + inizio.plusDays(1));
                            }
                        }

                        int giorni = (int) giorniNoleggio;
                        Noleggio n1 = new Noleggio(cliente,
                                veicolo,
                                inizio,
                                fine,
                                giorni,
                                giorni * veicolo.getPrezzo()
                        );

                        garage.inserisciNoleggio(n1);
                        garage.stampaNoleggi();

                        System.out.println("Scegli un altra opzione o premi 0 per uscire: ");
                        break;
                    case 6:
                        garage.stampa();
                        System.out.println("Scegli un altra opzione o premi 0 per uscire: ");
                        break;
                    case 7:

//                        String dimes = "300,200,100";
//                        String[] lines = dimes.split(",");
//                        String lines2 = Arrays.toString(lines);
//
//                        System.out.println(lines2);
//
//                        double[] dimensioni = new double[lines];
//                        String dimensioni2 = Arrays.toString(dimensioni);
//                        System.out.println(dimensioni2);

//                        garage.stampaClienti();
//                        System.out.println("Scegli un altra opzione o premi 0 per uscire: ");
                        break;
                    case 8:
                        garage.stampaNoleggi();
                        System.out.println("Scegli un altra opzione o premi 0 per uscire: ");
                        break;
                    case 0:
                        System.out.println("ARRIVEDERCI!!!");
                        bool = false;
                        break;
                    default:
                        System.out.println("NON VALIDO. SCEGLI UN VALORE DA 0 A 7");
                }
            } catch (InputMismatchException e) {
                System.out.println("Devi scegliere un numero da 0 a 7");

            }
        } while (bool);
    }


}

