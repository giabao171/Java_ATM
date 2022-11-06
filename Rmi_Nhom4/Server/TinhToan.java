/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */


public class TinhToan implements ITinhtoan{

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
   
    
}
