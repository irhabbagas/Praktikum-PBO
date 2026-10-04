package com.mycompany.vehiclemanagement;

public class Kendaraan {
    private String merk;
    private String model;
    private int tahun;

    public static int totalKendaraan = 0;

    public Kendaraan(String merk, String model, int tahun) {
        this.merk = merk;
        this.model = model;
        setTahun(tahun);
        totalKendaraan++;
    }

    public String getMerk() {
        return this.merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getTahun() {
        return this.tahun;
    }

    public void setTahun(int tahun) {
        if (tahun > 1800 && tahun <= 2026) {
            this.tahun = tahun;
        } else {
            System.out.println("[Peringatan] Tahun tidak valid! Diset ke default 2000.");
            this.tahun = 2000;
        }
    }

    public void tampilkanInfo() {
        System.out.printf("Merk: %-12s | Model: %-12s | Tahun: %d", this.merk, this.model, this.tahun);
    }

    public void servisRutin() {
        System.out.println("-> Lakukan pemeriksaan standar kendaraan.");
    }
}
