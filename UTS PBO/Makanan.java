// INHERITANCE: Makanan mewarisi semua atribut dan method Produk
public class Makanan extends Produk {

    // ATRIBUT khusus Makanan
    private String kedaluwarsa;

    public Makanan(String nama, double harga, int stok, String kedaluwarsa) {
        super(nama, harga, stok);   // memanggil constructor class induk
        this.kedaluwarsa = kedaluwarsa;
    }

    public String getKedaluwarsa() { return kedaluwarsa; }

    // POLIMORFISME (override): makanan kena pajak 10%
    @Override
    public double getPersenPajak() {
        return 0.10;
    }

    @Override
    public String getKategori() {
        return "Makanan";
    }

    @Override
    public String toString() {
        return super.toString() + "  exp: " + kedaluwarsa;
    }
}
