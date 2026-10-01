
public class DemoKartu {
    public static void main(String[] args) {
        System.out.println("=== TEST KARTU DEBIT ===");
        KartuDebit debitRahma = new KartuDebit("1234-5678", "Rahma", 5000000, 10000000);
        debitRahma.cekSaldo(); // Memanggil method warisan dari parent
        debitRahma.tarikTunai(500000); // Memanggil method warisan dari parent
        System.out.println("Batas tarik harian: Rp" + debitRahma.getBatasTarik()); // Method spesifik class anak
        
        System.out.println("\n=== TEST KARTU KREDIT ===");
        KartuKredit kreditRahma = new KartuKredit("8765-4321", "Rahma", 2000000, 15000000);
        kreditRahma.cekSaldo(); // Memanggil method warisan dari parent
        kreditRahma.bayarCicilan(1000000); // Method spesifik class anak
    }
}
