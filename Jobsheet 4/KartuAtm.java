public class KartuAtm {
    private String jenisKartu;
    private String namaBank;
    private String noSeri;
    private String namaPemilik;
    private long saldo;
    private boolean hasChip;

    public KartuAtm(String jenisKartu, String namaBank, String noSeri, String namaPemilik, long saldo,
            boolean hasChip) {
        this.jenisKartu = jenisKartu;
        this.namaBank = namaBank;
        this.noSeri = noSeri;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
        this.hasChip = hasChip;
    }

    public String getPemilik() {
        return namaPemilik;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSetorTunai(long nominal) {
        this.saldo += nominal;
    }

    public boolean setTarikTunai(long nominal) {
        if (this.saldo >= nominal) {
            this.saldo -= nominal;
            return true;
        }
        return false;
    }

    public void cetakInfo() {
        System.out.println("=== INFO KARTU ATM ===");
        System.out.println("Bank: " + this.namaBank + " | Pemilik: " + this.namaPemilik);
        System.out.println("No Seri: " + this.noSeri + " | Jenis Kartu: " + this.jenisKartu);
        System.out.println("Status Chip: " + (this.hasChip ? "Aktif" : "Tidak Aktif"));
        System.out.println("Saldo Tersedia: Rp" + this.saldo);
        System.out.println("======================");
    }
}