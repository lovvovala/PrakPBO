public class MainElektronik {
    public static void main(String[] args) {
        Kipas kipas = new Kipas("Angin Duduk", 250000, "Hitam", "Maspion");
        TV tv = new TV("LED", 15, 3500000, "Hitam", "Samsung");
        SmartFridge kulkasPintar = new SmartFridge(50, 2, 8000000, "Silver", "LG");

        System.out.println("=== INFO KIPAS ===");
        System.out.println("Merk: " + kipas.getMerk() + ", Jenis: " + kipas.getJenis());

        System.out.println("\n=== INFO TV ===");
        System.out.println("Merk: " + tv.getMerk() + ", Volume Awal: " + tv.getVolume());
        tv.naikkanVolume(5);
        System.out.println("Volume TV setelah dinaikkan: " + tv.getVolume());

        System.out.println("\n=== INFO SMART FRIDGE ===");
        System.out.println("Merk: " + kulkasPintar.getMerk() + ", Volume Awal: " + kulkasPintar.getVolume());
    }
}