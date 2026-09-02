// Class sebagai cetakan
class Laptop {
    //  State
    String merk;
    int ram;
    int harga;

    // Constructor untuk menginisialisasi objek
    public Laptop(String merk, int ram, int harga) {
        this.merk = merk;
        this.ram = ram;
        this.harga = harga;
    }

    // Behavior 
    public void tambahRAM(int tambahan) {
        this.ram += tambahan; // Langsung memodifikasi variabel milik objek ini
    }

    public void diskonHarga(int diskon) {
        this.harga -= diskon;
    }

    public void tampilkanInfo() {
        System.out.println("Merk: " + this.merk + " | RAM: " + this.ram + "GB | Harga: " + this.harga);
    }
}

// 2. Class Utama (Main)
public class MainLaptopOOP {
    public static void main(String[] args) {
        // Mengimplementasikan 10 objek menggunakan array of objects
        Laptop[] daftarLaptop = new Laptop[10];
        
        daftarLaptop[0] = new Laptop("Asus", 4, 5000);
        daftarLaptop[1] = new Laptop("Acer", 8, 4500);
        daftarLaptop[2] = new Laptop("Lenovo", 16, 7000);
        daftarLaptop[3] = new Laptop("HP", 8, 7200);
        daftarLaptop[4] = new Laptop("Dell", 16, 9000);
        daftarLaptop[5] = new Laptop("MSI", 16, 15000);
        daftarLaptop[6] = new Laptop("Apple", 8, 20000);
        daftarLaptop[7] = new Laptop("Axioo", 4, 3000);
        daftarLaptop[8] = new Laptop("Zyrex", 8, 4000);
        daftarLaptop[9] = new Laptop("Toshiba", 4, 3500);
        
        // Memanggil fungsi langsung dari objeknya masing-masing
        daftarLaptop[0].tambahRAM(4); 
        daftarLaptop[2].diskonHarga(1000);
        
        // Menampilkan data
        daftarLaptop[0].tampilkanInfo();
        daftarLaptop[2].tampilkanInfo();
    }
}