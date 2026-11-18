// INHERITANCE: Minuman mewarisi semua atribut dan method Produk
public class Minuman extends Produk {

    // ATRIBUT khusus Minuman
    private int ukuranMl;

    public Minuman(String nama, double harga, int stok, int ukuranMl) {
        super(nama, harga, stok);
        this.ukuranMl = ukuranMl;
    }

    public int getUkuranMl() { return ukuranMl; }

    // POLIMORFISME (override): minuman kena pajak 5% (beda dengan Makanan)
    @Override
    public double getPersenPajak() {
        return 0.05;
    }

    @Override
    public String getKategori() {
        return "Minuman";
    }

    @Override
    public String toString() {
        return super.toString() + "  " + ukuranMl + "ml";
    }
}
