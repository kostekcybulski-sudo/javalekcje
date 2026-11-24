public class DrukujCzyZwroc {
    static void drukujVat(double netto, double stawka) {      // void: nic nie zwraca
        System.out.printf("VAT: %.2f%n", netto * stawka);
    }

    static double vat(double netto, double stawka) {          // double: zwraca liczbę
        return Math.round(netto * stawka * 100) / 100.0;
    }

    public static void main(String[] args) {
        drukujVat(597.00, 0.23);                 // wypisze, ale wyniku nie da się użyć
        double razem = vat(597.00, 0.23) + vat(735.00, 0.08) + vat(259.60, 0.05);
        System.out.printf("Razem VAT: %.2f%n", razem);
    }
}
