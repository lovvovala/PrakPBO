public class Dosen extends Pegawai {
    public String nidn;

    // Constructor tanpa parameter
    public Dosen() {
        System.out.println("Objek dari class Dosen dibuat");
    }

    // Method getAllInfo() dari Percobaan 4 Langkah 8
    public String getAllInfo() {
        String info = "";
        info += "NIP   : " + super.nip + "\n";
        info += "Nama  : " + super.nama + "\n";
        info += "Gaji  : " + super.gaji + "\n";
        info += "NIDN  : " + this.nidn + "\n";

        return info;
    }
}
