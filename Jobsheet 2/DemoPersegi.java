public class DemoPersegi {
    public static void main(String[] args) {
        PersegiPanjang pp = new PersegiPanjang();
        pp.panjang = 10;
        pp.lebar = 5;

        // Menampilkan data dan hasil perhitungan
        pp.displayInfo();
        System.out.println("Luas Persegi    : " + pp.getLuas());
        System.out.println("Keliling Persegi: " + pp.getKeliling());
    }
}