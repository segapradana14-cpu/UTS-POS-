// ABSTRACT CLASS induk untuk Admin dan Kasir
public abstract class Pengguna {
    private String username;
    private String nama;

    public Pengguna(String username, String nama) {
        this.username = username;
        this.nama = nama;
    }

    public String getUsername() { return username; }
    public String getNama() { return nama; }

    // Method abstract: tiap peran punya menu berbeda
    public abstract String getPeran();
    public abstract void jalankanMenu(Inventaris inventaris);

    // Method biasa yang diwariskan apa adanya
    public void tampilSalam() {
        System.out.println("\nHalo, " + nama + " (" + getPeran() + ")");
    }
}
