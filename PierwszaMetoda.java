public class PierwszaMetoda {
    // reguła rabatu zapisana RAZ: 3% od części 1000-5000, 5% od części ponad 5000
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

    public static void main(String[] args) {
        double oferta = rabat(6000.00);    // wywołanie 1
        double faktura = rabat(6000.00);   // wywołanie 2
        double maly = rabat(800.00);       // wywołanie 3

        System.out.printf("Oferta:  rabat %.2f PLN%n", oferta);
        System.out.printf("Faktura: rabat %.2f PLN%n", faktura);
        System.out.printf("Male zamowienie: rabat %.2f PLN%n", maly);
        System.out.printf("Rabat od 1500: %.2f PLN%n", rabat(1500.00));
    }
}
