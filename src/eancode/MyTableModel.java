/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eancode;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author santosh
 */
public class MyTableModel  extends DefaultTableModel {

 
   public MyTableModel(Object[][] tableData, Object[] colNames) {
      super(tableData, colNames);
   }

   public boolean isCellEditable(int row, int column) {
      return false;
   }
}
