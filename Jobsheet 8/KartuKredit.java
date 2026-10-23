public class KartuKredit extends KartuAtm {
    private long limitKredit;

    public KartuKredit() {
        super();
    }

    public KartuKredit(String nomorKartu, String namaPemilik, double saldo, long limitKredit) {
        super(nomorKartu, namaPemilik, saldo);
        this.limitKredit = limitKredit;
    }

    @Override
    public void tarikTunai(double nominal) {
        double biayaAdmin = 50000;
        double totalPotongan = nominal + biayaAdmin;

        if (limitKredit >= totalPotongan) {
            limitKredit -= totalPotongan;
            System.out.println(
                    "Tarik Tunai Kredit Rp" + nominal + " (Admin Rp" + biayaAdmin + "). Sisa Limit: Rp" + limitKredit);
        } else {
            System.out.println("Gagal! Limit kredit tidak mencukupi.");
        }
    }

    public void bayarCicilan(double nominal) {
        limitKredit += nominal;
        System.out.println("Berhasil bayar cicilan Rp" + nominal + ". Limit saat ini: Rp" + limitKredit);
    }

    public final double getLimitKredit() {
        return limitKredit;
    }

}
