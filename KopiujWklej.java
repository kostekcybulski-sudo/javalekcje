public class KopiujWklej {
    public static void main(String[] args) {
        double wartosc = 6000.00;   // to samo zamówienie w ofercie i na fakturze

        // OFERTA: reguła rabatu zmieniona 1 stycznia (próg 1500 zamiast 1000)
        double rabatOferta;
        if (wartosc > 5000) {
            rabatOferta = (5000 - 1500) * 0.03 + (wartosc - 5000) * 0.05;
        } else if (wartosc > 1500) {
            rabatOferta = (wartosc - 1500) * 0.03;
        } else {
            rabatOferta = 0.0;
        }

        // FAKTURA: ta sama reguła skopiowana wcześniej, nikt jej nie zmienił
        double rabatFaktura;
        if (wartosc > 5000) {
            rabatFaktura = (5000 - 1000) * 0.03 + (wartosc - 5000) * 0.05;
        } else if (wartosc > 1000) {
            rabatFaktura = (wartosc - 1000) * 0.03;
        } else {
            rabatFaktura = 0.0;
        }

        System.out.printf("Oferta:  rabat %.2f, do zaplaty netto %.2f PLN%n", rabatOferta, wartosc - rabatOferta);
        System.out.printf("Faktura: rabat %.2f, do zaplaty netto %.2f PLN%n", rabatFaktura, wartosc - rabatFaktura);
    }
}
