// Satu baris belanjaan: pasangan Produk + jumlah
public class ItemTransaksi {
    private Produk produk;   // ATRIBUT bertipe objek (komposisi)
    private int jumlah;

    public ItemTransaksi(Produk produk, int jumlah) {
        this.produk = produk;
        this.jumlah = jumlah;
    }

    public Produk getProduk() { return produk; }
    public int getJumlah() { return jumlah; }

    // POLIMORFISME: hitungHarga() dipanggil lewat tipe Produk,
    // yang berjalan adalah versi milik objek aslinya (Makanan / Minuman)
    public double getSubtotal() {
        return produk.hitungHarga(jumlah);
    }
}
