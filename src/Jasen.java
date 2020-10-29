import java.util.HashMap;

public class Jasen {
    private String etunimi;
    private String sukunimi;
    private int ika;
    private int liittynyt;
    private Koira koira;
    // private HashMap<Saalis> saaliit;

    public Jasen(String etunimi, String sukunimi, int ika, int liittynyt) {
        this(etunimi, sukunimi, ika, liittynyt, null);
    }

    public Jasen(String etunimi, String sukunimi, int ika, int liittynyt, Koira koira) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.ika = ika;
        this.liittynyt = liittynyt;
        this.koira = koira;
        // this.saaliit = new HashMap();
    }


    public String getEtunimi() {

        return etunimi;
    }

    public String getSukunimi() {

        return sukunimi;
    }

    public int getIka() {

        return ika;
    }

    public int getLiittynyt() {

        return liittynyt;
    }

    public Koira getKoira() {

        return koira;
    }

    @Override
    public String toString() {

        if (koira == null) {
            return "Nimi: " + etunimi + " " + sukunimi + "\n" +
                    "Ikä: " + ika + "\n" +
                    "Koira: ei omista." + "\n" +
                    "Liittynyt seuraan vuonna " + liittynyt + "." + "\n";
        }
        return "Nimi: " + etunimi + " " + sukunimi + "\n" +
                "Ikä: " + ika + "\n" +
                "Koira: " + koira.toString() + "\n" +
                "Liittynyt seuraan vuonna " + liittynyt + "." + "\n";

    }
}
