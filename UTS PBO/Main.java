public class Main {
    public static void main(String[] args) {

        // OBJEK Inventaris + data awal
        Inventaris inventaris = new Inventaris();
        inventaris.tambah(new Makanan("Nasi Goreng", 20000, 10, "2026-12-31"));
        inventaris.tambah(new Makanan("Mie Ayam", 15000, 8, "2026-12-31"));
        inventaris.tambah(new Minuman("Es Teh", 5000, 20, 350));
        inventaris.tambah(new Minuman("Kopi Susu", 12000, 15, 250));

        // OBJEK Admin dan Kasir, disimpan dengan tipe induk Pengguna
        Pengguna admin = new Admin("admin", "Budi");
        Pengguna kasir = new Kasir("kasir", "Siti");

        System.out.println("=== SISTEM POS SEDERHANA ===");
        boolean jalan = true;
        while (jalan) {
            System.out.println("\nMasuk sebagai:");
            System.out.println("1. Admin");
            System.out.println("2. Kasir");
            System.out.println("0. Keluar");
            int pilih = Util.bacaInt("Pilih: ");

            Pengguna aktif = null;
            if (pilih == 1) {
                aktif = admin;
            } else if (pilih == 2) {
                aktif = kasir;
            } else if (pilih == 0) {
                jalan = false;
            } else {
                System.out.println("Pilihan tidak valid.");
            }

            if (aktif != null) {
                aktif.tampilSalam();
                // POLIMORFISME: satu pemanggilan, hasil beda tergantung objek aslinya
                aktif.jalankanMenu(inventaris);
            }
        }
        System.out.println("Program selesai.");
    }
}
