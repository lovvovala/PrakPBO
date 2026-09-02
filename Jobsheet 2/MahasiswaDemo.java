
public class MahasiswaDemo {
    public static void main(String[] args) {
        Mahasiswa m1 = new Mahasiswa();
        m1.nim = "023432";
        m1.nama = "Yansy Ayuningtyas";
        m1.alamat = "Nias, Sumatera Utara";
        m1.kelas = "2A";
        m1.displayBiodata();

        // (Jawaban No. 12) Instansiasi 2 objek mahasiswa baru 
        Mahasiswa m2 = new Mahasiswa();
        m2.nim = "123456";
        m2.nama = "Budi Santoso";
        m2.alamat = "Surabaya, Jawa Timur";
        m2.kelas = "2B";
        m2.displayBiodata();

        Mahasiswa m3 = new Mahasiswa();
        m3.nim = "789012";
        m3.nama = "Siti Aminah";
        m3.alamat = "Malang, Jawa Timur";
        m3.kelas = "2C";
        m3.displayBiodata();
    }
}
