/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.chitiettaikhoanbean;
import bean.taikhoanbean;
import bo.KetNoi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author USER
 */
public class chitiettaikhoandao {
    public int Them(Date NgayRutTien, long SoTienRutRa, String SoTaiKhoan, String GhiChu)throws Exception{
        String sql="INSERT INTO ChiTietTaiKhoan(NgayRutTien, SoTienRutRa, SoTaiKhoan, Ghichu) VALUES (?,?,?,?)";
        PreparedStatement cmd= KetNoi.cn.prepareStatement(sql);
        //Truyen cau lenh vao tham so
        java.sql.Date ns = new java.sql.Date(NgayRutTien.getTime());
        cmd.setDate(1, ns);
        cmd.setLong(2, SoTienRutRa);
        cmd.setString(3, SoTaiKhoan);
        cmd.setString(4, GhiChu);
        //Thuc hien
        return cmd.executeUpdate();
    };
    
    public ArrayList<chitiettaikhoanbean> LichSuGiaoDich(String SoTaiKhoan) throws Exception{
        ArrayList<chitiettaikhoanbean> ds = new ArrayList<chitiettaikhoanbean>();
        
        String sql="select * from ChiTietTaiKhoan where SoTaiKhoan = ?";
        PreparedStatement cmd= KetNoi.cn.prepareStatement(sql);
        cmd.setString(1,SoTaiKhoan);
        
        ResultSet rs= cmd.executeQuery();
        while (rs.next()){
            long Id = rs.getLong("Id");
            Date NgayRutTien = rs.getDate("NgayRutTien");
            long SoTienRutRa = rs.getLong("SoTienRutRa");
            String SoTK = rs.getString("SoTaiKhoan");
            String GhiChu = rs.getString("Ghichu");
            chitiettaikhoanbean cttk= new chitiettaikhoanbean(Id, NgayRutTien, SoTienRutRa, SoTK, GhiChu);   
            ds.add(cttk);
        }
        rs.close();
        return ds;
    }
}
