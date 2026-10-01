public class Pegawai {
    public String nip;
    public String nama;
    public double gaji;

    // Constructor tanpa parameter
    public Pegawai() {
        System.out.println("Objek dari class Pegawai dibuat");
    }

    // Method getInfo()
    public String getInfo() {
        String info = "";
        info += "NIP   : " + nip + "\n";
        info += "Nama  : " + nama + "\n";
        info += "Gaji  : " + gaji + "\n";
        return info;
    }

    public String getAllInfo() {
        String info = getInfo();
        info += "NIDN  : " + ((Dosen) this).nidn + "\n";

        return info;
    }
}
