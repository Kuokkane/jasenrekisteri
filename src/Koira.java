public class Koira {
    private String nimi;
    private String rotu;
    private int ika;


    public Koira(String nimi, String rotu, int ika) {
        this.nimi = nimi;
        this.rotu = rotu;
        this.ika = ika;
    }

    public String getNimi() {
        return nimi;
    }

    public String getRotu() {
        return rotu;
    }

    public int getIka() {
        return ika;
    }

    @Override
    public String toString() {
        return nimi + " - " + ika + "-vuotias " + rotu;
    }
}
