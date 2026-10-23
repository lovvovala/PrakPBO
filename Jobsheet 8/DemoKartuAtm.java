public class DemoKartuAtm {
        public static void main(String[] args) {
        System.out.println("=== TEST OVERRIDING & OVERLOADING (KARTU DEBIT) ===");
        KartuDebit debit = new KartuDebit("123-456", "Rachmah", 5000000, 2000000);
        debit.cekSaldo();
        debit.tarikTunai(2500000); 
        debit.tarikTunai(1000000, true);

        System.out.println("\n=== TEST FINAL METHOD & OVERRIDING (KARTU KREDIT) ===");
        KartuKredit kredit = new KartuKredit("987-654", "Rahma imoet", 0, 10000000);
        kredit.tarikTunai(2000000); 
        System.out.println("Sisa limit bisa diakses aman: Rp" + kredit.getLimitKredit()); 

        System.out.println("\n=== MODIFIKASI ATRIBUT PARENT ===");
        System.out.println("Nama Pemilik awal: " + debit.namaPemilik);
        
        debit.namaPemilik = "Rachmah Nur Chotimah"; 
        System.out.println("Nama Pemilik setelah dimodifikasi: " + debit.namaPemilik);
        
        // Cek saldo lagi untuk membuktikan perubahannya
        debit.cekSaldo(); 
    }
}
