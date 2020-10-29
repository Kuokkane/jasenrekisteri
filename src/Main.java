import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Jasenrekisteri jasenrekisteri = new Jasenrekisteri();
        Scanner lukija = new Scanner(System.in);
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(jasenrekisteri, lukija);

        Koira koira1 = new Koira("Alli", "Karjalan karhukoira", 10);
        Koira koira2 = new Koira("Jeppe", "Itäsiperianlaika", 5);
        Jasen jasen1 = new Jasen("Matti", "Meikäläinen", 30, 2003, koira1);
        Jasen jasen2 = new Jasen("Maija", "Maijanen", 27, 2005);
        Jasen jasen3 = new Jasen("Erno", "Erämies", 30, 2012, koira2);
        Jasen jasen4 = new Jasen("Kalle", "Kuusisto", 29, 2004);

        jasenrekisteri.lisaa(jasen1);
        jasenrekisteri.lisaa(jasen2);
        jasenrekisteri.lisaa(jasen3);
        jasenrekisteri.lisaa(jasen4);
        kayttoliittyma.Kaynnista();
    }
}
