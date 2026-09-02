public class LaptopStruktural {
    public static void main(String[] args) {
        
        String[] merk = {"Asus", "Acer", "Lenovo", "HP", "Dell", "MSI", "Apple", "Axioo", "Zyrex", "Toshiba"};
        int[] ram = {4, 4, 8, 8, 16, 16, 8, 4, 8, 4};
        int[] harga = {5000, 4500, 7000, 7200, 9000, 15000, 20000, 3000, 4000, 3500}; // dalam ribuan

        
        ram[0] = tambahRAM(ram[0], 4);
        harga[4] = diskonHarga(harga[4], 1000);

       
        System.out.println("Merk: " + merk[0] + " | RAM: " + ram[0] + "GB | Harga: " + harga[0]);
        System.out.println("Merk: " + merk[4] + " | RAM: " + ram[4] + "GB | Harga: " + harga[4]);
    }

    
    public static int tambahRAM(int ramSaatIni, int tambahan) {
        return ramSaatIni + tambahan;
    }

    public static int diskonHarga(int hargaSaatIni, int diskon) {
        return hargaSaatIni - diskon;
    }
}