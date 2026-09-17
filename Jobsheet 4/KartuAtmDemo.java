public class KartuAtmDemo {
   public static void main(String[] args) {
        // 1. Instansiasi Bank
        Bank bankBri = new Bank("BRI");
        Bank bankBca = new Bank("BCA");

        // 2. Bank menerbitkan Kartu ATM
        KartuAtm kartu1 = bankBri.terbitkanKartu("Rachmah Nur Chotimah", 5000000);
        KartuAtm kartu2 = bankBca.terbitkanKartu("Rachmah Nur Chotimah", 2500000);

        // 3. Instansiasi Nasabah
        Nasabah nasabahKu = new Nasabah("Rachmah Nur Chotimah", "35730123456789");

        // 4. Nasabah menyimpan/memiliki kartu tersebut
        nasabahKu.tambahKartu(kartu1);
        nasabahKu.tambahKartu(kartu2);

        // 5. Tampilkan data relasi
        nasabahKu.tampilkanKartu();
    } 
}
