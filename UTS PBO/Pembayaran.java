// INTERFACE: kontrak/aturan yang harus dipenuhi class yang mengimplementasikannya.
// Hanya berisi method tanpa isi.
public interface Pembayaran {
    String getMetode();
    double hitungBiayaLayanan(double total);
    boolean butuhInputUang();
    boolean validasi(double tagihan, double uangDiterima);
}
