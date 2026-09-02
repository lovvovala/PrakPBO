public class Tas {
    public String merek;
    public String warna;
    public double kapasitas; // dalam Liter

    public void cetakInfo() {
        System.out.println("Merek Tas : " + merek);
        System.out.println("Warna     : " + warna);
        System.out.println("Kapasitas : " + kapasitas + " Liter");
        System.out.println("----------------------------");
    }
}