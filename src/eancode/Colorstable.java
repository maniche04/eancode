/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eancode;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author santosh
 */
public class Colorstable extends DefaultTableCellRenderer{
    private static final long serialVersionUID = -990127651329222L;
    int selectedRow=-1;
 
  public Colorstable (int row){
         super();  
         this.selectedRow=row;
     }
     
  
     
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column){
      Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);    

    if(selectedRow!=-1){
        if(selectedRow==row && !isSelected) {
             ((JLabel) cell).setHorizontalAlignment(SwingConstants.LEFT);
            cell.setFont(new Font("Segoe UI", Font.BOLD, 16));
                cell.setForeground(Color.RED);
                ((JLabel) cell).setText(value.toString()); 
                 
               System.out.println("get function after mouse clicked and row val is" + row);   
        }   
          }else
           {  
             cell.setForeground(new java.awt.Color(0,0,255));
             
           }
         
     
         
     return this;
   
  }
 
}