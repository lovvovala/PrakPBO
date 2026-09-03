public class KartuAtmDemo {
    public static void main(String[] args) {
        
        // Instansiasi Objek 1 
        KartuAtm kartu1 = new KartuAtm();
        kartu1.jenisKartu = "Debit";
        kartu1.namaBank = "BRI";
        kartu1.jenisTabungan = "Simpedes";
        kartu1.noSeri = "1234-5678-9012";
        kartu1.namaPemilik = "Rachmah Nur Chotimah";
        kartu1.saldo = 500000;
        kartu1.hasChip = true;

        // Instansiasi Objek 2
        KartuAtm kartu2 = new KartuAtm();
        kartu2.jenisKartu = "Kredit";
        kartu2.namaBank = "Mandiri";
        kartu2.jenisTabungan = "Platinum";
        kartu2.noSeri = "9876-5432-1098";
        kartu2.namaPemilik = "Budi Santoso";
        kartu2.saldo = 10000000;
        kartu2.hasChip = true;

        // Eksekusi Method Objek 1 
        System.out.println("=== Transaksi Kartu 1 ===");
        kartu1.cetakInfo();
        kartu1.setorTunai(200000);
        kartu1.tarikTunai(150000);
        kartu1.lakukanPembayaran(50000, "Mie Gacoan Sawojajar");
        kartu1.lakukanPembayaran(1000000, "Beli Tiket Kereta"); 

        // Eksekusi Method Objek 2 
        System.out.println("\n=== Transaksi Kartu 2 ===");
        kartu2.cetakInfo();
        kartu2.terimaTransfer(2500000);
        kartu2.lakukanPembayaran(1500000, "Cicilan Laptop");
        System.out.println("Cek Saldo Akhir Kartu 2: Rp" + kartu2.cekSaldo());
    }
}