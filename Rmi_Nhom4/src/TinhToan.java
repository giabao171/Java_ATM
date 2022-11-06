
import bean.chitiettaikhoanbean;
import bean.taikhoanbean;
import dao.chitiettaikhoandao;
import dao.taikhoandao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */


public class TinhToan extends UnicastRemoteObject implements ITinhtoan{
    
    public TinhToan() throws RemoteException{};

    @Override
    public int Cong(int a, int b) throws Exception {
        int s = a+b;
        System.out.println("Tong: "+ s);
        return s;
    }

    @Override
    public int Tru(int a, int b) throws Exception {
        int s = a-b;
        System.out.println("Hieu: "+ s);
        return s;
    }
    
    @Override
    public int Nhan(int a, int b) throws Exception {
        int s = a*b;
        System.out.println("Tich: "+ s);
        return s;
    }
    
    public int Chia(int a, int b) throws Exception {
        int s = a/b;
        System.out.println("Thuong: "+ s);
        return s;
    }
    taikhoandao tk = new taikhoandao();
    chitiettaikhoandao cttkdao = new chitiettaikhoandao();
    
    @Override
    public taikhoanbean KtDn(String SoTaiKhoan, String MatKhau) throws Exception {
          return tk.ktDangNhap(SoTaiKhoan, MatKhau);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public taikhoanbean RutTien(String SoTaiKhoan, long SoTienRut) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        return tk.ThayDoiSoTien(SoTaiKhoan, SoTienRut);
    }

    @Override
    public taikhoanbean ChuyenTien(String SoTaiKhoanChuyen, long SoTienRut, String SoTaiKhoanNhan) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return tk.ChuyenTien(SoTaiKhoanChuyen, SoTienRut, SoTaiKhoanNhan);
    }

    @Override
    public taikhoanbean DoiMatKhau(String SoTaiKhoan, String MatKhauCu, String MatKhauMoi) throws Exception {
        return tk.DoiMatKhau(SoTaiKhoan, MatKhauCu, MatKhauMoi);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long HienThiSoDu(String SoTaiKhoan) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return tk.getSoTien(SoTaiKhoan);
    }

    @Override
    public ArrayList<chitiettaikhoanbean> HienThiLichSuGiaoDich(String SoTaiKhoan) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return cttkdao.LichSuGiaoDich(SoTaiKhoan);
    }
    
}
