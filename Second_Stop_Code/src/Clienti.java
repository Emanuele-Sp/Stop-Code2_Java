import java.util.ArrayList;
import java.util.Scanner;

public class Clienti {
    private String nome;
    private String cognome;
    private String numeroPatente;
    private boolean attivo;

    public Clienti(String nome, String cognome, String numeroPatente, boolean attivo) {
        this.nome = nome;
        this.cognome = cognome;
        this.numeroPatente = numeroPatente;
        this.attivo = attivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNumeroPatente() {
        return numeroPatente;
    }

    public void setNumeroPatente(String numeroPatente) {
        this.numeroPatente = numeroPatente;
    }

    public boolean isAttivo() {
        return attivo;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }

    public static Clienti InputCliente() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        if (!nome.isEmpty()) {
            nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
        }

        System.out.print("Cognome: ");
        String cognome = scanner.nextLine();
        if (!cognome.isEmpty()) {
            cognome = cognome.substring(0, 1).toUpperCase() + cognome.substring(1).toLowerCase();
        }

        System.out.print("Numero Patente: ");
        String numeroPatente = scanner.nextLine();
        if (!numeroPatente.isEmpty()) {
            numeroPatente = numeroPatente.toUpperCase();
        }

        System.out.print("Stato: ");
        boolean attivo = false;

        return new Clienti(nome, cognome, numeroPatente, attivo);
    }

    @Override
    public String toString() {
        return "nome = " + nome + '\n' +
                "cognome = " + cognome + '\n' +
                "numeroPatente = " + numeroPatente + "\n" +
                "attivo = " + attivo + "\n";
    }
}
