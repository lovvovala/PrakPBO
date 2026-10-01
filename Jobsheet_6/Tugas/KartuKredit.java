public class KartuKredit extends KartuAtm {
    // Modifier private (-)
    private double limitKredit;

    // Konstruktor memanggil super() dari parent
    public KartuKredit(String nomorKartu, String namaPemilik, double saldo, double limitKredit) {
        super(nomorKartu, namaPemilik, saldo);
        this.limitKredit = limitKredit;
    }

    public void bayarCicilan(double nominal) {
        saldo += nominal; // Asumsi bayar cicilan mengembalikan saldo limit yang terpakai
        System.out.println("Berhasil bayar cicilan Rp" + nominal + ". Saldo saat ini: Rp" + saldo);
    }

    public double getLimitKredit() {
        return limitKredit;
    }
}
