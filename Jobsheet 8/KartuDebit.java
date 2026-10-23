public class KartuDebit extends KartuAtm {
    private long batasTarikHarian;
    public KartuDebit() {
        super();
         this.batasTarikHarian = batasTarikHarian;
    }

    public KartuDebit(String nomorKartu, String namaPemilik, double saldo) {
        super(nomorKartu, namaPemilik, saldo);
        this.batasTarikHarian = batasTarikHarian; 
    }

    @Override
    public void tarikTunai(double nominal) {
        if (saldo >= nominal) {
            saldo -= nominal;
            System.out.println("Tarik tunai sebesar Rp" + nominal + " berhasil.");
        } else {
            System.out.println("Saldo tidak mencukupi untuk tarik tunai!");
        }
    }

    public void SetBatasTarik(double batas) {
        this.batasTarikHarian = (long) batas;
    }

    public double GetBatasTarik() {
        return (double) this.batasTarikHarian;
    }
    
}
