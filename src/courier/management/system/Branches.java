/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courier.management.system;

import courier.management.system.models.Branch;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sun.security.pkcs11.Secmod;

public class Branches extends javax.swing.JFrame {

    /**
     * Creates new form CreateBranch
     */
    public Branches() {
        initComponents();
        setBranchesTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        branchNameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        createBranchButton = new javax.swing.JButton();
        branchLocationField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        branchesTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Branches");
        setPreferredSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        branchNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchNameFieldActionPerformed(evt);
            }
        });
        getContentPane().add(branchNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 170, -1));

        jLabel2.setText("Branch name:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 80, -1));

        jLabel3.setText("Location:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 80, -1));

        createBranchButton.setText("Create");
        createBranchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createBranchButtonMouseClicked(evt);
            }
        });
        getContentPane().add(createBranchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, -1));
        getContentPane().add(branchLocationField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 170, 30));

        branchesTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(branchesTable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 380, 140));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void branchNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_branchNameFieldActionPerformed

    private void createBranchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createBranchButtonMouseClicked
        // TODO add your handling code here:
        
        String branchName = branchNameField.getText();
        String branchLocation = branchLocationField.getText();
        
        if(branchName.isEmpty()){
            JOptionPane.showMessageDialog(null, "Branch name is required.");
        } else {
            
            DB.getInstance().createBranch(branchName, branchLocation);
            
            JOptionPane.showMessageDialog(null, "Branch created successfully.");
            
            setBranchesTable();
            
            branchNameField.setText("");
            branchLocationField.setText("");
        }
        
    }//GEN-LAST:event_createBranchButtonMouseClicked


    
    private void setBranchesTable(){
        
        String[] columns = {"id", "Branch Name", "Branch Location"};
        
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        
        
        List<Branch> branches = DB.getInstance().getAllBranches();
        
        String[] row = new String[3];
        
        for(Branch branch: branches){
            row[0] = String.valueOf(branch.getId());
            row[1] = branch.getName();
            row[2] = branch.getLocation();
            model.addRow(row);
        }
        
        branchesTable.setModel(model);
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField branchLocationField;
    private javax.swing.JTextField branchNameField;
    private javax.swing.JTable branchesTable;
    private javax.swing.JButton createBranchButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
