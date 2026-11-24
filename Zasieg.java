public class Zasieg {
    static double vat(double netto) {
        return netto * stawka;            // stawka pochodzi z main
    }

    public static void main(String[] args) {
        double stawka = 0.23;
        System.out.println(vat(597.00));
    }
}
