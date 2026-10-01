public class Dosen extends Pegawai {
    public String nidn;

    // Constructor tanpa parameter
    public Dosen() {
        System.out.println("Objek dari class Dosen dibuat");
    }

    public String getInfo() {
        return "NIDN  : " + this.nidn + "\n";
    }

    public String getAllInfo() {
        String info = super.getInfo();
        info += this.getInfo();

        return info;

    }
}
