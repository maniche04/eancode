/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eancode;

import java.awt.Dimension;
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
public class SalesInvoice extends EanHome{
    
    GlobalVariable gv = new GlobalVariable();
     DbConnection dbconn = new DbConnection();
    Date date = new Date(); 
    JTable salestable = new JTable();
    JComboBox title;
    JTextField titlesec;
    JTextField suppinvc;
    String titlecomp = "";
    JComboBox trantype;

    String trantypestr;
    JTextField trannum;
    int inputsalresult = 0;  
    int trannuminit=0;
    Connection connekt = null;
    Statement stmt = null;
    PreparedStatement pst =null;
    ResultSet rs = null;

      
      
        public void inputsaleval()
{
     
      JPanel salesPanel = new JPanel();
     
      trantype = new JComboBox();
      trantype.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Credit Sales","Cash Sales"}));
      trantypestr = trantype.getSelectedItem().toString();
      if(trantypestr.equals("Credit Sales"))
      {
         trantypestr = "S01";
         
      }else if(trantypestr.equals("Credit Sales"))
      {
         trantypestr = "S02";
      }
      
      trantype.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
          trantypestr = trantype.getSelectedItem().toString();
          if(trantypestr.equals("Credit Sales"))
          {
              trantypestr = "S01";
          }else
          {
              trantypestr = "S02";
          }
        }
       });
      
    
      
      
      suppinvc = new JTextField();
     
      salesPanel.setPreferredSize(new Dimension(70, 50));
      salesPanel.setLayout(new BoxLayout(salesPanel, BoxLayout.Y_AXIS));
    
      salesPanel.add(trantype);
      salesPanel.add(suppinvc);
      
     inputsalresult = JOptionPane.showConfirmDialog(null, salesPanel,"Enter Details", JOptionPane.OK_CANCEL_OPTION);
}
    
    
    
    public void SalesReport()
{
    inputsaleval();
    trantypestr = trantype.getSelectedItem().toString(); 
    
    if(trantypestr.equals("Credit Sales"))
        {
           trantypestr = "S01";
        }else
        {
           trantypestr = "S02";
        }
    
      
     
     
 if (inputsalresult == JOptionPane.OK_OPTION) {  
     try {
             trannuminit = Integer.parseInt(suppinvc.getText());            
          } catch (Exception z) { 
                JOptionPane.showMessageDialog(this, "Number only",
                    "Input error", JOptionPane.ERROR_MESSAGE);
                    suppinvc.setText("");
                    return;
            }
    if (!suppinvc.getText().isEmpty())
    {
    String varno = "";
    String vardate = "";
    String brcode = "";
    String brname ="";
    String acccode = "";
    String accname = "";
    String curr = "";
    String currrate ="";
    String disprice ="";
    String particular = "";
    String remarks ="";
    String salesmancode="";
    String salesmanname = "";
        
        
    String qry1 = "SELECT DISTINCT A.vr_no, A.vr_date, A.br_code, C.br_name, B.acc_code, B.Acc_name, (CASE A.cur_rate WHEN 1 THEN 'AED' ELSE 'USD' END) as currency, A.cur_rate,A.disc_percent,ISNULL(B.particulars,''),ISNULL(B.remarks2,''),B.sales_man, S.salesman_name FROM diczdata A LEFT JOIN dichdata B ON A.trc_code = B.trc_code AND A.vr_no = B.vr_no LEFT JOIN brmas C ON A.br_code = C.br_code LEFT JOIN salesman S ON B.sales_man = S.salesman_code WHERE A.trc_code = '"+trantypestr.trim()+"' AND A.vr_no = '"+suppinvc.getText().trim()+"'";
   
    
    String qry2 = "SELECT A.sr_no, A.ite_code, B.ite_name, 'PCS' as unit, A.ite_qty, A.ite_rate, A.ite_rate * A.ite_qty as totalprice FROM diczdata A LEFT JOIN dicihmas B on A.ite_code = B.ite_code WHERE A.trc_code = '"+trantypestr.trim()+"' AND A.vr_no = '"+suppinvc.getText().trim()+"' ORDER BY A.sr_no";
    
    Connection epoconnekt = null;
    PreparedStatement epost =null;
    PreparedStatement epost2 =null;
    ResultSet epors = null;   
    ResultSet epors2 = null; 
        try {
            
            epoconnekt =  dbconn.epormisconn();
            epost =  epoconnekt.prepareStatement(qry1);
            epors = epost.executeQuery();
            epost2 =  epoconnekt.prepareStatement(qry2);
            epors2 = epost2.executeQuery();
            
           
            
           
            if(epors.next())
            {
                varno = epors.getString(1);
                vardate = epors.getString(2);
                brcode = epors.getString(3);
                brname = epors.getString(4);
                acccode = epors.getString(5);
                accname = epors.getString(6);
                curr = epors.getString(7);
                currrate = epors.getString(8);
                disprice = epors.getString(9);
                particular = epors.getString(10);
                remarks =  epors.getString(11);
                salesmancode = epors.getString(12);
                salesmanname =  epors.getString(13);
                
                
            }
            
        //clear & fill data in table 
           
          Vector columnNames = new Vector();
          Vector data = new Vector();
          ResultSetMetaData metaData = epors2.getMetaData(); 
          int columns = epors2.getMetaData().getColumnCount();  

          
           for (int i = 1; i <= columns; i++) {
                columnNames.addElement(metaData.getColumnName(i));
            }  
       
          while (epors2.next()) {
                Vector row = new Vector(columns);
                for (int i = 1; i <= columns; i++) {
                    row.addElement(epors2.getObject(i));
                    
                }
             data.addElement(row);
            }
          epors2.close();
            
            final DefaultTableModel minemodel = new DefaultTableModel(data,columnNames);
            salestable.setModel(minemodel);
        
          //System.out.println("cell value" + salestable.getModel().getValueAt(0,1));
          //clear & fill data in table  
          jasperSalesReport(salestable,varno,vardate,brcode,brname,acccode,accname,curr,currrate,disprice,particular,remarks,salesmancode,salesmanname); 
          
           insertviewnumber();
            
        } catch (Exception ex) {
            Logger.getLogger(SearchEanPanelNormal.class.getName()).log(Level.SEVERE, null, ex);
           
           
        }
    }
    else
    {
        JOptionPane.showMessageDialog(this,"Please Enter Fields!"); 
    }
 }
 
        
}
   
    
public void jasperSalesReport(JTable table,String vrnum,String vrdate,String brcode,String brname,String acccode,String accname,String curr,String currrate, String dispercent,String particular,String headremarks,String salemancode,String salesmanname) throws JRException
 {
     
int rowcount = 0;     
List Resultadospack = new ArrayList();
String credorcash = "";
DecimalFormat dFormat = new DecimalFormat("####,###,###.00");
double pergrndtot = 0;
int pertotqty = 0;
double distot = 0;
double totgrand = 0;
double totdis = 0;
double nettot = 0;
int totqty = 0;
int serialnum = 1;
SaleBeanData collectiondate;
Resultadospack.clear();
if(trantypestr.equals("S01") || trantypestr.equals("Credit Sales"))
{
    credorcash = "CREDIT";
            
}else if(trantypestr.equals("S02") || trantypestr.equals("Cash Sales")) 
{
   credorcash = "CASH"; 
}

Map map = new HashMap();
JDialog reporte = new JDialog();
reporte.setSize(900,700);
reporte.setLocationRelativeTo(null);

map.put("accnum",acccode);//Parameter value is title
map.put("accname",accname);
map.put("docnum",vrnum);
map.put("docdate",vrdate);
map.put("brcode",brcode);
map.put("brname",brname);
map.put("particular",particular);
map.put("headremarks",headremarks);
map.put("salesmancode", salemancode);
map.put("salesmanname",salesmanname);
map.put("creditorcash",credorcash );

System.out.println("test sale name "+ salesmanname);
System.out.println("test cash "+ credorcash);

for(rowcount = 0; rowcount<table.getRowCount();rowcount++)
{
    
pergrndtot = table.getModel().getValueAt(rowcount,6).toString().trim().equals("") ? 0 : Double.parseDouble(String.valueOf(table.getModel().getValueAt(rowcount,6).toString()));
totgrand = totgrand + pergrndtot;
pertotqty =  table.getValueAt(rowcount,4).toString().trim().equals("")? 0 : (int)Double.parseDouble(table.getValueAt(rowcount,4).toString());
totqty = totqty + pertotqty;


collectiondate = new SaleBeanData( String.valueOf(serialnum), //table.getValueAt(start,2)
                       String.valueOf(table.getValueAt(rowcount,1)),
                       String.valueOf(table.getValueAt(rowcount,2)),
                       String.valueOf(table.getValueAt(rowcount,3)),
                       String.valueOf((int)Double.parseDouble(table.getModel().getValueAt(rowcount,4).toString())),
                       String.valueOf(dFormat.format(Double.parseDouble(table.getModel().getValueAt(rowcount,5).toString()))),
                       String.valueOf(dFormat.format(Double.parseDouble(table.getModel().getValueAt(rowcount,6).toString()))));
serialnum++; 
//grandtotal = grandtotal + Integer.parseInt(String.valueOf(table.getValueAt(start,7)));
Resultadospack.add(collectiondate);


}

distot = dispercent.equals("") ? 0 : Double.parseDouble(dispercent);

totdis =  (distot * totgrand)/100;
nettot = totgrand - totdis;

String decintext = String.valueOf(dFormat.format(nettot)).substring(String.valueOf(dFormat.format(nettot)).indexOf("."));
map.put("grosstot", String.valueOf(dFormat.format(totgrand)));
map.put("distot", String.valueOf(dFormat.format(totdis)));
map.put("nettot", String.valueOf(dFormat.format(nettot)));
map.put("qtytot", String.valueOf(totqty));
map.put("prtby", gv.getGlobusername());
map.put("prtat",String.valueOf((date)));
map.put("currtotext",EnglishNumberToWords.convert((int)nettot)+" "+ EnglishNumberToWords.convertDicimal(decintext));

if(curr.equals("AED"))
{
map.put("currtyp","Total DHS :");    
}else
{
map.put("currtyp","Total USD :");
}


JasperPrint jPrint = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("eancode/salesreport.jasper"),map, new JRBeanCollectionDataSource(Resultadospack));
JRViewer jv = new JRViewer(jPrint);
reporte.getContentPane().add(jv);
reporte.setVisible(true);  
     
    
 }
    
    
public void insertviewnumber()
{
        try {
            String userviews = "";
            String invnum = String.valueOf(trannuminit);
            String userexist = "select invviewnum from salesinvprintmng where username = '" + gv.getGlobusername() + "' AND invno = '"+invnum+"'";
            
          System.out.println(userexist);
            connekt =  dbconn.conn();
            pst = connekt.prepareStatement(userexist);
            rs = pst.executeQuery();
            
            if(rs.next())
            {
                String viewnum = String.valueOf(Integer.parseInt(rs.getString(1)) + 1);
                userviews = "update salesinvprintmng set invviewnum = '"+ viewnum +"' where username = '" + gv.getGlobusername() + "' AND invno = '"+invnum+"'";
              
            }
            else
            {
                String viewstr = String.valueOf("1");
                userviews = "insert into salesinvprintmng values('"+gv.getGlobusername()+"','"+invnum+"','"+viewstr+"')";
                
            }
            
             pst = connekt.prepareStatement(userviews);
             pst.executeUpdate();
            
        } catch (Exception ex) {
            Logger.getLogger(SalesInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    
}


    
}
