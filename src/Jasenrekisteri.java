import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Jasenrekisteri {
    private ArrayList<Jasen> jasenet;


    public Jasenrekisteri() {
        this.jasenet = new ArrayList<>();
    }

    public void lisaa(Jasen jasen) {
        jasenet.add(jasen);
    }

    public void poista(int poistettava) {
        for (int i = 0; i < jasenet.size(); i++) {
            if (i == poistettava - 1) {
                jasenet.remove(i);
            }
        }
    }

    public void haeTiedot(int haettava) {
        for (int i = 0; i < jasenet.size(); i++) {
            if (i == haettava - 1) {
                System.out.println(jasenet.get(i).toString());
            }
        }

    }

    public void listaa() {
        for (Jasen j : jasenet) {
            System.out.println(jasenet.indexOf(j) + 1 + ". " + j.getEtunimi() + " " + j.getSukunimi());
        }
    }

    public void naytaKoiralliset() {
        ArrayList<Jasen> koiralliset = jasenet.stream()
                .filter(jasen -> jasen.getKoira() != null)
                .collect(Collectors.toCollection(ArrayList::new));

        koiralliset.stream()
                .forEach(jasen -> System.out.println(jasen));

    }
}