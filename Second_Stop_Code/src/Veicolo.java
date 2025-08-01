public class Veicolo {
    private int annoImmatricolazione;
    private Marchi marchio;
    private String modello;
    private String targa;
    private String tipoAlimentazione;
    private  int cilindrata;
    private double prezzo;

    public Veicolo(int annoImmatricolazione, Marchi marchio, String modello, String targa, String tipoAlimentazione, int cilindrata, double prezzo) {
        this.annoImmatricolazione = annoImmatricolazione;
        this.marchio = marchio;
        this.modello = modello;
        this.targa = targa;
        this.tipoAlimentazione = tipoAlimentazione;
        this.cilindrata = cilindrata;
        this.prezzo = prezzo;
    }

    public int getAnnoImmatricolazione() {
        return annoImmatricolazione;
    }

    public void setAnnoImmatricolazione(int annoImmatricolazione) {
        this.annoImmatricolazione = annoImmatricolazione;
    }

    public Marchi getMarchio() {
        return marchio;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public void setMarca(String marca) {
        this.marchio = marchio;
    }

    public String getTipoAlimentazione() {
        return tipoAlimentazione;
    }

    public void setTipoAlimentazione(String tipoAlimentazione) {
        this.tipoAlimentazione = tipoAlimentazione;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    public double getPrezzo() {return prezzo; }

    public void setPrezzo(double prezzo) { this.prezzo = prezzo;}

    @Override
    public String toString() {
        return "Veicolo" + "\n" +
                "annoImmatricolazione = " + annoImmatricolazione + '\n' +
                "marca = " + marchio + '\n' +
                "modello = " + modello + '\n' +
                "targa = " + targa + '\n' +
                "tipoAlimentazione = '" + tipoAlimentazione + '\n' +
                "cilindrata = " + cilindrata + '\n' +
                "prezzo = " + prezzo + '\n'
                ;
    }
}
