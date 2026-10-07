public class DemoKartu {
    public static void main(String[] args) {
        System.out.println("=== TEST OVERRIDING & OVERLOADING (KARTU DEBIT) ===");
        KartuDebit debit = new KartuDebit("123-456", "Rachmah", 5000000, 2000000);
        debit.cekSaldo();
        
        // Memanggil Overriding (Mencoba tarik lebih dari batas harian)
        debit.tarikTunai(2500000); 
        
        // Memanggil Overloading (Tarik tunai dengan cetak struk)
        debit.tarikTunai(1000000, true);

        System.out.println("\n=== TEST FINAL METHOD & OVERRIDING (KARTU KREDIT) ===");
        KartuKredit kredit = new KartuKredit("987-654", "Rahma imooet", 0, 10000000);
        
        // Memanggil Overriding khusus Kartu Kredit
        kredit.tarikTunai(2000000); 
        
        // Memanggil Final Method
        System.out.println("Sisa limit bisa diakses aman: Rp" + kredit.getLimitKredit()); 

        System.out.println("\n=== MODIFIKASI ATRIBUT PARENT ===");
        System.out.println("Nama Pemilik awal: " + debit.namaPemilik);
        
        // Modifikasi atribut yang diwariskan dari Parent
        debit.namaPemilik = "Rachmah Nur Chotimah"; 
        System.out.println("Nama Pemilik setelah dimodifikasi: " + debit.namaPemilik);
        
        // Cek saldo lagi untuk membuktikan perubahannya
        debit.cekSaldo(); 
    }
}