# Minpro-2-PBO-SistemSewaAlatSnorkeling

**Nama:** Muhammad Farel Awaluddin  
**NIM:** 2509116055  
**Kelas:** B  

## 1. Deskripsi Program

Sistem Manajemen Sewa Alat Snorkeling & Diving merupakan program berbasis Java yang digunakan untuk mengelola data alat snorkeling dan diving serta proses penyewaan alat.

Program ini dibuat sebagai Mini Project 2 pada Praktikum Pemrograman Berorientasi Objek (PBO). Program dikembangkan dengan menerapkan konsep constructor, access modifier, encapsulation, inheritance, polymorphism, ArrayList, validasi input, dan MVC (Model-View-Controller).

Program memiliki fitur utama berupa pengelolaan data alat, pembuatan penyewaan, melihat data penyewaan, dan pengembalian alat.

## 2. Fitur Program

Fitur yang tersedia dalam program:

- Menambahkan data alat.
- Menampilkan data alat.
- Mengubah data alat.
- Menghapus data alat.
- Membuat penyewaan alat.
- Menampilkan data penyewaan.
- Melakukan pengembalian alat.
- Mengurangi jumlah alat yang tersedia ketika alat disewa.
- Menambah kembali jumlah alat yang tersedia ketika alat dikembalikan.
- Validasi input angka.
- Validasi jumlah unit berdasarkan stok yang tersedia.
- Validasi durasi sewa.
- Validasi ID alat agar tidak terjadi duplikasi.
- Menyediakan dummy data saat program pertama kali dijalankan.

## 3. Alur Program

Program dimulai dari menu utama yang menyediakan lima pilihan:

1. Kelola Data Alat
2. Buat Penyewaan
3. Lihat Data Penyewaan
4. Pengembalian Alat
5. Keluar

<img width="371" height="210" alt="image" src="https://github.com/user-attachments/assets/24a045cd-c5ba-4853-bdd8-e3ef6874deb0" />

Menu utama digunakan sebagai halaman awal untuk memilih proses yang ingin dilakukan pengguna. Pilihan `Keluar` digunakan untuk mengakhiri program.

Pada menu Kelola Data Alat, pengguna dapat melakukan proses tambah, lihat, ubah, dan hapus data alat.

<img width="373" height="426" alt="image" src="https://github.com/user-attachments/assets/595803f0-df0b-495f-b274-e2166bca900c" />

Menu Kelola Data Alat digunakan untuk mengelola data alat melalui proses tambah, lihat, ubah, dan hapus. Pilihan `Kembali` digunakan untuk kembali ke menu utama.

### Tambah Alat

Pengguna dapat menambahkan data alat baru dengan memasukkan ID alat, jenis alat, nama alat, ukuran, tarif per hari, kondisi, jumlah tersedia, serta data khusus sesuai jenis alat.

<img width="382" height="617" alt="image" src="https://github.com/user-attachments/assets/4811366d-857c-43ca-a0f5-75c906fc1a7f" />

Data alat yang berhasil ditambahkan akan disimpan ke dalam ArrayList dan dapat ditampilkan kembali melalui menu Lihat Alat.

### Tambah Alat Diving

Selain alat snorkeling, pengguna juga dapat menambahkan alat diving dengan memasukkan data umum alat serta kapasitas tabung.

<img width="381" height="617" alt="image" src="https://github.com/user-attachments/assets/7ef40d96-b7c7-4577-b9f5-edf1f090c5a3" />

Data alat diving kemudian disimpan ke dalam ArrayList sebagai object `AlatDiving`.

### Lihat Data Alat

Pengguna dapat melihat seluruh data alat yang tersimpan melalui menu Lihat Alat.

<img width="333" height="693" alt="image" src="https://github.com/user-attachments/assets/39357eb1-b7d6-4999-b12c-06bbdfecb778" />

Data yang ditampilkan berasal dari ArrayList dan mencakup informasi alat beserta data khusus sesuai jenis alat.

### Ubah Data Alat

Pengguna dapat mengubah data alat yang sudah tersimpan dengan memasukkan ID alat yang ingin diubah, kemudian memasukkan data baru.

<img width="322" height="357" alt="image" src="https://github.com/user-attachments/assets/27a076eb-ec74-461a-8e20-eb36200922a9" />

Setelah proses berhasil, data alat pada ArrayList diperbarui menggunakan setter yang tersedia pada class terkait.

### Hapus Data Alat

Pengguna dapat menghapus data alat dengan memasukkan ID alat yang ingin dihapus.

<img width="330" height="198" alt="image" src="https://github.com/user-attachments/assets/a350ee44-4ec4-4626-b378-2be87754bfc8" />

Jika ID alat ditemukan, data alat akan dihapus dari ArrayList dan program menampilkan pesan bahwa alat berhasil dihapus.

### Buat Penyewaan

Pengguna dapat membuat transaksi penyewaan dengan memasukkan data penyewa, memilih ID alat, menentukan jumlah unit, dan menentukan durasi sewa.

<img width="330" height="360" alt="image" src="https://github.com/user-attachments/assets/5f3007cf-8faf-4a14-893c-2c92f143cd4b" />

Sistem menghitung total biaya berdasarkan tarif per hari, jumlah unit, dan durasi sewa. Setelah penyewaan berhasil, jumlah alat yang tersedia akan berkurang sesuai jumlah unit yang disewa.

### Lihat Data Penyewaan

Pengguna dapat melihat seluruh transaksi penyewaan yang telah dibuat melalui menu Lihat Data Penyewaan.

<img width="335" height="361" alt="image" src="https://github.com/user-attachments/assets/8765edba-825f-4e61-b869-41710f621120" />

Data yang ditampilkan meliputi identitas penyewa, alat yang disewa, jumlah unit, durasi, total biaya, dan status penyewaan.

### Pengembalian Alat

Pengguna dapat melakukan pengembalian alat dengan memasukkan ID penyewaan yang masih berstatus aktif.

<img width="322" height="255" alt="image" src="https://github.com/user-attachments/assets/e3eaa3e5-0fa2-43a4-9bd3-f057c76eacac" />

Setelah pengembalian berhasil, jumlah alat yang tersedia akan ditambahkan kembali sesuai jumlah unit yang sebelumnya disewa.

Data penyewaan juga berubah status menjadi `DIKEMBALIKAN`.

<img width="323" height="360" alt="image" src="https://github.com/user-attachments/assets/828aa83b-fba0-4718-80e1-a44b2eeecd04" />

Program akan terus berjalan selama pengguna belum memilih menu Keluar.

## 4. Struktur Project

Program menggunakan beberapa package untuk menerapkan konsep MVC.

### Package main

- Main.java

Digunakan sebagai titik awal program.

### Package model

- AlatSelam.java
- AlatSnorkeling.java
- AlatDiving.java
- Penyewa.java
- Penyewaan.java

Digunakan untuk menyimpan struktur data dan object dalam program.

### Package view

- SewaAlatView.java

Digunakan untuk menampilkan menu dan menerima input dari pengguna.

### Package controller

- SewaAlatController.java

Digunakan untuk mengatur alur program, proses CRUD, validasi, penyewaan, dan pengembalian alat.

## 5. Encapsulation

Encapsulation diterapkan dengan menggunakan access modifier `private` pada atribut class.

Contohnya pada class `AlatSelam`:

    private String idAlat;
    private String namaAlat;
    private String ukuran;
    private double tarifPerHari;
    private String kondisi;
    private int jumlahTersedia;

Atribut tersebut tidak diakses secara langsung dari class lain. Akses terhadap data dilakukan menggunakan getter dan setter.

Contohnya:

    public String getNamaAlat() {
        return namaAlat;
    }

    public void setNamaAlat(String namaAlat) {
        this.namaAlat = namaAlat;
    }


<img width="642" height="771" alt="image" src="https://github.com/user-attachments/assets/0a2f85c0-b6d4-4296-b8f7-46cf772b24b8" />


Dengan demikian, data object dapat diakses melalui method yang telah disediakan.

## 6. Inheritance

Inheritance diterapkan dengan menggunakan class `AlatSelam` sebagai superclass dan dua subclass, yaitu `AlatSnorkeling` dan `AlatDiving`.

Struktur inheritance:

    AlatSelam
        |
        +-- AlatSnorkeling
        |
        +-- AlatDiving

Class `AlatSnorkeling` menggunakan:

    extends AlatSelam

<img width="805" height="260" alt="image" src="https://github.com/user-attachments/assets/fd1eb6c0-fb6c-49b8-8780-eb0ce792652c" />

Class `AlatDiving` juga menggunakan:

    extends AlatSelam

<img width="802" height="255" alt="image" src="https://github.com/user-attachments/assets/e15c7382-2c9d-4c08-ae46-632ea9ae005d" />

Kedua subclass mewarisi data dan method dari `AlatSelam` serta memiliki atribut khusus masing-masing.

`AlatSnorkeling` memiliki atribut khusus:

    private String jenisMasker;

Sedangkan `AlatDiving` memiliki atribut khusus:

    private int kapasitasTabung;

## 7. Polymorphism

Polymorphism diterapkan melalui method overriding pada method `tampilkanInfo()`.

Pada class `AlatSelam` terdapat method:

    public void tampilkanInfo()

Method tersebut kemudian dioverride oleh `AlatSnorkeling` dan `AlatDiving` menggunakan annotation `@Override`.

<img width="701" height="227" alt="image" src="https://github.com/user-attachments/assets/67c18fad-3e78-4435-b2dd-514c52a2717b" />

<img width="718" height="213" alt="image" src="https://github.com/user-attachments/assets/fc7d9eb5-32f5-4aeb-a8fc-be0ab6058d8a" />

Pada `AlatSnorkeling`, method `tampilkanInfo()` menampilkan informasi tambahan berupa jenis masker.

Pada `AlatDiving`, method `tampilkanInfo()` menampilkan informasi tambahan berupa kapasitas tabung.

Data alat disimpan menggunakan:

    ArrayList<AlatSelam>

Object `AlatSnorkeling` dan `AlatDiving` dapat disimpan dalam ArrayList tersebut karena keduanya merupakan subclass dari `AlatSelam`.

<img width="677" height="105" alt="image" src="https://github.com/user-attachments/assets/6cfd96f9-b286-4bec-9be3-9c99f971241a" />

Ketika `tampilkanInfo()` dipanggil, method yang dijalankan menyesuaikan dengan object yang digunakan.

## 8. MVC (Model-View-Controller)

Program menggunakan pola MVC untuk memisahkan bagian data, tampilan, dan pengendalian program.

<img width="388" height="325" alt="image" src="https://github.com/user-attachments/assets/c26cbcb5-c11b-4af3-8886-829985e50388" />

Struktur package tersebut menunjukkan pemisahan komponen program berdasarkan pola MVC.

### Model

Model terdiri dari:

- AlatSelam
- AlatSnorkeling
- AlatDiving
- Penyewa
- Penyewaan

Model digunakan untuk menyimpan struktur data dan informasi object.

### View

View terdiri dari:

- SewaAlatView

View digunakan untuk menampilkan menu, menerima input, dan menampilkan pesan kepada pengguna.

### Controller

Controller terdiri dari:

- SewaAlatController

Controller menghubungkan View dengan Model serta mengatur proses program seperti CRUD, penyewaan, pengembalian alat, dan validasi.

### Main

Main digunakan sebagai titik awal program untuk membuat object View dan Controller kemudian menjalankan program.

## 9. Validasi Input

Program menerapkan beberapa validasi untuk mencegah input yang tidak sesuai.

### Validasi Input Angka

Jika pengguna memasukkan teks pada input yang membutuhkan angka, program akan menampilkan pesan bahwa input harus berupa angka.

<img width="322" height="221" alt="image" src="https://github.com/user-attachments/assets/e461e49a-e69c-427e-8e1f-ccf52ea79284" />

Validasi ini digunakan pada input yang membutuhkan nilai angka seperti tarif, jumlah alat, jumlah unit, durasi sewa, dan kapasitas tabung.

### Validasi ID Alat Duplikat

ID alat harus unik dan tidak boleh sama dengan ID alat yang sudah tersimpan.

<img width="330" height="252" alt="image" src="https://github.com/user-attachments/assets/d7ff7234-1338-49f1-823e-bc8157e74872" />

Jika ID alat sudah digunakan, program akan menghentikan proses penambahan dan menampilkan pesan bahwa ID alat sudah digunakan.

### Validasi Jenis Alat

Pengguna hanya dapat memilih jenis alat yang tersedia, yaitu Alat Snorkeling atau Alat Diving.

<img width="317" height="371" alt="image" src="https://github.com/user-attachments/assets/84b73b0e-c106-42f8-93b8-423c7b89565a" />

Jika pengguna memasukkan pilihan jenis alat selain 1 atau 2, program akan menampilkan pesan `Jenis alat tidak tersedia`.

### Validasi Tarif Per Hari

Tarif per hari harus memiliki nilai lebih dari 0.

<img width="322" height="415" alt="image" src="https://github.com/user-attachments/assets/6e120bd0-698a-433c-945d-ee804fab5a2f" />

Jika pengguna memasukkan tarif 0 atau nilai negatif, proses penambahan data dihentikan dan program menampilkan pesan bahwa tarif per hari harus lebih dari 0.

### Validasi Jumlah Tersedia

Jumlah alat yang tersedia harus memiliki nilai lebih dari 0.

<img width="327" height="448" alt="image" src="https://github.com/user-attachments/assets/40490378-e65e-46ba-8994-8e8ee591a4d0" />

Jika pengguna memasukkan jumlah tersedia 0 atau nilai negatif, program akan menghentikan proses penambahan data dan menampilkan pesan bahwa jumlah tersedia harus lebih dari 0.

### Validasi Jumlah Unit

Jumlah unit yang disewa tidak boleh melebihi jumlah alat yang tersedia.

<img width="322" height="313" alt="image" src="https://github.com/user-attachments/assets/eb28a946-71aa-4ac0-822c-c8c160f0e132" />

Jika jumlah unit yang dimasukkan lebih besar daripada stok alat, program akan menolak penyewaan dan menampilkan pesan `Jumlah unit melebihi stok yang tersedia`.

### Validasi Durasi Sewa

Durasi penyewaan harus memiliki nilai lebih dari 0 hari.

<img width="325" height="327" alt="image" src="https://github.com/user-attachments/assets/c8977a7f-451c-4fd5-a563-0a48a58fec10" />

Jika pengguna memasukkan durasi 0 atau nilai negatif, program akan menolak penyewaan dan menampilkan pesan `Durasi sewa harus lebih dari 0`.

### Validasi Kapasitas Tabung

Untuk alat diving, kapasitas tabung harus memiliki nilai lebih dari 0.

<img width="322" height="455" alt="image" src="https://github.com/user-attachments/assets/aacd0995-de44-46a7-8101-ad58abbff3fa" />

Jika pengguna memasukkan kapasitas tabung 0 atau nilai negatif, program akan menghentikan proses penambahan dan menampilkan pesan `Kapasitas tabung harus lebih dari 0`.

### Validasi ID Penyewaan

Pada proses pengembalian, sistem memeriksa apakah ID penyewaan yang dimasukkan terdapat dalam daftar transaksi.

<img width="328" height="250" alt="image" src="https://github.com/user-attachments/assets/d6b2aeb6-5b54-4c16-960b-53f0cdaaee8f" />

Jika ID penyewaan tidak ditemukan, proses pengembalian tidak dilakukan dan program menampilkan pesan `ID Penyewaan tidak ditemukan.`.

### Validasi Pengembalian

Sistem memeriksa status penyewaan sebelum melakukan pengembalian alat.

<img width="327" height="241" alt="image" src="https://github.com/user-attachments/assets/c2554663-3428-4418-8d9b-3f875436bd0f" />

Jika penyewaan sudah memiliki status `DIKEMBALIKAN`, sistem tidak akan melakukan pengembalian untuk kedua kalinya dan menampilkan pesan `Alat sudah dikembalikan`.

## 10. Dummy Data

Program menyediakan dummy data yang dimasukkan ke dalam ArrayList ketika program pertama kali dijalankan.

<img width="332" height="466" alt="image" src="https://github.com/user-attachments/assets/9690d45a-08aa-4349-8786-19e8a8b44d6a" />

Dengan adanya dummy data, pengguna dapat langsung memilih menu Lihat Alat tanpa harus memasukkan data terlebih dahulu. Dummy data juga digunakan untuk membantu proses pengujian program.

## 11. Teknologi yang Digunakan

- Java
- NetBeans
- Maven
- ArrayList
- Git dan GitHub
- MVC (Model-View-Controller)

## 12. Kesimpulan

Program Sistem Manajemen Sewa Alat Snorkeling & Diving dibuat sebagai penerapan konsep Pemrograman Berorientasi Objek pada Praktikum PBO.

Program menerapkan constructor, access modifier, encapsulation, inheritance, polymorphism, ArrayList, validasi input, CRUD, dan MVC. Program juga menyediakan dummy data sehingga data dapat langsung ditampilkan ketika program pertama kali dijalankan.