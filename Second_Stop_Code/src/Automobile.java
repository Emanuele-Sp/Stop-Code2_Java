import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Automobile extends Veicolo {
    private int numPorte;

    public Automobile(int annoImmatricolazione, Marchi marchio, String modello, String targa, String tipoAlimentazione, int cilindrata, int numPorte, double prezzo) {
        super(annoImmatricolazione, marchio, modello, targa, tipoAlimentazione, cilindrata, prezzo);
        this.numPorte = numPorte;
    }

    public int getNumPorte() {
        return numPorte;
    }

    public void setNumPorte(int numPorte) {
        this.numPorte = numPorte;
    }


    public static Automobile InputAuto() {

        Scanner scanner = new Scanner(System.in);

        int anno = 0;
        int annoCorrente = LocalDate.now().getYear();
        int annoMinimo = annoCorrente - 100;

        while (true) {
            System.out.print("Anno di immatricolazione: ");
            String annoStr = scanner.nextLine().trim();

            if (annoStr.isEmpty()) {
                System.out.println("Il campo anno di immatricolazione non può essere vuoto.");
                continue;
            }

            if (!annoStr.matches("\\d+")) {
                System.out.println("Devi inserire solo numeri interi positivi.");
                continue;
            }

            anno = Integer.parseInt(annoStr);

            if (anno > annoCorrente) {
                System.out.println("Impossibile inserire un anno superiore a quello corrente!");
                continue;
            } else if (anno < annoMinimo) {
                System.out.println("Hai inserito un anno troppo vecchio (più di 100 anni fa).");
                continue;
            }

            break; // tutto ok
        }


        Marchi marchio;
        do {
            System.out.print("Marchio: ");
            String marca = scanner.nextLine().toUpperCase();
            try {
                marchio = Marchi.valueOf(marca);

            } catch (IllegalArgumentException e) {
                System.out.println("Marca non valida. Valori ammessi: " + Arrays.toString(Marchi.values()));
                marchio = null;

            }
        } while (marchio == null);


        System.out.print("Modello: ");
        String modello = scanner.nextLine();
        if (!modello.isEmpty()) {

            if (modello.matches("[a-zA-Z]+")) {
                modello = modello.substring(0, 1).toUpperCase() + modello.substring(1).toLowerCase();
            } else {
                System.out.println("Devi inserire solo lettere");
                modello = scanner.nextLine();
            }
        } else {
            System.out.println("L'array non può essere vuoto");
            modello = scanner.nextLine();
        }

        String targa;
        boolean bool = true;
        do {
            System.out.print("Targa: ");
            targa = scanner.nextLine();
            if (!targa.isEmpty()) {

                char[] targaArray = targa.toCharArray();
                if (targaArray.length != 7) {
                    System.out.println("La targa deve essere nel formato AB123CD: ");
                } else {

                    if (Character.isLetter(targaArray[0]) && Character.isLetter(targaArray[1])
                            && Character.isDigit(targaArray[2]) && Character.isDigit(targaArray[3])
                            && Character.isDigit(targaArray[4]) && Character.isLetter(targaArray[5])
                            && Character.isLetter(targaArray[6])) {
                        bool = false;
                        targa = new String(targaArray).toUpperCase();
                    } else {
                        System.out.println("La targa deve essere nel formato AB123CD: ");
                    }
                }
            } else {
                System.out.println("Il campo targa non può essere vuoto");
            }
        } while (bool);


        System.out.print("Alimentazione (es. Benzina, Elettrica): ");
        String alimentazione = scanner.nextLine();
        if (!alimentazione.isEmpty()) {
            if (alimentazione.matches("[a-zA-Z]+")) {
                alimentazione = alimentazione.substring(0, 1).toUpperCase() + alimentazione.substring(1).toLowerCase();
            } else {
                System.out.println("Devi inserire solo lettere");
                alimentazione = scanner.nextLine();
            }
        } else {
            System.out.println("L'array non può essere vuoto");
            alimentazione = scanner.nextLine();
        }


        int cilindrata = 0;

        while (true) {
            System.out.print("Cilindrata (in cc): ");
            String cilindrataStr = scanner.nextLine().trim();

            if (cilindrataStr.isEmpty()) {
                System.out.println("Il campo cilindrata non può essere vuoto.");
                continue;
            }

            if (!cilindrataStr.matches("\\d+")) {
                System.out.println("Devi inserire solo numeri interi positivi.");
                continue;
            }
            cilindrata = Integer.parseInt(cilindrataStr);
            break;
        }


        int posti = 0;
        while (true) {
            System.out.print("Numero di posti: ");
            String input = scanner.nextLine().trim();

            if (input.matches("\\d+")) {
                posti = Integer.parseInt(input);
                break;
            } else {
                System.out.println("Inserisci solo numeri interi positivi.");
            }
        }


        double prezzo = 0.0;
        while (true) {
            System.out.print("Prezzo giornaliero: ");
            String input = scanner.nextLine().trim();

            if (input.matches("\\d+(\\.\\d+)?")) {
                prezzo = Double.parseDouble(input);
                break;
            } else {
                System.out.println("Inserisci un numero valido (es. 25.50). Usa il punto come separatore decimale.");
            }
        }


        return new Automobile(anno, marchio, modello, targa, alimentazione, cilindrata, posti, prezzo);
    }


    @Override
    public String toString() {
        return super.toString() + " - Automobile" + "\n" +
                "numPorte = " + numPorte
                ;
    }
}
