/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class taikhoanbean implements Serializable{
    private String SoTaiKhoan;
    private String HoTen;
    private long SoTien;
    private String MatKhau;

    public taikhoanbean() {
    }

    public taikhoanbean(String SoTaiKhoan, String HoTen, long SoTien, String MatKhau) {
        this.SoTaiKhoan = SoTaiKhoan;
        this.HoTen = HoTen;
        this.SoTien = SoTien;
        this.MatKhau = MatKhau;
    }

    public String getSoTaiKhoan() {
        return SoTaiKhoan;
    }

    public String getHoTen() {
        return HoTen;
    }

    public long getSoTien() {
        return SoTien;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setSoTaiKhoan(String SoTaiKhoan) {
        this.SoTaiKhoan = SoTaiKhoan;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public void setSoTien(long SoTien) {
        this.SoTien = SoTien;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }
    
    
}
