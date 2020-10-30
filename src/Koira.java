public class Koira {
    private String nimi;
    private String rotu;
    private int ika;


    public Koira(String nimi, String rotu, int ika) {
        this.nimi = nimi;
        this.rotu = rotu;
        this.ika = ika;
    }

    @Override
    public String toString() {
        return nimi + " - " + ika + "-vuotias " + rotu;
    }
}
