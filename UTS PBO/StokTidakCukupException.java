// INHERITANCE: exception buatan sendiri mewarisi class Exception
public class StokTidakCukupException extends Exception {
    public StokTidakCukupException(String namaProduk, int diminta, int tersedia) {
        super("Stok " + namaProduk + " tidak cukup (diminta " + diminta
                + ", tersedia " + tersedia + ")");
    }
}
