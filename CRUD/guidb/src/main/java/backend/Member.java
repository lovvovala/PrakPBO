package backend;

public class Member {
    private int id;
    private String nama;
    private String alamat;
    private String noHp;
    private String jenisMember;
    private String email;
    private String tanggalDaftar;
    private String status;

    // Constructor lengkap dengan ID (untuk Read & Update)
    public Member(int id, String nama, String alamat, String noHp, String jenisMember, String email, String tanggalDaftar, String status) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.noHp = noHp;
        this.jenisMember = jenisMember;
        this.email = email;
        this.tanggalDaftar = tanggalDaftar;
        this.status = status;
    }

    // Constructor tanpa ID (untuk Insert data baru)
    public Member(String nama, String alamat, String noHp, String jenisMember, String email, String tanggalDaftar, String status) {
        this.nama = nama;
        this.alamat = alamat;
        this.noHp = noHp;
        this.jenisMember = jenisMember;
        this.email = email;
        this.tanggalDaftar = tanggalDaftar;
        this.status = status;
    }

    public int getId() { return id; }
    public String getNama() { return nama; }
    public String getAlamat() { return alamat; }
    public String getNoHp() { return noHp; }
    public String getJenisMember() { return jenisMember; }
    public String getEmail() { return email; }
    public String getTanggalDaftar() { return tanggalDaftar; }
    public String getStatus() { return status; }

    public void setNama(String nama) { this.nama = nama; }
    public void setAlamat(String alamat) { this.alamat = alamat; }
    public void setNoHp(String noHp) { this.noHp = noHp; }
    public void setJenisMember(String jenisMember) { this.jenisMember = jenisMember; }
    public void setEmail(String email) { this.email = email; }
    public void setTanggalDaftar(String tanggalDaftar) { this.tanggalDaftar = tanggalDaftar; }
    public void setStatus(String status) { this.status = status; }
}