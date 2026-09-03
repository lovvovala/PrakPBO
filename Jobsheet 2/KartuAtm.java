public class KartuAtm {
    // Atribut (State)
    public String jenisKartu;
    public String namaBank;
    public String jenisTabungan;
    public String noSeri;
    public String namaPemilik;
    public long saldo;
    public boolean hasChip;

    // Method (Behavior)
    public void setorTunai(long nominal) {
        saldo += nominal;
        System.out.println("Setor tunai Rp" + nominal + " berhasil. Saldo: Rp" + saldo);
    }

    public boolean tarikTunai(long nominal) {
        if (saldo >= nominal) {
            saldo -= nominal;
            System.out.println("Tarik tunai Rp" + nominal + " berhasil. Sisa saldo: Rp" + saldo);
            return true;
        } else {
            System.out.println("Tarik tunai GAGAL! Saldo tidak mencukupi.");
            return false;
        }
    }

    public long cekSaldo() {
        return saldo;
    }

    public boolean lakukanPembayaran(double nominal, String keterangan) {
        if (saldo >= nominal) {
            saldo -= nominal;
            System.out.println("Pembayaran '" + keterangan + "' sebesar Rp" + nominal + " berhasil. Sisa saldo: Rp" + saldo);
            return true;
        } else {
            System.out.println("Pembayaran '" + keterangan + "' GAGAL! Saldo tidak mencukupi.");
            return false;
        }
    }

    public void terimaTransfer(double nominal) {
        saldo += nominal;
        System.out.println("Transfer masuk Rp" + nominal + " diterima. Saldo saat ini: Rp" + saldo);
    }
    
    public void cetakInfo() {
        System.out.println("Bank: " + namaBank + " | Pemilik: " + namaPemilik);
        System.out.println("No Seri: " + noSeri + " | Jenis: " + jenisKartu);
        System.out.println("Saldo Awal: Rp" + saldo);
        System.out.println("-------------------------------------------------");
    }
}