public class KartuDebit extends KartuAtm {
    // Modifer private (-) agar atribut tidak dilihat di class lain
    private double batasTarikHarian;

    // Contructor
    public KartuDebit(String nomorKartu, String namaPemilik, double saldo, double batasTarikHarian) {
        super(nomorKartu, namaPemilik, saldo);
        this.batasTarikHarian = batasTarikHarian;
    }

    // method
    public void setBatasTarik(double batas) {
        this.batasTarikHarian = batas;
        System.out.println("Batas tarik harian diubah menjadi: Rp" + batas);
    }

    public double getBatasTarik() {
        return batasTarikHarian;
    }
}
