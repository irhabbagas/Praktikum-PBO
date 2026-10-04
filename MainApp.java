package com.mycompany.vehiclemanagement;

import java.util.Scanner;

public class MainApp {

    public static void cariKendaraan(String merk, Kendaraan[] daftar, int jumlah) {
        System.out.println("\n=== Hasil Pencarian berdasarkan Merk: " + merk + " ===");
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getMerk().equalsIgnoreCase(merk)) {
                System.out.print("- ");
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Kendaraan dengan merk tersebut tidak ditemukan.");
    }

    public static void cariKendaraan(int tahun, Kendaraan[] daftar, int jumlah) {
        System.out.println("\n=== Hasil Pencarian berdasarkan Tahun: " + tahun + " ===");
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getTahun() == tahun) {
                System.out.print("- ");
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Kendaraan buatan tahun tersebut tidak ditemukan.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Kendaraan[] daftarKendaraan = new Kendaraan[10];
        int jumlahKendaraan = 0;
        boolean isRunning = true;

        daftarKendaraan[jumlahKendaraan++] = new Mobil("Toyota", "Avanza", 2020, 5);
        daftarKendaraan[jumlahKendaraan++] = new Motor("Honda", "Vario 160", 2022, "4-Tak");
        daftarKendaraan[jumlahKendaraan++] = new Mobil("Honda", "Civic Turbo", 2023, 4);
        daftarKendaraan[jumlahKendaraan++] = new Motor("Yamaha", "RX-King", 2004, "2-Tak");

        System.out.println("=========================================");
        System.out.println("   SELAMAT DATANG DI VEHICLE MANAGER     ");
        System.out.println("=========================================");

        while (isRunning) {
            System.out.println("\n--- MENU UTAMA ---");
            System.out.println("1. Tambah Kendaraan Baru");
            System.out.println("2. Tampilkan Seluruh Kendaraan");
            System.out.println("3. Cari Kendaraan (Fitur Overloading)");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu (1-4): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> {
                    if (jumlahKendaraan < daftarKendaraan.length) {
                        System.out.println("\n-- Pilih Jenis Kendaraan --");
                        System.out.println("1. Mobil");
                        System.out.println("2. Motor");
                        System.out.print("Pilihan (1/2): ");
                        int jenis = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Merk  : ");
                        String merk = scanner.nextLine();
                        System.out.print("Masukkan Model : ");
                        String model = scanner.nextLine();
                        System.out.print("Masukkan Tahun : ");
                        int tahun = scanner.nextInt();
                        scanner.nextLine();

                        if (jenis == 1) {
                            System.out.print("Masukkan Jumlah Pintu: ");
                            int pintu = scanner.nextInt();
                            scanner.nextLine();
                            daftarKendaraan[jumlahKendaraan] = new Mobil(merk, model, tahun, pintu);
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Tipe Mesin: ");
                            String tipe = scanner.nextLine();
                            daftarKendaraan[jumlahKendaraan] = new Motor(merk, model, tahun, tipe);
                        }

                        jumlahKendaraan++;
                        System.out.println("Sukses! Data kendaraan berhasil ditambahkan.");
                    } else {
                        System.out.println("Kapasitas garasi/sistem sudah penuh!");
                    }
                }
                case 2 -> {
                    System.out.println("\n--- Daftar Seluruh Kendaraan ---");
                    if (jumlahKendaraan == 0) {
                        System.out.println("Belum ada data kendaraan.");
                    } else {
                        for (int i = 0; i < jumlahKendaraan; i++) {
                            System.out.printf("%d. ", (i + 1));
                            daftarKendaraan[i].tampilkanInfo();
                            daftarKendaraan[i].servisRutin();
                            System.out.println();
                        }
                        System.out.println("* Total Objek Kendaraan Terdaftar: " + Kendaraan.totalKendaraan);
                    }
                    System.out.print("Tekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                }
                case 3 -> {
                    System.out.println("\n-- Cari Kendaraan Berdasarkan --");
                    System.out.println("1. Merk (Teks)");
                    System.out.println("2. Tahun Pembuatan (Angka)");
                    System.out.print("Pilihan (1/2): ");
                    int kriteria = scanner.nextInt();
                    scanner.nextLine();

                    if (kriteria == 1) {
                        System.out.print("Masukkan Merk: ");
                        String m = scanner.nextLine();
                        cariKendaraan(m, daftarKendaraan, jumlahKendaraan);
                    } else if (kriteria == 2) {
                        System.out.print("Masukkan Tahun: ");
                        int t = scanner.nextInt();
                        scanner.nextLine();
                        cariKendaraan(t, daftarKendaraan, jumlahKendaraan);
                    } else {
                        System.out.println("Pilihan pencarian tidak valid.");
                    }
                    System.out.print("Tekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                }
                case 4 -> {
                    isRunning = false;
                    System.out.println("\nTerima kasih telah menggunakan aplikasi ini!");
                }
                default -> System.out.println("Pilihan tidak valid! Silahkan pilih angka 1-4.");
            }
        }
        scanner.close();
    }
}
