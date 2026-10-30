// 1. Interface Phone
interface Phone {
    int maxVolume = 100;
    int minVolume = 0;

    void powerOn();
    void powerOff();
    void volumeUp();
    void volumeDown();
}

// 2. Abstract Class Smartphone
abstract class Smartphone implements Phone {
    protected String os;
    protected int volume;
    protected int volumeStep;
    protected boolean isPowerOn;

    protected Smartphone(String os, int volumeStep) {
        this.os = os;
        this.volumeStep = volumeStep;
        this.volume = 50; // Set default volume ke 50
        this.isPowerOn = false;
    }

    @Override
    public void powerOn() {
        this.isPowerOn = true;
        System.out.println("Smartphone menyala dengan OS: " + this.os);
    }

    @Override
    public void powerOff() {
        this.isPowerOn = false;
        System.out.println("Smartphone dimatikan.");
    }

    @Override
    public void volumeUp() {
        if (isPowerOn) {
            if (this.volume + this.volumeStep > maxVolume) {
                System.out.println("Volume sudah maksimal (100). Tidak bisa ditambahkan.");
                this.volume = minVolume;
            } else {
                this.volume += this.volumeStep;
                System.out.println("Volume naik menjadi: " + this.volume);
            }
        } else {
            System.out.println("Nyalakan HP terlebih dahulu!");
        }
    }

    @Override
    public void volumeDown() {
        if (isPowerOn) {
            if (this.volume - this.volumeStep < minVolume) {
                System.out.println("Volume sudah minimal (0). Tidak bisa dikurangi.");
                this.volume = minVolume;
            } else {
                this.volume -= this.volumeStep;
                System.out.println("Volume turun menjadi: " + this.volume);
            }
        } else {
            System.out.println("Nyalakan HP terlebih dahulu!");
        }
    }

    public int getVolume() {
        return this.volume;
    }

    // Abstract method yang wajib diimplementasikan oleh subclass
    public abstract void useFeature();
}

// 3. Subclass Xiaomi
class Xiaomi extends Smartphone {
    private boolean turboOn;

    public Xiaomi() {
        super("HyperOS", 5);
        this.turboOn = false;
    }

    @Override
    public void useFeature() {
        if (isPowerOn) {
            this.turboOn = !this.turboOn;
            System.out.println("Xiaomi: Fitur Turbo " + (turboOn ? "Aktif" : "Non-aktif") + ".");
        } else {
            System.out.println("Nyalakan Xiaomi terlebih dahulu untuk menggunakan fitur Turbo!");
        }
    }
}

// 4. Subclass iPhone
class iPhone extends Smartphone {
    private boolean faceIdOn;

    public iPhone() {
        super("iOS", 10);
        this.faceIdOn = false;
    }

    @Override
    public void useFeature() {
        if (isPowerOn) {
            this.faceIdOn = !this.faceIdOn;
            System.out.println("iPhone: Fitur Face ID " + (faceIdOn ? "Aktif" : "Non-aktif") + ".");
        } else {
            System.out.println("Nyalakan iPhone terlebih dahulu untuk menggunakan fitur Face ID!");
        }
    }
}

// 5. Subclass Samsung
class Samsung extends Smartphone {
    private boolean dexActive;

    public Samsung() {
        super("One UI", 2);
        this.dexActive = false;
    }

    @Override
    public void useFeature() {
        if (isPowerOn) {
            this.dexActive = !this.dexActive;
            System.out.println("Samsung: Fitur Samsung DeX " + (dexActive ? "Aktif" : "Non-aktif") + ".");
        } else {
            System.out.println("Nyalakan Samsung terlebih dahulu untuk menggunakan fitur DeX!");
        }
    }
}

// 6. Subclass Oppo
class Oppo extends Smartphone {
    private boolean flashOn;

    public Oppo() {
        super("ColorOS", 4);
        this.flashOn = false;
    }

    @Override
    public void useFeature() {
        if (isPowerOn) {
            this.flashOn = !this.flashOn;
            System.out.println("Oppo: Fitur Flash Charge " + (flashOn ? "Aktif" : "Non-aktif") + ".");
        } else {
            System.out.println("Nyalakan Oppo terlebih dahulu untuk menggunakan fitur Flash Charge!");
        }
    }
}

// 7. Client Class PenggunaTelepon
class PenggunaTelepon {
    private Phone phone;

    public PenggunaTelepon(Phone phone) {
        this.phone = phone;
    }

    public void turnOnThePhone() {
        this.phone.powerOn();
    }

    public void turnOffThePhone() {
        this.phone.powerOff();
    }

    public void makePhoneLouder() {
        this.phone.volumeUp();
    }

    public void makePhoneSilent() {
        this.phone.volumeDown();
    }
}

// 8. Main Class untuk Demonstrasi
public class MainPhoneDemo {
    public static void main(String[] args) {
        System.out.println("=== SKENARIO 1: POLIMORFISME & ARRAY ===");
        // Array Phone[] berisi 4 merek
        Phone[] myPhones = {new Xiaomi(), new iPhone(), new Samsung(), new Oppo()};
        
        for (Phone p : myPhones) {
            p.powerOn();
            p.volumeUp(); // Menunjukkan volumeStep yang berbeda
            
            // Abstract class: useFeature() dipanggil lewat tipe Smartphone
            if (p instanceof Smartphone) {
                ((Smartphone) p).useFeature();
            }
            System.out.println("--------------------");
        }

        System.out.println("\n=== SKENARIO 2: ATRIBUT FINAL & HP MATI ===");
        Phone oppo = new Oppo();
        PenggunaTelepon user = new PenggunaTelepon(oppo);
        
        // HP masih mati menolak perubahan volume
        user.makePhoneLouder(); 
        
        user.turnOnThePhone();
        
        // Volume dinaikkan terus sampai MAX_VOLUME
        System.out.println("Menaikkan volume sampai batas maksimal:");
        for(int i = 0; i < 15; i++) {
            user.makePhoneLouder();
        }
        
        System.out.println("\n=== SKENARIO 3: ASOSIASI DENGAN INTERFACE ===");
        // PenggunaTelepon memakai Samsung, lalu Xiaomi, tanpa mengubah class
        Phone samsung = new Samsung();
        PenggunaTelepon user2 = new PenggunaTelepon(samsung);
        user2.turnOnThePhone();
        user2.makePhoneLouder();
        
        System.out.println("\n--- Ganti HP ke Xiaomi ---");
        Phone xiaomi = new Xiaomi();
        user2 = new PenggunaTelepon(xiaomi); // Mengganti referensi interface Phone
        user2.turnOnThePhone();
        user2.makePhoneLouder();
    }
}