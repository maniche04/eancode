/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eancode;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import net.sf.jasperreports.swing.JRViewer;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author santosh
 */
public final class GrnPrintSave extends javax.swing.JFrame {

    /**
     * Creates new form GrnPrintSave (local grn)
     */
    DbConnection dbconn = new DbConnection(); 
    GlobalVariable gv = new GlobalVariable();
    String compstr = "";
    Connection connekt = null;
    Statement stmt = null;
    PreparedStatement pst =null;
    ResultSet rs = null;
    String mysearch = "";
    int flaginsertupdate = 0;
    String currgrnnumber = "";
    Object panelget =null;    
    JTable mygrntbl = new JTable();
    Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
  
  
public GrnPrintSave(String grnnum) throws Exception {
    initComponents();
    
    gv.setAppDefaultImg(this);
    
    compstr = compdrop.getSelectedItem().toString();
        
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
     
                   
                   
    printGRNRepo(grnnum); 
}
  


    
public void printGRNRepo(String grnnumber) throws Exception
  {
     int exist = checkGrnTypeStatus(grnnumber);
        
      if(exist == 1)
        {
            //feed data and update only
            currgrnnumber = grnnumber;
            flaginsertupdate = 1;
        }
        else
        {
           //insert only
           grnnumtxt.setText(grnnumber); 
           grndatetxt.setText(dateFormat.format(date));
           currgrnnumber = grnnumber;
           flaginsertupdate = 2;   
        }  
      
  }
     
public int checkGrnTypeStatus(String grnnum) throws Exception
  {
      
    //if exist -> fill(select) and save(update) else not exist -> save(insert) 
    String docstat = "select TOP 1 grnnumber, compname, receivefrom, suppinvc, ctnnum, grndate,recvdate,ISNULL(Comment,'') as Comment from grndetailstbl Where grnnumber = '" + grnnum + "'";
    System.out.println("tttt" + docstat); 
    connekt =  dbconn.conn();
    pst = connekt.prepareStatement(docstat);
    rs = pst.executeQuery(); 
    
 if(rs.next())
    {
  compdrop.setSelectedItem(rs.getString("compname").trim());
  recvfromtxt.setText(rs.getString("receivefrom").trim()); 
  suppinvctxt.setText(rs.getString("suppinvc").trim()); 
  ctntxt.setText(rs.getString("ctnnum").trim()); 
  grnnumtxt.setText(rs.getString("grnnumber").trim()); 
  grndatetxt.setText(rs.getString("grndate").trim()); 
  String dateValue = rs.getString("recvdate").trim(); // What ever column
  java.util.Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateValue);
  nottxtarea.setText(rs.getString("Comment").trim());
    recvdatetxt.setDate(date); 
    return 1;
    } 
   else
     {
   return 0;
     }  
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        recvfromtxt = new javax.swing.JTextField();
        suppinvctxt = new javax.swing.JTextField();
        ctntxt = new javax.swing.JTextField();
        grnnumtxt = new javax.swing.JTextField();
        grndatetxt = new javax.swing.JTextField();
        recvdatetxt = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        compdrop = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        nottxtarea = new javax.swing.JTextArea();

        setResizable(false);

        jLabel1.setText("Comp. Title:");

        jLabel2.setText("Receive From:");

        jLabel3.setText("Doc no.:");

        jLabel4.setText("CTN:");

        jLabel5.setText("  GRN Num :");

        jLabel6.setText("GRN Date :");

        jLabel7.setText("Receive Date :");

        grnnumtxt.setEditable(false);

        grndatetxt.setEditable(false);

        recvdatetxt.setDateFormatString("dd-MM-yyyy");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 0));
        jLabel8.setText("Save & print GRN");

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        compdrop.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "JIZAN PERFUMES LLC", "INTERCITY PERFUMES LLC", "J P G TRADING LLC" }));
        compdrop.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                compdropItemStateChanged(evt);
            }
        });

        jLabel9.setText("Note :");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        nottxtarea.setColumns(20);
        nottxtarea.setRows(5);
        nottxtarea.setWrapStyleWord(true);
        nottxtarea.setAutoscrolls(false);
        jScrollPane1.setViewportView(nottxtarea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addComponent(jLabel4)
                                .addComponent(jLabel3))
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(compdrop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(grndatetxt)
                                .addComponent(grnnumtxt)
                                .addComponent(ctntxt)
                                .addComponent(suppinvctxt)
                                .addComponent(recvfromtxt)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(recvdatetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(compdrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(recvfromtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(suppinvctxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ctntxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(grnnumtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(grndatetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(recvdatetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       //TODO add your handling code here:
       if(flaginsertupdate == 1)
        {
           try {
               updateGrnvalues(currgrnnumber); //update only
               this.setVisible(false);
           } catch (Exception ex) {
               Logger.getLogger(GrnPrintSave.class.getName()).log(Level.SEVERE, null, ex);
           }
        }else
        {
           try {
               NewGrnInfo(); // insert only
               this.setVisible(false);
           } catch (Exception ex) {
               Logger.getLogger(GrnPrintSave.class.getName()).log(Level.SEVERE, null, ex);
           }
        }  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
       if(!grnnumtxt.getText().isEmpty() && !grndatetxt.getText().isEmpty() && grnnumtxt.getText().substring(0, 3).equals("LOC") || grnnumtxt.getText().substring(0, 3).equals("LOC") || grnnumtxt.getText().substring(0, 3).equals("LOC")) 
            {
                 try {
                   this.setVisible(false);  
                   System.out.println("dialogname"+gv.getDialogname());
                   if(gv.getDialogname().equals("admin"))
                        {
                            
                   mygrntbl = gv.getSearchobj().eantbl;
                   String recvdatetxt1 = ((JTextField)recvdatetxt.getDateEditor().getUiComponent()).getText().trim();
                   JasperGenerator(mygrntbl,compdrop.getSelectedItem().toString(),suppinvctxt.getText().trim(),ctntxt.getText().trim(),grnnumtxt.getText().trim(),grndatetxt.getText().trim(),recvdatetxt1,recvfromtxt.getText().trim(),nottxtarea.getText().trim());
                        }else       
                        {       
                    mygrntbl = gv.getSearchNormalobj().eantbl;          
                   String recvdatetxt1 = ((JTextField)recvdatetxt.getDateEditor().getUiComponent()).getText().trim();
                   JasperGenerator(mygrntbl, compdrop.getSelectedItem().toString(),suppinvctxt.getText().trim(),ctntxt.getText().trim(),grnnumtxt.getText().trim(),grndatetxt.getText().trim(),recvdatetxt1,recvfromtxt.getText().trim(),nottxtarea.getText().trim());
                        }
                       
                   } catch (Exception ex) {
                        Logger.getLogger(SearchEanPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void compdropItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_compdropItemStateChanged
        // TODO add your handling code here:
          compstr = compdrop.getSelectedItem().toString();
     
    }//GEN-LAST:event_compdropItemStateChanged

public void JasperGenerator(JTable table,String title, String suppinvc,String ctn,String grnnum,String grndate,String recddate, String titlecompsec,String notetxt) throws JRException
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

JasperData collectdate;
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

collectdate = new JasperData(String.valueOf(countitem++), //table.getValueAt(start,2)
                       String.valueOf(table.getValueAt(start,2)),
                       String.valueOf(table.getValueAt(start,11)),  
                       String.valueOf(table.getValueAt(start,3)),
                       String.valueOf(table.getValueAt(start,4)),
                       String.valueOf(table.getValueAt(start,5)),
                       String.valueOf(table.getValueAt(start,6)),
                       String.valueOf(table.getValueAt(start,7)), //total
                       String.valueOf(table.getValueAt(start,8)), 
                       String.valueOf(table.getValueAt(start,9)),
                       String.valueOf(table.getValueAt(start,10)),
                       String.valueOf(table.getValueAt(start,12)));

//grandtotal = grandtotal + Integer.parseInt(String.valueOf(table.getValueAt(start,7)));
Resultados.add(collectdate);

}


Map map = new HashMap();
JDialog reporte = new JDialog();
reporte.setSize(900,700);
reporte.setLocationRelativeTo(null);

//reorte.setTtile("Reporte asdf");

if(notetxt.length() > 0)
{
  map.put("notelbl","Note:");
  map.put("note",notetxt);
}
else
{
  map.put("notelbl","");
  map.put("note","");  
}

map.put("inputtitle",title);//Parameter value is title
map.put("suppinvoice",suppinvc);
map.put("ctns",ctn);

if(grnnum.substring(0, 3).equals("LOC"))
{
   grnnum = grnnum.replace("MTN", "LOC");
   System.out.println("tttt"+grnnum);
   map.put("doctypelbl","LOC");    
}

map.put("grnnum",grnnum);
map.put("grndate",grndate);
System.out.println("date"+grndate);
map.put("recddate",recddate);
map.put("recvtitle",titlecompsec);
map.put("grndtot",String.valueOf(grandtotal));
map.put("boxtot",String.valueOf(grdtotbox));
map.put("leaktot",String.valueOf(grdtotleak));
map.put("brkntot",String.valueOf(grdtotbrkn));
map.put("preparedby",gv.getGlobusername());
map.put("dmgtot",String.valueOf(grdtotbox + grdtotleak + grdtotbrkn ));

//map.put("Fetch","2763238");//Parameter value is Fetch

  JasperPrint jPrint = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("eancode/report.jasper"),map, new JRBeanCollectionDataSource(Resultados));
    
//JasperPrint jPrint = JasperFillManager
  
 
    
JRViewer jv = new JRViewer(jPrint);
reporte.getContentPane().add(jv);
reporte.setVisible(true);


   
} 
    
 
    
public void NewGrnInfo() throws Exception
{
    //todo list
    
     grndatetxt.setText(dateFormat.format(date));
       String comptitle =   compdrop.getSelectedItem().toString();
       String recvstr = recvfromtxt.getText(); 
       String suppstr = suppinvctxt.getText(); 
       String ctnnum = ctntxt.getText(); 
       String notestr = nottxtarea.getText();
       String receivedate = ((JTextField)recvdatetxt.getDateEditor().getUiComponent()).getText().trim();
       
       
    
      String addnewgrnstat = "insert into grndetailstbl(grnnumber, compname, receivefrom, suppinvc, ctnnum, grndate,recvdate,Comment) values ('"+ grnnumtxt.getText().trim() +"','" + comptitle + "','"+recvstr+"','"+suppstr+"','"+ctnnum+"','"+grndatetxt.getText().trim()+"','"+receivedate+"','"+notestr+"')";
      System.out.println(addnewgrnstat);
      pst = connekt.prepareStatement(addnewgrnstat);
      pst.executeUpdate();   
      
}

public void updateGrnvalues(String grnnum) throws Exception
 {
    String receivedate = ((JTextField)recvdatetxt.getDateEditor().getUiComponent()).getText().trim();
    String updategrnstr ="UPDATE grndetailstbl SET compname = '" +  compdrop.getSelectedItem().toString() + "', receivefrom = '" +recvfromtxt.getText().trim() +"', suppinvc = '"+suppinvctxt.getText().trim()+"', ctnnum = '"+ctntxt.getText().trim()+"', grndate = '"+grnnumtxt.getText().trim()+"', recvdate = '"+receivedate+"', Comment = '"+nottxtarea.getText()+"'  WHERE grnnumber = '" + grnnum + "'"; 
    System.out.println(updategrnstr);
    pst = connekt.prepareStatement(updategrnstr);
    pst.executeUpdate();  
    
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
            java.util.logging.Logger.getLogger(GrnPrintSave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GrnPrintSave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GrnPrintSave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GrnPrintSave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new GrnPrintSave().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox compdrop;
    private javax.swing.JTextField ctntxt;
    private javax.swing.JTextField grndatetxt;
    private javax.swing.JTextField grnnumtxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea nottxtarea;
    private com.toedter.calendar.JDateChooser recvdatetxt;
    private javax.swing.JTextField recvfromtxt;
    private javax.swing.JTextField suppinvctxt;
    // End of variables declaration//GEN-END:variables
}
