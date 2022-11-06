/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *
 * @author USER
 */
public class FrmToHop extends javax.swing.JFrame {
    long s1 = 0, s2 = 0, s3 = 0, s4 = 0, s = 0;
    boolean kt1 = false, kt2 = false, kt3= false, kt4 = false;
    
    public class ToHop extends Thread {
        int n;
        int k;
        int td;
        
        public ToHop(int n, int k, int td){
           this.n = n;
           this.k = k;
           this.td = td;
       }
        
        public long tohop(int n, int k){
           //System.out.println("To hop: ");
           if( k==0 || k==n) return 1;
           else 
               return tohop(n-1,k-1) + tohop(n-1,k);
       }
    
        public void run() {

            if (td == 1) {
                s1 = tohop(n-2,k);
                kt1 = true;
                System.out.println("Th1: "+s1);
            }
            if (td == 2) {
                s2 = tohop(n-2,k-1);
                kt2 = true;
                System.out.println("Th2: "+s2);
            }
            if (td == 3) {
                s3 = tohop(n-2,k-1);
                kt3 = true;
                System.out.println("Th3: "+s3);
            }
            if (td == 4) {
                s4 = tohop(n-2,k-2);
                kt4 = true;
                System.out.println("Th4: "+s4);
            }
        }
}   
    public FrmToHop() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNhapn = new javax.swing.JTextField();
        txtNhapk = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtKQ = new javax.swing.JTextField();
        btnTinh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Nhập n: ");

        jLabel2.setText("Nhập k: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tổ Hợp");
        jLabel3.setName("lbDem"); // NOI18N

        txtNhapn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNhapnActionPerformed(evt);
            }
        });

        jLabel4.setText("Kết quả");

        btnTinh.setText("Tính");
        btnTinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTinhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNhapn, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNhapk, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKQ, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(btnTinh)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNhapn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNhapk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtKQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnTinh)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

//        for (int i= 1; i<=4 ;++i){
//            ToHop th1 = new ToHop(8,4,i);
//            th1.start();
//        }
//        while(true) { 
//            System.out.println("Doi ..........");
//            if(kt1 == true && kt2 == true && kt3 == true && kt4 == true){
//                s = s1 + s2 +s3 + s4;
//                System.out.println("TH1 + TH2 + TH3 + TH4:" + s);
//                break;
//            }
//          }
        
    }//GEN-LAST:event_formWindowOpened

    private void txtNhapnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNhapnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNhapnActionPerformed

    private void btnTinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTinhMouseClicked
        
        int n = Integer.parseInt(txtNhapn.getText());
        int k = Integer.parseInt(txtNhapk.getText());
        for (int i= 1; i<=4 ;++i){
            ToHop th1 = new ToHop(n,k,i);
            th1.start();
        }
        while(true) { 
            System.out.println("Doi ..........");
            if(kt1 == true && kt2 == true && kt3 == true && kt4 == true){
                s = s1 + s2 +s3 + s4;
                txtKQ.setText(Long.toString(s));
//                System.out.println("TH1 + TH2 + TH3 + TH4:" + s);
                break;
            }
          }
    }//GEN-LAST:event_btnTinhMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmToHop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmToHop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmToHop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmToHop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmToHop().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtKQ;
    private javax.swing.JTextField txtNhapk;
    private javax.swing.JTextField txtNhapn;
    // End of variables declaration//GEN-END:variables
}