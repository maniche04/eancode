/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eancode;




import SearchPack.AutoCompleteDBLink;
import SearchPack.AutoTextComplete;
import eancode.helpers.MatImage;



//import com.lowagie.text.Document;
//import com.lowagie.text.DocumentException;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.KeyEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.sql.ResultSetMetaData;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;




/**
 *
 * @author santosh
 */
public class SearchEanPanel extends javax.swing.JFrame {

    /**
     * Creates new form SearchEanPanel
     */
    MatImage mt = new MatImage();
    TableRowResizer tblrowresize = new TableRowResizer();
    TableRowResizerSeltbl tblrowresizeseltbl = new TableRowResizerSeltbl();
    DefaultTableModel currtableModel;
    AutoTextComplete atcdes;
    AutoCompleteDBLink autocdblink;
    DbConnection dbconn = new DbConnection(); 
    testjd testdia =  new testjd(this,true);
    Connection connekt = null;
    Statement stmt = null;
    PreparedStatement pst =null;
    ResultSet rs = null;
    String mysearch = "";
    PrintSetup ps =  new PrintSetup();
    GlobalVariable gv = new GlobalVariable();
    String datestr = "";
    String eancodestr = "";
    String materialstr = "";
    String desstr = ""; 
    String doctypstr = "";
    String docnumstr = "";
    String contryoriginstr = "";
    String grnstr = "";
    Object[][] tableData;
    String gdstr = "";
    Connection epoconnekt = null;
    int colval = 0;
    int qtygd = 0;
    int qtybox = 0;
    int qtyleak = 0;
    int qtybrk = 0;
    int qtytot = 0;
    String condstr = "";
    int rowval = 0 ;
    int colvalue  =0 ;
    String currprinttype = "";
    int inputresult = 0;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date(); 
    JTable salestable = new JTable();
    JLabel label1;
    JLabel label2;
    int currowval = 0;
    int rowclick = 0;
    int currenttotval = 0;
    ArrayList<Integer> arrlist = new ArrayList<Integer>(100);
   
    int increament = 0; 
      
      
public SearchEanPanel() {
        
        
        initComponents();
        
        gv.setAppDefaultImg(this); 
        
        
        /*ROW HEIGHT EXPAND ON RUN TIME*/
        tblrowresize.TableRowResizer(eantbl);
        tblrowresizeseltbl.TableRowResizer(eantbl);
        /*END OF ROW HEIGHT EXPAND ON RUN TIME*/
        cancelbtn.setEnabled(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        jScrollPane1.setHorizontalScrollBar(jScrollPane1.createHorizontalScrollBar());
        jScrollPane1.setVerticalScrollBar(jScrollPane1.createVerticalScrollBar());
        atcdes = new AutoTextComplete(eantbl);
        //atcdes.setItems(new String[] {"Cash","Credit","Transfer","Other"});
        atcdes.setActiveColumn(2);

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
        filterdesc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        filterdate = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        filtereancode = new javax.swing.JTextField();
        filtermaterial = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        filterdoctyp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        filterdocnum = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        eantbl = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        filtercountryorigin = new javax.swing.JTextField();
        printsetupbtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        delrowtbn = new javax.swing.JButton();
        cancelbtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        filtergrn = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setTitle("Jizan Scanner");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        filterdesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterdescKeyReleased(evt);
            }
        });

        jLabel4.setText("Desc");

        jLabel1.setText("Date");

        filterdate.setDateFormatString("yyyy-MM-dd");

        jLabel2.setText("EanCode");

        filtereancode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtereancodeActionPerformed(evt);
            }
        });
        filtereancode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtereancodeKeyReleased(evt);
            }
        });

        filtermaterial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtermaterialKeyReleased(evt);
            }
        });

        jLabel3.setText("Material");

        jLabel5.setText("doctype");

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        filterdoctyp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterdoctypKeyReleased(evt);
            }
        });

        jLabel6.setText("docnum");

        filterdocnum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterdocnumKeyReleased(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        eantbl.setBackground(new java.awt.Color(239, 217, 224));
        eantbl.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        eantbl.setForeground(new java.awt.Color(0, 0, 255));
        eantbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "matcode", "Description", "GoodQty", "Dmg", "Leak", "Brkn", "Total", "Origin", "eancode", "Weight", "Remark", "lotnumber", "doctype", "docnum", "grnnum", "docstatus", "grnstatus"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, false, true, true, true, true, true, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        eantbl.setGridColor(new java.awt.Color(255, 102, 0));
        eantbl.setRowHeight(26);
        eantbl.setSelectionBackground(new java.awt.Color(153, 153, 255));
        eantbl.getTableHeader().setReorderingAllowed(false);
        eantbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eantblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eantblMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eantblMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                eantblMouseReleased(evt);
            }
        });
        eantbl.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                eantblFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                eantblFocusLost(evt);
            }
        });
        eantbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                eantblKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                eantblKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                eantblKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(eantbl);
        if (eantbl.getColumnModel().getColumnCount() > 0) {
            eantbl.getColumnModel().getColumn(0).setMinWidth(30);
            eantbl.getColumnModel().getColumn(0).setPreferredWidth(30);
            eantbl.getColumnModel().getColumn(0).setMaxWidth(30);
            eantbl.getColumnModel().getColumn(1).setMinWidth(100);
            eantbl.getColumnModel().getColumn(1).setPreferredWidth(100);
            eantbl.getColumnModel().getColumn(1).setMaxWidth(100);
            eantbl.getColumnModel().getColumn(2).setCellEditor(new TextAreaEditor());
            eantbl.getColumnModel().getColumn(2).setCellRenderer(new TextAreaRenderer());
            eantbl.getColumnModel().getColumn(3).setMinWidth(30);
            eantbl.getColumnModel().getColumn(3).setPreferredWidth(30);
            eantbl.getColumnModel().getColumn(3).setMaxWidth(30);
            eantbl.getColumnModel().getColumn(4).setMinWidth(30);
            eantbl.getColumnModel().getColumn(4).setPreferredWidth(30);
            eantbl.getColumnModel().getColumn(4).setMaxWidth(30);
            eantbl.getColumnModel().getColumn(5).setMinWidth(30);
            eantbl.getColumnModel().getColumn(5).setPreferredWidth(30);
            eantbl.getColumnModel().getColumn(5).setMaxWidth(30);
            eantbl.getColumnModel().getColumn(6).setMinWidth(30);
            eantbl.getColumnModel().getColumn(6).setPreferredWidth(30);
            eantbl.getColumnModel().getColumn(6).setMaxWidth(30);
            eantbl.getColumnModel().getColumn(7).setMinWidth(40);
            eantbl.getColumnModel().getColumn(7).setPreferredWidth(40);
            eantbl.getColumnModel().getColumn(7).setMaxWidth(40);
            eantbl.getColumnModel().getColumn(8).setMinWidth(50);
            eantbl.getColumnModel().getColumn(8).setPreferredWidth(50);
            eantbl.getColumnModel().getColumn(8).setMaxWidth(50);
            eantbl.getColumnModel().getColumn(9).setMinWidth(100);
            eantbl.getColumnModel().getColumn(9).setPreferredWidth(100);
            eantbl.getColumnModel().getColumn(9).setMaxWidth(100);
            eantbl.getColumnModel().getColumn(10).setMinWidth(50);
            eantbl.getColumnModel().getColumn(10).setPreferredWidth(50);
            eantbl.getColumnModel().getColumn(10).setMaxWidth(50);
            eantbl.getColumnModel().getColumn(11).setMinWidth(50);
            eantbl.getColumnModel().getColumn(11).setPreferredWidth(50);
            eantbl.getColumnModel().getColumn(11).setMaxWidth(50);
            eantbl.getColumnModel().getColumn(12).setMinWidth(70);
            eantbl.getColumnModel().getColumn(12).setPreferredWidth(70);
            eantbl.getColumnModel().getColumn(12).setMaxWidth(70);
            eantbl.getColumnModel().getColumn(13).setMinWidth(50);
            eantbl.getColumnModel().getColumn(13).setPreferredWidth(50);
            eantbl.getColumnModel().getColumn(13).setMaxWidth(50);
            eantbl.getColumnModel().getColumn(14).setMinWidth(70);
            eantbl.getColumnModel().getColumn(14).setPreferredWidth(70);
            eantbl.getColumnModel().getColumn(14).setMaxWidth(70);
            eantbl.getColumnModel().getColumn(15).setMinWidth(110);
            eantbl.getColumnModel().getColumn(15).setMaxWidth(110);
            eantbl.getColumnModel().getColumn(16).setMinWidth(40);
            eantbl.getColumnModel().getColumn(16).setPreferredWidth(40);
            eantbl.getColumnModel().getColumn(16).setMaxWidth(40);
            eantbl.getColumnModel().getColumn(17).setMinWidth(50);
            eantbl.getColumnModel().getColumn(17).setPreferredWidth(50);
            eantbl.getColumnModel().getColumn(17).setMaxWidth(50);
        }

        jScrollPane2.setViewportView(jScrollPane1);

        jLabel7.setText("Country");

        filtercountryorigin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtercountryoriginKeyReleased(evt);
            }
        });

        printsetupbtn.setBackground(new java.awt.Color(255, 204, 204));
        printsetupbtn.setText("Ean print");
        printsetupbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printsetupbtnActionPerformed(evt);
            }
        });

        updatebtn.setBackground(new java.awt.Color(255, 204, 204));
        updatebtn.setText("Edit");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });

        delrowtbn.setBackground(new java.awt.Color(255, 204, 204));
        delrowtbn.setText("Delete");
        delrowtbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delrowtbnActionPerformed(evt);
            }
        });

        cancelbtn.setText("Cancel");
        cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbtnActionPerformed(evt);
            }
        });

        jButton3.setText("GRN Save/Print ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel8.setText("Grn No.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterdate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filtereancode, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filtermaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterdesc, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(printsetupbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updatebtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delrowtbn)
                        .addGap(18, 18, 18)
                        .addComponent(cancelbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filtergrn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filtercountryorigin))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterdoctyp, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterdocnum, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(filtereancode)
                        .addComponent(filtermaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(filterdesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(filterdoctyp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(filterdocnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(filterdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(printsetupbtn)
                    .addComponent(updatebtn)
                    .addComponent(delrowtbn)
                    .addComponent(cancelbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addComponent(filtergrn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(filtercountryorigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu1.setText("Others");

        jMenuItem2.setText("Stricker Print");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



   
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //TODO add your handling code here:
        
       SwingUtilities.invokeLater(new Runnable() {
      public void run() {
          searchResult();
      }
    });
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

public  void searchResult()
    {
        datestr = ((JTextField)filterdate.getDateEditor().getUiComponent()).getText().trim();
        contryoriginstr = filtercountryorigin.getText().trim();
         eancodestr = filtereancode.getText().trim();
         materialstr = filtermaterial.getText().trim();
         desstr = filterdesc.getText().trim();
         doctypstr = filterdoctyp.getText().trim();
         docnumstr = filterdocnum.getText().trim();
         grnstr = filtergrn.getText().trim();
          
        datestr = stringstat(datestr);
        eancodestr =  stringstat(eancodestr);
        materialstr = stringstat(materialstr);
        desstr = stringstat(desstr);
        doctypstr =  stringstat(doctypstr);
        docnumstr =  stringstat(docnumstr);
        contryoriginstr =  stringstat(contryoriginstr);
        grnstr =  stringstat(grnstr);
        
        
    mysearch = "select eantbl.id, epromis_material,des, cond_goodqty, cond_dmgboxqty,cond_dmgleakqty, cond_dmgbrkqty, qty,contrycode, eancode, weight, remark, eantbl.lotnumber, eantbl.doctype, eantbl.docnum, grnnum, doctbl.docstatus, grntbl.grnstatus from eancodetbl eantbl left join doctyperegistertbl doctbl on doctbl.docnum = eantbl.docnum and eantbl.doctype = doctbl.doctype left join grnseriestbl grntbl on grntbl.doctype = eantbl.doctype and grntbl.grnserlnum = SUBSTRING(eantbl.grnnum,6,4) where date like '" + datestr + "'"
               + "and eancode like '" + eancodestr +  "' and epromis_material like '" + materialstr + "' and des like '" + desstr + "' and eantbl.doctype like '" + doctypstr + "' and eantbl.docnum like '" + docnumstr + "' and contrycode like '" + contryoriginstr + "' and grnnum like '" + grnstr + "' ORDER BY  eantbl.id DESC";
        
        
    System.out.println(mysearch);
        
              
    searchEsixtEancode(mysearch,eantbl);   
    
        
    }
    
    private void filtereancodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtereancodeActionPerformed
        // TODO add your handling code here:    
    }//GEN-LAST:event_filtereancodeActionPerformed

    
    private void filtereancodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtereancodeKeyReleased
      // TODO add your handling code here:
        if(evt.getKeyCode() == evt.VK_ENTER) {
            searchResult();
        }    
    }//GEN-LAST:event_filtereancodeKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        gv.getObj().scanersrchbtn.setEnabled(true);
        
    }//GEN-LAST:event_formWindowClosing

    private void filtermaterialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtermaterialKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == evt.VK_ENTER) {
            searchResult();
        }
    }//GEN-LAST:event_filtermaterialKeyReleased

    private void filterdescKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterdescKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == evt.VK_ENTER) {
            searchResult();
        }
    }//GEN-LAST:event_filterdescKeyReleased

    private void filterdoctypKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterdoctypKeyReleased
        // TODO add your handling code here:
         if(evt.getKeyCode() == evt.VK_ENTER) {
            searchResult();
        }
    }//GEN-LAST:event_filterdoctypKeyReleased

    private void filterdocnumKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterdocnumKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == evt.VK_ENTER) {
            searchResult();
        }
    }//GEN-LAST:event_filterdocnumKeyReleased

    private void filtercountryoriginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtercountryoriginKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == evt.VK_ENTER) {
            searchResult();
        }
    }//GEN-LAST:event_filtercountryoriginKeyReleased

    private void printsetupbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printsetupbtnActionPerformed
      
        try {
            // TODO add your handling code here:
            
            myMethod(eantbl);
          
        } catch (Exception ex) {
            Logger.getLogger(SearchEanPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }//GEN-LAST:event_printsetupbtnActionPerformed
  
    


   
    
    
    
    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
        // TODO add your handling code here:
        //selwhrhoustblx.getCellEditor().stopCellEditing();
    int i = 0;
    int last = eantbl.getRowCount();
     
      if("Edit".equals(evt.getActionCommand()))
      {
           cancelbtn.setEnabled(true);
          eantbl.setEnabled(true);
          
          updatebtn.setText("Save");
          updatebtn.setBackground(new java.awt.Color(204,255,204));
          eantbl.setBackground(new java.awt.Color(204,255,204));
          delrowtbn.setBackground(new java.awt.Color(204,255,204));
      }
      else if("Save".equals(evt.getActionCommand()))  
      {
        try {
        
        connekt =  dbconn.conn();
        pst = null;
       //System.out.println(strupdate);
       
  //selwhrhoustblx.getCellEditor().stopCellEditing();
      
      Component co = eantbl.getEditorComponent(); 
      if(co != null) { 
            TableCellEditor seltce = eantbl.getCellEditor(); 
            seltce.stopCellEditing();      
        }
      
      
    /*Start - to check if good, damages item is just enter but not hit tab key */ 
              
                      
         if(eantbl.getValueAt(rowclick,3).toString().equals(""))
           {qtygd = 0;}
           else
           {qtygd = Integer.parseInt(eantbl.getValueAt(rowclick,3).toString().trim());}
           if(eantbl.getValueAt(rowclick,4).toString().equals(""))
           {qtybox = 0;}
           else
           {qtybox = Integer.parseInt(eantbl.getValueAt(rowclick,4).toString().trim());}
           if(eantbl.getValueAt(rowclick,5).toString().equals(""))
           {qtyleak = 0;}
           else
           {qtyleak = Integer.parseInt(eantbl.getValueAt(rowclick,5).toString().trim());}
           if(eantbl.getValueAt(rowclick,6).toString().equals(""))
           {qtybrk = 0;}
           else
           {qtybrk =  Integer.parseInt(eantbl.getValueAt(rowclick,6).toString().trim());}
           if(eantbl.getValueAt(rowclick,7).toString().equals(""))
           {qtytot = 0;}
           else
           {qtytot = Integer.parseInt(eantbl.getValueAt(rowclick,7).toString().trim());}
            
            qtytot = qtygd + qtybox + qtyleak + qtybrk;
        
            eantbl.getModel().setValueAt(qtytot,rowclick,7); 
                      
              
    /*End - to check if good, damages item is just enter but not hit tab key */ 
      
      
      
      
   /*verify all required fields are filled or not*/ 
        
            for( i=0 ;i < last ;i++){
           
            int id = Integer.parseInt(eantbl.getValueAt(i,0).toString());  
            String matcode = (String) eantbl.getValueAt(i,1).toString();
            String des = (String) eantbl.getValueAt(i,2).toString();
            des = des.replace("'","");
            String gdqty1 =  (String) eantbl.getValueAt(i,3).toString();
            
    
            
            String dmgboxqty1 = (String) eantbl.getValueAt(i,4).toString();
            String dmgleakqty1 = (String) eantbl.getValueAt(i,5).toString();
            String dmgbrknqty1 = (String) eantbl.getValueAt(i,6).toString();
            String total = (String) eantbl.getValueAt(i,7).toString();
            String contyrorg = (String) eantbl.getValueAt(i,8); 
            String encode = (String) eantbl.getValueAt(i,9);
            String wght = (String) eantbl.getValueAt(i,10);
            String rmrk = (String) eantbl.getValueAt(i,11);
            String lotnum = (String) eantbl.getValueAt(i,12);
            String doctype = (String) eantbl.getValueAt(i,13);
            String docnum = (String) eantbl.getValueAt(i,14);
            String grnnumstr = (String) eantbl.getValueAt(i,15);
            
            
            
            String strupdate ="UPDATE eancodetbl SET epromis_material = '" + matcode + "', des = '" + des + "', cond_goodqty  = '"+ gdqty1 + "', cond_dmgboxqty = '"+ dmgboxqty1 + "', cond_dmgleakqty = '"+ dmgleakqty1 + "', cond_dmgbrkqty = '"+ dmgbrknqty1 + "',"
              + " qty = '"+ total + "',contrycode = '"+ contyrorg + "',eancode = '"+ encode +"', weight = '"+ wght + "', remark = '"+ rmrk + "', lotnumber = '"+ lotnum + "', doctype = '" + doctype + "', docnum = '" + docnum + "', grnnum = '" + grnnumstr + "' WHERE id = '" + id + "'";
       
        
           
              pst = connekt.prepareStatement(strupdate);
              pst.executeUpdate();
              
            
            }
        } catch (Exception ex) {
              Logger.getLogger(SearchEanPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
      
      }
      if(i == last)
      {
          
         searchResult();
         //eantbl.setEnabled(false);
         updatebtn.setBackground(new java.awt.Color(255,204,204));
         updatebtn.setText("Edit");
         delrowtbn.setBackground(new java.awt.Color(255,204,204));
         cancelbtn.setEnabled(false);
         eantbl.setBackground(new java.awt.Color(255,204,204));
         eantbl.setForeground(new java.awt.Color(0,0,255));
      }
        
    }//GEN-LAST:event_updatebtnActionPerformed

public void updatetotalqtyonmouseclick()
{
     {
    
       colvalue = eantbl.getSelectedColumn();
      
       if(updatebtn.getText().equals("Save"))
       {
       if(eantbl.getColumnName(3).equals("GoodQty") || eantbl.getColumnName(4).equals("Dmg") || eantbl.getColumnName(5).equals("Leak") || eantbl.getColumnName(6).equals("Brkn"))
       {
           System.out.println("qty selected");
           
           if(eantbl.getValueAt(rowclick,3).toString().equals(""))
           {qtygd = 0;}
           else
           {qtygd = Integer.parseInt(eantbl.getValueAt(rowclick,3).toString().trim());}
           if(eantbl.getValueAt(rowclick,4).toString().equals(""))
           {qtybox = 0;}
           else
           {qtybox = Integer.parseInt(eantbl.getValueAt(rowclick,4).toString().trim());}
           if(eantbl.getValueAt(rowclick,5).toString().equals(""))
           {qtyleak = 0;}
           else
           {qtyleak = Integer.parseInt(eantbl.getValueAt(rowclick,5).toString().trim());}
           if(eantbl.getValueAt(rowclick,6).toString().equals(""))
           {qtybrk = 0;}
           else
           {qtybrk =  Integer.parseInt(eantbl.getValueAt(rowclick,6).toString().trim());}
           if(eantbl.getValueAt(rowclick,7).toString().equals(""))
           {qtytot = 0;}
           else
           {qtytot = Integer.parseInt(eantbl.getValueAt(rowclick,7).toString().trim());}
               
   if(currowval == rowval)
     {
    if(colvalue == 3 || colvalue == 4 || colvalue == 5 || colvalue == 6 || colvalue == 7)
        {
             if(eantbl.getValueAt(rowclick,3).toString().equals(""))
                  {gdstr = "0";}
                    else
                    {gdstr = eantbl.getValueAt(rowclick,3).toString().trim();}
                    
            if (Integer.parseInt(gdstr) > 0 || qtybox > 0 ||  qtyleak > 0 || qtybrk > 0)
                    {
                    if(java.util.regex.Pattern.matches("\\d+",gdstr))
                        {
                          System.out.println("test 321"+ qtybrk);
                          qtytot = Integer.parseInt(gdstr) + qtybox + qtyleak + qtybrk;
                          if(qtytot > 0)
                          {
                        
                          eantbl.getModel().setValueAt(qtytot,rowclick,7); 
                        
                          }
                        }
                     else
                        {
                           System.out.println("test 321 test");
                                qtytot = Integer.parseInt(gdstr) + qtybox + qtyleak + qtybrk;
                            if(qtytot > 0)
                                {
                            eantbl.getModel().setValueAt(qtygd,rowclick,3);
                             
                                }
                        }     
                    }
           } 
    
        }
       }
       }
       }
       
       
     System.out.println("current selected row is "+ rowclick);
}
    
  
 public void updatetatalqty(java.awt.event.KeyEvent evt)
 {
     
    colvalue = eantbl.getSelectedColumn();
      
      if(updatebtn.getText().equals("Save"))
       {
        if(eantbl.getColumnName(3).equals("GoodQty") || eantbl.getColumnName(4).equals("Dmg") || eantbl.getColumnName(5).equals("Leak") || eantbl.getColumnName(6).equals("Brkn"))
          {
           System.out.println("qty selected");

           if(eantbl.getValueAt(rowclick,3).toString().equals(""))
           {qtygd = 0;}
           else
           {qtygd = Integer.parseInt(eantbl.getValueAt(rowclick,3).toString().trim());}
           if(eantbl.getValueAt(rowclick,4).toString().equals(""))
           {qtybox = 0;}
           else
           {qtybox = Integer.parseInt(eantbl.getValueAt(rowclick,4).toString().trim());}
           if(eantbl.getValueAt(rowclick,5).toString().equals(""))
           {qtyleak = 0;}
           else
           {qtyleak = Integer.parseInt(eantbl.getValueAt(rowclick,5).toString().trim());}
           if(eantbl.getValueAt(rowclick,6).toString().equals(""))
           {qtybrk = 0;}
           else
           {qtybrk =  Integer.parseInt(eantbl.getValueAt(rowclick,6).toString().trim());}
           if(eantbl.getValueAt(rowclick,7).toString().equals(""))
           {qtytot = 0;}
           else
           {qtytot = Integer.parseInt(eantbl.getValueAt(rowclick,7).toString().trim());}
               
   if(currowval == rowval)
     {
    if(colvalue == 3 || colvalue == 4 || colvalue == 5 || colvalue == 6 || colvalue == 7)
        {
            System.out.println("colvalue........."+colvalue);
            
          if(evt.getKeyCode()== KeyEvent.VK_TAB || evt.getKeyCode()== KeyEvent.VK_ENTER || evt.getKeyCode()== KeyEvent.VK_LEFT || evt.getKeyCode()== KeyEvent.VK_RIGHT ||  evt.getKeyCode()== KeyEvent.VK_DOWN || evt.getKeyCode()== KeyEvent.VK_UP)
           {
               if(eantbl.getValueAt(rowclick,3).toString().equals(""))
                  {gdstr = "0";}
                    else
                    {gdstr = eantbl.getValueAt(rowclick,3).toString().trim();}
                    
               //System.out.println("good , box, leak, brkn"+Integer.parseInt(gdstr)+"  "+ qtybox + "  " + qtyleak + " "+ qtybrk);
                  
               if (Integer.parseInt(gdstr) > 0 || qtybox > 0 ||  qtyleak > 0 || qtybrk > 0)
                    {
                            if(java.util.regex.Pattern.matches("\\d+",gdstr))
                                    {
                                      System.out.println("test 321"+ qtybrk);
                                      qtytot = Integer.parseInt(gdstr) + qtybox + qtyleak + qtybrk;
                                      if(qtytot > 0 )
                                      {
                                      
                                      eantbl.getModel().setValueAt(qtytot,rowclick,7);
                                     
                                      
                                      
                                      
                                      //eantbl.setDefaultRenderer(Object.class,new ColorCellRender());  
                                      }
                                    }
                            else
                                    {
                                      System.out.println("test 321 test");
                                      qtytot = Integer.parseInt(gdstr) + qtybox + qtyleak + qtybrk;
                                      if(qtytot > 0)
                                        {
                                      eantbl.getModel().setValueAt(qtygd,rowclick,3); 
                                     
                                    
                                         }
                        }     
                    }
                  }  
                 
                }
        
    try {
          currenttotval =  mt.currentTotal(Integer.parseInt(eantbl.getModel().getValueAt(rowclick,0).toString()));
          System.out.println("current row total"+currenttotval);
//currenttotval = Integer.parseInt(eantbl.getModel().getValueAt(currowval, 7).toString().trim());
        } catch (Exception ex) {
            Logger.getLogger(SearchEanPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    if(currenttotval!=qtytot)
          {
              TableCellRenderer tcr = new PositiveNumber(currowval);
              TableColumn column = eantbl.getColumnModel().getColumn(7);  
              column.setCellRenderer(tcr);  
              
              arrlist.add(currowval);
               
             
              System.out.println("value to pushed"+currowval);
            
             
          }
        }
       }
       }
       else
       {
            
            
       }
       
     System.out.println("current selected row is "+ rowclick);
 }
    
 
   
    
    private void eantblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eantblKeyReleased
        // TODO add your handling code here:

     updatetatalqty(evt);
     
      rowval = eantbl.getSelectedRow();
      colvalue = eantbl.getSelectedColumn();
     //rowclick = inputtbl.rowAtPoint(evt.getPoint());
      if(eantbl.getColumnName(2).equals("des") && colvalue == 2 && updatebtn.getText().equals("Save"))
             {         
                
     if (evt.getKeyCode() == KeyEvent.VK_DELETE || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_LEFT || evt.getKeyCode() == KeyEvent.VK_RIGHT || evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP)
        {
//   flag = true;
//// eantbl.getSelectionModel().clearSelection();
////  
//// DefaultTableModel dm = (DefaultTableModel) .getModel();
////   
//// eantbl.getModel().setValueAt("asdf",rowval,2);
////            System.out.println("delete pressed!" + rowval);
//           
//        
//        }
        }
         else
        {
                   
            
            condstr  = condstr + evt.getKeyChar();
            
            eantbl.getModel().setValueAt("", rowval, 2);    
           
           
        }
        
        System.out.println("works" + condstr); 
        Pattern pattern  = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(condstr);
        if (matcher.matches()) {
             
                System.out.println("intput string1 TEST" + condstr );   
                    try {
                             epoconnekt =  dbconn.epormisconn();
                             autocdblink = new AutoCompleteDBLink(atcdes, condstr, epoconnekt,2);
                         } catch (ClassNotFoundException ex) {
                             Logger.getLogger(EanScanned.class.getName()).log(Level.SEVERE, null, ex);
                         }
               
                }   
                 
             }
     
      if(evt.getKeyCode()== KeyEvent.VK_TAB)
      {
        
            Set set2 = gv.getMyMap().entrySet();

        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
         Map.Entry mentry2 = (Map.Entry)iterator2.next();
         if(mentry2.getValue().toString().equals(eantbl.getValueAt(rowval,2).toString()))
             {
                 
            eantbl.getModel().setValueAt(mentry2.getKey().toString().trim(),rowval,1);
             }
       }
   
       System.out.println("test after tab2");   
      }
         
   
    
      
    }//GEN-LAST:event_eantblKeyReleased

    private void eantblFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_eantblFocusGained
        // TODO add your handling code here:
        
        
        
        
    }//GEN-LAST:event_eantblFocusGained

    
    public void mouseupdatetotal(java.awt.event.MouseEvent evt)
    {
       
        int modifiers = evt.getModifiers();
        int rowclick = eantbl.getSelectedRow();
       
       if(eantbl.getColumnName(3).equals("GoodQty") || eantbl.getColumnName(4).equals("Dmg_Box_Qty") || eantbl.getColumnName(5).equals("Dmg_leak_qty") || eantbl.getColumnName(6).equals("Dmg_Brkn_qty"))
       {
           System.out.println("qty selected");
           if(eantbl.getValueAt(rowclick,3).toString().equals(""))
           {qtygd = 0;}
           else
           {qtygd = Integer.parseInt(eantbl.getValueAt(rowclick,3).toString().trim());}
           if(eantbl.getValueAt(rowclick,4).toString().equals(""))
           {qtybox = 0;}
           else
           {qtybox = Integer.parseInt(eantbl.getValueAt(rowclick,4).toString().trim());}
           if(eantbl.getValueAt(rowclick,5).toString().equals(""))
           {qtyleak = 0;}
           else
           {qtyleak = Integer.parseInt(eantbl.getValueAt(rowclick,5).toString().trim());}
           if(eantbl.getValueAt(rowclick,6).toString().equals(""))
           {qtybrk = 0;}
           else
           {qtybrk =  Integer.parseInt(eantbl.getValueAt(rowclick,6).toString().trim());}
           if(eantbl.getValueAt(rowclick,7).toString().equals(""))
           {qtytot = 0;}
           else
           {qtytot = Integer.parseInt(eantbl.getValueAt(rowclick,7).toString().trim());}
               
                
                    if(eantbl.getValueAt(rowclick,3).toString().equals(""))
                    {gdstr = "0";}
                    else
                    {gdstr = eantbl.getValueAt(rowclick,3).toString().trim();}
          
                    if(java.util.regex.Pattern.matches("\\d+",gdstr))
                        {
                            //qtytot = Integer.parseInt(gdstr) + qtybox + qtyleak + qtybrk;
                        if(qtytot !=  (Integer.parseInt(gdstr) + qtybox + qtyleak + qtybrk))
                            {
//eantbl.getModel().setValueAt(colvalue, rowclick, colvalue);
                            }
//eantbl.getModel().setValueAt(qtytot,rowclick,7);   
                        }
                     else
                        {
                            eantbl.getModel().setValueAt(qtygd,rowclick,3);  
                        }     
                   
                  
       }
         
       System.out.println("current selected row is "+ rowclick); 
       
    }
    
    
    
    private void eantblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eantblMouseClicked
        // TODO add your handling code here:
      updatetotalqtyonmouseclick();  
       
    
     
  
         
      int colval = eantbl.getSelectedColumn();
           
      rowval = eantbl.getSelectedRow();

      
    if(colval == 0)
      {
        eantbl.setColumnSelectionAllowed(false);
        eantbl.setRowSelectionAllowed(true);
      }
    else
      {
        eantbl.setColumnSelectionAllowed(true);
        eantbl.setRowSelectionAllowed(false); 
        eantbl.setCellSelectionEnabled(true);
      }
      
      
   if(colval == 16 && evt.getClickCount() == 2 && !eantbl.getValueAt(rowval, 16).toString().equalsIgnoreCase("Null") && updatebtn.getText().equals("Save"))
      {
           testdia.jcomobostat.removeAllItems();;
          
            String selctdoctypval = eantbl.getValueAt(rowval, 13).toString();
            String selctdocnumval = eantbl.getValueAt(rowval, 14).toString();
            String selctdocstatus = eantbl.getValueAt(rowval, 16).toString();
            //System.out.println("test"+selctdocstatus);
            testdia.doctypset.setText(selctdoctypval);
            testdia.docnumset.setText(selctdocnumval);
            
            testdia.jcomobostat.addItem(selctdocstatus);
            if(selctdocstatus.equals("Start") || selctdocstatus.equals("Break"))
            {
                testdia.jcomobostat.addItem("Close");
            }
            else
            {
                 testdia.jcomobostat.addItem("Start");
            }
           
          testdia.updateto = "doctypetbl";
          testdia.setVisible(true);
      }
      if(colval == 17 && evt.getClickCount() == 2 && !eantbl.getValueAt(rowval, 16).toString().equalsIgnoreCase("Null") && updatebtn.getText().equals("Save"))
      {
            testdia.jcomobostat.removeAllItems();;
            rowval = eantbl.getSelectedRow();
            String selctdoctypval = eantbl.getValueAt(rowval, 13).toString();
            String selctrgrnval = eantbl.getValueAt(rowval, 15).toString();
            String selctgrnstatus = eantbl.getValueAt(rowval, 17).toString();
            //System.out.println("test"+selctdocstatus);
            testdia.doctypset.setText(selctdoctypval);
            testdia.docnumset.setText(selctrgrnval);

            testdia.jcomobostat.addItem(selctgrnstatus);
            if(selctgrnstatus.equals("Start") || selctgrnstatus.equals("Break"))
            {
                testdia.jcomobostat.addItem("Close");
            }
            else
            {
                 testdia.jcomobostat.addItem("Start");
            }
 
        testdia.updateto = "grntbl";  
        testdia.setVisible(true); 
      }
     
  
    }//GEN-LAST:event_eantblMouseClicked

    private void eantblFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_eantblFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_eantblFocusLost

    private void eantblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eantblMouseEntered
        // TODO add your handling code here:
      
        
    }//GEN-LAST:event_eantblMouseEntered

    private void eantblKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eantblKeyTyped
        // TODO add your handling code here:
        if(updatebtn.getText().equals("Save"))
        {
            
        }
        
    }//GEN-LAST:event_eantblKeyTyped

    private void eantblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eantblKeyPressed
    
        
            //TODO add your handling code here:
            colvalue = eantbl.getSelectedColumn();
            rowclick  = eantbl.getSelectedRow();
            currowval = rowclick;
            
         
    }//GEN-LAST:event_eantblKeyPressed

    
public void deleterow()
{
    String ids = "";
    pst = null;
    String[] result = new String[100];
           if (eantbl.getSelectedRowCount() > 0)
            {  
            int[] selectedRow = eantbl.getSelectedRows();
     
            for (int i : selectedRow) {
               result[i] = eantbl.getModel().getValueAt(i, 0).toString();               
                if (ids.length() > 0) {
                    ids = ids + "," + result[i];
                } else {
                    ids = result[i];
                }
               }
            String delrow = "delete from eancodetbl where id IN ("+ ids +")";
            
             
        try {
        connekt =  dbconn.conn();
        pst = connekt.prepareStatement(delrow);
        pst.executeUpdate();
        searchResult();
        } catch (ClassNotFoundException ex) {
        Logger.getLogger(SearchEanPanel.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(SearchEanPanel.class.getName()).log(Level.SEVERE, null, ex);
    }
            }
          
}
    
    
    
    
    private void delrowtbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delrowtbnActionPerformed
        // TODO add your handling code here:
        if(updatebtn.getText().equals("Edit"))
        {
           JOptionPane.showMessageDialog(this,"Make in edit mode!");  
        }
        else 
        {
           
           
        if(JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
        deleterow();
        eantbl.setEnabled(false);
        updatebtn.setBackground(new java.awt.Color(255,204,204));
        updatebtn.setText("Edit");
        delrowtbn.setBackground(new java.awt.Color(255,204,204));   
        eantbl.setBackground(new java.awt.Color(255,204,204));
        eantbl.setForeground(new java.awt.Color(0,0,255));
           }
           else
           {
               //not
           }
        
        }
    }//GEN-LAST:event_delrowtbnActionPerformed

 public void textlistner(final JTextField jtx)
 {
     jtx.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
            jtx.setText("");
            }
    });
     
 }
    
 
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        SwingUtilities.invokeLater(new Runnable() {
      public void run() {
     StickerPrint stck = new  StickerPrint();
     stck.setVisible(true);
      }
    });
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void cancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbtnActionPerformed
        //TODO add your handling code here:
        searchResult();
        
        updatebtn.setBackground(new java.awt.Color(255,204,204));
        updatebtn.setText("Edit");
        delrowtbn.setBackground(new java.awt.Color(255,204,204));
        cancelbtn.setEnabled(false);
        eantbl.setBackground(new java.awt.Color(255,204,204));
        eantbl.setForeground(new java.awt.Color(0,0,255));
        
    }//GEN-LAST:event_cancelbtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    
       if(filtergrn.getText().trim().isEmpty())
       {
           JOptionPane.showMessageDialog(this, "Please, Enter GRN No. then search to save !!");  
           return;
       }
      for(int check = 0 ; check <= eantbl.getRowCount()-1;check++)
      {
          if(eantbl.getModel().getValueAt(check, 15).toString().equals(filtergrn.getText().trim()) == true)
          {
              
          }else
          {
              JOptionPane.showMessageDialog(this, "Please, Enter GRN No. then search to save !!");  
              return;
          }
      }
      
      if (!filtergrn.getText().trim().isEmpty() && eantbl.getRowCount() > 0 && filtergrn.getText().substring(0, 3).equals("LOC")) 
       {
         try {
               
               gv.setDialogname("admin");
               System.out.println("admin:"+ gv.getDialogname() );
               GrnPrintSave grnprintobj =  new GrnPrintSave(filtergrn.getText().trim());
               grnprintobj.setVisible(true);
               gv.setSearchobj(this);

           }catch (Exception ex) {
               Logger.getLogger(SearchEanPanel.class.getName()).log(Level.SEVERE, null, ex);
           }
       }

//else if (!filtergrn.getText().trim().isEmpty() && eantbl.getRowCount() > 0 && filtergrn.getText().substring(0, 3).equals("MTN")) 
//       {
//           try {
//               gv.setDialogname("admin");
//               GrnPrintSave grnprintobj =  new GrnPrintSave(filtergrn.getText().trim());
//               grnprintobj.setVisible(true);
//               gv.setSearchobj(this);
//
//           } catch (Exception ex) {
//               Logger.getLogger(SearchEanPanel.class.getName()).log(Level.SEVERE, null, ex);
//           }
//       }else if (!filtergrn.getText().trim().isEmpty() && eantbl.getRowCount() > 0 && filtergrn.getText().substring(0, 3).equals("AR ")) 
//       {
//           try {
//               gv.setDialogname("admin");
//               GrnPrintSave grnprintobj =  new GrnPrintSave(filtergrn.getText().trim());
//               grnprintobj.setVisible(true);
//               gv.setSearchobj(this);
//
//           } catch (Exception ex) {
//               Logger.getLogger(SearchEanPanel.class.getName()).log(Level.SEVERE, null, ex);
//           }
//}
       
       else if(!filtergrn.getText().trim().isEmpty() && eantbl.getRowCount() > 0 && filtergrn.getText().substring(0, 3).equals("IMP"))
       {
           try {
              gv.setDialogname("admin"); 
               GrnPrintSaveImport grnprintimpoobj =  new GrnPrintSaveImport(filtergrn.getText().trim());
               grnprintimpoobj.setVisible(true);
               gv.setSearchobj(this);
               
           } catch (Exception ex) {
               Logger.getLogger(SearchEanPanel.class.getName()).log(Level.SEVERE, null, ex);
           }
      }
      else
      {
           JOptionPane.showMessageDialog(this, "Please, Enter GRN No. and Search to save!!");  
      }
       
    
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void eantblMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eantblMousePressed
 // TODO add your handling code here:
              
// TODO add your handling code here:
//        int mousecurrrowval = eantbl.getSelectedRow();
//         int mousclickgrdtot = Integer.parseInt(eantbl.getModel().getValueAt(mousecurrrowval, 7).toString().trim());
//          
//         if(currenttotval == mousclickgrdtot ) 
//         {
//             TableCellRenderer tcr = new PositiveNumber(mousecurrrowval);
//             TableColumn column = eantbl.getColumnModel().getColumn(7);  
//             column.setCellRenderer(tcr);  
//             
//         }
//          
          
          
    }//GEN-LAST:event_eantblMousePressed

    private void eantblMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eantblMouseReleased
     
        
    }//GEN-LAST:event_eantblMouseReleased

  


    
    
    
public void myMethod(JTable entryTable) throws Exception {
     
String result = "";
String eandate = "";     
if (entryTable.getSelectedRowCount() > 0)
                {
          
             int selectedRow[] = entryTable.getSelectedRows();   
             for (int i : selectedRow) {
                 result = entryTable.getModel().getValueAt(i, 9).toString();
                 
                  if (eandate.length() > 0) {
                     eandate = eandate + "," + result;
                 } else {
                     eandate = result;
                 }
                
                        }
              gv.setBarcodedata(eandate);
              System.out.println("values are "+eandate);
              ps.setVisible(true);
              
                }
else
            {
     ps.setVisible(false);       
    JOptionPane.showMessageDialog(this,"Row Not selected!");
   
            }

}
    
    
public void searchEsixtEancode(String currsear, JTable currtbl) 
    {
        
//      Component co = eantbl.getEditorComponent(); 
//      if (co != null) { 
//                TableCellEditor tce = eantbl.getCellEditor(); 
//                tce.stopCellEditing(); 
//        } 
      
      //instance table model
//DefaultTableModel tableModel = new DefaultTableModel() {
//
//   @Override
//   public boolean isCellEditable(int row, int column) {
//       //Only the third column
//       return column == 3;
//   }
//};

//currtbl.setModel(tableModel);
      
    
      rs = null; 
      
      try {
        connekt =  dbconn.conn();
        pst = connekt.prepareStatement(currsear);
        rs = pst.executeQuery();
        
        while(currtbl.getRowCount() > 0) 
        {
          ((DefaultTableModel) currtbl.getModel()).removeRow(0);
        }
        
        int columns = rs.getMetaData().getColumnCount();
        
        while(rs.next())
          {  
              Object[] row = new Object[columns];
              
              for (int i = 1; i <= columns; i++)
                    {  
               row[i - 1] = rs.getObject(i).toString().trim();
                   }
                   
              ((DefaultTableModel) currtbl.getModel()).insertRow(rs.getRow()-1,row);
      
           
        }
    
      
     }catch (ClassNotFoundException ex) {
        Logger.getLogger(SearchEanPanel.class.getName()).log(Level.SEVERE, null, ex);
     }catch (SQLException ex) {
        Logger.getLogger(SearchEanPanel.class.getName()).log(Level.SEVERE, null, ex);
     }catch (NullPointerException ex)
        {
      Logger.getLogger(SearchEanPanel.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }
    
    
public String stringstat(String str)
    {
        String curstr="";
        if (str.equals(""))
        {
            curstr = "%";
        }
        else if (!str.equals(""))
        {
            curstr = "%" + str + "%";
        } 
       
        return curstr;
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
                if ("Windows Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchEanPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchEanPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchEanPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchEanPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchEanPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelbtn;
    private javax.swing.JButton delrowtbn;
    public javax.swing.JTable eantbl;
    private javax.swing.JTextField filtercountryorigin;
    private com.toedter.calendar.JDateChooser filterdate;
    private javax.swing.JTextField filterdesc;
    private javax.swing.JTextField filterdocnum;
    private javax.swing.JTextField filterdoctyp;
    private javax.swing.JTextField filtereancode;
    private javax.swing.JTextField filtergrn;
    private javax.swing.JTextField filtermaterial;
    public static javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton printsetupbtn;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}
