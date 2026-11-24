public class PrzezWartosc {
    static void podniesCene(double cena) {        // dostaje KOPIĘ liczby
        cena = cena * 1.10;
    }

    static double cenaPoPodwyzce(double cena) {   // zwraca nową wartość
        return Math.round(cena * 1.10 * 100) / 100.0;
    }

    static void podniesWszystkie(double[] ceny) { // dostaje adres TEJ SAMEJ tablicy
        for (int i = 0; i < ceny.length; i++) {
            ceny[i] = Math.round(ceny[i] * 1.10 * 100) / 100.0;
        }
    }

    public static void main(String[] args) {
        double cena = 100.00;
        podniesCene(cena);
        System.out.println("Po podniesCene:    " + cena);
        cena = cenaPoPodwyzce(cena);
        System.out.println("Po cenaPoPodwyzce: " + cena);

        double[] cennik = {100.00, 200.00};
        podniesWszystkie(cennik);
        System.out.println("Cennik po metodzie: " + cennik[0] + ", " + cennik[1]);
    }
}
