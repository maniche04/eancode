/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eancode;

import java.awt.AWTException;
import java.awt.AWTKeyStroke;
import java.awt.Color;
import javax.swing.table.TableCellRenderer;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.KeyboardFocusManager;
import java.awt.Robot;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author USER
 */
class TextAreaRenderer extends JScrollPane implements TableCellRenderer {
   
    JTextArea textarea;
    private Robot robot;
      Font font = new Font("Segoe UI", Font.PLAIN, 12);
   public TextAreaRenderer() {
         super(new JCheckBox());
      textarea = new JTextArea();
      textarea.setLineWrap(true);
      textarea.setWrapStyleWord(true);
      //textarea.setBorder(new TitledBorder("This is a JTextArea"));
    
      textarea.setFont(font);
    
      //Border border = BorderFactory.createLineBorder(Color.WHITE);
      //textarea.setBorder(null);
      //textarea.setOpaque(true);
   
    
getViewport().add(textarea);
   }
  
    @Override
   public Component getTableCellRendererComponent(JTable table, Object value,
                                  boolean isSelected, boolean hasFocus,
                                  int row, int column)
   {
      if (isSelected) {
          //System.out.println("check your text");
         setForeground(table.getSelectionForeground());
         setBackground(table.getSelectionBackground());
         textarea.setForeground(table.getSelectionForeground());
         textarea.setBackground(table.getSelectionBackground()); 
    } else {

         setForeground(table.getForeground());
         setBackground(table.getBackground());
         textarea.setForeground(table.getForeground());
         textarea.setBackground(table.getBackground());
         
    }   
    //textarea.requestFocusInWindow();                             
    textarea.setText((String) value);
    textarea.setCaretPosition(textarea.getDocument().getLength());
    

    //textarea.setCaretPosition(0);
      
      return this;
   }

}
