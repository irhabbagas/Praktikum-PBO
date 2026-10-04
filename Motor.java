package com.mycompany.vehiclemanagement;

public class Motor extends Kendaraan {
    private String tipeMesin;

    public Motor(String merk, String model, int tahun, String tipeMesin) {
        super(merk, model, tahun);
        this.tipeMesin = tipeMesin;
    }

    public String getTipeMesin() {
        return this.tipeMesin;
    }

    public void setTipeMesin(String tipeMesin) {
        this.tipeMesin = tipeMesin;
    }

    @Override
    public void tampilkanInfo() {
        System.out.print("[MOTOR] ");
        super.tampilkanInfo();
        System.out.printf(" | Tipe Mesin: %s%n", this.tipeMesin);
    }

    @Override
    public void servisRutin() {
        System.out.println("-> Servis Motor: Cek rantai/cvt, bersihkan busi, dan ganti oli samping/mesin.");
    }
}
