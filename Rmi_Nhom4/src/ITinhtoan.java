
import bean.chitiettaikhoanbean;
import bean.taikhoanbean;
import java.rmi.Remote;
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
public interface ITinhtoan extends Remote{
    public int Cong(int a, int b) throws Exception;
    public int Tru(int a, int b) throws Exception;
    public int Nhan(int a, int b) throws Exception;
    public int Chia(int a, int b) throws Exception;
    public taikhoanbean KtDn(String SoTaiKhoan, String MatKhau)throws Exception;
    public taikhoanbean RutTien(String SoTaiKhoan, long SoTienRut)throws Exception;
    public taikhoanbean ChuyenTien(String SoTaiKhoanChuyen, long SoTienRut, String SoTaiKhoanNhan)throws Exception;
    public taikhoanbean DoiMatKhau(String SoTaiKhoan, String MatKhauCu, String MatKhauMoi)throws Exception;
    public long HienThiSoDu(String SoTaiKhoan)throws Exception;
    public ArrayList<chitiettaikhoanbean> HienThiLichSuGiaoDich (String SoTaiKhoan)throws Exception;
}
