package main;

import model.Transaksi;
import model.Antrean;
import model.Buku;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PerpustakaanKampus {

    static String[] kategori = {"Pemrograman", "Matematika", "Jaringan Komputer", "Basis Data"};
    static String[] namaHari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu"};

    static int[][] peminjaman = new int[kategori.length][namaHari.length];

    static final int LANTAI = 3;
    static final int RAK = 3;
    static final int POSISI = 5;
    static String[][][] lokasi = new String[LANTAI][RAK][POSISI];

    static ArrayList<Buku> daftarBuku = new ArrayList<>();

    static Stack<Transaksi> riwayat = new Stack<>();

    static Queue<Antrean> antrean = new LinkedList<>();

    static Scanner input = new Scanner(System.in);

    static int bacaAngka(String pesan, int min, int max) {
        while (true) {
            System.out.print(pesan);
            String teks = input.nextLine().trim();
            try {
                int angka = Integer.parseInt(teks);
                if (angka >= min && angka <= max) {
                    return angka;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Input tidak valid. Masukkan angka " + min + " - " + max + ".");
        }
    }

    static String bacaTeks(String pesan) {
        String teks = "";
        while (teks.isEmpty()) {
            System.out.print(pesan);
            teks = input.nextLine().trim();
            if (teks.isEmpty()) {
                System.out.println("Input tidak boleh kosong.");
            }
        }
        return teks;
    }

    static Buku cariBuku(String kode) {
        for (Buku b : daftarBuku) {
            if (b.getKode().equalsIgnoreCase(kode)) {
                return b;
            }
        }
        return null;
    }

    static void catatLokasi(Buku b, String isi) {
        lokasi[b.getLantai()][b.getRak()][b.getPosisi()] = isi;
    }

    static String teksLokasi(Buku b) {
        return "L" + (b.getLantai() + 1) + "-R" + (b.getRak() + 1) + "-P" + (b.getPosisi() + 1);
    }

    static void tampilKategori() {
        System.out.println("\n--- Kategori Buku (Array 1D) ---");
        for (int i = 0; i < kategori.length; i++) {
            System.out.println((i + 1) + ". " + kategori[i]);
        }
    }

    static void tambahBuku() {
        System.out.println("\n--- Tambah Buku (ArrayList + Array 3D) ---");
        String kode = bacaTeks("Kode buku: ").toUpperCase();
        if (cariBuku(kode) != null) {
            System.out.println("Kode buku sudah terdaftar.");
            return;
        }
        String judul = bacaTeks("Judul buku: ");
        tampilKategori();
        int kat = bacaAngka("Pilih kategori (1-" + kategori.length + "): ", 1, kategori.length) - 1;
        int lt = bacaAngka("Lantai (1-" + LANTAI + "): ", 1, LANTAI) - 1;
        int rk = bacaAngka("Rak (1-" + RAK + "): ", 1, RAK) - 1;
        int ps = bacaAngka("Posisi (1-" + POSISI + "): ", 1, POSISI) - 1;
        if (lokasi[lt][rk][ps] != null) {
            System.out.println("Lokasi sudah terisi buku " + lokasi[lt][rk][ps] + ". Pilih lokasi lain.");
            return;
        }
        Buku buku = new Buku(kode, judul, kat, lt, rk, ps);
        daftarBuku.add(buku);
        catatLokasi(buku, kode);
        riwayat.push(new Transaksi("TAMBAH", buku, null, 0, daftarBuku.size() - 1));
        System.out.println("Buku berhasil ditambahkan.");
    }

    static void tampilBuku() {
        System.out.println("\n--- Daftar Buku (ArrayList) ---");
        if (daftarBuku.isEmpty()) {
            System.out.println("Belum ada buku.");
            return;
        }
        System.out.printf("%-3s %-8s %-28s %-18s %-9s %s%n", "No", "Kode", "Judul", "Kategori", "Lokasi", "Status");
        for (int i = 0; i < daftarBuku.size(); i++) {
            Buku b = daftarBuku.get(i);
            String status = b.isTersedia() ? "Tersedia" : "Dipinjam: " + b.getPeminjam();
            System.out.printf("%-3d %-8s %-28s %-18s %-9s %s%n", i + 1, b.getKode(), b.getJudul(),
                    kategori[b.getKategori()], teksLokasi(b), status);
        }
    }

    static void hapusBuku() {
        System.out.println("\n--- Hapus Buku (ArrayList + Array 3D) ---");
        Buku buku = cariBuku(bacaTeks("Kode buku yang dihapus: "));
        if (buku == null) {
            System.out.println("Buku tidak ditemukan.");
            return;
        }
        if (!buku.isTersedia()) {
            System.out.println("Buku sedang dipinjam, tidak dapat dihapus.");
            return;
        }
        int indeks = daftarBuku.indexOf(buku);
        daftarBuku.remove(indeks);
        catatLokasi(buku, null);
        riwayat.push(new Transaksi("HAPUS", buku, null, 0, indeks));
        System.out.println("Buku berhasil dihapus.");
    }

    static void tampilPeta() {
        System.out.println("\n--- Peta Lokasi Buku (Array 3D) ---");
        for (int l = 0; l < LANTAI; l++) {
            System.out.println("Lantai " + (l + 1));
            for (int r = 0; r < RAK; r++) {
                System.out.print("  Rak " + (r + 1) + ": ");
                for (int p = 0; p < POSISI; p++) {
                    String isi = lokasi[l][r][p] == null ? "[kosong]" : "[" + lokasi[l][r][p] + "]";
                    System.out.print(isi + " ");
                }
                System.out.println();
            }
        }
    }

    static void cariLokasi() {
        System.out.println("\n--- Cari Lokasi Buku (Array 3D) ---");
        String kode = bacaTeks("Kode buku yang dicari: ");
        for (int l = 0; l < LANTAI; l++) {
            for (int r = 0; r < RAK; r++) {
                for (int p = 0; p < POSISI; p++) {
                    if (kode.equalsIgnoreCase(lokasi[l][r][p])) {
                        System.out.println("Ditemukan di Lantai " + (l + 1) + ", Rak " + (r + 1) + ", Posisi " + (p + 1));
                        return;
                    }
                }
            }
        }
        System.out.println("Buku tidak ditemukan di rak.");
    }

    static void daftarAntre() {
        System.out.println("\n--- Daftar Antrean Peminjaman (Queue) ---");
        String nama = bacaTeks("Nama mahasiswa: ");
        String kode = bacaTeks("Kode buku yang ingin dipinjam: ").toUpperCase();
        antrean.offer(new Antrean(nama, kode));
        System.out.println(nama + " masuk antrean nomor " + antrean.size() + ".");
    }

    static void tampilAntrean() {
        System.out.println("\n--- Antrean Peminjaman (Queue) ---");
        if (antrean.isEmpty()) {
            System.out.println("Antrean kosong.");
            return;
        }
        int no = 1;
        for (Antrean a : antrean) {
            System.out.println(no + ". " + a.getNama() + " -> " + a.getKodeBuku());
            no++;
        }
    }

    static void layaniAntrean() {
        System.out.println("\n--- Layani Antrean (Queue + Array 2D + Stack) ---");
        if (antrean.isEmpty()) {
            System.out.println("Antrean kosong.");
            return;
        }
        Antrean a = antrean.poll();
        System.out.println("Melayani: " + a.getNama() + " (buku " + a.getKodeBuku() + ")");
        Buku buku = cariBuku(a.getKodeBuku());
        if (buku == null) {
            System.out.println("Buku tidak ditemukan. " + a.getNama() + " dikeluarkan dari antrean.");
            return;
        }
        if (!buku.isTersedia()) {
            System.out.println("Buku sedang dipinjam oleh " + buku.getPeminjam() + ". Silakan antre kembali.");
            return;
        }
        int hari = bacaAngka("Hari peminjaman (1=Senin ... 7=Minggu): ", 1, 7) - 1;
        buku.setPeminjam(a.getNama());
        peminjaman[buku.getKategori()][hari]++;
        riwayat.push(new Transaksi("PINJAM", buku, a.getNama(), hari, -1));
        System.out.println("Peminjaman berhasil: " + buku.getJudul() + " dipinjam " + a.getNama()
                + " pada hari " + namaHari[hari] + ".");
    }

    static void kembalikanBuku() {
        System.out.println("\n--- Pengembalian Buku (Stack) ---");
        Buku buku = cariBuku(bacaTeks("Kode buku yang dikembalikan: "));
        if (buku == null) {
            System.out.println("Buku tidak ditemukan.");
            return;
        }
        if (buku.isTersedia()) {
            System.out.println("Buku ini tidak sedang dipinjam.");
            return;
        }
        String nama = buku.getPeminjam();
        buku.setPeminjam(null);
        riwayat.push(new Transaksi("KEMBALI", buku, nama, 0, -1));
        System.out.println("Buku " + buku.getJudul() + " dikembalikan oleh " + nama + ".");
    }

    static void tampilStatistik() {
        System.out.println("\n--- Statistik Peminjaman: Kategori x Hari (Array 2D) ---");
        System.out.printf("%-20s", "Kategori");
        for (String h : namaHari) {
            System.out.printf("%-8s", h);
        }
        System.out.println("Total");
        for (int i = 0; i < kategori.length; i++) {
            int total = 0;
            System.out.printf("%-20s", kategori[i]);
            for (int j = 0; j < namaHari.length; j++) {
                System.out.printf("%-8d", peminjaman[i][j]);
                total += peminjaman[i][j];
            }
            System.out.println(total);
        }
    }

    static void lihatTransaksiTerakhir() {
        System.out.println("\n--- Transaksi Terakhir (Stack) ---");
        if (riwayat.isEmpty()) {
            System.out.println("Belum ada transaksi.");
            return;
        }
        System.out.println("Transaksi terakhir: " + riwayat.peek());
    }

    static void tampilRiwayat() {
        System.out.println("\n--- Riwayat Transaksi, terbaru di atas (Stack) ---");
        if (riwayat.isEmpty()) {
            System.out.println("Belum ada transaksi.");
            return;
        }
        for (int i = riwayat.size() - 1; i >= 0; i--) {
            System.out.println((riwayat.size() - i) + ". " + riwayat.get(i));
        }
    }

    static void batalkanTransaksi() {
        System.out.println("\n--- Batalkan Transaksi Terakhir (Stack) ---");
        if (riwayat.isEmpty()) {
            System.out.println("Belum ada transaksi yang bisa dibatalkan.");
            return;
        }
        Transaksi t = riwayat.pop();
        Buku buku = t.getBuku();
        switch (t.getJenis()) {
            case "TAMBAH":
                daftarBuku.remove(buku);
                catatLokasi(buku, null);
                break;
            case "HAPUS":
                daftarBuku.add(t.getIndeks(), buku);
                catatLokasi(buku, buku.getKode());
                break;
            case "PINJAM":
                buku.setPeminjam(null);
                peminjaman[buku.getKategori()][t.getHari()]--;
                break;
            case "KEMBALI":
                buku.setPeminjam(t.getNama());
                break;
        }
        System.out.println("Transaksi dibatalkan: " + t);
    }

    static void dataAwal() {
        Buku[] contoh = {
            new Buku("PRG-01", "Dasar Pemrograman Java", 0, 0, 0, 0),
            new Buku("MTK-01", "Kalkulus Dasar", 1, 0, 1, 0),
            new Buku("JKM-01", "Jaringan Komputer", 2, 1, 0, 0),
            new Buku("BSD-01", "Sistem Basis Data", 3, 1, 1, 0)
        };
        for (Buku b : contoh) {
            daftarBuku.add(b);
            catatLokasi(b, b.getKode());
        }
    }

    static void tampilMenu() {
        System.out.println("\n===== SISTEM MANAJEMEN PERPUSTAKAAN KAMPUS =====");
        System.out.println("-- Koleksi Buku --");
        System.out.println(" 1. Tampilkan kategori buku         (Array 1D)");
        System.out.println(" 2. Tambah buku                     (ArrayList + Array 3D)");
        System.out.println(" 3. Tampilkan daftar buku           (ArrayList)");
        System.out.println(" 4. Hapus buku                      (ArrayList + Array 3D)");
        System.out.println("-- Lokasi Penyimpanan --");
        System.out.println(" 5. Tampilkan peta lokasi rak       (Array 3D)");
        System.out.println(" 6. Cari lokasi buku                (Array 3D)");
        System.out.println("-- Peminjaman --");
        System.out.println(" 7. Daftar antrean peminjaman       (Queue)");
        System.out.println(" 8. Layani antrean berikutnya       (Queue + Array 2D + Stack)");
        System.out.println(" 9. Tampilkan antrean               (Queue)");
        System.out.println("10. Kembalikan buku                 (Stack)");
        System.out.println("11. Statistik peminjaman            (Array 2D)");
        System.out.println("-- Riwayat Transaksi --");
        System.out.println("12. Lihat transaksi terakhir        (Stack)");
        System.out.println("13. Batalkan transaksi terakhir     (Stack)");
        System.out.println("14. Tampilkan seluruh riwayat       (Stack)");
        System.out.println(" 0. Keluar");
    }

    public static void main(String[] args) {
        dataAwal();
        int pilihan;
        do {
            tampilMenu();
            pilihan = bacaAngka("Pilih menu (0-14): ", 0, 14);
            switch (pilihan) {
                case 1: tampilKategori(); break;
                case 2: tambahBuku(); break;
                case 3: tampilBuku(); break;
                case 4: hapusBuku(); break;
                case 5: tampilPeta(); break;
                case 6: cariLokasi(); break;
                case 7: daftarAntre(); break;
                case 8: layaniAntrean(); break;
                case 9: tampilAntrean(); break;
                case 10: kembalikanBuku(); break;
                case 11: tampilStatistik(); break;
                case 12: lihatTransaksiTerakhir(); break;
                case 13: batalkanTransaksi(); break;
                case 14: tampilRiwayat(); break;
                case 0: System.out.println("Terima kasih. Program selesai."); break;
            }
        } while (pilihan != 0);
    }
}
