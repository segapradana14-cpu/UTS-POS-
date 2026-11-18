import java.util.ArrayList;

// Class pengelola kumpulan produk (relasi: Inventaris "memiliki" banyak Produk)
public class Inventaris {
    // ATRIBUT berupa koleksi objek; tipe elemennya Produk (tipe induk)
    private ArrayList<Produk> daftar = new ArrayList<>();

    // Menerima Makanan maupun Minuman karena keduanya adalah Produk
    public void tambah(Produk p) {
        daftar.add(p);
    }

    public Produk cariByKode(String kode) {
        for (Produk p : daftar) {
            if (p.getKode().equalsIgnoreCase(kode)) {
                return p;
            }
        }
        return null;
    }

    public boolean hapus(String kode) {
        Produk p = cariByKode(kode);
        if (p == null) {
            return false;
        }
        return daftar.remove(p);
    }

    public void tampilSemua() {
        if (daftar.isEmpty()) {
            System.out.println("(belum ada produk)");
            return;
        }
        System.out.println("---------------- DAFTAR PRODUK ----------------");
        for (Produk p : daftar) {
            System.out.println(p);   // otomatis memanggil toString() versi Makanan/Minuman
        }
        System.out.println("-----------------------------------------------");
    }
}
