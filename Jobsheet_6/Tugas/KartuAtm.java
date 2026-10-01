// parent
public class KartuAtm {
    // protected (#) agar atribut ini hanya bisa diakses dan diwariskan kepada child
    protected String nomorKartu;
    protected String namaPemilik;
    protected double saldo;

    // Contructor
    public KartuAtm() { // kosongan
    }
    public KartuAtm(String nomorKartu, String namaPemilik, double saldo){
        this.nomorKartu = nomorKartu;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }

    // method
    public void cekSaldo(){
        System.out.println("Saldo " + namaPemilik + " saat ini: Rp" + saldo);
    }

    public void tarikTunai(double nominal) {
        if (saldo >= nominal) {
            saldo -= nominal;
            System.out.println("Berhasil menarik Rp" + nominal + ". Saldo saldo: Rp" + saldo);
        } else {
            System.out.println("Maaf, saldo tidak mencukupi!");
        }
    }
}
