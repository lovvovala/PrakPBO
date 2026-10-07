public class Segitiga {
    private int sudut;

    // Overloading Method 1
    public int totalSudut(int sudutA) {
        this.sudut = 180 - sudutA;
        return this.sudut;
    }

    // Overloading Method 2
    public int totalSudut(int sudutA, int sudutB) {
        this.sudut = 180 - (sudutA + sudutB);
        return this.sudut;
    }

    // Overloading Method 3
    public int keliling(int sisiA, int sisiB, int sisiC) {
        return sisiA + sisiB + sisiC;
    }

    // Overloading Method 4 (Rumus Phytagoras)
    public double keliling(int sisiA, int sisiB) {
        double c = Math.sqrt(Math.pow(sisiA, 2) + Math.pow(sisiB, 2));
        return sisiA + sisiB + c;
    }

    public static void main(String[] args) {
        Segitiga sg = new Segitiga();
        System.out.println("Total Sudut (1 Sudut Diketahui) : " + sg.totalSudut(60));
        System.out.println("Total Sudut (2 Sudut Diketahui) : " + sg.totalSudut(60, 40));
        System.out.println("Keliling (3 Sisi)               : " + sg.keliling(3, 4, 5));
        System.out.println("Keliling (2 Sisi Tegak Lurus)   : " + sg.keliling(3, 4));
    }
}