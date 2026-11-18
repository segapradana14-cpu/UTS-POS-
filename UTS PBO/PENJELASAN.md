# Contekan Konsep OOP pada Program POS

Format: `File:baris`. Nomor baris sesuai file yang diberikan (jangan diubah kalau mau dipakai untuk menunjuk).

Cara menjalankan:
```
javac *.java
java Main
```

## Struktur class

| Class | Peran |
|---|---|
| `Produk` (abstract) | Induk semua barang |
| `Makanan`, `Minuman` | Anak dari `Produk` |
| `Pengguna` (abstract) | Induk pengguna |
| `Admin`, `Kasir` | Anak dari `Pengguna` |
| `Pembayaran` (interface) | Kontrak metode bayar |
| `PembayaranTunai`, `PembayaranQRIS` | Implementasi interface |
| `Inventaris` | Menyimpan daftar `Produk` |
| `Transaksi`, `ItemTransaksi` | Keranjang belanja dan struk |
| `StokTidakCukupException` | Exception buatan sendiri |
| `Util` | Input, format rupiah |
| `Main` | Titik masuk program |

## 1. Class
Cetak biru objek. Contoh: `Produk.java:3`, `Makanan.java:2`, `Transaksi.java` (seluruh file), `Kasir.java:4`.

## 2. Objek
Hasil `new`, yaitu wujud nyata dari class.
- `Main.java:5` objek `Inventaris`
- `Main.java:6-9` objek `Makanan` dan `Minuman`
- `Main.java:12` objek `Admin`, `Main.java:13` objek `Kasir`
- `Kasir.java:49` objek `Transaksi`
- `Transaksi.java:28` objek `ItemTransaksi`
- `Kasir.java:85` objek `PembayaranQRIS`, `Kasir.java:87` objek `PembayaranTunai`

## 3. Atribut
Variabel yang dideklarasikan di dalam class.
- `Produk.java:9-12` kode, nama, harga, stok
- `Makanan.java:5` kedaluwarsa (atribut khusus Makanan)
- `Minuman.java:5` ukuranMl (atribut khusus Minuman)
- `Pengguna.java:3-4` username, nama
- `Transaksi.java:7-9` noTransaksi, namaKasir, items
- `Inventaris.java:6` daftar (koleksi `Produk`)
- `ItemTransaksi.java:3-4` produk, jumlah
- Atribut **static** (milik class, bukan milik objek): `Produk.java:6` dan `Transaksi.java:5`
- Atribut **final** (tidak bisa diubah): `Produk.java:9`, `Transaksi.java:7`

## 4. Method
Fungsi di dalam class (ada tanda kurung `()`).
- Constructor: `Produk.java:15`, `Makanan.java:7`, `Minuman.java:7`, `Transaksi.java:11`
- Method biasa: `Produk.java:61` hitungHarga, `Transaksi.java:21` tambahItem, `Transaksi.java:50` cetakStruk, `Inventaris.java:9` tambah
- Method static: `Util.java:8` rupiah, `Util.java:17` bacaInt, `Produk.java:28` getJumlahProduk

## 5. Enkapsulasi
Atribut `private`, diakses lewat getter dan setter, setter memvalidasi data.
- Atribut private: `Produk.java:9-12`
- Getter: `Produk.java:24-27`
- Setter dengan validasi: `Produk.java:31` (nama), `Produk.java:38` (harga), `Produk.java:45` (stok)
- Validasi melempar error: `Produk.java:33`, `Produk.java:40`, `Produk.java:47`
- Setter dipanggil dari luar: `Admin.java` menu "Ubah stok" (`p.setStok(...)`) dan `Transaksi.java` (`p.kurangiStok(...)`)
- Bukti nyata: coba ubah stok jadi `-5` lewat menu Admin, program menolak dengan pesan "Stok tidak boleh negatif"

## 6. Inheritance (pewarisan)
Kata kunci `extends` dan `super`.
- `Makanan.java:2` Makanan mewarisi Produk
- `Minuman.java:2` Minuman mewarisi Produk
- `Admin.java:2` Admin mewarisi Pengguna
- `Kasir.java:4` Kasir mewarisi Pengguna
- `StokTidakCukupException.java:2` mewarisi Exception bawaan Java
- `super(...)` memanggil constructor induk: `Makanan.java:8`, `Minuman.java:8`, `Admin.java:5`, `Kasir.java:9`
- `super.toString()` memanggil method induk: `Makanan.java:27`, `Minuman.java:27`
- Method yang diwarisi tanpa ditulis ulang: `getNama()`, `getStok()`, `setStok()`, dll. milik `Produk` bisa dipakai oleh `Makanan` dan `Minuman`; `tampilSalam()` (`Pengguna.java:19`) bisa dipakai `Admin` dan `Kasir`

## 7. Polimorfisme
Satu nama method, perilaku berbeda tergantung objek aslinya.

**a. Overriding (pewarisan)**
- `getPersenPajak()`: Makanan 10% (`Makanan.java:16`), Minuman 5% (`Minuman.java:16`)
- `getKategori()`: `Makanan.java:21`, `Minuman.java:21`
- `toString()`: `Produk.java:71`, `Makanan.java:26`, `Minuman.java:26`
- `getPeran()` dan `jalankanMenu()`: `Admin.java:9,15` dan `Kasir.java:13,19` (menu Admin dan Kasir berbeda)

**b. Pemanggilan lewat tipe induk (inilah inti polimorfisme)**
- `ItemTransaksi.java:17` `produk.hitungHarga(jumlah)`: variabelnya bertipe `Produk`, tapi yang jalan versi pajak Makanan atau Minuman
- `Main.java:38` `aktif.jalankanMenu(inventaris)`: variabel bertipe `Pengguna`, yang jalan menu Admin atau Kasir
- `Inventaris.java:9` `tambah(Produk p)` menerima Makanan maupun Minuman
- `Inventaris.java` bagian `tampilSemua()` memanggil `println(p)` dan otomatis memakai `toString()` yang sesuai

**c. Polimorfisme lewat interface**
- `Kasir.java:83-88` variabel `Pembayaran metode` diisi Tunai atau QRIS
- `Transaksi.java:50` parameter `Pembayaran metode` menerima keduanya
- `PembayaranTunai.java:10` biaya layanan 0, `PembayaranQRIS.java:10` biaya layanan 0,7%

**d. Overloading (nama sama, parameter beda, dalam satu class)**
- `Produk.java:57` `hitungHarga()` dan `Produk.java:61` `hitungHarga(int jumlah)`

## 8. Abstraksi: abstract class dan interface
- `Produk.java:3` abstract class (tidak bisa di-`new Produk(...)`)
- `Produk.java:53-54` method abstract (tanpa isi, wajib di-override anak)
- `Pengguna.java:2` abstract class, `Pengguna.java:15-16` method abstract
- `Pembayaran.java:3` interface (kontrak)
- `PembayaranTunai.java:2` dan `PembayaranQRIS.java:1` memakai `implements`

## 9. Konsep tambahan (kalau ditanya)
- **Komposisi / hubungan "punya"**: `Transaksi` punya banyak `ItemTransaksi` (`Transaksi.java:9`), `ItemTransaksi` punya `Produk` (`ItemTransaksi.java:3`), `Inventaris` punya banyak `Produk` (`Inventaris.java:6`)
- **Exception handling**:
  - dilempar: `Transaksi.java:26` (`throw new StokTidakCukupException`)
  - dideklarasikan: `Transaksi.java:21` (`throws`)
  - ditangkap: `Kasir.java:66` dan `Kasir.java:68`, serta `Admin.java:73`
- **Koleksi**: `ArrayList` di `Inventaris.java:6`, `Transaksi.java:9`, `Kasir.java:6`
- **Keyword `this`**: `Produk.java:17`, `Makanan.java:9`

## Contoh jawaban singkat saat ditanya dosen

- *"Mana atributnya?"* → `harga` di `Produk.java:11` (private, tipe double).
- *"Mana objeknya?"* → `Main.java:6`, `new Makanan("Nasi Goreng", ...)` membuat objek dari class `Makanan`.
- *"Mana method-nya?"* → `hitungHarga(int jumlah)` di `Produk.java:61`.
- *"Mana enkapsulasinya?"* → atribut `stok` private (`Produk.java:12`), diubah lewat `setStok()` (`Produk.java:45`) yang menolak nilai negatif.
- *"Mana inheritance-nya?"* → `Makanan.java:2`, `extends Produk`, sehingga Makanan otomatis punya nama, harga, stok.
- *"Mana polimorfismenya?"* → `ItemTransaksi.java:17`: `produk.hitungHarga(jumlah)` dipanggil lewat tipe `Produk`, tapi hasil hitungnya berbeda untuk Makanan (pajak 10%) dan Minuman (pajak 5%).
- *"Beda class dan objek?"* → class itu `Produk`/`Makanan` (cetakan), objek itu `Nasi Goreng` hasil `new` di `Main.java:6`.
- *"Beda overloading dan overriding?"* → overloading: `Produk.java:57` dan `:61` (satu class, parameter beda). Overriding: `Makanan.java:16` menimpa method abstract milik `Produk` (beda class, signature sama).
