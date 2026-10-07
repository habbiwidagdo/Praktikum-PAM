# My Profile App - Tugas Praktikum P3

Aplikasi ini adalah hasil dari tugas praktikum Pertemuan 3 untuk mata kuliah Pengembangan Aplikasi Mobile (Institut Teknologi Sumatera). Aplikasi ini dibangun menggunakan **Compose Multiplatform** dengan menerapkan paradigma UI Deklaratif.

## Screenshot Aplikasi

<!-- Ganti path/URL di dalam kurung dengan lokasi file screenshot Anda -->
**Tampilan Android:**  
![Screenshot Android](img\android.png)

## Penjelasan Kode

Sesuai dengan instruksi modul P3, UI aplikasi ini dibagi menjadi 3 fungsi `@Composable` utama yang dapat digunakan kembali (*reusable*), dan dirangkai pada satu layar utama (`ProfileScreen`). Seluruh kode diletakkan di dalam modul `commonMain`.

### 1. `ProfileHeader`
Fungsi ini bertugas menampilkan avatar pengguna, nama, dan bio.
* Menggunakan `Box` sebagai *container* utama untuk *alignment*.
* Menggunakan `Column` untuk menyusun avatar dan teks secara vertikal.
* Tampilan avatar menggunakan `Box` berukuran statis dengan `Modifier.clip(CircleShape)` untuk membentuk lingkaran yang rapi.

### 2. `InfoItem`
Fungsi ini adalah komponen terkecil yang digunakan untuk menampilkan baris informasi spesifik (Email, Telepon, Lokasi).
* Menggunakan `Row` agar `Icon` dan `Text` (informasi) tersusun menyamping (horizontal).
* `verticalAlignment = Alignment.CenterVertically` digunakan agar ikon dan teks sejajar di tengah.

### 3. `ProfileCard`
Fungsi ini membungkus kumpulan informasi detail.
* Menggunakan komponen `Card` dari Material 3 yang diberikan elevasi (`CardDefaults.cardElevation`) untuk menghasilkan efek bayangan (*shadow*) dan `RoundedCornerShape` agar sudutnya melengkung.
* Di dalamnya terdapat `Column` yang memanggil `InfoItem` berulang kali, dipisahkan oleh komponen `Divider` (garis pemisah).

### 4. `ProfileScreen`
Ini adalah layar utama aplikasi yang memanggil seluruh komponen di atas.
* Dibungkus dengan `Column` utama yang menutupi seluruh layar (`Modifier.fillMaxSize()`).
* Menggunakan `modifier = Modifier.verticalScroll(rememberScrollState())` agar halaman dapat di-*scroll* (digulir) pada layar perangkat yang lebih kecil.
* Terdapat komponen tambahan berupa `Button` di bagian bawah.

---

## Cara Menjalankan Aplikasi

Karena ini adalah proyek Compose Multiplatform, Anda dapat menjalankannya di berbagai platform.

### Persiapan:
1. Buka proyek ini menggunakan **Android Studio** atau **IntelliJ IDEA**.
2. Pastikan koneksi internet aktif agar Gradle dapat mengunduh dependensi (termasuk pustaka *Material Icons Extended*).
3. Tunggu hingga proses **Gradle Sync** selesai (tidak ada *error* merah di panel bawah).

### Menjalankan di Android:
1. Di bagian atas IDE, pada kotak *Run/Debug Configurations*, pilih modul **`composeApp`** atau **`androidApp`**.
2. Pilih *device* fisik atau Android Emulator yang sudah berjalan.
3. Klik tombol **Run** (ikon segitiga hijau/Play).

### Menjalankan di Desktop (JVM):
1. Buka tab **Terminal** yang ada di bagian bawah IDE.
2. Ketikkan perintah berikut dan tekan Enter:
   ```bash
   ./gradlew desktop:run
   ```
   *(Atau gunakan panel Gradle di sebelah kanan: navigasi ke `composeApp` -> `Tasks` -> `compose desktop` -> klik dua kali pada `run`)*.