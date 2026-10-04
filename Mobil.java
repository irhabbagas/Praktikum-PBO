package com.mycompany.vehiclemanagement;

public class Mobil extends Kendaraan {
    private int jumlahPintu;

    public Mobil(String merk, String model, int tahun, int jumlahPintu) {
        super(merk, model, tahun);
        setJumlahPintu(jumlahPintu);
    }

    public int getJumlahPintu() {
        return this.jumlahPintu;
    }

    public void setJumlahPintu(int jumlahPintu) {
        if (jumlahPintu > 0) {
            this.jumlahPintu = jumlahPintu;
        } else {
            this.jumlahPintu = 4;
        }
    }

    @Override
    public void tampilkanInfo() {
        System.out.print("[MOBIL] ");
        super.tampilkanInfo();
        System.out.printf(" | Pintu: %d Hal%n", this.jumlahPintu);
    }

    @Override
    public void servisRutin() {
        System.out.println("-> Servis Mobil: Ganti oli mesin, cek rem, dan rotasi ban.");
    }
}
