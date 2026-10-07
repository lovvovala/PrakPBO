public class KartuDebit extends KartuAtm {
    private long batasTarikHarian;

    // Constructor tanpa parameter
    public KartuDebit() {
        super();
        this.batasTarikHarian = 5000000;
    }

    // Constructor berparameter
    public KartuDebit(String nomorKartu, String namaPemilik, double saldo, long batasTarikHarian) {
        super(nomorKartu, namaPemilik, saldo);
        this.batasTarikHarian = batasTarikHarian;
    }

    // Overriding method tarikTunai
    @Override
    public void tarikTunai(double nominal) {
        if (nominal > batasTarikHarian) {
            System.out.println("Gagal! Nominal Rp" + nominal + " melebihi batas tarik harian Rp" + batasTarikHarian);
        } else {
            super.tarikTunai(nominal);
        }
    }

    public void setBatasTarik(double batas) {
        this.batasTarikHarian = (long) batas;
    }

    public double getBatasTarik() {
        return (double) this.batasTarikHarian;
    }
}
