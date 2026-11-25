package backend;

public class MemberGym {
    private int id;
    private String nama;
    private int usia;
    private String paket;

    // Constructor tanpa ID (untuk proses INSERT data baru)
    public MemberGym(String nama, int usia, String paket) {
        this.nama = nama;
        this.usia = usia;
        this.paket = paket;
    }

    // Constructor dengan ID (opsional, jika nanti butuh READ/UPDATE)
    public MemberGym(int id, String nama, int usia, String paket) {
        this.id = id;
        this.nama = nama;
        this.usia = usia;
        this.paket = paket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUsia() {
        return usia;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }

    public String getPaket() {
        return paket;
    }

    public void setPaket(String paket) {
        this.paket = paket;
    }
}