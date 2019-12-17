
package courier.management.system;


public class AdminPanel extends javax.swing.JPanel {

    
    public AdminPanel() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        branchesButton = new javax.swing.JButton();
        managersButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        branchesButton.setText("Branches");
        branchesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                branchesButtonMouseClicked(evt);
            }
        });
        branchesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchesButtonActionPerformed(evt);
            }
        });
        add(branchesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 140, -1));

        managersButton.setText("Managers");
        managersButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                managersButtonMouseClicked(evt);
            }
        });
        add(managersButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 140, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void branchesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_branchesButtonMouseClicked
        // TODO add your handling code here:
        new Branches().setVisible(true);
    }//GEN-LAST:event_branchesButtonMouseClicked

    private void managersButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_managersButtonMouseClicked
        // TODO add your handling code here:
        new CreateManager().setVisible(true);
    }//GEN-LAST:event_managersButtonMouseClicked

    private void branchesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchesButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_branchesButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton branchesButton;
    private javax.swing.JButton managersButton;
    // End of variables declaration//GEN-END:variables
}
