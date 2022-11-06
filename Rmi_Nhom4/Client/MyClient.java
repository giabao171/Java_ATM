
import java.rmi.Naming;
import java.util.jar.Attributes;

public class MyClient {
    public static void main(String [] args){
    try{
        ITinhtoan tt= (ITinhtoan)Naming.lookup("rmi://172.16.0.166/TinhToan");
        System.out.print(tt.Cong(10,20) );
        System.out.print(tt.Tru(10,20) );
        System.out.print(tt.Nhan(10,20) );
        System.out.print(tt.Chia(10,20) );
    }catch(Exception tt){
        System.out.print(tt);
    }
  }
}
