/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eancode;

import SearchPack.AutoCompleteDBLink;
import SearchPack.AutoTextComplete;
import eancode.helpers.MatImage;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;


/**
 *
 * @author santosh
 */

public class EanScanned extends javax.swing.JFrame {

    /**
     * Creates new form EanScanned
     */
    
    AutoTextComplete atcDes; 
    AutoTextComplete atcctry; 
    AutoCompleteDBLink autocdblink;
    DbConnection dbconn = new DbConnection(); 
    GlobalVariable gv = new GlobalVariable();
    Connection scanconnekt = null;
    Statement scanstmt = null;
    PreparedStatement scanpst =null;
    ResultSet scanrs = null;
    Connection epoconnekt = null;
    Statement sepostmt = null;
    PreparedStatement epopst =null;
    ResultSet epors = null;
    String newean = "";
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date(); 
    String currdoctype = "";
    String currdocnumtxt = "";
    String cntrycod = "";
    String currusername = gv.getGlobusername(); 
    String curreancode = "";
    String currmat = "";
    String currdesc = "";
    String currdoctyp = "";
    String currdocnum = "";
    String cuurcountrycode = "";
    int rowclick = 0;
    int colclick  = 0;    
    boolean hasSpecialChar = false;
    String currdes = "";
    String  des = "";
    String empromismat = "";    
    String d_f = "";
    String qty = "";    
    String ctry = "";
    String whgt = "";
    String condstr = "";
    DateFormat yeartwodig = new SimpleDateFormat("yy"); // Just the year, with last 2 digits
    String formatyeartwodig = yeartwodig.format(Calendar.getInstance().getTime());
    String grnnum = "";
    String epromisecode = "";
    String countryqry = "select Description, Country from countrymas";
    JComponent matcomponent = null;
    String searchstring = "";
    MatImage maturl = new MatImage();
    DefaultTableModel dm; 
    
    public EanScanned() {
        
        initComponents();
     
       
        atcctry = new AutoTextComplete(inputtbl);
        atcctry.setActiveColumn(3);
        getCountryName();
        
//        atcDes = new AutoTextComplete(inputtbl);
//        atcDes.setActiveColumn(0);
        //getMatName();
        currdoctype = doctypecmb.getSelectedItem().toString().trim();
        jScrollPane2.setVisible(false);
        gv.setAppDefaultImg(this);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        grnstartbtn.setEnabled(false);
        txtean.setEnabled(false);
        doctypecmb.setVisible(true);
        txtdocno.setVisible(true);
        error.setVisible(false);
        btnassign.setVisible(false);
        toglectrorg.setVisible(false);
        btnclose.setVisible(false);
        endgrnbtn.setVisible(false);
        lblgrn.setVisible(false);
        grntxt.setVisible(false); 
        entereancode.setVisible(false);
              
    }
    
public void getCountryName()
{
    try{
          scanconnekt =  dbconn.conn();
          autocdblink = new AutoCompleteDBLink(atcctry, countryqry, scanconnekt,3); 
    }catch(ClassNotFoundException ex) {
          Logger.getLogger(EanScanned.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public void getMatName(String inputchar)
        {
         try {
             epoconnekt =  dbconn.epormisconn();
             
//autocdblink = new AutoCompleteDBLink(atcDes, condstr, epoconnekt,0); 
             
             matcomponent = entereancode;  
             AutoTextComplete atcomp = new AutoTextComplete(matcomponent);
             autocdblink = new AutoCompleteDBLink(atcomp,epoconnekt,inputchar); /*, users, connekt*/ 
             
        } catch (Exception ex) {
            Logger.getLogger(EanScanned.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtean = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        error = new javax.swing.JLabel();
        btnassign = new javax.swing.JButton();
        doctypecmb = new javax.swing.JComboBox();
        txtdocno = new javax.swing.JTextField();
        toglectrorg = new javax.swing.JToggleButton();
        btnclose = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        inputtbl = new javax.swing.JTable();
        lblgrn = new javax.swing.JLabel();
        grntxt = new javax.swing.JTextField();
        grnstartbtn = new javax.swing.JButton();
        endgrnbtn = new javax.swing.JButton();
        savemsg = new javax.swing.JLabel();
        entereancode = new javax.swing.JTextField();
        imglbl = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setTitle("Jizan Scanner");
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        txtean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txteanActionPerformed(evt);
            }
        });
        txtean.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txteanKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txteanKeyTyped(evt);
            }
        });

        jLabel1.setText("Scan Ean");

        error.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        error.setForeground(new java.awt.Color(0, 102, 51));
        error.setText("Not found");

        btnassign.setBackground(new java.awt.Color(51, 204, 0));
        btnassign.setText("Assign");
        btnassign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnassignActionPerformed(evt);
            }
        });

        doctypecmb.setBackground(new java.awt.Color(204, 204, 255));
        doctypecmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ISR", "LGR", "MTN", "AR", "Current" }));
        doctypecmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                doctypecmbItemStateChanged(evt);
            }
        });
        doctypecmb.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                doctypecmbPropertyChange(evt);
            }
        });

        txtdocno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdocnoActionPerformed(evt);
            }
        });
        txtdocno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdocnoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdocnoKeyTyped(evt);
            }
        });

        toglectrorg.setBackground(new java.awt.Color(51, 204, 0));
        toglectrorg.setText("OK");
        toglectrorg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                toglectrorgItemStateChanged(evt);
            }
        });
        toglectrorg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toglectrorgActionPerformed(evt);
            }
        });

        btnclose.setBackground(new java.awt.Color(204, 204, 255));
        btnclose.setText("End");
        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        inputtbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Des", "epromis-code", "qty", "country", "weight"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        inputtbl.setAutoscrolls(false);
        inputtbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputtblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inputtblMouseEntered(evt);
            }
        });
        inputtbl.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                inputtblComponentHidden(evt);
            }
        });
        inputtbl.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputtblFocusGained(evt);
            }
        });
        inputtbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputtblKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputtblKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputtblKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(inputtbl);
        if (inputtbl.getColumnModel().getColumnCount() > 0) {
            inputtbl.getColumnModel().getColumn(0).setPreferredWidth(400);
            inputtbl.getColumnModel().getColumn(2).setPreferredWidth(40);
            inputtbl.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        jScrollPane3.setViewportView(jScrollPane2);

        lblgrn.setForeground(new java.awt.Color(153, 153, 153));
        lblgrn.setText("GRN No.");

        grntxt.setEditable(false);

        grnstartbtn.setBackground(new java.awt.Color(204, 204, 255));
        grnstartbtn.setText("Start");
        grnstartbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grnstartbtnActionPerformed(evt);
            }
        });

        endgrnbtn.setBackground(new java.awt.Color(204, 204, 255));
        endgrnbtn.setText("End GRN");
        endgrnbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endgrnbtnActionPerformed(evt);
            }
        });

        savemsg.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        savemsg.setForeground(new java.awt.Color(0, 102, 0));

        entereancode.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                entereancodeInputMethodTextChanged(evt);
            }
        });
        entereancode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                entereancodeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                entereancodeKeyReleased(evt);
            }
        });

        imglbl.setBackground(new java.awt.Color(255, 255, 255));
        imglbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imglbl.setText("Image Appears Here");
        imglbl.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 0, 255), null));
        imglbl.setMaximumSize(new java.awt.Dimension(118, 100));
        imglbl.setMinimumSize(new java.awt.Dimension(118, 100));
        imglbl.setPreferredSize(new java.awt.Dimension(118, 100));

        jButton1.setText("Missing?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(savemsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(toglectrorg, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnassign, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(223, 223, 223)
                                .addComponent(lblgrn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(113, 113, 113))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(224, 224, 224)
                                        .addComponent(doctypecmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtdocno, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtean, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(grntxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(entereancode))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(12, 12, 12)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(grnstartbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnclose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(endgrnbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(imglbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imglbl, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel1))
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtean, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(doctypecmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdocno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnclose))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(grnstartbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(endgrnbtn))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblgrn)
                                .addComponent(grntxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(entereancode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(savemsg, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnassign)
                        .addComponent(toglectrorg)
                        .addComponent(error)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txteanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txteanKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txteanKeyTyped

    private void txteanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txteanKeyReleased
    //TODO add your handling code here:

    if(evt.getKeyCode() == evt.VK_ENTER) {
          // your code is scanned and you can access it using frame.getBarCode()
          // now clean the bar code so the next one can be read
         savemsg.setText("");
         newean = txtean.getText();
        try{
            
            txtean.setText("");
            entereancode.setVisible(true);
            
            searchInMaster(newean); 
            
            System.out.println(newean);
                        
         } catch (Exception ex) {
            Logger.getLogger(EanScanned.class.getName()).log(Level.SEVERE, null, ex);
         } 
      } 
     
    }//GEN-LAST:event_txteanKeyReleased

    private void btnassignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnassignActionPerformed
        try {
            // TODO add your handling code here:
           
           insertneweancode();  
           error.setText("");
           entereancode.setText("");
        } catch (Exception ex) {
            Logger.getLogger(EanScanned.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_btnassignActionPerformed

 public int checkExistCode()
                {
     String checkmatcode = "select empromisname from eancodescaniastbl where eancode ='"+newean+"'";  
        try {
            scanconnekt =  dbconn.conn();
            scanpst = scanconnekt.prepareStatement(checkmatcode);
            scanrs = scanpst.executeQuery();  
      if(scanrs.next())
         {
        System.out.println("value......"+inputtbl.getValueAt(0,1).toString().trim());
        System.out.println("epromis code......"+scanrs.getString(1).trim());
        
        if(!inputtbl.getModel().getValueAt(0,0).toString().trim().equals(scanrs.getString(1).trim()))
           {
            System.out.println(inputtbl.getValueAt(0,0).toString().trim()+ "----------------"+scanrs.getString(1).trim() );
            JOptionPane.showMessageDialog(this, newean + " ---> IS ALREADY LINKED TO \n" + scanrs.getString(1)); 
            error.setText(newean);   
            return 0; // not insert in master                
           }else
           {
            return 1;   // only insert in transaction tbl
           }   
       }
      else
       {
         return 2; //insert in both master and transation
       }  

        } catch (Exception ex) {
            Logger.getLogger(EanScanned.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 2;

    }    

 
    private void txteanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txteanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txteanActionPerformed

   
public void grnNewSerialNumber(String grnserialnum,String grnstatus) throws Exception
{
  
         String addnewgrnstat = "insert into grnseriestbl(doctype,docnum,grnserlnum,grnstatus) values ('"+ currdoctype +"','"+ currdocnumtxt +"','" + grnserialnum + "','"+grnstatus+"')";
         System.out.println(addnewgrnstat);
         scanpst = scanconnekt.prepareStatement(addnewgrnstat);
         scanpst.executeUpdate();   
   
}


public int checkGrnTypeStatus() throws Exception
  {
     
    String docstat = "select TOP 1 grnserlnum, grnstatus from grnseriestbl Where doctype = '" + currdoctype + "' and  docnum = '" + currdocnumtxt + "' ORDER BY id DESC";
    System.out.println("tttt" + docstat); 
    scanconnekt =  dbconn.conn();
    scanpst = scanconnekt.prepareStatement(docstat);
    scanrs = scanpst.executeQuery();   
     
 if(scanrs.next())
     {
       String strstat = scanrs.getString("grnstatus").trim(); 
       grnnum = scanrs.getString("grnserlnum").trim(); 
        
       if(strstat.equals("Close"))
                {         
                    
                 getLastGrn();
                 //JOptionPane.showMessageDialog(this, "GRN Number with Doctype "+ currdoctype +"& docnum" +  currdocnumtxt + "already used !!");      
                 grnnum = String.valueOf(Integer.parseInt(grnnum) + 1); 
                 return  1;         
              }  
            else if(strstat.equals("Break"))
                    {
                return 2;
                    }
            else if(strstat.equals("Start"))
                {
               return 3;
                }     
        } 
     else
        {
        getLastGrn();
        
           return 0;
           
      //need to handle still
        }  
        return 0;
 }




public void getLastGrn() throws SQLException
{
    String isstr = "ISR";
    String grnlastnum = "";
    
    if(currdoctype.equals("ISR"))
      {
       grnlastnum = "select MAX(grnserlnum) as grnserlnummax from grnseriestbl Where doctype = '" + currdoctype + "'"; 
      }
      else
      {
       grnlastnum = "select MAX(grnserlnum) as grnserlnummax from grnseriestbl Where doctype IN ('MTN','LGR','AR')";   
      }
      
    System.out.println("tttt" + grnlastnum); 
    scanpst = scanconnekt.prepareStatement(grnlastnum);
    scanrs = scanpst.executeQuery();
      
    if(scanrs.next())
            {
    grnnum = scanrs.getString("grnserlnummax").trim();    
            }
}

public int checkdoctypestatus() throws Exception
{
    
     String docstat = "select docstatus from doctyperegistertbl Where doctype = '" + currdoctype + "' and docnum = '" + currdocnumtxt + "'";
     System.out.println("uuuu" + docstat); 
     scanconnekt =  dbconn.conn();
     scanpst = scanconnekt.prepareStatement(docstat);
     scanrs = scanpst.executeQuery();       
   if(scanrs.next())
     {
       String strstat = scanrs.getString("docstatus").toString(); 
            if(strstat.equals("Close"))
                {  
                    
              //JOptionPane.showMessageDialog(this, "Doctype "+ currdoctype +"with docnum" +  currdocnumtxt + "already used !!");      
                    return 1;
                }  
            else if(strstat.equals("Break"))
                    {
                return 2;
                    }
            else if(strstat.equals("Start"))
                {
                return 3;
                }     
        } 
     else
        {
      return 0;  
        }  
        return 0;
}
    

public void insertdocstat(String matstat) throws Exception
    {                       
String addnewmatstat = "insert into doctyperegistertbl values ('"+ currdoctype +"','" + currdocnumtxt + "','" + matstat + "')";
System.out.println(addnewmatstat);
scanpst = scanconnekt.prepareStatement(addnewmatstat);
scanpst.executeUpdate();              
    }
 
 
public void updatedocstat(String updatemat) throws Exception
 {
String updatematstr ="UPDATE doctyperegistertbl SET docstatus = '" + updatemat + "'  WHERE doctype = '" + currdoctype + "' and docnum = '"+ currdocnumtxt +"'" ; 
System.out.println(updatematstr);
scanpst = scanconnekt.prepareStatement(updatematstr);
scanpst.executeUpdate();     
 }


public void updategrndocstat(String grnnum,String grnstat) throws Exception
 {
     
    String updategrnstr ="UPDATE grnseriestbl SET grnstatus = '" + grnstat + "'  WHERE doctype = '" + currdoctype + "' and docnum = '" + currdocnumtxt + "' and grnserlnum = '"+grnnum+"'"; ; 
    System.out.println(updategrnstr);
    scanpst = scanconnekt.prepareStatement(updategrnstr);
    scanpst.executeUpdate();  
    
 }


    private void txtdocnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdocnoKeyTyped
     //TODO add your handling code here:
    //System.out.println("docnum"+txtdocno.getText().trim());  
    }//GEN-LAST:event_txtdocnoKeyTyped

    private void txtdocnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdocnoActionPerformed
     //TODO add your handling code here:
    }//GEN-LAST:event_txtdocnoActionPerformed

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
     //TODO add your handling code here:
    }//GEN-LAST:event_formComponentHidden

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
     //TODO add your handling code here:     
    }//GEN-LAST:event_formWindowStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
     //TODO add your handling code here:
     gv.getObj().scanerbtn.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

 
    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        //TODO add your handling code here:
    }//GEN-LAST:event_formKeyReleased

public void inputcontroller()
 {
     
   Pattern pattern;
   Matcher matcher;
        
        if(currdoctype.equals("Current"))
            {
              pattern  = Pattern.compile("\\d{4}");
              matcher = pattern.matcher(txtdocno.getText().trim());
              if (matcher.matches()) {
                   grnstartbtn.setText("Start");
                   grnstartbtn.setEnabled(true);
                 }else
                 {
                   grnstartbtn.setText("Start");
                   grnstartbtn.setEnabled(false);   
                 }   
            }else if(currdoctype.equals("LGR"))
            {
                pattern  = Pattern.compile("\\d{3}-\\d{2}");
                matcher = pattern.matcher(txtdocno.getText().trim());
                
                if (matcher.matches()) {
                grnstartbtn.setText("Start");
                grnstartbtn.setEnabled(true);
                }else
                {
                  grnstartbtn.setText("Start");
                  grnstartbtn.setEnabled(false);  
                }
               
            }else if(currdoctype.equals("ISR"))
            {
                pattern  = Pattern.compile("\\d{4}-\\d{2}");
                matcher = pattern.matcher(txtdocno.getText().trim());
                
                if (matcher.matches()) {
                grnstartbtn.setText("Start");
                grnstartbtn.setEnabled(true);
                }else
                {
                    grnstartbtn.setText("Start");
                    grnstartbtn.setEnabled(false); 
                }
            }else if(currdoctype.equals("MTN"))
            {
                pattern  = Pattern.compile("\\d{5}");
                matcher = pattern.matcher(txtdocno.getText().trim());
                
                if (matcher.matches()) {
                grnstartbtn.setText("Start");
                grnstartbtn.setEnabled(true);
                }else
                {
                    grnstartbtn.setText("Start");
                    grnstartbtn.setEnabled(false); 
                }
            }else if(currdoctype.equals("AR"))
            {
                pattern  = Pattern.compile("\\d{4}-\\d{2}");
                matcher = pattern.matcher(txtdocno.getText().trim());
                
                if (matcher.matches()) {
                grnstartbtn.setText("Start");
                grnstartbtn.setEnabled(true);
                }
                else
                {
                    grnstartbtn.setText("Start");
                    grnstartbtn.setEnabled(false); 
                } 
            }  
 }
    

    private void txtdocnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdocnoKeyReleased
        // TODO add your handling code here:
        inputcontroller(); 
    }//GEN-LAST:event_txtdocnoKeyReleased

    private void doctypecmbPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_doctypecmbPropertyChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_doctypecmbPropertyChange

    private void doctypecmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_doctypecmbItemStateChanged
        //TODO add your handling code here:
        currdoctype = doctypecmb.getSelectedItem().toString().trim();
        inputcontroller(); 
        
        
    }//GEN-LAST:event_doctypecmbItemStateChanged

    private void toglectrorgItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_toglectrorgItemStateChanged
      // TODO add your handling code here:
   
//        
//      if(evt.getStateChange()==evt.SELECTED){
//                        if(jScrollPane2.isVisible()== true)
//                        {
//                        inputtbl.getModel().setValueAt("",0,2);
//                        inputtbl.getModel().setValueAt("",0,3);
//                        }
//   
// if(toglectrorg.getActionCommand().equals("New"))
//            {
//    inputtbl.setEnabled(true);              
//    inputtbl.setBackground(new java.awt.Color(153,255,153));
//    toglectrorg.setBackground(new java.awt.Color(153,255,153));
//    toglectrorg.setText("OK");
//            }
//        }else if(evt.getStateChange()==evt.DESELECTED){
//        try {
//          
//            if(toglectrorg.getActionCommand().equals("OK"))
//                    {        
//            insertneweancode();
//            toglectrorg.setSelected(true);
//            toglectrorg.setText("OK");
//            error.setText("");
//                    }
//          }catch (SQLException ex) {
//              Logger.getLogger(EanScanned.class.getName()).log(Level.SEVERE, null, ex);
//         } 
//      }
    
    }//GEN-LAST:event_toglectrorgItemStateChanged

    private void toglectrorgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toglectrorgActionPerformed
        // TODO add your handling code here:
           try {
            if(toglectrorg.getActionCommand().equals("OK"))
                    {        
            insertneweancode();
//            toglectrorg.setSelected(true);
//            toglectrorg.setText("OK");
            
            error.setText("");
            entereancode.setText("");
            
                    }
          }catch (SQLException ex) {
              Logger.getLogger(EanScanned.class.getName()).log(Level.SEVERE, null, ex);
         }    
    }//GEN-LAST:event_toglectrorgActionPerformed

    private void inputtblComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_inputtblComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_inputtblComponentHidden

    private void inputtblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputtblMouseClicked
        // TODO add your handling code here:
//      rowclick = inputtbl.getSelectedRowCount();
//      colclick = inputtbl.getSelectedColumnCount();
//        if(evt.getClickCount() == 2)
//        {
//         rowclick = inputtbl.rowAtPoint(evt.getPoint());
//         colclick = inputtbl.columnAtPoint(evt.getPoint());
//        
//        }
         colclick = inputtbl.getSelectedColumn();
        
        
    }//GEN-LAST:event_inputtblMouseClicked

 public void getDropDown(java.awt.event.KeyEvent evt)
            {
     Pattern pattern  = Pattern.compile("[a-zA-Z0-9]"); 
     System.out.println("condstr" + condstr.length());
     //System.out.println("works" + condstr);
     Matcher matcher = pattern.matcher(condstr);
     if(matcher.matches()) {
            System.out.println("intput string" + condstr );   
            try {
                    epoconnekt =  dbconn.epormisconn();
                    autocdblink = new AutoCompleteDBLink(atcDes, condstr, epoconnekt,0);
                         
                } catch (ClassNotFoundException ex) {
                     Logger.getLogger(EanScanned.class.getName()).log(Level.SEVERE, null, ex);
                 }
               
                 }
          
      if(evt.getKeyCode()== KeyEvent.VK_TAB || evt.getKeyCode()== KeyEvent.VK_LEFT)
            {
        Set set2 = gv.getMyMap().entrySet();

        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
         Map.Entry mentry2 = (Map.Entry)iterator2.next();
         if(mentry2.getValue().toString().equals(inputtbl.getValueAt(0,0).toString()))
             {
            inputtbl.getModel().setValueAt(mentry2.getKey().toString().trim(),0,1);
             }
       }  
       System.out.println("test after tab");   
      }
                
}
    
    
    private void inputtblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputtblKeyReleased
     // TODO add your handling code here:
  
//        
//    if(rowclick == 0 && colclick == 0) {
//       
//      
//                
//        
//      if (evt.getKeyCode() == KeyEvent.VK_DELETE || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_LEFT || evt.getKeyCode() == KeyEvent.VK_RIGHT || evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_TAB)
//        {
//            condstr = condstr.substring(0, condstr.length()-1);
//            
//            System.out.println("after back space" + condstr);
//              
//            
//        }
//         else
//        {
//                   
//            
//         condstr  = condstr + evt.getKeyChar();
//            
//         
//         System.out.println("rownum"+ rowclick + "col"+ colclick);
//         
//         inputtbl.getModel().setValueAt("",0,0);    
//           
//           
//        }
//          
//            
//        }  
//       Pattern pattern  = Pattern.compile("[a-zA-Z0-9]");
//      
//       Matcher matcher = pattern.matcher(condstr);
//                if (matcher.matches()) {
//                System.out.println("intput string" + condstr );   
//                    try {
//                             epoconnekt =  dbconn.epormisconn();
//                             autocdblink = new AutoCompleteDBLink(atcDes, condstr, epoconnekt,0);
//                         } catch (ClassNotFoundException ex) {
//                             Logger.getLogger(EanScanned.class.getName()).log(Level.SEVERE, null, ex);
//                         }
//                 }
      if(evt.getKeyCode()== KeyEvent.VK_TAB || evt.getKeyCode()== KeyEvent.VK_LEFT)
      {
          colclick = inputtbl.getSelectedColumn();
        Set set2 = gv.getMyMap().entrySet();

        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
         Map.Entry mentry2 = (Map.Entry)iterator2.next();
         if(mentry2.getValue().toString().equals(inputtbl.getValueAt(0,0).toString()))
             {
            inputtbl.getModel().setValueAt(mentry2.getKey().toString().trim(),0,1);
             }
       }
          
       System.out.println("test after tab"); 

}
  
    }//GEN-LAST:event_inputtblKeyReleased

    private void inputtblKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputtblKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_inputtblKeyTyped

    private void inputtblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputtblKeyPressed

// TODO add your handling code here:  
//if(rowclick == 0 && colclick == 0){
//    
//  if(evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)
//    {
//     if(condstr.length() > 0 )
//         {
//      condstr = condstr.substring(0, condstr.length()-1);
//      System.out.println("current string is : " + condstr);  
//       getDropDown(evt);
//        }
//    }else
//        {
//            condstr  = condstr + evt.getKeyChar(); 
//             getDropDown(evt);
//        }
//}
        
    }//GEN-LAST:event_inputtblKeyPressed

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                        // TODO add your handling code here:
                        updatedocstat("Close");
                        btnclose.setVisible(false);
                        newean = "";
                        txtean.setEnabled(false);
                        grnstartbtn.setText("Start");
                        grnstartbtn.setEnabled(false);
                        grntxt.setText("");
                        endgrnbtn.setVisible(false);
                        txtdocno.setText("");
                        doctypecmb.setEnabled(true);
                        txtdocno.setEnabled(true);
                        txtean.setEnabled(false);
                        error.setVisible(false);
                        btnassign.setVisible(false);
                        jScrollPane2.setVisible(false);
                        toglectrorg.setVisible(false);
                        entereancode.setText("");
                        entereancode.setVisible(false);
            
             } catch (Exception ex) {
                        Logger.getLogger(EanScanned.class.getName()).log(Level.SEVERE, null, ex);
                    }
             } else {
                    // no option
                }
                
    }//GEN-LAST:event_btncloseActionPerformed

    private void grnstartbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grnstartbtnActionPerformed
        // TODO add your handling code here:
        
      if("Start".equals(evt.getActionCommand()))
        {
           if(txtdocno.getText().trim().length() >= 4)
            {   
              currdoctype = doctypecmb.getSelectedItem().toString().trim();
              currdocnumtxt = txtdocno.getText().trim();
              try {
                  int matchnum = checkdoctypestatus();
              if(matchnum == 3 )
                    {        
                        if(!currdoctype.equals("Current"))
                                {
                             btnclose.setVisible(true);      
                                } 
                    updatedocstat("Start");
                    
                    }
            else if (matchnum == 2)
                    {
                        //update
                      
                        if(!currdoctype.equals("Current"))
                                {
                                  btnclose.setVisible(true);      
                                } 
                        
                       updatedocstat("Break");
  
                    } 
            else if(matchnum == 0 )
                        {
                              if(!currdoctype.equals("Current"))
                                {
                                        btnclose.setVisible(true);      
                                } 
                              insertdocstat("Start");
                
                        }
            else if (matchnum == 1)
                    {
                    JOptionPane.showMessageDialog(this, "Doctype "+ currdoctype +" with docnum " +  currdocnumtxt + " already used !!"); 
                    return;
                    }
   
                } catch (Exception ex) {
                    Logger.getLogger(EanScanned.class.getName()).log(Level.SEVERE, null, ex);
                }
       
        }
           
/*Started - to check for grn proper number and auto increament*/
           
                            try
                            {
                                                             
                              if(currdoctype.equals("ISR") || currdoctype.equals("LGR") || currdoctype.equals("MTN") || currdoctype.equals("AR"))
                               {
                                   if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
                                   JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
                                       
                                   }else
                                   {
                                     return;  
                                   }
                                   
                                int grnmatch = checkGrnTypeStatus();
                                String getgrnnum="";
                                if(grnmatch == 0 ) // new start
                                {
                                    if(currdoctype.equals("ISR"))
                                    {
                                       
                                         String grnnew = String.valueOf(Integer.parseInt(grnnum)+1);
                                         getgrnnum = grnDigit(grnnew);
                                         grnNewSerialNumber(getgrnnum,"Start");
                                        
                                         grntxt.setText("IMP. "+getgrnnum+" - "+formatyeartwodig); 
                                    }
                                    else if(currdoctype.equals("Current"))
                                    {
                                     grntxt.setText("Non");
                                    }
                                    else
                                    {
                                         String grnnew = String.valueOf(Integer.parseInt(grnnum)+1);
                                         getgrnnum = grnDigit(grnnew);
                                         grnNewSerialNumber(getgrnnum,"Start");                                      
                                         grntxt.setText("LOC. "+getgrnnum+" - "+formatyeartwodig); 
                                    }
                                    
//                                    if(currdoctype.equals("LGR"))
//                                    else if(currdoctype.equals("MTN"))
//                                    {
//                                         String grnnew = String.valueOf(Integer.parseInt(grnnum)+1);
//                                         getgrnnum = grnDigit(grnnew);
//                                         grnNewSerialNumber(getgrnnum,"Start");
//                                         grntxt.setText("LOC. "+getgrnnum+" - "+formatyeartwodig); 
//
//                                    }else if(currdoctype.equals("AR"))
//                                    {
//                                         String grnnew = String.valueOf(Integer.parseInt(grnnum)+1);
//                                         getgrnnum = grnDigit(grnnew);
//                                         grnNewSerialNumber(getgrnnum,"Start");
//                                      
//                                        grntxt.setText("LOC. "+getgrnnum+" - "+formatyeartwodig); 
//
//                                    }
//                                    else
//                                    {
//                                        
//                                        grntxt.setText("Non");
//                                    }
                                 }

                                else if(grnmatch == 2) //break
                                     {
                                        if(currdoctype.equals("ISR"))
                                          {
                                               String grnnew = String.valueOf(Integer.parseInt(grnnum));
                                               getgrnnum = grnDigit(grnnew);
                                               updategrndocstat(getgrnnum,"Break");
                                               grntxt.setText("IMP. "+getgrnnum+" - "+formatyeartwodig);

                                          }
                                        else if(currdoctype.equals("Current"))
                                            {
                                                grntxt.setText("Non");
                                            }
                                        else 
                                          {
                                              String grnnew = String.valueOf(Integer.parseInt(grnnum));
                                              getgrnnum = grnDigit(grnnew);
                                              updategrndocstat(getgrnnum,"Break");
                                              grntxt.setText("LOC. "+getgrnnum+" - "+formatyeartwodig);

                                          }
                                        
//                                        if(currdoctype.equals("LGR"))
//                                        else if (currdoctype.equals("MTN"))
//                                        {
//                                            String grnnew = String.valueOf(Integer.parseInt(grnnum));
//                                            getgrnnum = grnDigit(grnnew);
//                                            updategrndocstat(getgrnnum,"Break");
//                                            grntxt.setText("LOC. "+getgrnnum+" - "+formatyeartwodig);
//                                            
//                                        }
//                                        else if (currdoctype.equals("AR"))
//                                        {
//                                            String grnnew = String.valueOf(Integer.parseInt(grnnum));
//                                            getgrnnum = grnDigit(grnnew);
//                                            updategrndocstat(getgrnnum,"Break");
//                                            grntxt.setText("LOC. "+getgrnnum+" - "+formatyeartwodig);
//                                            
//                                        }
//                                        else 
//                                          {
//                                              grntxt.setText("Non");
//                                          }
                                   }
                             
                                else if(grnmatch == 3) 
                                  { //if windows close then it will remain //"start" status which should consider break status
                                      
                                  if(currdoctype.equals("ISR"))
                                        {
                                            String grnnew = String.valueOf(Integer.parseInt(grnnum));
                                            System.out.println("test" + grnnew);
                                            getgrnnum = grnDigit(grnnew);
                                            updategrndocstat(getgrnnum,"Start");
                                            grntxt.setText("IMP. "+getgrnnum+" - "+formatyeartwodig);
                                        }
                                  else if(currdoctype.equals("Current"))
                                    {
                                     grntxt.setText("Non");
                                    }
                                  else 
                                    {
                                        
                                      String grnnew = String.valueOf(Integer.parseInt(grnnum));
                                      getgrnnum = grnDigit(grnnew);
                                      updategrndocstat(getgrnnum,"Start");
                                      grntxt.setText("LOC. "+getgrnnum+" - "+formatyeartwodig);
                            
                                    }
                                  
//                                  if(currdoctype.equals("LGR"))
//                                  else if(currdoctype.equals("MTN"))
//                                      {
//                                            String grnnew = String.valueOf(Integer.parseInt(grnnum));
//                                            getgrnnum = grnDigit(grnnew);
//                                            updategrndocstat(getgrnnum,"Start");
//                                            grntxt.setText("LOC. "+getgrnnum+" - "+formatyeartwodig);
//                            
//                                       }
//                                  else if (currdoctype.equals("AR"))
//                                        {
//                                            String grnnew = String.valueOf(Integer.parseInt(grnnum));
//                                            getgrnnum = grnDigit(grnnew);
//                                            updategrndocstat(getgrnnum,"Start");
//                                            grntxt.setText("LOC. "+getgrnnum+" - "+formatyeartwodig);
//                                            
//                                        }
//                                 else
//                                        {
//                                            
//                                            grntxt.setText("Non");
//                                        }  
                                    
                                }
                        
                                else if(grnmatch == 1) //close
                                {
                                  if(currdoctype.equals("ISR"))
                                        {
       
                                            String grnnew = String.valueOf(Integer.parseInt(grnnum));
                                            getgrnnum = grnDigit(grnnew);
                                            grnNewSerialNumber(getgrnnum,"Start");
                                            grntxt.setText("IMP. "+getgrnnum+" - "+formatyeartwodig);
                                        
                                        }
                                  else if(currdoctype.equals("Current"))
                                    {
                                     grntxt.setText("Non");
                                    }
                                  else 
                                     {
                                            String grnnew = String.valueOf(Integer.parseInt(grnnum));
                                            getgrnnum = grnDigit(grnnew);
                                            grnNewSerialNumber(getgrnnum,"Start");
                                            grntxt.setText("LOC. "+getgrnnum+" - "+formatyeartwodig);
                            
                                      }
                                  
//                                  if(currdoctype.equals("LGR")) //from up else
//                                 else if(currdoctype.equals("MTN"))
//                                      {
//                                            String grnnew = String.valueOf(Integer.parseInt(grnnum));
//                                            getgrnnum = grnDigit(grnnew);
//                                            grnNewSerialNumber(getgrnnum,"Start");
//                                            grntxt.setText("LOC. "+getgrnnum+" - "+formatyeartwodig);
//                            
//                                       }
//                                  else if (currdoctype.equals("AR"))
//                                        {
//                                            String grnnew = String.valueOf(Integer.parseInt(grnnum));
//                                            getgrnnum = grnDigit(grnnew);
//                                            grnNewSerialNumber(getgrnnum,"Start");
//                                            grntxt.setText("LOC. "+getgrnnum+" - "+formatyeartwodig);
//                                            
//                                        } 
//                                else
//                                      {
//                                           
//                                        grntxt.setText("Non");
//                                      }  
                                    
                                    }
                         grnstartbtn.setText("Break");
                         grnstartbtn.setEnabled(true);
                         txtean.setEnabled(true);
                         doctypecmb.setEnabled(false);
                         txtdocno.setEnabled(false);
                         lblgrn.setVisible(true);
                         grntxt.setVisible(true);
                               }
                                   
                         else
                               {
                                   
                         grnstartbtn.setText("Break");
                         grnstartbtn.setEnabled(true);
                         txtean.setEnabled(true);
                         doctypecmb.setEnabled(false);
                         txtdocno.setEnabled(false);
                         lblgrn.setVisible(false);
                         grntxt.setVisible(false);
                                   
                               }
                  
           
                    }catch (Exception ex) {
                    Logger.getLogger(EanScanned.class.getName()).log(Level.SEVERE, null, ex);
                }
           
       
           
           if (currdoctype.equals("MTN") || currdoctype.equals("AR"))
                {
               endgrnbtn.setVisible(true);
               btnclose.setVisible(true); 
                }
           else  if (currdoctype.equals("ISR") || currdoctype.equals("LGR"))
               {     
             endgrnbtn.setVisible(true);
             btnclose.setVisible(true);                      
                }
           else if (currdoctype.equals("Current"))
                {
                endgrnbtn.setVisible(false);  
                btnclose.setVisible(false);
                }
           
        /*End - to check for grn proper number and auto increament*/
        }   
       
else if("Break".equals(evt.getActionCommand()))
        { 
            String getgrnnum = "";
            newean = "";
            grnstartbtn.setText("Start");
            grnstartbtn.setEnabled(true);
            endgrnbtn.setVisible(false);
            btnclose.setVisible(false);
            txtdocno.setText("");
            doctypecmb.setEnabled(true);
            txtdocno.setEnabled(true);
            txtean.setEnabled(false);
            error.setVisible(false);
            btnassign.setVisible(false);
            jScrollPane2.setVisible(false);
            toglectrorg.setVisible(false);
            
            if(currdoctype.equals("Current"))
            {
            
            }else
            {
              btnclose.setVisible(false);  
             
            }
            
    try {
             updatedocstat("Break");
               if(currdoctype.equals("ISR") || currdoctype.equals("LGR") || currdoctype.equals("MTN") || currdoctype.equals("AR"))
               {
     
                if(currdoctype.equals("ISR"))
                        {
                           
                            //5,9
                            String updategrnstat = grntxt.getText().trim().substring(5, 9);
                            //String grnnew = String.valueOf(Integer.parseInt(grnnum));
                            //getgrnnum = grnDigit(grnnew);
                            updategrndocstat(updategrnstat,"Break");
                            grntxt.setText("");
                            //grntxt.setText("IMP. "+getgrnnum+" - "+formatyeartwodig);
                        }
                      else if(currdoctype.equals("LGR"))
                        {
                            //String grnnew = String.valueOf(Integer.parseInt(grnnum));
                            String updategrnstat = grntxt.getText().trim().substring(5, 9);
                            //getgrnnum = grnDigit(grnnew);
                            updategrndocstat(updategrnstat,"Break");
                            grntxt.setText("");
                            //grntxt.setText("LOC. "+getgrnnum+" - "+formatyeartwodig);
                            
                        }
                       else if(currdoctype.equals("MTN"))
                        {
                            //String grnnew = String.valueOf(Integer.parseInt(grnnum));
                            String updategrnstat = grntxt.getText().trim().substring(5, 9);
                            //getgrnnum = grnDigit(grnnew);
                            updategrndocstat(updategrnstat,"Break");
                            grntxt.setText("");
                            //grntxt.setText("LOC. "+getgrnnum+" - "+formatyeartwodig);
                            
                        }
                        else if(currdoctype.equals("AR"))
                        {
                            //String grnnew = String.valueOf(Integer.parseInt(grnnum));
                            String updategrnstat = grntxt.getText().trim().substring(5, 9);
                            //getgrnnum = grnDigit(grnnew);
                            updategrndocstat(updategrnstat,"Break");
                            grntxt.setText("");
                            //grntxt.setText("LOC. "+getgrnnum+" - "+formatyeartwodig);
                            
                        }
                      else
                        {
                           grntxt.setText("");
                        }
               }
               else{
                 grntxt.setText("");
               }
           } catch (Exception ex) {
               Logger.getLogger(EanScanned.class.getName()).log(Level.SEVERE, null, ex);
           }
            
        }
        
       
    }//GEN-LAST:event_grnstartbtnActionPerformed

public String grnDigit(String dig)
   {
       String myfourdigit = "";
      
           if (dig.length() == 1)
             return myfourdigit = "000" + dig;
           else if(dig.length() == 2)
             return myfourdigit = "00" + dig;  
           else if(dig.length() == 3)
             return myfourdigit = "0" + dig;
           else
               return dig;  
  }
    

    
    private void endgrnbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endgrnbtnActionPerformed
        // TODO add your handling code here: 
        if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
        try {
             if(currdoctype.equals("ISR") || currdoctype.equals("LGR") || currdoctype.equals("MTN") || currdoctype.equals("AR"))
             {
                    String grnnum = grntxt.getText().substring(5,9);
                    updategrndocstat(grnnum,"Close"); 
             }
             else
             {
                    updategrndocstat(grntxt.getText(),"Close"); 
                 
             }
             } catch (Exception ex) {
            Logger.getLogger(EanScanned.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnclose.setVisible(false);
        newean = "";
        txtean.setEnabled(false);
        grnstartbtn.setText("Start");
        endgrnbtn.setVisible(false);
        grntxt.setText("");
        grnstartbtn.setEnabled(false);
        txtdocno.setText("");
        doctypecmb.setEnabled(true);
        txtdocno.setEnabled(true);
        txtean.setEnabled(false);
        error.setVisible(false);
        btnassign.setVisible(false);
        jScrollPane2.setVisible(false);
        toglectrorg.setVisible(false);
        entereancode.setText("");
        entereancode.setVisible(false);
        }
        else
        {
            //no option
        }
        
    }//GEN-LAST:event_endgrnbtnActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void inputtblFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputtblFocusGained
        // TODO add your handling code here:
      
 
    }//GEN-LAST:event_inputtblFocusGained

    private void inputtblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputtblMouseEntered
      //TODO add your handling code here:
      colclick = inputtbl.getSelectedColumn();
    }//GEN-LAST:event_inputtblMouseEntered
  
    
    
    
    private void entereancodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_entereancodeKeyReleased
      //TODO add your handling code here:
      
   if(entereancode.getText().isEmpty())
        {
            entereancode.setText("");

          
        }
        
      if (evt.getKeyCode() == KeyEvent.VK_DELETE || evt.getKeyCode() == KeyEvent.VK_LEFT || evt.getKeyCode() == KeyEvent.VK_RIGHT || evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_TAB)
        {
          
       } 
       else{ 
                System.out.println("testtttt.........."+entereancode.getText());           
               getMatName(entereancode.getText());
      }
        
      

//        char manupulate = ' ';
//        if (evt.getKeyCode() == KeyEvent.VK_DELETE || evt.getKeyCode() == KeyEvent.VK_LEFT || evt.getKeyCode() == KeyEvent.VK_RIGHT || evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_TAB)
//        {
//          
//        }else if(evt.getKeyCode() == KeyEvent.VK_ENTER)
//         {
//            searchstring = "";        
//         }else if(evt.getKeyCode() == KeyEvent.VK_SPACE )
//         {
//             
//           searchstring =   searchstring + manupulate;
//             
//         }
//         else if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)
//         {
//             if(!searchstring.isEmpty())
//             {
//                 searchstring = searchstring.substring(0, searchstring.length()-1);
//          System.out.println("testttttttttttttttttt................."+ searchstring );
//             }
//         }
//         else
//         {   
//         searchstring = searchstring + evt.getKeyChar();
//         getMatName(searchstring);  
//         }
         
    }//GEN-LAST:event_entereancodeKeyReleased

    private void entereancodeInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_entereancodeInputMethodTextChanged
        // TODO add your handling code here:
     
         if(entereancode.getText().isEmpty())
        {
            entereancode.setText("");
        }
        
        
        
        
    }//GEN-LAST:event_entereancodeInputMethodTextChanged

    private void entereancodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_entereancodeKeyPressed
        // TODO add your handling code here:
  if (evt.getKeyCode() == KeyEvent.VK_ENTER)
  {
      
      if(!entereancode.getText().isEmpty())
      {
        inputtbl.getModel().setValueAt(entereancode.getText(), 0, 0);
          
       
        Set set2 = gv.getMyMap().entrySet();

        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
         Map.Entry mentry2 = (Map.Entry)iterator2.next();
         if(mentry2.getValue().toString().equals(inputtbl.getValueAt(0,0).toString()))
             {
                 
            inputtbl.getModel().setValueAt(mentry2.getKey().toString().trim(),0,1);
            //URL url = new URL(maturl.getImage(mentry2.getKey().toString().trim()));
           // BufferedImage image = ImageIO.read(url); 
            imglbl.setText("<html><img width='200' height='200' src='" + maturl.getImage(mentry2.getKey().toString().trim()) + "'</img></html>");
            //imglbl.setIcon(new javax.swing.ImageIcon(maturl.getImage(mentry2.getKey().toString().trim())));
            System.out.println("url of pic...."+maturl.getImage(mentry2.getKey().toString().trim()));
             
             }
       }
      }
      
  }


        
        
    }//GEN-LAST:event_entereancodeKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Docmissing docm = new Docmissing();
        docm.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

//    System.out.println("is goes focusable");
//    dm = (DefaultTableModel)inputtbl.getModel();

     
    
public void searchInMaster(String currean)
{
   String mysearchmaster = "select TOP 1 empromisname,empromiscode,'' as dumpqty ,countryorig,''  as dumpwgt FROM eancodescaniastbl WHERE eancode = '" + currean + "'";
  
   System.out.println("mysearch" + mysearchmaster);
   
   Component co = inputtbl.getEditorComponent(); 
        if (co != null) { 
                TableCellEditor tce = inputtbl.getCellEditor(); 
                tce.stopCellEditing(); 
            } 
        Filltbl(mysearchmaster,inputtbl);
        
}    
    



    
//public void searcheancode(String currean)
//{
//    
//     String mysearch = "select TOP 1 des,epromis_material,qty,contrycode,weight FROM eancodetbl WHERE eancode = '" + currean + "'";
//        
//        
//     System.out.println("mysearch" + mysearch);
//        
//        
//        Component co = inputtbl.getEditorComponent(); 
//        if (co != null) { 
//                TableCellEditor tce = inputtbl.getCellEditor(); 
//                tce.stopCellEditing(); 
//            } 
//        Filltbl(mysearch,inputtbl);
//    
//    
//}
    
    
public void insertneweancode() throws SQLException
    {
    
     int last = inputtbl.getRowCount(); 
     Component co = inputtbl.getEditorComponent(); 
     if(co != null) { 
        TableCellEditor seltce = inputtbl.getCellEditor(); 
        seltce.stopCellEditing();      
        } 

if(inputtbl.getValueAt(0,0).toString()!=null && inputtbl.getValueAt(0,1).toString()!=null && inputtbl.getValueAt(0,2).toString()!=null && inputtbl.getValueAt(0,3).toString()!=null && inputtbl.getValueAt(0,4).toString()!=null)
        {
             

             String currgrntxt = "";
             currdes = (String) inputtbl.getValueAt(0,0).toString().trim();
             des = currdes.replace("'","");
             empromismat = (String) inputtbl.getValueAt(0,1).toString().trim();
             
//d_f =(String) inputtbl.getValueAt(0,SD).toString().trim();
             
             qty = (String) inputtbl.getValueAt(0,2).toString().trim();    
             
             ctry = inputtbl.getValueAt(0,3).toString().trim();
             
             if(ctry.contains("-"))
             {
               ctry = inputtbl.getValueAt(0,3).toString().trim().substring(inputtbl.getValueAt(0,3).toString().trim().indexOf("-") + 1);
             }
             
             
             whgt = (String) inputtbl.getValueAt(0,4).toString().trim();
             String goodqtystr = qty;
             String dmgboxqtystr = "";
             String dmgleakqtystr = "";
             String dmgbrkqtystr = "";
             String remarkstr = "";
             String lotnum = "";
            
             if(!grntxt.getText().trim().isEmpty() && currdoctype.equals("ISR") )
             {
                 currgrntxt = "IMP. "+grntxt.getText().trim().substring(5,9)+" - "+formatyeartwodig;
             }else if(!grntxt.getText().trim().isEmpty() && currdoctype.equals("LGR"))
             {
                currgrntxt = "LOC. "+grntxt.getText().trim().substring(5,9)+" - "+formatyeartwodig;
             }else if(!grntxt.getText().trim().isEmpty() && currdoctype.equals("MTN"))
             {
                currgrntxt = "LOC. "+grntxt.getText().trim().substring(5,9)+" - "+formatyeartwodig;
             }else if(!grntxt.getText().trim().isEmpty() && currdoctype.equals("AR"))
             {
                currgrntxt = "LOC. "+grntxt.getText().trim().substring(5,9)+" - "+formatyeartwodig;
             }
             else
             {
                currgrntxt = "";
             }
                 
         
             
             if(checkExistCode() == 0) // just return
             {
                return;
                
             }else if(checkExistCode() == 1) //insert only transaction table
             {
                 
            String currdate = dateFormat.format(date); 
            String addnewrow = "insert into eancodetbl(date,eancode,epromis_material,des,doctype,docnum,cond_goodqty,cond_dmgboxqty,cond_dmgleakqty, cond_dmgbrkqty,qty,weight,contrycode,remark,username,lotnumber,grnnum) values ('"+ currdate +"','" + newean + "','" + empromismat + "','" + des + "',"
                    + "'" + currdoctype + "','"+ currdocnumtxt + "','" + goodqtystr + "','" + dmgboxqtystr + "','" + dmgleakqtystr + "','" + dmgbrkqtystr +"','" + qty + "','" + whgt + "','" + ctry + "','" + remarkstr +"','" + currusername +"','" + lotnum +"','"+currgrntxt+"')";
            
            System.out.println("insert into selfprog_db");
            System.out.println(addnewrow);
            scanpst = scanconnekt.prepareStatement(addnewrow);
            scanpst.executeUpdate();
                 
             }
             else
             { //(2) insert both in master and transcation
                 
            String addnewrowtomaster = "insert into eancodescaniastbl(empromisname,empromiscode,countryorig,eancode) values ('" + des +"','"+empromismat+"','"+ctry+"','"+newean+"')";
            System.out.println(addnewrowtomaster);
            scanpst = scanconnekt.prepareStatement(addnewrowtomaster);
            scanpst.executeUpdate();
                   
            String currdate = dateFormat.format(date); 
            String addnewrow = "insert into eancodetbl(date,eancode,epromis_material,des,doctype,docnum,cond_goodqty,cond_dmgboxqty,cond_dmgleakqty, cond_dmgbrkqty,qty,weight,contrycode,remark,username,lotnumber,grnnum) values ('"+ currdate +"','" + newean + "','" + empromismat + "','" + des + "',"
                    + "'" + currdoctype + "','"+ currdocnumtxt + "','" + goodqtystr + "','" + dmgboxqtystr + "','" + dmgleakqtystr + "','" + dmgbrkqtystr +"','" + qty + "','" + whgt + "','" + ctry + "','" + remarkstr +"','" + currusername +"','" + lotnum +"','"+currgrntxt+"')";
            
            
            System.out.println("insert into selfprog_db");
            System.out.println(addnewrow);
            scanpst = scanconnekt.prepareStatement(addnewrow);
            scanpst.executeUpdate();
                 
             }
            
             
//                if(typeofclick.equals("Assignclicked") || typeofclick.equals("OKClicked"))
//                    {
//                  
//                    }               
          
           
            
             
     
            /*star - Clear the editing table*/

            DefaultTableModel dm = (DefaultTableModel)inputtbl.getModel();
            while(dm.getRowCount() > 0)
                    {
                dm.removeRow(0);
                  }
        
            /*end - Clear the editing table*/
            
            jScrollPane2.setVisible(false);
            btnassign.setVisible(false);
            error.setVisible(false);
            toglectrorg.setVisible(false);
            savemsg.setText("Assigned sucessfully."); 
            
        }
        else
        {
             JOptionPane.showMessageDialog(this, "Data missing!!"); 
            
        }
           
     }


public void updateeancode() throws SQLException 
 {
        if(inputtbl.getValueAt(0,0).toString()!=null && inputtbl.getValueAt(0,1).toString()!=null && inputtbl.getValueAt(0,2).toString()!=null && inputtbl.getValueAt(0,3).toString()!=null && inputtbl.getValueAt(0,4).toString()!=null)
        {
          
             currdes = (String) inputtbl.getValueAt(0,0);
             des = currdes.replace("'","");
             empromismat = (String) inputtbl.getValueAt(0,1); 
             
                                //d_f = (String) inputtbl.getValueAt(0,2);
             
             qty = (String) inputtbl.getValueAt(0,3);    
             ctry = (String) inputtbl.getValueAt(0,4);
            
            
            String currdate = dateFormat.format(date); 
        
        
            String strupdate ="UPDATE inputtbl SET qty = '"+ qty + "', contrycode = '"+ ctry + "', weight = '"+ whgt + "',";
       
            scanpst = scanconnekt.prepareStatement(strupdate);
            scanpst.executeUpdate();  
     } 
   else
        {
   JOptionPane.showMessageDialog(this, "Data missing!!");
        }   
                        
 }



public void Filltbl(String qrystr, JTable inputable) 
 {
 
     ResultSet rs = null;
    //String[] LocTo = null;
    System.out.println("this is set" + gv.getGlobusername());
    dm = (DefaultTableModel)inputtbl.getModel();
       
try {
       while(inputable.getRowCount() > 0) 
        {
         ((DefaultTableModel) inputable.getModel()).removeRow(0);
        }     
     
  
      scanconnekt =  dbconn.conn();
      scanpst = scanconnekt.prepareStatement(qrystr);
      rs = scanpst.executeQuery();  
        
      int columns = rs.getMetaData().getColumnCount();       
        if(rs.next())
          { 
             //instance table model
            
             jScrollPane2.setVisible(true);
             toglectrorg.setVisible(true);
//             toglectrorg.setText("New");
//             inputable.setEnabled(false);
//             toglectrorg.setSelected(false);
             btnassign.setVisible(false);
             Object[] row = new Object[columns];
              
             for(int i = 1; i <= columns; i++)
                   {  
                row[i - 1] = rs.getObject(i).toString().trim();
                   }
             
      ((DefaultTableModel) inputable.getModel()).insertRow(rs.getRow()-1,row); 
      
      error.setBackground(new java.awt.Color(153,255,153));
      error.setVisible(true);
      error.setText(newean);
      imglbl.setText("<html><img width='200' height='200' src='" + maturl.getImage(inputtbl.getModel().getValueAt(0,1).toString().trim()) + "'</img></html>");
            //imglbl.setIcon(new javax.swing.ImageIcon(maturl.getImage(mentry2.getKey().toString().trim())));
            System.out.println("url of pic...."+maturl.getImage(inputtbl.getModel().getValueAt(0,1).toString().trim()));    
        
//toglectrorg.setBackground(new java.awt.Color(255,204,204));
//inputtbl.setBackground(new java.awt.Color(255,153,153)); 
      
        }
        else
        {
            
            
            dm = (DefaultTableModel)inputtbl.getModel();
            imglbl.setText("<html><img width='200' height='200' src='http://www.bruachproperty.com/images/noImageFound.jpg'</img></html>");
//            inputable.setEnabled(true);
            System.out.print("else part");
            error.setBackground(new java.awt.Color(153,255,153));
            error.setText(newean);
            error.setVisible(true);
            jScrollPane2.setVisible(true);
            btnassign.setVisible(true);
            toglectrorg.setVisible(false);
//            toglectrorg.setBackground(new java.awt.Color(255,204,204));
            dm.addRow(new Object[]{"", "", "","",""});
     
        }
        

        
    }catch (ClassNotFoundException ex) {
        Logger.getLogger(EanScanned.class.getName()).log(Level.SEVERE, null, ex);
    }catch (SQLException ex) {
        Logger.getLogger(EanScanned.class.getName()).log(Level.SEVERE, null, ex);
    }catch (NullPointerException ex)
    {
        Logger.getLogger(EanScanned.class.getName()).log(Level.SEVERE, null, ex); 
    }
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
                if ("Motif".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EanScanned.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EanScanned.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EanScanned.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EanScanned.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EanScanned().setVisible(true);
            }
        });
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnassign;
    private javax.swing.JButton btnclose;
    private javax.swing.JComboBox doctypecmb;
    private javax.swing.JButton endgrnbtn;
    public static javax.swing.JTextField entereancode;
    private javax.swing.JLabel error;
    private javax.swing.JButton grnstartbtn;
    private javax.swing.JTextField grntxt;
    private javax.swing.JLabel imglbl;
    public static javax.swing.JTable inputtbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblgrn;
    private javax.swing.JLabel savemsg;
    private javax.swing.JToggleButton toglectrorg;
    private javax.swing.JTextField txtdocno;
    private javax.swing.JTextField txtean;
    // End of variables declaration//GEN-END:variables
}
