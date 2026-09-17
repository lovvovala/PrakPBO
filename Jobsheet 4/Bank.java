public class Bank {
    private String namaBank;

    // Constructor
    public Bank(String namaBank) {
        this.namaBank = namaBank;
    }

    // Method untuk menerbitkan kartu, me-return objek KartuAtm
    public KartuAtm terbitkanKartu(String namaPemilik, double saldo) {
        // Membuat nomor seri acak sederhana untuk simulasi
        String noSeri = "SN-" + (int)(Math.random() * 100000);
        
        // Memanggil constructor KartuAtm
        // Cast saldo ke long agar sesuai dengan tipe data di constructor KartuAtm
        KartuAtm kartuBaru = new KartuAtm("Debit", this.namaBank, noSeri, namaPemilik, (long)saldo, true);
        
        System.out.println("Bank " + this.namaBank + " berhasil menerbitkan kartu untuk " + namaPemilik);
        return kartuBaru;
    }
}