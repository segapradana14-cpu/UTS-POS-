public class PembayaranQRIS implements Pembayaran {

    @Override
    public String getMetode() {
        return "QRIS";
    }

    // POLIMORFISME: method sama dengan PembayaranTunai, perilakunya berbeda
    @Override
    public double hitungBiayaLayanan(double total) {
        return total * 0.007;   // biaya layanan 0,7%
    }

    @Override
    public boolean butuhInputUang() {
        return false;   // QRIS dibayar pas lewat scan
    }

    @Override
    public boolean validasi(double tagihan, double uangDiterima) {
        return true;
    }
}
