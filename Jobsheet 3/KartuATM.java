public class KartuATM {
    // 1. Private Atribut untuk perlindungan data (Information Hiding)
    private String namaBank;
    private String jenisTabungan; // Dari kotak atribut atas
    private String jenisKartu;    // Dari tabel modifier
    private String noSeri;
    private String namaPemilik;
    private long saldo;
    private boolean hasChip;

    // 2. Constructor (Di diagram ditulis setKartuAtm)
    public KartuATM(String jenisKartu, String namaBank, String noSeri, String namaPemilik, long saldo, boolean hasChip) {
        this.jenisKartu = jenisKartu;
        this.namaBank = namaBank;
        this.noSeri = noSeri;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
        this.hasChip = hasChip;
        // Mengisi default jenis tabungan
        this.jenisTabungan = "Umum"; 
    }

    // 3. Getter Methods (Read-Only)
    public String getPemilik() {
        return namaPemilik;
    }

    public long getSaldo() {
        return saldo;
    }

    // 4. Public Methods (Behavior)
    public void setSetorTunai(long nominal) {
        this.saldo += nominal;
        System.out.println("Setor tunai Rp" + nominal + " berhasil. Saldo saat ini: Rp" + this.saldo);
    }

    public boolean setTarikTunai(long nominal) {
        // Pengecekan apakah saldo cukup atau tidak
        if (this.saldo >= nominal) {
            this.saldo -= nominal;
            System.out.println("Tarik tunai Rp" + nominal + " berhasil. Sisa saldo: Rp" + this.saldo);
            return true;
        } else {
            System.out.println("Tarik tunai GAGAL! Saldo tidak mencukupi.");
            return false;
        }
    }

    public boolean setLakukanPembayaran(double nominal, String keterangan) {
        // Konversi nominal double ke long untuk pencocokan saldo
        long nominalBayar = (long) nominal;
        if (this.saldo >= nominalBayar) {
            this.saldo -= nominalBayar;
            System.out.println("Pembayaran '" + keterangan + "' sebesar Rp" + nominalBayar + " berhasil.");
            return true;
        } else {
            System.out.println("Pembayaran '" + keterangan + "' GAGAL! Saldo tidak mencukupi.");
            return false;
        }
    }

    public void setTerimaTransfer(double nominal) {
        long nominalTransfer = (long) nominal;
        this.saldo += nominalTransfer;
        System.out.println("Transfer masuk Rp" + nominalTransfer + " diterima. Saldo saat ini: Rp" + this.saldo);
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