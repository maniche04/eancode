/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eancode;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author santosh
 */
public class GrnPrintSaveImport extends javax.swing.JFrame {

    /**
     * Creates new form GrnPrintSaveImport
     */
    DbConnection dbconn = new DbConnection(); 
    GlobalVariable gv = new GlobalVariable();
    Connection connekt = null;
    Statement stmt = null;
    PreparedStatement pst =null;
    ResultSet rs = null;
    String mysearch = "";
    int flaginsertupdate = 0;
    String currgrnnumber = "";
    String comptitle = "";
    JTable mygrnimptbl = new JTable();
    
    public GrnPrintSaveImport(String grnnum) throws Exception {
        
        initComponents();
        gv.setAppDefaultImg(this);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        printGRNRepoImp(grnnum);
        
    }

    public void printGRNRepoImp(String grnnumber) throws Exception
    {
        int exist = checkGrnTypeStatusImpo(grnnumber);
        
        if(exist == 1)
        {
          //feed data and update only
          currgrnnumber = grnnumber;
          flaginsertupdate = 1;
          
        }
        else
        {
             //insert only
          grnnumtxt1.setText(grnnumber);
          Date date = new Date();
          DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
          grndatetxt1.setText(dateFormat.format(date));
          currgrnnumber = grnnumber;
          flaginsertupdate = 2;
            
        }
        
    }
     
public int checkGrnTypeStatusImpo(String grnnum) throws Exception
  {
      
//if exist -> fill(select) and save(update) else not exist -> save(insert) 
   
    
    String docstat = "select TOP 1 grnnumber, compname, grndate,recvdate, isrnumber, prnumber, sealnumber, shipmode, countsize, skids, weight from grndetailstbl Where grnnumber = '" + grnnum + "'";
    System.out.println("tttt" + docstat); 
    connekt =  dbconn.conn();
    pst = connekt.prepareStatement(docstat);
    rs = pst.executeQuery(); 
    
 if(rs.next())
    {
       comptitledrop.setSelectedItem(rs.getString("compname").trim());  
       grnnumtxt1.setText(rs.getString("grnnumber").trim()); 
       grndatetxt1.setText(rs.getString("grndate").trim()); 
       String dateValue = rs.getString("recvdate").trim(); // What ever column
       java.util.Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateValue);
       recvdatetxt1.setDate(date); 
       srnotxt.setText(rs.getString("isrnumber").trim()); 
       prnotxt.setText(rs.getString("prnumber").trim()); 
       sealnotxt.setText(rs.getString("sealnumber").trim()); 
       shipmodtxt.setText(rs.getString("shipmode").trim()); 
       countsizetxt.setText(rs.getString("countsize").trim()); 
       skidstxt.setText(rs.getString("skids").trim()); 
       wgttxt.setText(rs.getString("weight").trim()); 
       
       return 1;
       
     } 
   else
     {
   return 0;
     }  
     
 } 
   

public void NewGrnInfoImpo() throws Exception
{
    //Todo list
    
    String comptitle = comptitledrop.getSelectedItem().toString();
    String grnnumstr = grnnumtxt1.getText().trim();
    String grndatestr = grndatetxt1.getText().trim();
    String receivedate = ((JTextField)recvdatetxt1.getDateEditor().getUiComponent()).getText().trim();
    String srnostr = srnotxt.getText().trim();
    String prnotxtstr = prnotxt.getText().trim();
    String sealnotxtstr = sealnotxt.getText().trim();
    String shipmodtxtstr = shipmodtxt.getText().trim();
    String countsizetxtstr  = countsizetxt.getText().trim();
    String skidstxtstr = skidstxt.getText().trim();
    String wgttxtstr = wgttxt.getText().trim();
       
    String addnewgrnstat = "insert into grndetailstbl(grnnumber, compname, grndate,recvdate, isrnumber, prnumber, sealnumber, shipmode, countsize, skids, weight) values ('"+ grnnumstr +"','" + comptitle + "','"+grndatestr+"','"+receivedate+"','"+srnostr+"','"+prnotxtstr+"','"+sealnotxtstr+"','"+shipmodtxtstr+"','"+countsizetxtstr+"','"+skidstxtstr+"','"+wgttxtstr+"')";
    System.out.println(addnewgrnstat);
    pst = connekt.prepareStatement(addnewgrnstat);
    pst.executeUpdate();   
    
}

public void updateGrnvaluesImpo(String grnnum) throws Exception
 {
    String receivedate = ((JTextField)recvdatetxt1.getDateEditor().getUiComponent()).getText().trim();
    String updategrnstr = "UPDATE grndetailstbl SET compname = '" + comptitledrop.getSelectedItem().toString() + "', grndate = '"+grndatetxt1.getText().trim()+"', recvdate = '"+receivedate+"', isrnumber = '"+srnotxt.getText().trim()+"', prnumber = '"+prnotxt.getText().trim()+"', sealnumber = '"+sealnotxt.getText().trim()+"' , shipmode = '"+shipmodtxt.getText().trim()+"', countsize = '"+countsizetxt.getText().trim()+"', skids = '"+skidstxt.getText().trim()+"' , weight = '"+wgttxt.getText().trim()+"'  WHERE grnnumber = '" + grnnum + "'"; 
    System.out.println(updategrnstr);
    pst = connekt.prepareStatement(updategrnstr);
    pst.executeUpdate();  
    
 }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        savegrnbtn = new javax.swing.JButton();
        printgrnbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        comptxt1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        grnnumtxt1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        grndatetxt1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        recvdatetxt1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        srnotxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        prnotxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        sealnotxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        shipmodtxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        countsizetxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        skidstxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        wgttxt = new javax.swing.JTextField();
        comptitledrop = new javax.swing.JComboBox();

        setResizable(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 0));
        jLabel8.setText("Save GRN");

        savegrnbtn.setText("Save");
        savegrnbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savegrnbtnActionPerformed(evt);
            }
        });

        printgrnbtn.setText("Print");
        printgrnbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printgrnbtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Comp. Title:");

        jLabel5.setText("  GRN Num :");

        grnnumtxt1.setEditable(false);

        jLabel6.setText("GRN Date :");

        grndatetxt1.setEditable(false);

        jLabel7.setText("Receive Date :");

        recvdatetxt1.setDateFormatString("dd-MM-yyyy");

        jLabel2.setText("SR No. :");

        jLabel3.setText("  PR No. :");

        jLabel4.setText("Seal No. :");

        jLabel9.setText("Ship Mode  :");

        jLabel10.setText("Count Size  :");

        jLabel11.setText("        Skids :");

        jLabel12.setText("     Weight : ");

        comptitledrop.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "JIZAN PERFUMES LLC", "INTERCITY PERFUMES LLC" }));
        comptitledrop.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comptitledropItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(savegrnbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(printgrnbtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(shipmodtxt)
                                    .addComponent(grndatetxt1)
                                    .addComponent(grnnumtxt1)
                                    .addComponent(recvdatetxt1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(srnotxt)
                                    .addComponent(prnotxt)
                                    .addComponent(sealnotxt)
                                    .addComponent(countsizetxt)
                                    .addComponent(skidstxt)
                                    .addComponent(wgttxt)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comptitledrop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comptxt1))))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(savegrnbtn)
                                .addComponent(printgrnbtn))
                            .addComponent(jLabel8))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(comptitledrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comptxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grnnumtxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grndatetxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(recvdatetxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(srnotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(prnotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(sealnotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(shipmodtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(countsizetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(skidstxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(wgttxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void savegrnbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savegrnbtnActionPerformed
        //TODO add your handling code here:
          if(flaginsertupdate == 1)
        {
           try {
               updateGrnvaluesImpo(currgrnnumber); //update only
                 this.setVisible(false);
           } catch (Exception ex) {
               Logger.getLogger(GrnPrintSave.class.getName()).log(Level.SEVERE, null, ex);
           }
        }else
        {
           try {
               NewGrnInfoImpo(); // insert only
                 this.setVisible(false);
           } catch (Exception ex) {
               Logger.getLogger(GrnPrintSave.class.getName()).log(Level.SEVERE, null, ex);
           }
        } 
       

    }//GEN-LAST:event_savegrnbtnActionPerformed

    private void printgrnbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printgrnbtnActionPerformed
        // TODO add your handling code here:
     if(!grnnumtxt1.getText().isEmpty() && !grndatetxt1.getText().isEmpty() && grnnumtxt1.getText().substring(0, 3).equals("IMP")) 
            {
                 try {
                    this.setVisible(false);  
                   
                          mygrnimptbl = gv.getSearchobj().eantbl;
                          if(mygrnimptbl  != null)
                          {
                    String recvdate  = ((JTextField)recvdatetxt1.getDateEditor().getUiComponent()).getText().trim();
                    JasperGeneratorImportGrn(mygrnimptbl,comptitledrop.getSelectedItem().toString(),grnnumtxt1.getText().trim(),grndatetxt1.getText().trim(),recvdate,srnotxt.getText().trim(),prnotxt.getText().trim(),sealnotxt.getText().trim(),shipmodtxt.getText().trim(),countsizetxt.getText().trim(),skidstxt.getText().trim(),wgttxt.getText().trim());
                          }
                        else
                          {
                    mygrnimptbl = gv.getSearchNormalobj().eantbl;
                     String recvdate  = ((JTextField)recvdatetxt1.getDateEditor().getUiComponent()).getText().trim();
                    JasperGeneratorImportGrn(mygrnimptbl,comptitledrop.getSelectedItem().toString(),grnnumtxt1.getText().trim(),grndatetxt1.getText().trim(),recvdate,srnotxt.getText().trim(),prnotxt.getText().trim(),sealnotxt.getText().trim(),shipmodtxt.getText().trim(),countsizetxt.getText().trim(),skidstxt.getText().trim(),wgttxt.getText().trim());
                      
                          }
               
                 }catch (Exception ex) {
                        Logger.getLogger(SearchEanPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
                 
    }//GEN-LAST:event_printgrnbtnActionPerformed

    private void comptitledropItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comptitledropItemStateChanged
        // TODO add your handling code here:
        comptitle = comptitledrop.getSelectedItem().toString();
        
    }//GEN-LAST:event_comptitledropItemStateChanged

public void JasperGeneratorImportGrn(JTable table,String title,String grnnum,String grndate,String recddate,String isr,String prnum,String seal,String shipmode,String countsize,String skids,String wgt) throws JRException
{
 
int intval = 0;    
int start = 0;
String datos = "";
int grandtotal = 0;
int grdtotbox = 0;
int grdtotleak = 0;
int grdtotbrkn = 0;
int grdtotdmg = 0;
int countitem = 1;

int totboxval = 0;
int totleakval = 0;
int totbrknval = 0;
int grdtotval = 0;

List Resultados = new ArrayList();

ImpotGrnBean collectdate1;
Resultados.clear();

for(start = 0; start<table.getRowCount();start++)
{
    
totboxval = table.getValueAt(start,4).equals("") ? 0 : Integer.parseInt(String.valueOf(table.getValueAt(start,4)));
grdtotbox = grdtotbox + totboxval;
totleakval = table.getValueAt(start,5).equals("") ? 0 : Integer.parseInt(String.valueOf(table.getValueAt(start,5)));
grdtotleak = grdtotleak +  totleakval;
totbrknval = table.getValueAt(start,6).equals("") ? 0 : Integer.parseInt(String.valueOf(table.getValueAt(start,6)));
grdtotbrkn = grdtotbrkn + totbrknval; 
grdtotval = table.getModel().getValueAt(start,7).equals("") ? intval : Integer.parseInt(String.valueOf(table.getValueAt(start,7)));
grandtotal = grandtotal + grdtotval;

collectdate1 = new ImpotGrnBean( String.valueOf(countitem++), //table.getValueAt(start,2)
                       String.valueOf(table.getValueAt(start,2)),
                       String.valueOf(table.getValueAt(start,3)),
                       String.valueOf(table.getValueAt(start,4)),
                       String.valueOf(table.getValueAt(start,5)),
                       String.valueOf(table.getValueAt(start,6)),
                       String.valueOf(table.getValueAt(start,7)), //total
                       String.valueOf(table.getValueAt(start,8)), 
                       String.valueOf(table.getValueAt(start,12)),
                       String.valueOf(table.getValueAt(start,10)),
                       String.valueOf(table.getValueAt(start,11)));

//grandtotal = grandtotal + Integer.parseInt(String.valueOf(table.getValueAt(start,7)));
Resultados.add(collectdate1);

}


Map map = new HashMap();
JDialog reporte = new JDialog();
reporte.setSize(900,700);
reporte.setLocationRelativeTo(null);
//reorte.setTtile("Reporte asdf");
map.put("comptitle",title);//Parameter value is title
map.put("grnnum",grnnum);
map.put("grndate",grndate);
map.put("grnrecivdate",recddate);
map.put("isrval",isr);
map.put("shipmodel",shipmode);
map.put("skidnum",skids);
map.put("prnuum",prnum);
map.put("countsizenum",countsize);
map.put("wgtnum",wgt);
map.put("sealnum",seal);
map.put("grdtotal",String.valueOf(grandtotal));
map.put("dmgtot",String.valueOf(grdtotbox + grdtotleak + grdtotbrkn ));


JasperPrint jPrint = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("eancode/ImportGrn.jasper"),map, new JRBeanCollectionDataSource(Resultados));
JRViewer jv = new JRViewer(jPrint);
reporte.getContentPane().add(jv);
reporte.setVisible(true);


    
}       
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(GrnPrintSaveImport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GrnPrintSaveImport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GrnPrintSaveImport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GrnPrintSaveImport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new GrnPrintSaveImport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comptitledrop;
    private javax.swing.JTextField comptxt1;
    private javax.swing.JTextField countsizetxt;
    private javax.swing.JTextField grndatetxt1;
    private javax.swing.JTextField grnnumtxt1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton printgrnbtn;
    private javax.swing.JTextField prnotxt;
    private com.toedter.calendar.JDateChooser recvdatetxt1;
    private javax.swing.JButton savegrnbtn;
    private javax.swing.JTextField sealnotxt;
    private javax.swing.JTextField shipmodtxt;
    private javax.swing.JTextField skidstxt;
    private javax.swing.JTextField srnotxt;
    private javax.swing.JTextField wgttxt;
    // End of variables declaration//GEN-END:variables
}
