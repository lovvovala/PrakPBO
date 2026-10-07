public class KartuAtm {
    // Atribut sesuai diagram
    public final String namaBank = "Bank Central"; // final attribute
    protected String nomorKartu;
    protected String namaPemilik;
    protected double saldo;

    // Constructor tanpa parameter
    public KartuAtm() {
    }

    // Constructor berparameter
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

    // Overloading 1: Tarik tunai biasa
    public void tarikTunai(double nominal) {
        if (saldo >= nominal) {
            saldo -= nominal;
            System.out.println("Tarik tunai sebesar Rp" + nominal + " berhasil.");
        } else {
            System.out.println("Saldo tidak mencukupi untuk tarik tunai!");
        }
    }

    // Overloading 2: Tarik tunai dengan opsi cetak struk
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