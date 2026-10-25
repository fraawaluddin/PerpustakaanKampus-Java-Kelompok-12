package model;

public class Buku {
    private String kode;
    private String judul;
    private int kategori;
    private int lantai;
    private int rak;
    private int posisi;
    private String peminjam;

    public Buku(String kode, String judul, int kategori, int lantai, int rak, int posisi) {
        this.kode = kode;
        this.judul = judul;
        this.kategori = kategori;
        this.lantai = lantai;
        this.rak = rak;
        this.posisi = posisi;
        this.peminjam = null;
    }

    public String getKode() { return kode; }
    public String getJudul() { return judul; }
    public int getKategori() { return kategori; }
    public int getLantai() { return lantai; }
    public int getRak() { return rak; }
    public int getPosisi() { return posisi; }
    public String getPeminjam() { return peminjam; }
    public void setPeminjam(String peminjam) { this.peminjam = peminjam; }
    public boolean isTersedia() { return peminjam == null; }
}
