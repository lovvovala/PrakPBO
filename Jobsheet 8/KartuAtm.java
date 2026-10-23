public abstract class KartuAtm {
    final String namaBank = "Bank Mandiri";
    protected String nomorKartu;
    protected String namaPemilik;
    protected double saldo;

    public KartuAtm() {

    }

    public KartuAtm(String nomorKartu, String namaPemilik, double saldo) {
        this.nomorKartu = nomorKartu;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }

    public void cekSaldo() {
        System.out.println("Bank          : " + namaBank);
        System.out.println("Nomor Kartu   : " + nomorKartu);
        System.out.println("Nama Pemilik  : " + namaPemilik);
        System.out.println("Saldo Saat Ini: Rp" + saldo);
    }

    public abstract void tarikTunai(double nominal);

    public void tarikTunai(double nominal, boolean cetakStruk) {
        this.tarikTunai(nominal);
        if (cetakStruk) {
            System.out.println("--- STRUK TRANSAKSI ---");
            System.out.println("Bank      : " + namaBank);
            System.out.println("Penarikan : Rp" + nominal);
            System.out.println("Sisa Saldo: Rp" + saldo);
            System.out.println("-----------------------");
        }
    }
}
