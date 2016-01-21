/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eancode;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author santosh
 */
public class ColorCellRender extends DefaultTableCellRenderer {
      private final Color alt2 = new Color(236, 236, 236);
    private final Color alt1 = Color.WHITE;
    private final Color invalidStatus = Color.RED;
  public Component getTableCellRendererComponent(JTable table,
                                                 Object value,
                                                 boolean isSelected,
                                                 boolean hasFocus,
                                                 int row,
                                                 int column) {
    Component c = 
      super.getTableCellRendererComponent(table, value,
                                          isSelected, hasFocus,
                                          row, column);

    // Only for specific cell
    if (row == SearchEanPanel.currowval && column == 7) {
       //c.setFont(/* special font*/);
       // you may want to address isSelected here too
       c.setForeground(invalidStatus);
       //c.setBackground(/*special background color*/);
    }
    return c;
  }
}