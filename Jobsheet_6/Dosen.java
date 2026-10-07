public class Dosen extends Pegawai {
    public String nidn;

    // Constructor tanpa parameter
    public Dosen() {
        System.out.println("Objek dari class Dosen dibuat");
    }

    // Constructor dengan parameter
    public Dosen(String nip, String nama, double gaji, String nidn) {
        super(nip, nama, gaji); // Memanggil constructor dari class Pegawai
        this.nidn = nidn;
    }

    public String getAllInfo() {
        String info = super.getInfo();
        info += "NIDN  : " + nidn + "\n";
        return info;
    }
}