import java.util.Scanner;

public class Kayttoliittyma {
    private Jasenrekisteri jasenrekisteri;
    private Scanner lukija;


    public Kayttoliittyma(Jasenrekisteri jasenrekisteri, Scanner lukija) {
        this.jasenrekisteri = jasenrekisteri;
        this.lukija = lukija;
    }

    public void Kaynnista() {
        while (true) {
            paaValikko();
            int komento = Integer.valueOf(lukija.nextLine());
            paavalikkoInput(komento);
        }
    }

    public void paaValikko() {
        System.out.println("<<<Kittilän metsästysseura>>>");
        System.out.println("1. jäsenvalikko");
    }


    public void jasenValikko() {
        while (true) {
            System.out.println("Valitse tehtävä:");
            System.out.println("0 - palaa");
            System.out.println("1 - näytä jäsenet");
            System.out.println("2 - näytä koiralliset jäsenet");
            System.out.println("3 - uusi jäsen");
            System.out.println("4 - poista jäsen");

            int komento = Integer.valueOf(lukija.nextLine());

            if (komento == 0) {
                break;
            } else if (komento == 1) {
                listaaValikko();

            } else if (komento == 2) {
                jasenrekisteri.naytaKoiralliset();

            }
            else if (komento == 3) {
                System.out.println("Syötä etunimi:");
                String etunimi = lukija.nextLine();
                System.out.println("Syötä sukunimi:");
                String sukunimi = lukija.nextLine();
                System.out.println("Syötä ikä:");
                int ika = Integer.valueOf(lukija.nextLine());
                System.out.println("Syötä liittymisvuosi:");
                int liittynyt = Integer.valueOf(lukija.nextLine());
                System.out.println("Omistaako koiran? (k/e)");
                String vastaus = lukija.nextLine();


                if (vastaus.equals("e")) {
                    Jasen jasen = new Jasen(etunimi, sukunimi, ika, liittynyt);
                    jasenrekisteri.lisaa(jasen);
                } else if (vastaus.equals("k")) {
                    System.out.println("Syötä koiran nimi:");
                    String koirannimi = lukija.nextLine();
                    System.out.println("Syötä koiran rotu");
                    String koiranrotu = lukija.nextLine();
                    System.out.println("Syötä koiran ikä:");
                    int koiranika = Integer.valueOf(lukija.nextLine());

                    Koira koira = new Koira(koirannimi, koiranrotu, koiranika);
                    Jasen jasen = new Jasen(etunimi, sukunimi, ika, liittynyt, koira);

                    jasenrekisteri.lisaa(jasen);
                }

            } else if (komento == 4) {
                System.out.println("Valitse poistettava henkilö");
                jasenrekisteri.listaa();
                int poistettava = Integer.valueOf(lukija.nextLine());
                jasenrekisteri.poista(poistettava);
            }

        }
    }

    public void listaaValikko() {
        System.out.println("Paina numeroa nähdäksesi lisätietoja");
        System.out.println("0. takaisin");
        jasenrekisteri.listaa();

        int komento = Integer.valueOf(lukija.nextLine());
        jasenrekisteri.haeTiedot(komento);
    }

    public void paavalikkoInput(int komento) {
        if (komento == 1) {
            jasenValikko();
        } else {
            System.out.println("Virheellinen valinta");
        }
    }
}