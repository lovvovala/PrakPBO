public class PersegiPanjang {
    
    public int panjang;
    public int lebar;

    // Method menampilkan info
    public void displayInfo() {
        System.out.println("Panjang Persegi : " + panjang);
        System.out.println("Lebar Persegi   : " + lebar);
    }

    // Method menghitung luas
    public int getLuas() {
        return panjang * lebar;
    }

    // Method menghitung keliling
    public int getKeliling() {
        return 2 * (panjang + lebar);
    }
}