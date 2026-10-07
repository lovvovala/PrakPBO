// Parent class
class Manusia {
    public void bernafas() {
        System.out.println("Manusia bernafas menggunakan paru-paru.");
    }

    public void makan() {
        System.out.println("Manusia makan makanan untuk bertahan hidup.");
    }
}

// Child class Dosen 
class Dosen extends Manusia {
    @Override
    public void makan() {
        System.out.println("Dosen makan siang di kantin kampus.");
    }

    public void lembur() {
        System.out.println("Dosen sedang lembur memeriksa tugas mahasiswa.");
    }
}

// Child class Mahasiswa
class Mahasiswa extends Manusia {
    @Override
    public void makan() {
        System.out.println("Mahasiswa makan mie instan di kosan.");
    }

    public void tidur() {
        System.out.println("Mahasiswa tidur setelah merampungkan tugas.");
    }
}

// Main class
public class MainManusia {
    public static void main(String[] args) {
        // Penerapan Dynamic Method Dispatch / Polymorphism
        Manusia m1 = new Manusia();
        Manusia m2 = new Dosen();     // Reference Manusia, Objek Dosen
        Manusia m3 = new Mahasiswa(); // Reference Manusia, Objek Mahasiswa

        System.out.println("=== MANUSIA ==");
        m1.bernafas();
        m1.makan();

        System.out.println("\n=== DOSEN (Dynamic Dispatch) ===");
        m2.bernafas();
        m2.makan(); // Memanggil method makan() milik Dosen

        System.out.println("\n=== MAHASISWA (Dynamic Dispatch) ===");
        m3.bernafas();
        m3.makan(); // Memanggil method makan() milik Mahasiswa
    }
}