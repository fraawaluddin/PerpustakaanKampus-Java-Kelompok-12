package model;

import model.Buku;

public class Transaksi {
    private String jenis;
    private Buku buku;
    private String nama;
    private int hari;
    private int indeks;

    public Transaksi(String jenis, Buku buku, String nama, int hari, int indeks) {
        this.jenis = jenis;
        this.buku = buku;
        this.nama = nama;
        this.hari = hari;
        this.indeks = indeks;
    }

    public String getJenis() { return jenis; }
    public Buku getBuku() { return buku; }
    public String getNama() { return nama; }
    public int getHari() { return hari; }
    public int getIndeks() { return indeks; }

    @Override
    public String toString() {
        String teks = jenis + " | " + buku.getKode() + " - " + buku.getJudul();
        if (nama != null) {
            teks += " | " + nama;
        }
        return teks;
    }
}
