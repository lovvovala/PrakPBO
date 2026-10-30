public class SmartFridge extends Kulkas implements Audible {
    private int volume;

    // 1. Constructor (Pastikan penulisan parameternya utuh dalam satu baris)
    public SmartFridge(int volume, int jumlahPintu, double harga, String warna, String merk) {
        super(jumlahPintu, harga, warna, merk); // Hanya boleh ada satu pemanggilan super()
        this.volume = volume;
    }
    @Override
    public void naikkanVolume(int increment) {
        this.volume += increment;
    }

    @Override
    public void turunkanVolume(int decrement) {
        this.volume += decrement;
    }

    public int getVolume() {
        return this.volume; // Mengatasi warning "volume is not used"
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
