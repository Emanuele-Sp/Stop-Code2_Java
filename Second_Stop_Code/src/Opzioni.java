public class Opzioni {

    private String[] option = {"Registra Automobile", "Registra Furgone",
            "Registra Motocicletta", "Registra cliente", "Registra Noleggio",
            "Lista Veicoli", "Lista clienti", "Lista Noleggi", "Esci"};


    public void stampaOpzioni() {
        String retValue = "";
        for (int i = 0; i < option.length; i++) {
            if (i + 1 == option.length) {
                retValue += ((0) + " - " + option[i] + "\n");
            } else {
                retValue += ((i + 1) + " - " + option[i] + "\n");
            }


        }
        System.out.println(retValue);
    }


}
