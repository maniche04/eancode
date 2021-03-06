/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eancode;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author santosh
 */
public class EanHome extends javax.swing.JFrame {

    /**
     * Creates new form EanHome
     */
    
GlobalVariable gv = new GlobalVariable();
    
public EanHome() {
        initComponents();
        gv.setAppDefaultImg(this);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        //Start - to confirm defore closing the application
        
        this.addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent e) {
            int confirmed = JOptionPane.showConfirmDialog(null, 
                 "Are you sure you want to exit Application ?", "Exit Application",
                    JOptionPane.YES_NO_OPTION);
                    if (confirmed == JOptionPane.YES_OPTION) {
                   System.exit(0);
                    }
                  }
                });
        
loginusername.setText(gv.getGlobusername());
//End-to confirm defore closing the application

sales.setVisible(false);

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
        scanerbtn = new javax.swing.JButton();
        scanersrchbtn = new javax.swing.JButton();
        sales = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        loginusername = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Jizan Scanner");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        scanerbtn.setBackground(new java.awt.Color(204, 204, 255));
        scanerbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        scanerbtn.setText("Scan EAN");
        scanerbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanerbtnActionPerformed(evt);
            }
        });

        scanersrchbtn.setBackground(new java.awt.Color(204, 204, 255));
        scanersrchbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        scanersrchbtn.setText("Search EAN");
        scanersrchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanersrchbtnActionPerformed(evt);
            }
        });

        sales.setBackground(new java.awt.Color(204, 204, 255));
        sales.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        sales.setText("Sales ");
        sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("User Name :");

        loginusername.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        loginusername.setForeground(new java.awt.Color(255, 153, 0));
        loginusername.setText("username");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(loginusername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(scanerbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(scanersrchbtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(sales, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(loginusername))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scanerbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scanersrchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sales, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void scanerbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanerbtnActionPerformed
// TODO add your handling code here:
//if(gv.getUsertype().equals("admin"))
//{
    
    EanScanned scanner = new EanScanned();
    scanner.setVisible(true);
    this.scanerbtn.setEnabled(false);
    gv.setObj(this);

//}
// else
// {
// JOptionPane.showMessageDialog(this,"Only For Admin user!");               
// } 
    
    }//GEN-LAST:event_scanerbtnActionPerformed

    
    
public void ItemData(int totitem)
       {
            if(totitem > 0)
                {
             
                    
                    
            }else
                {
                    
                }
                
       }
    
    private void scanersrchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanersrchbtnActionPerformed
        // TODO add your handling code here:
        
        if(gv.getUsertype().equals("admin"))
        {
            
        SearchEanPanel searchpanel = new SearchEanPanel();
        searchpanel.setVisible(true);
        this.scanersrchbtn.setEnabled(false);
        gv.setObj(this);
        
        }
        else if(gv.getUsertype().equals("purchase")) 
        {
            
        SearchEanPanelNormal searchpanelnormal = new SearchEanPanelNormal();
        searchpanelnormal.setVisible(true);
        this.scanersrchbtn.setEnabled(false);
        gv.setObj(this);       
            
        }
        else
        {
            
        SearchEanPanelNormal searchpanelnormal = new SearchEanPanelNormal();
        searchpanelnormal.setVisible(true);
        this.scanersrchbtn.setEnabled(false);
        gv.setObj(this);
        
        }
        
    }//GEN-LAST:event_scanersrchbtnActionPerformed

    private void salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesActionPerformed
        //TODO add your handling code here:
        //System.out.println("sadfasd"+ gv.getUsertype());
        
        if(gv.getUsertype().equals("admin"))
          {
              SalePrintManager saleprtmang = new SalePrintManager();
              saleprtmang.setVisible(true);
              this.sales.setEnabled(false);
              gv.setObj(this); 
              
          }else
          {
              
    SalesInvoice saleinv = new SalesInvoice();
    saleinv.SalesReport();
            
          }          
        
    }//GEN-LAST:event_salesActionPerformed

    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

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
                if ("Windows Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EanHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EanHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EanHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EanHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EanHome().setVisible(true);
            }
        });
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel loginusername;
    public javax.swing.JButton sales;
    public javax.swing.JButton scanerbtn;
    public javax.swing.JButton scanersrchbtn;
    // End of variables declaration//GEN-END:variables
}
