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
        System.out.println("2. kaadot");
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

            } else if (komento == 3) {
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
                    Jasen jasen = new Jasen(etunimi, sukunimi, ika, liittynyt);

                    jasenrekisteri.lisaa(jasen);
                    jasenrekisteri.lisaaJasenelleKoira(koira);
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
        while (true) {
            System.out.println("Paina numeroa nähdäksesi lisätietoja");
            System.out.println("0. takaisin");
            jasenrekisteri.listaa();

            int komento = Integer.valueOf(lukija.nextLine());
            if (komento == 0) {
                break;
            }
            int etsittava = komento;
            henkiloValikko(etsittava, komento);
        }
    }

    public void henkiloValikko(int etsittava, int komento) {
        while (true) {
            System.out.println("Mitkä tiedot näytetään?");
            System.out.println("0. Palaa");
            System.out.println("1. Henkilötiedot");
            System.out.println("2. Kaadot");
            int henkiloValikkoKomento = Integer.valueOf(lukija.nextLine());

            if (henkiloValikkoKomento == 0) {
                break;
            }
            henkiloValikkoInput(etsittava, henkiloValikkoKomento);
        }
    }

    public void henkiloValikkoInput(int etsittava, int komento) {
        if (komento == 1) {
            jasenrekisteri.haeTiedot(etsittava);
        } else if ( komento == 2) {
            jasenrekisteri.listaaKaadot(etsittava);
        }
    }

    public void paavalikkoInput(int komento) {


        if (komento == 1) {
            jasenValikko();
        } else if (komento == 2) {
            kaatoValikko();
        } else {
            System.out.println("Virheellinen valinta");
        }
    }

    public void kaatoValikko() {
        while (true) {
            System.out.println("Valitse tehtävä:");
            System.out.println("0 - palaa");
            System.out.println("1 - uusi kaato");

            int komento = Integer.valueOf(lukija.nextLine());

            if (komento == 0) {
                break;
            } else if (komento == 1) {
                kaatoListaaValikko();
            } else {
                System.out.println("Virheellinen komento");
            }
        }
    }

    public void kaatoListaaValikko() {
        System.out.println("Kelle lisätään kaato?");
        jasenrekisteri.listaa();
        int komento = Integer.valueOf(lukija.nextLine());
        System.out.println("Kaadettu saaliseläin:");
        String saalis = lukija.nextLine();
        System.out.println("montako kappaletta?");
        int kappalemaara = Integer.valueOf(lukija.nextLine());

        jasenrekisteri.lisaaKaato(komento, saalis, kappalemaara);
    }
}