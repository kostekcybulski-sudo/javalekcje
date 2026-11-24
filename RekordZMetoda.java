import java.util.List;

public class RekordZMetoda {
    record Pozycja(String nazwa, int ilosc, double cena, double stawka) {
        double wartosc() {                        // metoda rekordu: liczy z SWOICH pól
            return Math.round(ilosc * cena * 100) / 100.0;
        }
        boolean zRabatem() {
            return wartosc() > 1000;
        }
    }

    public static void main(String[] args) {
        List<Pozycja> pozycje = List.of(
            new Pozycja("Papier A4", 10, 21.90, 0.23),
            new Pozycja("Laptop", 3, 1899.00, 0.23));

        for (Pozycja p : pozycje) {
            System.out.printf("%-10s %9.2f  rabat: %s%n", p.nazwa(), p.wartosc(), p.zRabatem() ? "tak" : "nie");
        }
    }
}
