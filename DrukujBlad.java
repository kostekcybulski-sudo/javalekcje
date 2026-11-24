public class DrukujBlad {
    static void drukujVat(double netto, double stawka) {
        System.out.printf("VAT: %.2f%n", netto * stawka);
    }

    public static void main(String[] args) {
        double razem = drukujVat(597.00, 0.23) + drukujVat(735.00, 0.08);
        System.out.println(razem);
    }
}
