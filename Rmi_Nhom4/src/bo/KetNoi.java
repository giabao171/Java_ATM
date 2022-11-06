/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import bean.taikhoanbean;
import dao.chitiettaikhoandao;
import dao.taikhoandao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author USER
 */
public class KetNoi {
    public static Connection cn;
    public void KetNoi() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Da xac dinh HQTCSDL");
            String url = "jdbc:sqlserver://LAPTOP-NBTB1CPB:1433;databaseName=QLTaiKhoan;user=sa; password=0338876816";
            cn=DriverManager.getConnection(url);
            System.out.println("connected");

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) { 
        try {
            KetNoi kn = new KetNoi();
            kn.KetNoi();
            chitiettaikhoandao ctdao = new chitiettaikhoandao();
//            System.out.println(ctdao.LichSuGiaoDich("1"));
//            String st ="2022-12-12";
//            SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
//            Date ngay = dd.parse(st);
//            Date d = new Date();
//            ctdao.Them(d, 2222, "3", "them Tien");
             
            taikhoandao tkdao = new taikhoandao();
//            taikhoanbean tkbean = tkdao.ChuyenTien("1", 111, "3");
//            System.out.println(tkbean.getSoTien());
//            System.out.println(tkdao.ktDangNhap("1", "123"));
//            taikhoanbean tkbean = tkdao.ktDangNhap("1", "123");
//            taikhoanbean tkbean = tkdao.ThayDoiSoTien("1", 1);
                 
//            System.out.println(tkbean.getSoTien());
//                System.out.println(tkdao.getSoTien("1"));
        } catch (Exception e) {
            e.printStackTrace();        }
    }
}
