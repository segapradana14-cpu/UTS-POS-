// ABSTRACT CLASS: class induk yang tidak bisa di-new langsung,
// hanya boleh diwarisi oleh Makanan dan Minuman
public abstract class Produk {

    // ATRIBUT static: milik class, dipakai bersama oleh semua objek
    private static int jumlahProduk = 0;

    // ATRIBUT instance dengan ENKAPSULASI (private)
    private final String kode;   // final: tidak bisa diubah setelah dibuat
    private String nama;
    private double harga;
    private int stok;

    // CONSTRUCTOR
    public Produk(String nama, double harga, int stok) {
        jumlahProduk++;
        this.kode = String.format("P%03d", jumlahProduk);
        setNama(nama);
        setHarga(harga);
        setStok(stok);
    }

    // GETTER (enkapsulasi: akses baca)
    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }
    public static int getJumlahProduk() { return jumlahProduk; }

    // SETTER dengan VALIDASI (enkapsulasi: akses tulis terkontrol)
    public void setNama(String nama) {
        if (nama == null || nama.isBlank()) {
            throw new IllegalArgumentException("Nama produk tidak boleh kosong");
        }
        this.nama = nama;
    }

    public void setHarga(double harga) {
        if (harga <= 0) {
            throw new IllegalArgumentException("Harga harus lebih dari 0");
        }
        this.harga = harga;
    }

    public void setStok(int stok) {
        if (stok < 0) {
            throw new IllegalArgumentException("Stok tidak boleh negatif");
        }
        this.stok = stok;
    }

    // METHOD ABSTRACT: tidak punya isi, WAJIB di-override oleh class anak
    public abstract double getPersenPajak();
    public abstract String getKategori();

    // METHOD OVERLOADING: nama sama, parameter berbeda
    public double hitungHarga() {
        return hitungHarga(1);
    }

    public double hitungHarga(int jumlah) {
        return harga * jumlah * (1 + getPersenPajak());
    }

    public void kurangiStok(int jumlah) {
        setStok(stok - jumlah);
    }

    // OVERRIDE method milik class Object
    @Override
    public String toString() {
        return String.format("[%s] %-14s %-8s %10s  stok: %d",
                kode, nama, getKategori(), Util.rupiah(harga), stok);
    }
}
