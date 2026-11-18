import java.util.ArrayList;

// 1. Class Pegawai (Parent)
class Pegawai {
    public String nip;
    public String nama;

    public Pegawai() {
    }

    public Pegawai(String nip, String nama) {
        this.nip = nip;
        this.nama = nama;
    }

    public void displayInfo() {
        System.out.println("NIP: " + nip);
        System.out.println("Nama: " + nama);
    }
}

// 2. Class Dosen (Child dari Pegawai)
class Dosen extends Pegawai {
    public String nidn;

    public Dosen() {
    }

    public Dosen(String nip, String nama, String nidn) {
        super(nip, nama);
        this.nidn = nidn;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("NIDN: " + nidn);
    }

    public void mengajar() {
        System.out.println("Membuat rencana pembelajaran");
        System.out.println("Menyusun materi");
        System.out.println("Melaksanakan PBM");
        System.out.println("Melakukan evaluasi");
    }
}

// 3. Class TenagaKependidikan (Child dari Pegawai)
class TenagaKependidikan extends Pegawai {
    public String kategori;

    public TenagaKependidikan() {
    }

    public TenagaKependidikan(String nip, String nama, String kategori) {
        super(nip, nama);
        this.kategori = kategori;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Kategori: " + kategori);
    }
}

// 4. Class Main (Demo)
public class Demo {
    public static void main(String[] args) {
        // Instansiasi Object
        Dosen dosen1 = new Dosen("19940201", "Widia, S.Kom. M.Kom", "199402");
        Dosen dosen2 = new Dosen("19700105", "Muhammad, S.T, M.T", "197001");
        TenagaKependidikan tendik1 = new TenagaKependidikan("19750301", "Aida, A.Md.", "Tenaga Administrasi");
        TenagaKependidikan tendik2 = new TenagaKependidikan("19650304", "Rika, S.T.", "Tenaga Laboratorium");

        // PRAKTIKUM 2.3: Heterogenous Collection
        System.out.println("=== TEST HETEROGENOUS COLLECTION ===");
        ArrayList<Pegawai> daftarPegawai = new ArrayList<Pegawai>();
        daftarPegawai.add(dosen1);
        daftarPegawai.add(dosen2);
        daftarPegawai.add(tendik1);
        daftarPegawai.add(tendik2);
        System.out.println("Jumlah Pegawai: " + daftarPegawai.size());

        // PRAKTIKUM 2.4: Polymorphic
        Pegawai pegawai1 = dosen1;
        System.out.println(pegawai1.nip);
        System.out.println(pegawai1.nama);
        pegawai1.displayInfo();

        TenagaKependidikan test = (TenagaKependidikan) pegawai1;

    }

    public static void train(Pegawai pegawai) {
        System.out.println("Memberikan pelatihan untuk pegawai");
        pegawai.displayInfo();

        // hanya test
        System.out.println(pegawai.nidn);
        System.out.println(pegawai.kategori);
        pegawai.mengajar();
    }

}