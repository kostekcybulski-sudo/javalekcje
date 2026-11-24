import java.util.List;

public class FakturaAI {
    record Pozycja(String nazwa, int ilosc, double cena, double stawka) {}

    static double n23, n8, n5, rabaty;

    static double zaokr(double x) {
        return Math.round(x * 100) / 100.0;
    }

    static double rabat(double wartosc) {
        if (wartosc > 5000) {
            return zaokr(4000 * 0.03 + (wartosc - 5000) * 0.05);
        } else if (wartosc > 1000) {
            return zaokr((wartosc - 1000) * 0.05);
        }
        return 0.0;
    }

    static double vat(double netto, double stawka) {
        return zaokr(netto * stawka);
    }

    static int wypiszBledy(Pozycja p, int nr) {
        if (p.ilosc() <= 0) {
            System.out.println("BLAD: pozycja " + nr + ": ilosc <= 0");
            return 1;
        }
        if (p.cena() < 0) {
            System.out.println("BLAD: pozycja " + nr + ": cena <= 0");
            return 1;
        }
        if (p.stawka() != 0.23 && p.stawka() != 0.08 && p.stawka() != 0.05) {
            System.out.println("BLAD: pozycja " + nr + ": stawka spoza 23/8/5%");
            return 1;
        }
        return 0;
    }

    static void drukujFakture(String tytul, List<Pozycja> pozycje) {
        System.out.println("== " + tytul);
        if (pozycje.isEmpty()) {
            System.out.println("BLAD: faktura bez pozycji");
            return;
        }
        int bledy = 0;
        for (int i = 0; i < pozycje.size(); i++) {
            bledy += wypiszBledy(pozycje.get(i), i + 1);
        }
        if (bledy > 0) {
            return;
        }
        for (Pozycja p : pozycje) {
            double wartosc = zaokr(p.ilosc() * p.cena());
            double r = rabat(wartosc);
            rabaty += r;
            if (p.stawka() == 0.23) {
                n23 += zaokr(wartosc - r);
            } else if (p.stawka() == 0.08) {
                n8 += zaokr(wartosc - r);
            } else {
                n5 += zaokr(wartosc - r);
            }
        }
        double v23 = vat(zaokr(n23), 0.23), v8 = vat(zaokr(n8), 0.08), v5 = vat(zaokr(n5), 0.05);
        double netto = zaokr(n23 + n8 + n5), podatek = zaokr(v23 + v8 + v5);
        System.out.println("Pozycji: " + pozycje.size());
        System.out.printf("Rabaty razem: %.2f%n", rabaty);
        System.out.printf("23%%: netto %.2f, VAT %.2f%n", n23, v23);
        System.out.printf(" 8%%: netto %.2f, VAT %.2f%n", n8, v8);
        System.out.printf(" 5%%: netto %.2f, VAT %.2f%n", n5, v5);
        System.out.printf("Razem netto:  %.2f PLN%n", netto);
        System.out.printf("Razem VAT:    %.2f PLN%n", podatek);
        System.out.printf("Razem brutto: %.2f PLN%n", zaokr(netto + podatek));
    }

    public static void main(String[] args) {
        List<Pozycja> faktura1 = List.of(
            new Pozycja("Papier A4", 10, 21.90, 0.23),
            new Pozycja("Toner", 2, 189.00, 0.23),
            new Pozycja("Laptop", 3, 1899.00, 0.23),
            new Pozycja("Ksiazka", 4, 64.90, 0.05),
            new Pozycja("Nocleg", 3, 245.00, 0.08));
        List<Pozycja> faktura2 = List.of(
            new Pozycja("Usluga", 1, 1000.00, 0.23));

        drukujFakture("Faktura 1", faktura1);
        drukujFakture("Faktura 2", faktura2);
    }
}
