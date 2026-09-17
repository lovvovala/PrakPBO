import java.util.ArrayList;

public class Nasabah {
    private String nama;
    private String noIdentitas;
    private ArrayList<KartuAtm> daftarKartu; // Relasi dengan KartuAtm

    // Constructor
    public Nasabah(String nama, String noIdentitas) {
        this.nama = nama;
        this.noIdentitas = noIdentitas;
        this.daftarKartu = new ArrayList<KartuAtm>(); // Instansiasi ArrayList
    }

    // Method untuk menambah kartu ke dalam ArrayList
    public void tambahKartu(KartuAtm k) {
        this.daftarKartu.add(k);
        System.out.println("Kartu berhasil ditambahkan ke dompet " + this.nama);
    }

    // Method untuk menampilkan semua kartu yang dimiliki
    public void tampilkanKartu() {
        System.out.println("\n=== DATA NASABAH ===");
        System.out.println("Nama         : " + this.nama);
        System.out.println("No Identitas : " + this.noIdentitas);
        System.out.println("Daftar Kartu ATM:");
        
        if (daftarKartu.isEmpty()) {
            System.out.println("  Belum ada kartu ATM.");
        } else {
            for (KartuAtm kartu : daftarKartu) {
                kartu.cetakInfo(); // Memanggil method dari class KartuAtm
            }
        }
    }
}