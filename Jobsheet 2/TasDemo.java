public class TasDemo {
    
    public static void main(String[] args) {
        
        Tas tas1 = new Tas();
        Tas tas2 = new Tas();

        tas1.merek = "Eiger";
        tas1.warna = "Hitam";
        tas1.kapasitas = 25.5;

        tas2.merek = "Jansport";
        tas2.warna = "Merah";
        tas2.kapasitas = 20.0;

        System.out.println("Informasi Tas 1:");
        tas1.cetakInfo();

        System.out.println("Informasi Tas 2:");
        tas2.cetakInfo();
    }
}

