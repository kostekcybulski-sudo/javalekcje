public class KolejnoscArgumentow {
    // cena po rabacie: najpierw CENA, potem STAWKA rabatu (ułamek)
    static double cenaPoRabacie(double cena, double stawkaRabatu) {
        return Math.round(cena * (1 - stawkaRabatu) * 100) / 100.0;
    }

    public static void main(String[] args) {
        System.out.println("Dobrze:     " + cenaPoRabacie(6000.00, 0.03));
        System.out.println("Zamienione: " + cenaPoRabacie(0.03, 6000.00));   // kompilator nie protestuje
    }
}
