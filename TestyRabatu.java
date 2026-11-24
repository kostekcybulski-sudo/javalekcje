public class TestyRabatu {
    static double rabat(double wartosc) {
        double r;
        if (wartosc > 5000) {
            r = (5000 - 1000) * 0.03 + (wartosc - 5000) * 0.05;
        } else if (wartosc > 1000) {
            r = (wartosc - 1000) * 0.03;
        } else {
            r = 0.0;
        }
        return Math.round(r * 100) / 100.0;
    }

    static int bledy = 0;

    static void sprawdz(String opis, double oczekiwane, double otrzymane) {
        boolean ok = Math.abs(oczekiwane - otrzymane) < 0.005;   // zgodne co do grosza
        if (!ok) {
            bledy++;
        }
        System.out.printf("%-22s oczekiwane %8.2f  otrzymane %8.2f  %s%n", opis, oczekiwane, otrzymane, ok ? "OK" : "BLAD");
    }

    public static void main(String[] args) {
        sprawdz("ponizej progu 999,99", 0.00, rabat(999.99));
        sprawdz("prog 1000,00", 0.00, rabat(1000.00));
        sprawdz("1000,01", 0.00, rabat(1000.01));
        sprawdz("srodek 1500,00", 15.00, rabat(1500.00));
        sprawdz("prog 5000,00", 120.00, rabat(5000.00));
        sprawdz("5000,01", 120.00, rabat(5000.01));
        sprawdz("Laptop 5697,00", 154.85, rabat(5697.00));
        sprawdz("6000,00", 170.00, rabat(6000.00));
        System.out.println(bledy == 0 ? "Wszystkie testy OK" : "Testy z bledem: " + bledy);
    }
}
