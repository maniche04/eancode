/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eancode.helpers;

import eancode.DbConnection;
import eancode.EanScanned;
import eancode.GlobalVariable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manish
 */
public class MatImage {
    
    DbConnection dbconn = new DbConnection(); 
    GlobalVariable gv = new GlobalVariable();
    Connection scanconnekt = null;
    Statement scanstmt = null;
    PreparedStatement scanpst =null;
    ResultSet scanrs = null;
    
    public String getImage(String matcode) {
        
        String checkmatcode = "SELECT TOP 1 imgurl from itempics where itemcode ='"+ matcode+"'";  
        String imagelink = "";
        try {
            scanconnekt =  dbconn.conn();
            scanpst = scanconnekt.prepareStatement(checkmatcode);
            scanrs = scanpst.executeQuery();  
      if(scanrs.next())
         {
        imagelink = scanrs.getString(1);
    } else {
          imagelink = "http://www.bruachproperty.com/images/noImageFound.jpg";
      }
      
} catch (Exception ex) {
            Logger.getLogger(EanScanned.class.getName()).log(Level.SEVERE, null, ex);
        }
   
   return imagelink;
    
}
    
    
 public int currentTotal(int id) throws Exception
    {
        String checkmatcode = "SELECT TOP 1  qty from eancodetbl where id ='"+ id+"'";  
        int currtotal = 0;
        try {
            scanconnekt =  dbconn.conn();
            scanpst = scanconnekt.prepareStatement(checkmatcode);
            scanrs = scanpst.executeQuery();  
      if(scanrs.next())
            {
        currtotal = Integer.parseInt(scanrs.getString(1));
         return currtotal;
            }
        }catch(Exception ex) {
            Logger.getLogger(EanScanned.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 1;
    }   
}
