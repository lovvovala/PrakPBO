// Parent class
class Karyawan {
    protected String nama;
    protected int gaji;
    
    // overloading constructors
    public Karyawan() {
    }

    public Karyawan(String nama, int gaji) {
        this.nama = nama;
        this.gaji = gaji;
    }
    
    public void info() {
        System.out.println("Nama: " + nama);
        System.out.println("Gaji: Rp. " + gaji);
    }
    
    public void kerja() {
        System.out.println(nama + " sedang mengerjakan tugas.");
    }
}

// Child class 1 : Manager
class Manager extends Karyawan {
    private int jumlahBawahan;
    
    public Manager(String nama, int gaji, int jumlahBawahan) {
        super(nama, gaji);
        this.jumlahBawahan = jumlahBawahan;
    }
    
    @Override
    public void info() {
        super.info();
        System.out.println("Jumlah Bawahan: " + jumlahBawahan + " orang");
    }

    @Override
    public void kerja() {
        System.out.println(nama + " sedang mengawasi pekerjaan " + jumlahBawahan + " bawahan.");
    }
}

// Child class 2 : Intern
class Intern extends Karyawan {
    private int durasiMagang; 

    public Intern(String nama, int gaji, int durasiMagang) {
        super(nama, gaji);
        this.durasiMagang = durasiMagang;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Durasi Magang: " + durasiMagang + " bulan");
    }

    @Override
    public void kerja() {
        System.out.println(nama + " sedang belajar dan membantu pekerjaan operasional tim.");
    }
}

// Grandchild class : ProjectManager (Mewarisi dari Manager)
class ProjectManager extends Manager {
    private String namaProyek;

    public ProjectManager(String nama, int gaji, int jumlahBawahan, String namaProyek) {
        super(nama, gaji, jumlahBawahan); 
        this.namaProyek = namaProyek;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Nama Proyek: " + namaProyek);
    }

    @Override
    public void kerja() {
        System.out.println(nama + " sedang memimpin jalanannya proyek " + namaProyek );
    }
}

// Main class
public class DemoKaryawan {
    public static void main(String[] args) {
        System.out.println("=== DEMO ULANGAN TENGAH SEMESTER ===");
        System.out.println("\n=== TEST MANAGER ===");
        Manager manager = new Manager("Nidya", 10000000, 5);
        manager.info();
        manager.kerja();

        System.out.println("\n=== TEST PROJECT MANAGER ===");
        ProjectManager pm = new ProjectManager("Rahma Imoet", 15000000, 5, "ADUIN");
        pm.info();
        pm.kerja(); 

        System.out.println("\n=== TEST INTERN ===");
        Intern intern = new Intern("Fakhrun", 3000000, 6);
        intern.info();
        intern.kerja();
    }
}
