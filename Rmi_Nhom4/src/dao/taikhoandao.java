/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.taikhoanbean;
import bo.KetNoi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class taikhoandao{
    
    public taikhoanbean ktDangNhap(String SoTaiKhoan, String MatKhau) throws SQLException{
//        ArrayList<taikhoanbean> ds= new ArrayList<taikhoanbean>();
        String sql="select * from TaiKhoan where SoTaiKhoan = ? and MatKhau = ?";
        PreparedStatement cmd= KetNoi.cn.prepareStatement(sql);
        //Truyen cau lenh vao tham so
        cmd.setString(1,SoTaiKhoan);
        cmd.setString(2,MatKhau);
        
        //Thuc hien
        ResultSet rs= cmd.executeQuery();
        taikhoanbean tk = null;
        if (rs.next()){
            String soTk=rs.getString("SoTaiKhoan");
            String hTen=rs.getString("HoTen");
            Long soTien=rs.getLong("SoTien");
            String Mk=rs.getString("MatKhau");
            tk= new taikhoanbean(soTk, hTen, soTien, Mk);
        }
	rs.close();
	return tk;
    }
    
    public int doiMK (String SoTaiKhoan, String MatKhauCu, String MatKhauMoi) throws SQLException {
        String sql="update TaiKhoan set MatKhau = ? where SoTaiKhoan = ? and MatKhau = ?";
        PreparedStatement cmd= KetNoi.cn.prepareStatement(sql);
        
        cmd.setString(1, MatKhauMoi);
        cmd.setString(2, SoTaiKhoan);
        cmd.setString(3, MatKhauCu);
        
        return cmd.executeUpdate();
    }
    
    public taikhoanbean DoiMatKhau (String SoTaiKhoan, String MatKhauCu, String MatKhauMoi) throws SQLException{
        
        int dmk = doiMK(SoTaiKhoan, MatKhauCu, MatKhauMoi);
        taikhoanbean tkb = null;
        if (dmk >= 1) {
            String sql2="select * from TaiKhoan where SoTaiKhoan = ? and MatKhau = ?";
            PreparedStatement cmd= KetNoi.cn.prepareStatement(sql2);
            cmd.setString(1,SoTaiKhoan);
            cmd.setString(2,MatKhauMoi);
            
            ResultSet rs= cmd.executeQuery();
                while (rs.next()){
                String soTk=rs.getString("SoTaiKhoan");
                String hTen=rs.getString("HoTen");
                Long soTien=rs.getLong("SoTien");
                String Mk=rs.getString("MatKhau");
                tkb= new taikhoanbean(soTk, hTen, soTien, Mk);
                
            }
            rs.close();
        }
        return tkb;
    }
    
    public long getSoTien(String SoTaiKhoan)throws SQLException {
        String sql="select SoTien from TaiKhoan where SoTaiKhoan = ?";
        PreparedStatement cmd= KetNoi.cn.prepareStatement(sql);
        cmd.setString(1,SoTaiKhoan);
        ResultSet rs= cmd.executeQuery();
        long soTien = 0;
        if (rs.next()){
            soTien=rs.getLong("SoTien");
        }
        rs.close();
        return soTien;
    }
    
    public taikhoanbean ThayDoiSoTien(String SoTaiKhoan, long SoTienRut) throws SQLException {
        
        taikhoanbean tkb = null;
        long sotienTk = getSoTien(SoTaiKhoan);
        if(sotienTk > SoTienRut) {
            long soTienMoi = sotienTk - SoTienRut;
            String sql1="update TaiKhoan set SoTien = ? where SoTaiKhoan = ?";
            PreparedStatement cmd= KetNoi.cn.prepareStatement(sql1);

            cmd.setLong(1, soTienMoi);
            cmd.setString(2, SoTaiKhoan);
            cmd.executeUpdate();
            
            chitiettaikhoandao cttkdao = new chitiettaikhoandao();
            Date d = new Date();
            try {
                cttkdao.Them(d, SoTienRut, SoTaiKhoan, "Rut tien");
            } catch (Exception ex) {
                 ex.printStackTrace();
            }
            String sql2="select * from TaiKhoan where SoTaiKhoan = ?";
            cmd= KetNoi.cn.prepareStatement(sql2);
            cmd.setString(1,SoTaiKhoan);

            ResultSet rs= cmd.executeQuery();
            while (rs.next()){
                String soTk=rs.getString("SoTaiKhoan");
                String hTen=rs.getString("HoTen");
                Long soTien=rs.getLong("SoTien");
                String Mk=rs.getString("MatKhau");
                tkb= new taikhoanbean(soTk, hTen, soTien, Mk);       
            }
            rs.close();
            return tkb;
        }
        
        return tkb;
    }
    
    public taikhoanbean ChuyenTien (String SoTaiKhoanChuyen, long SoTienRut, String SoTaiKhoanNhan) throws SQLException {
        
        taikhoanbean tkbean = null;
        long tienTkChuyen = getSoTien(SoTaiKhoanChuyen);
        long tienTkNhan = getSoTien(SoTaiKhoanNhan);
        
        if(tienTkChuyen > SoTienRut) {
            String sql="update TaiKhoan set SoTien = ? where SoTaiKhoan = ?";
            PreparedStatement cmd= KetNoi.cn.prepareStatement(sql);
            cmd.setLong(1,tienTkChuyen - SoTienRut);
            cmd.setString(2, SoTaiKhoanChuyen);
            cmd.executeUpdate();
            
            cmd= KetNoi.cn.prepareStatement(sql);
            cmd.setLong(1,tienTkNhan + SoTienRut);
            cmd.setString(2, SoTaiKhoanNhan);
            cmd.executeUpdate();
            
            try {
                Date d = new Date();
                chitiettaikhoandao cttkdao = new chitiettaikhoandao();
                cttkdao.Them(d, SoTienRut, SoTaiKhoanChuyen, "Chuyen tien");
            } catch (Exception ex) {
                 ex.printStackTrace();
            }
            
            String sql2="select * from TaiKhoan where SoTaiKhoan = ?";
            cmd= KetNoi.cn.prepareStatement(sql2);
            //Truyen cau lenh vao tham so
            cmd.setString(1,SoTaiKhoanChuyen);
            //Thuc hien
            ResultSet rs= cmd.executeQuery();
            if (rs.next()){
                String soTk=rs.getString("SoTaiKhoan");
                String hTen=rs.getString("HoTen");
                Long soTien=rs.getLong("SoTien");
                String Mk=rs.getString("MatKhau");
                tkbean= new taikhoanbean(soTk, hTen, soTien, Mk);
            }
            rs.close();
            return tkbean;
        }
        return tkbean;
    }
}
