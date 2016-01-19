/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchPack;



import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author USER
 */
public class Popuplist { 
public JPopupMenu popup; 
  
   
public JPopupMenu getpopup()
    {
         
        popup = new JPopupMenu();
        //menuItemListener = new MyMenuItemListener();
        String[] names = {"John", "Paul", "Ringo", "George"};
            for (int i = 0; i < names.length; i++) {
                
                    String name = names[i];
                    JMenuItem item = new JMenuItem(name);
                    item.setName(name);
                    //item.addActionListener(menuItemListener);
                    
                    popup.add(item);
                    
                }
            return popup; 
        }
    
}
