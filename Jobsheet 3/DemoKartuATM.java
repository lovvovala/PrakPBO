public class DemoKartuATM {
    public static void main(String[] args) {
        // Instansiasi objek baru menggunakan Constructor[cite: 3]
        KartuATM kartuKu = new KartuATM(
            "Debit", 
            "BRI", 
            "1234-5678-9012", 
            "Rachmah Nur Chotimah", 
            1500000, 
            true
        );

        // Menampilkan Info Awal
        kartuKu.cetakInfo();

        // Melakukan berbagai transaksi uji coba
        kartuKu.setSetorTunai(500000);
        kartuKu.setTarikTunai(200000);
        kartuKu.setLakukanPembayaran(75000, "Bayar WiFi");
        kartuKu.setTerimaTransfer(250000);

        System.out.println("\n--- Pengecekan Menggunakan Getter ---");
        // Menggunakan getter agar data tetap aman dan bersifat read-only[cite: 3]
        System.out.println("Nama Pemilik : " + kartuKu.getPemilik());
        System.out.println("Sisa Saldo : Rp" + kartuKu.getSaldo());
    }
}