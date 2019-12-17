
package courier.management.system;

import courier.management.system.models.Parcel;
import courier.management.system.models.Transaction;
import java.util.List;
import javax.swing.JOptionPane;

public class MainFrame extends javax.swing.JFrame {

    int branchId;
    
   
    public MainFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelTrackOrder = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        parcelTrackerView = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        trackingText = new javax.swing.JTextPane();
        parcelInfoView1 = new javax.swing.JPanel();
        branchTabPanel = new javax.swing.JPanel();
        branchLoginPanel = new javax.swing.JPanel();
        branchUserNameField = new javax.swing.JTextField();
        branchPasswordField = new javax.swing.JPasswordField();
        branchLoginButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        adminTabPanel = new javax.swing.JPanel();
        adminLoginPanel = new javax.swing.JPanel();
        adminUserNameField = new javax.swing.JTextField();
        adminPasswordField = new javax.swing.JPasswordField();
        adminLoginButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Courier Management System");
        setMaximumSize(new java.awt.Dimension(10000, 10000));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(new java.awt.FlowLayout());

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(600, 400));

        jPanelTrackOrder.setPreferredSize(new java.awt.Dimension(600, 400));
        jPanelTrackOrder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchField.setText("Tracker ID");
        searchField.setPreferredSize(new java.awt.Dimension(200, 23));
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        jPanel3.add(searchField);

        searchButton.setText("Search");
        searchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButtonMouseClicked(evt);
            }
        });
        jPanel3.add(searchButton);

        jPanelTrackOrder.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 595, 50));

        parcelTrackerView.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(trackingText);

        parcelTrackerView.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 590, 210));

        jPanelTrackOrder.add(parcelTrackerView, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 595, 230));

        parcelInfoView1.setLayout(new java.awt.CardLayout());
        jPanelTrackOrder.add(parcelInfoView1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 41, 595, 100));

        jTabbedPane1.addTab("Track Order", jPanelTrackOrder);

        branchTabPanel.setPreferredSize(new java.awt.Dimension(600, 400));
        branchTabPanel.setLayout(new java.awt.CardLayout());

        branchLoginPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        branchUserNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchUserNameFieldActionPerformed(evt);
            }
        });
        branchLoginPanel.add(branchUserNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 130, -1));
        branchLoginPanel.add(branchPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 130, -1));

        branchLoginButton.setText("Login");
        branchLoginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                branchLoginButtonMouseClicked(evt);
            }
        });
        branchLoginPanel.add(branchLoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 80, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("password:");
        branchLoginPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 70, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("username:");
        branchLoginPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 70, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Branch manager login");
        branchLoginPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 210, 40));

        branchTabPanel.add(branchLoginPanel, "card2");

        jTabbedPane1.addTab("Branch Dashboard", branchTabPanel);

        adminTabPanel.setPreferredSize(new java.awt.Dimension(600, 400));
        adminTabPanel.setLayout(new java.awt.CardLayout());

        adminLoginPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adminUserNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminUserNameFieldActionPerformed(evt);
            }
        });
        adminLoginPanel.add(adminUserNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 130, -1));
        adminLoginPanel.add(adminPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 130, -1));

        adminLoginButton.setText("Login");
        adminLoginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminLoginButtonMouseClicked(evt);
            }
        });
        adminLoginPanel.add(adminLoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 80, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("password:");
        adminLoginPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 70, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("username:");
        adminLoginPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 70, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Admin login");
        adminLoginPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 210, 40));

        adminTabPanel.add(adminLoginPanel, "card2");

        jTabbedPane1.addTab("Admin Dashboard", adminTabPanel);

        getContentPane().add(jTabbedPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void branchUserNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchUserNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_branchUserNameFieldActionPerformed

    private void adminUserNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminUserNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminUserNameFieldActionPerformed

    private void adminLoginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminLoginButtonMouseClicked
        // TODO add your handling code here:
        adminLogin();
    }//GEN-LAST:event_adminLoginButtonMouseClicked

    private void branchLoginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_branchLoginButtonMouseClicked
        // TODO add your handling code here:
        
        branchLogin();
    }//GEN-LAST:event_branchLoginButtonMouseClicked

    private void searchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseClicked
        // TODO add your handling code here:
        try{
            int parcelId = Integer.parseInt(searchField.getText());
            
            if(DB.getInstance().isParcelExist(parcelId)){
                Parcel parcel = DB.getInstance().getParcelById(parcelId);
                
                ParcelItemView parcelItemView = new ParcelItemView(parcel, branchId);
                parcelItemView.hideButtons();
                
                parcelInfoView1.removeAll();
                parcelInfoView1.add(parcelItemView);
                parcelInfoView1.revalidate();
                parcelInfoView1.repaint();
                
                
                
                
                List<Transaction> transactions = DB.getInstance().getTransactionByParcel(parcelId);
                
                String trText = "";
                for(Transaction tr: transactions){
                    if(tr.getType().equals("pickup")){
                       trText = trText + "# Parcel is picked up from " + tr.getToBranch() + "\n";
                    } else if(tr.getType().equals("deliver")){
                        trText = trText + "# Parcel is Delivered \n";
                    } else if(tr.getType().equals("transfer")){
                        trText = trText + "# Parcel is transfer from " 
                                + tr.getFromBranch()+ " branch to " 
                                + tr.getToBranch() + " branch" + "\n";
                    }
                }
                
                
                trackingText.setText(trText);
                
                
                
                
                
            } else {
                JOptionPane.showMessageDialog(null, "No parcel found.");
            }
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Not a valid id.");
        }
        
        
    }//GEN-LAST:event_searchButtonMouseClicked

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    
    private void adminLogin(){
        String username = adminUserNameField.getText();
        String password = String.copyValueOf(adminPasswordField.getPassword());
        
        if(username.isEmpty() || password.isEmpty()){
            JOptionPane.showMessageDialog(null, "Field empty.");
           
        } else {
            if(DB.getInstance().adminLogin(username, password)){
                //loged in
                JOptionPane.showMessageDialog(null, "Logged in");
                
                adminTabPanel.remove(adminLoginPanel);
                
                AdminPanel adminPanel = new AdminPanel();
                
                adminTabPanel.add(adminPanel);
                
                
                
            } else {
                JOptionPane.showMessageDialog(null, "Invalid credentials");
            }
        }
    }
    
    private void branchLogin(){
        String username = branchUserNameField.getText();
        String password = String.copyValueOf(branchPasswordField.getPassword());
        
        if(username.isEmpty() || password.isEmpty()){
            JOptionPane.showMessageDialog(null, "Field empty.");
        } else {
            if(DB.getInstance().managerLogin(username, password)){
                //loged in
                JOptionPane.showMessageDialog(null, "Logged in");
                
                branchId = DB.getInstance().getBranchId(username);
                BranchDashboard branchDashboardPanel = new BranchDashboard(branchId);
                
                
                branchTabPanel.remove(branchLoginPanel);
                branchTabPanel.add(branchDashboardPanel);
                
            } else {
                JOptionPane.showMessageDialog(null, "Invalid credentials");
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminLoginButton;
    private javax.swing.JPanel adminLoginPanel;
    private javax.swing.JPasswordField adminPasswordField;
    private javax.swing.JPanel adminTabPanel;
    private javax.swing.JTextField adminUserNameField;
    private javax.swing.JButton branchLoginButton;
    private javax.swing.JPanel branchLoginPanel;
    private javax.swing.JPasswordField branchPasswordField;
    private javax.swing.JPanel branchTabPanel;
    private javax.swing.JTextField branchUserNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelTrackOrder;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel parcelInfoView1;
    private javax.swing.JPanel parcelTrackerView;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JTextPane trackingText;
    // End of variables declaration//GEN-END:variables
}
