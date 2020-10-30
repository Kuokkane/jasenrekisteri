import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Jasen {
    private String etunimi;
    private String sukunimi;
    private int ika;
    private int liittynyt;
    private ArrayList<Koira> koirat;
    private HashMap<String, Integer> saaliit;

    public Jasen(String etunimi, String sukunimi, int ika, int liittynyt) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.ika = ika;
        this.liittynyt = liittynyt;
        this.koirat = new ArrayList<>();
        this.saaliit = new HashMap();
    }

    public boolean onkoKoiria() {
        if (!koirat.isEmpty()) {
            return true;
        }
        return false;
    }

    public void lisaaKoira(Koira koira) {
        koirat.add(koira);
    }

    public void lisaaKaato(String saalis, int kappalemaara) {


        saaliit.put(saalis, kappalemaara);


    }

    public void listaaKaadot() {
        if (saaliit.isEmpty()) {
            System.out.println("Ei kaatoja");
        }

        for (Map.Entry<String, Integer> entry : saaliit.entrySet()) {
            String saalis = entry.getKey();
            int lukumaara = entry.getValue();

            if (lukumaara == 1) {
                System.out.println(saalis + ", " + lukumaara + " kappale");
            } else if (lukumaara > 1) {
                System.out.println(saalis + ", " + lukumaara + " kappaletta");
            }
        }
    }


    public String getEtunimi() {

        return etunimi;
    }

    public String getSukunimi() {

        return sukunimi;
    }


    @Override
    public String toString() {

        if (koirat.isEmpty()) {
            return "Nimi: " + etunimi + " " + sukunimi + "\n" +
                    "Ikä: " + ika + "\n" +
                    "Koira: ei omista." + "\n" +
                    "Liittynyt seuraan vuonna " + liittynyt + "." + "\n";
        }
        String kaikkikoirat = "";

        for (Koira k : koirat) {
            kaikkikoirat += k.toString() + "\n";
        }
        return "Nimi: " + etunimi + " " + sukunimi + "\n" +
                "Ikä: " + ika + "\n" +
                "Koirat: " + "\n" + kaikkikoirat +
                "Liittynyt seuraan vuonna " + liittynyt + "." + "\n";

    }
}
