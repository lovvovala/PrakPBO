package Tugas;

public class KartuDebit extends KartuAtm {
    // Modifer private (-) agar atribut tidak dilihat di class lain
    private long batasTarikHarian;

    // Contructor
    public KartuDebit(String nomorKartu, String namaPemilik, double saldo, long batasTarikHarian) {
        super(nomorKartu, namaPemilik, saldo);
        this.batasTarikHarian = batasTarikHarian;
    }

    // method
    public void setBatasTarik(long batas) {
        this.batasTarikHarian = batas;
        System.out.println("Batas tarik harian diubah menjadi: Rp" + batas);
    }

    public long getBatasTarik() {
        return batasTarikHarian;
    }
}
