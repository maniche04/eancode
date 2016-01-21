/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eancode;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author santosh
 */
public class PositiveNumber extends DefaultTableCellRenderer{
    private static final long serialVersionUID = -990127651329222L;
    int selectedRow=-1;
    
     public PositiveNumber (int row){
         super();  
         this.selectedRow=row;
     
     }
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column){
      Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);    
    if(selectedRow!=-1){
        if(selectedRow==row){
            ((JLabel) cell).setHorizontalAlignment(SwingConstants.CENTER);
            cell.setFont(new Font("Segoe UI", Font.BOLD, 16));
            
                cell.setForeground(Color.RED);
                
             ((JLabel) cell).setText(value.toString()); 
        }else{
            cell.setForeground(new java.awt.Color(0,0,255));
        }
    }
     return this;
  }
 
}