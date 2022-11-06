
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class GuiNhan {
    ServerSocket Sserver;
    public void MoCong(int cong) throws Exception{
        //Mo 1 cong co so hieu: cong
        Sserver = new ServerSocket(cong);
        System.out.println("Server da mo cong" + cong);
    }
    public String Nhan() throws Exception{
        Socket c= Sserver.accept();
        System.out.println("Co 1 nguoi ket noi den");
        
        //Tạo luồng để nhận thông tin client gửi lên
        InputStreamReader is= new InputStreamReader(c.getInputStream());
        //Tạo bộ đệm để lưu dữ liệu nhận về
        BufferedReader r= new BufferedReader(is);
        return r.readLine();
    }
    public void Gui(String data, String Ipmaychu, int cong) 
        throws Exception{
            //Noi len Server co Ip: Ipmaychu qua cong: cong
            Socket c= new Socket(Ipmaychu, cong);
            System.out.println("Da noi len may chu "+cong);
            DataOutputStream out =new DataOutputStream(c.getOutputStream());
            out.writeBytes(data); //Gửi thông báo
            out.write(13);
            out.write(10);
            c.close();
        }
    }


