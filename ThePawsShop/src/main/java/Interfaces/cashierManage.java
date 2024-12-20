
package Interfaces;

import codes.DbConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class cashierManage extends javax.swing.JFrame {

    Connection conn = null; //create java connection
    PreparedStatement pst = null; // create prepare statement
    ResultSet rs = null; //result set method
    

    public cashierManage() { 
        initComponents();
        conn = DbConnect.connect(); // connection with data base
        userdataload();
    }
    
    public void userdataload(){
        try {
            
            String sql = "SELECT user_id AS User_Id, user_name AS User_Name , password AS Password, contact_number AS Contact_Number FROM users";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            cadetable.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);   
        }
    }
    
    public void cashiertabledata(){
      int rownu = cadetable.getSelectedRow();
      
      String cashierId =  cadetable.getValueAt(rownu, 0).toString();
      String cashierName = cadetable.getValueAt(rownu, 1).toString();
      String cashierpwd = cadetable.getValueAt(rownu, 2).toString();
      String cashirContact = cadetable.getValueAt(rownu, 3).toString();
      
      idbox.setText(cashierId );
      unamebox.setText(cashierName);
      pwordbox.setText(cashierpwd );
      cnumbox.setText(cashirContact);
    }
    
    
    public void searchCashir(){
        
        String caseach = caSearch.getText();
        
        try {
            
        String sql = "SELECT * FROM users WHERE user_name LIKE '%" + caseach + "%' OR  user_id LIKE '%" + caseach + "%'";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        cadetable.setModel(DbUtils.resultSetToTableModel(rs));
                 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public void cashirupdate(){
        
      String cashierId =    idbox.getText();
      String cashierName =unamebox.getText();
      String cashierpwd = pwordbox.getText();
      String cashierContatct =cnumbox.getText();
    
        try {
            String sql = "UPDATE users SET user_name = '"+cashierName+"' , password = '"+cashierpwd+"' , contact_number = '"+cashierContatct+"' WHERE user_id = '"+cashierId+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Updated");
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void clearData(){
        caSearch.setText("");
        idbox.setText("ID" );
        unamebox.setText("");
        pwordbox.setText("");
        cnumbox.setText("");    
    }
    
    
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        caSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        unamebox = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pwordbox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cnumbox = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        idbox = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        cadeinsertbtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        caDeBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cadetable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 51, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        caSearch.setBackground(new java.awt.Color(255, 255, 255));
        caSearch.setForeground(new java.awt.Color(0, 0, 0));
        caSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caSearchActionPerformed(evt);
            }
        });
        caSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                caSearchKeyReleased(evt);
            }
        });
        jPanel3.add(caSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 270, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 300, 70));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Cashier Details Manage");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 290, 30));

        jPanel4.setBackground(new java.awt.Color(255, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("User Name");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        unamebox.setBackground(new java.awt.Color(255, 255, 255));
        unamebox.setForeground(new java.awt.Color(0, 0, 0));
        unamebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unameboxActionPerformed(evt);
            }
        });
        jPanel4.add(unamebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 190, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Password");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        pwordbox.setBackground(new java.awt.Color(255, 255, 255));
        pwordbox.setForeground(new java.awt.Color(0, 0, 0));
        pwordbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwordboxActionPerformed(evt);
            }
        });
        jPanel4.add(pwordbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 190, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Contact Number");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        cnumbox.setBackground(new java.awt.Color(255, 255, 255));
        cnumbox.setForeground(new java.awt.Color(0, 0, 0));
        cnumbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnumboxActionPerformed(evt);
            }
        });
        jPanel4.add(cnumbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 190, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Cashier ID");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        idbox.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        idbox.setForeground(new java.awt.Color(0, 0, 0));
        idbox.setText("ID");
        jPanel4.add(idbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("=");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 300, 260));

        jPanel5.setBackground(new java.awt.Color(255, 102, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cadeinsertbtn.setBackground(new java.awt.Color(255, 255, 255));
        cadeinsertbtn.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        cadeinsertbtn.setForeground(new java.awt.Color(0, 0, 0));
        cadeinsertbtn.setText("Insert");
        cadeinsertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadeinsertbtnActionPerformed(evt);
            }
        });
        jPanel5.add(cadeinsertbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, 40));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 100, 40));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 100, 40));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 100, 40));

        caDeBack.setBackground(new java.awt.Color(255, 255, 255));
        caDeBack.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        caDeBack.setForeground(new java.awt.Color(0, 0, 0));
        caDeBack.setText("Back");
        caDeBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caDeBackActionPerformed(evt);
            }
        });
        jPanel5.add(caDeBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 120, 40));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 300, 190));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 600));

        cadetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        cadetable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cadetableMouseClicked(evt);
            }
        });
        cadetable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cadetableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(cadetable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 540, 600));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 600));

        setSize(new java.awt.Dimension(880, 622));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void unameboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unameboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unameboxActionPerformed

    private void cnumboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnumboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnumboxActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        int check = JOptionPane.showConfirmDialog(null, "Do you want to delete ? ");
        
        if(check == 0 ){
            String cashierId = idbox.getText();
            
            try {
                String sql = "DELETE FROM users WHERE user_id = '"+cashierId+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Deleted");
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        userdataload();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void pwordboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwordboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwordboxActionPerformed

    private void cadeinsertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadeinsertbtnActionPerformed
        String name;
        String password;
        int contactNumber;
        
        name = unamebox.getText();
        password = pwordbox.getText();
        contactNumber = Integer.parseInt(cnumbox.getText());
        
        try {
            String sql = "INSERT INTO users (user_name , password , contact_number) VALUES ('"+name+"' , '"+password+"' , '"+contactNumber+"') ";
            pst = conn.prepareStatement(sql);
            pst.execute();
             JOptionPane.showMessageDialog(null, "Data inserted");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
       userdataload();
    }//GEN-LAST:event_cadeinsertbtnActionPerformed

    private void caDeBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caDeBackActionPerformed
        managerSelect cadeBack = new managerSelect();
        cadeBack.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_caDeBackActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cashirupdate();
        userdataload();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void caSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caSearchActionPerformed

    private void caSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caSearchKeyReleased
        searchCashir();
    }//GEN-LAST:event_caSearchKeyReleased

    private void cadetableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadetableMouseClicked
      cashiertabledata();
    }//GEN-LAST:event_cadetableMouseClicked

    private void cadetableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadetableKeyReleased
       cashiertabledata();
    }//GEN-LAST:event_cadetableKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        clearData();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(cashierManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cashierManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cashierManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cashierManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cashierManage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton caDeBack;
    private javax.swing.JTextField caSearch;
    private javax.swing.JButton cadeinsertbtn;
    private javax.swing.JTable cadetable;
    private javax.swing.JTextField cnumbox;
    private javax.swing.JLabel idbox;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pwordbox;
    private javax.swing.JTextField unamebox;
    // End of variables declaration//GEN-END:variables
}
