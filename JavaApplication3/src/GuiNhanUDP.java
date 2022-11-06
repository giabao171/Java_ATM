
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JFileChooser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class GuiNhanUDP {
    DatagramSocket dg;
    public void MoCong(int cong) throws Exception{
        dg = new DatagramSocket(cong);
        
        System.out.println("Server da mo cong: " + cong);
    }
    
    public String Nhan() throws Exception{
        System.out.println("Co 1 nguoi ket noi den");
        byte bodem[]=new byte[256]; 
        DatagramPacket dr= new DatagramPacket(bodem,bodem.length);
        dg.receive(dr);//Đợi 1 kết nối đến
        String st= new String(dr.getData()).trim() ;//Lấy dữ liệu về và đổi sang chuỗi
        return st;
    }
   
    
    public void Gui(String data, String Ipmaychu, int cong) throws Exception{  
        DatagramSocket c = new DatagramSocket();
        byte bodem[]=new byte[256]; //Tạo ra bộ đệm chứa dữ liệu cần gửi
        bodem = data.getBytes(); //Chuyển chuỗi thành dãy các byte
        InetAddress ip = InetAddress.getByName(Ipmaychu);//Lấy thông tin của máy cần gửi
        DatagramPacket dr= new DatagramPacket(bodem,bodem.length,ip,cong);
        c.send(dr);//Gửi dữ liệu đi
    }
    
    public byte[] NhanFile() throws Exception{
        System.out.println("Co 1 nguoi ket noi den");
        byte bodem[]=new byte[256]; 
        DatagramPacket dr= new DatagramPacket(bodem,bodem.length);
        dg.receive(dr);//Đợi 1 kết nối đến
        
//        String st= new String(dr.getData()).trim() ;//Lấy dữ liệu về và đổi sang chuỗi
        return dr.getData();
    }
    
    public void GuiFile(byte[] data, String Ipmaychu, int cong) throws Exception{  
        DatagramSocket c = new DatagramSocket();
        InetAddress ip = InetAddress.getByName(Ipmaychu);
        DatagramPacket dr = new DatagramPacket(
            data, data.length, ip, cong
        );
        c.send(dr);
    }
    
    
    

}
