import java.util.ArrayList;

// Clas Karyawan
class Karyawan {
    private String idKaryawan;
    private String nama;

    // Constructor
    public Karyawan(String idKaryawan, String nama) {
        this.idKaryawan = idKaryawan;
        this.nama = nama;
    }

    // Getter and Setter methods
    public String getNama() {return nama;}

}

// Class pelanggan
class Pelanggan {
    private String nama;
    private String noTelepon;
    private ArrayList<Kendaraan> daftarKendaraan;

    // Constructor
    public Pelanggan(String nama, String noTelepon) {
        this.nama = nama;
        this.noTelepon = noTelepon;
        this.daftarKendaraan = new ArrayList<>();
    }

    // Getter and Setter methods
    public String getNama() {return nama;}

    // Atribrut Sesuai perintah
    public void tambahKendaraan(Kendaraan kendaraan) { daftarKendaraan.add(kendaraan); System.out.println("Kendaraan ditambahkan untuk pelanggan: " + nama);}
}

// Class kendaraan
class Kendaraan {
    private String platNomor;
    private String merk;
    private String model;
    private String tipeKendaraan; // "Mobil" atau "Motor"
    private Pelanggan pemilik;

    // Constructor
    public Kendaraan(String platNomor, String merk, String model, String tipeKendaraan, Pelanggan pemilik) {
        this.platNomor = platNomor;
        this.merk = merk;
        this.model = model;
        this.tipeKendaraan = tipeKendaraan;
        this.pemilik = pemilik;
    }

    // Getter and Setter methods
    public String getTipeKendaraan() {return tipeKendaraan;}
    public String getInfo() {
        return "Plat Nomor: " + platNomor + ", Merk: " + merk + ", Model: " + model + ", Tipe: " + tipeKendaraan;
    }
}

// Class layanan
class Layanan {
    private String namaLayanan;
    private double harga;

    // Constructor
    public Layanan(String namaLayanan, double harga) {
        this.namaLayanan = namaLayanan;
        this.harga = harga;
    }

    // Getter and Setter methods
    public String getNamaLayanan() {return namaLayanan;}
    public double getHarga() {return harga;}
}

// Main Class
public class DemoBengkelMaju {
    public static void hitungDanCetakBiaya(Pelanggan p, Kendaraan k, Layanan l, Karyawan kar) {
       double totalBiaya = l.getHarga();
       double biayaLayananAwal = 0;

       // Aturan Perhitungan Biaya
       if (k.getTipeKendaraan().equalsIgnoreCase("Mobil")) {
           biayaLayananAwal = 50000; // Biaya layanan awal untuk mobil
       } else if (k.getTipeKendaraan().equalsIgnoreCase("Motor")) {
           biayaLayananAwal = 20000; // Biaya layanan awal untuk motor
       }

       totalBiaya += biayaLayananAwal;

       System.out.println("=================================");
       System.out.println("Nama Pelanggan      : " + p.getNama());
       System.out.println("Kendaraan           : " + k.getInfo());
       System.out.println("Layanan             : " + l.getNamaLayanan());
       System.out.println("Mekanik             : " + kar.getNama());
       System.out.println("Harga Layanan       : Rp" + String.format("%.0f", l.getHarga()));
       System.out.println("Biaya Tambahan      : Rp" + biayaLayananAwal);
       System.out.println("Total Biaya         : Rp" + String.format("%.0f", totalBiaya));
       System.out.println("=============================");
    }
    public static void main(String[] args) {
        // Display informasi
        System.out.println("\n======================== HASIL OUTPUT ========================");
        
        // Instansiasi objek Karyawan, Pelanggan, Kendaraan, dan Layanan
        Karyawan karyawan1 = new Karyawan("M001", "Nindya");
        Pelanggan pelanggan1 = new Pelanggan("Rachmah Nur C", "+6292929292929292");
        Kendaraan kendaraan1 = new Kendaraan("B 1234 XYZ", "Honda", "Civic", "Mobil", pelanggan1);
        Kendaraan kendaraan2 = new Kendaraan("N 5678 ABC", "Honda", "Stylo", "Motor", pelanggan1);
        Kendaraan kendaraan3 = new Kendaraan("AA 8907 FGH", "Honda", "Vario", "Motor", pelanggan1);
        Kendaraan kendaraan4 = new Kendaraan("AD 3467 UXF", "BYD", "Sealion 7", "Mobil", pelanggan1);
        Layanan layanan1 = new Layanan("Ganti Oli", 150000);
        Layanan layanan2 = new Layanan("Servis Berkala", 400000);


        // Menampilkan informasi karyawan, pelanggan, kendaraan, dan layanan
        System.out.println("\n--- INFORMASI BENGKEL MAJU ---");
        System.out.println("=================================");
        hitungDanCetakBiaya(pelanggan1, kendaraan2, layanan2, karyawan1);
        hitungDanCetakBiaya(pelanggan1, kendaraan1, layanan1, karyawan1);
        hitungDanCetakBiaya(pelanggan1, kendaraan3, layanan2, karyawan1);
        hitungDanCetakBiaya(pelanggan1, kendaraan4, layanan1, karyawan1);

    }
}
