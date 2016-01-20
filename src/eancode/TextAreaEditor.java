/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eancode;

import java.awt.AWTException;
import java.awt.AWTKeyStroke;
import java.awt.Color;
import javax.swing.table.TableCellEditor;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.KeyboardFocusManager;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import java.util.HashSet;
import java.util.Set;
import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.EventListenerList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author USER
 */
class TextAreaEditor extends DefaultCellEditor  implements TableCellEditor {

protected JScrollPane scrollpane;
   protected JTextArea textarea;
   private Robot robot;
   Font font = new Font("Segoe UI", Font.PLAIN, 12); 
 
  
   public TextAreaEditor() {
      super(new JCheckBox());
    scrollpane = new JScrollPane(textarea, 
   JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      textarea = new JTextArea(); 
      textarea.setLineWrap(true);
      textarea.setWrapStyleWord(true);
      textarea.setFont(font);
      scrollpane.getViewport().add(textarea);
      
      
      
      Set<AWTKeyStroke> forTraSet = new HashSet<AWTKeyStroke> ();
      textarea.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, forTraSet);
      textarea.getInputMap().put(KeyStroke.getKeyStroke("TAB"), "none");
      textarea.getInputMap().put(KeyStroke.getKeyStroke("control TAB"), "none");

      //Border border = BorderFactory.createLineBorder(Color.WHITE);
       KeyStroke enter = KeyStroke.getKeyStroke(
                KeyEvent.VK_ENTER, InputEvent.CTRL_MASK);
        textarea.getInputMap(JComponent.WHEN_FOCUSED).put(enter, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopCellEditing();
            }
         });  
      }
 
@Override
    public Component getTableCellEditorComponent(
            JTable table, Object value, boolean isSelected, int row, int column) {
        System.out.println("2. getTableCellEditorComponent");
        textarea.setFont(table.getFont());
        textarea.setText((value != null) ? value.toString() : "");
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                textarea.setCaretPosition(textarea.getText().length());
                textarea.requestFocusInWindow();
                System.out.println("4. invokeLater: getTableCellEditorComponent");
            }
        });
        
        
        return scrollpane;
    }
 
@Override
   public Object getCellEditorValue() {
      return textarea.getText();
   }

   
    @Override
    public boolean isCellEditable(final EventObject e) {
        if (e instanceof MouseEvent) {
            return ((MouseEvent) e).getClickCount() >= 2;
        }
        System.out.println("1. isCellEditable");
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                if (e instanceof KeyEvent) {
                    KeyEvent ke = (KeyEvent) e;
                    char kc = ke.getKeyChar();
                    if (Character.isUnicodeIdentifierStart(kc)) {
                        textarea.setText(textarea.getText() + kc);
                        System.out.println("3. invokeLater: isCellEditable");
                    }
                }
            }
        });
        return true;
    }

    //Copid from AbstractCellEditor
    protected EventListenerList listenerList = new EventListenerList();
    transient protected ChangeEvent changeEvent = null;

    @Override
    public boolean shouldSelectCell(EventObject e) {
        return true;
    }

    @Override
    public boolean stopCellEditing() {
        fireEditingStopped();
        return true;
    }

    @Override
    public void cancelCellEditing() {
        fireEditingCanceled();
        System.out.println("finalyy canceled");
    }

    @Override
    public void addCellEditorListener(CellEditorListener l) {
        listenerList.add(CellEditorListener.class, l);
    }

    @Override
    public void removeCellEditorListener(CellEditorListener l) {
        listenerList.remove(CellEditorListener.class, l);
         System.out.println("finalyy removed");
    }


    public CellEditorListener[] getCellEditorListeners() {
        return listenerList.getListeners(CellEditorListener.class);
    }

    protected void fireEditingStopped() {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
// Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == CellEditorListener.class) {
                // Lazily create the event:
                if (changeEvent == null) {
                    changeEvent = new ChangeEvent(this);
                }
                ((CellEditorListener) listeners[i + 1]).editingStopped(changeEvent);
                System.out.println("finalyy stoped");
            }
        }
    }


    protected void fireEditingCanceled() {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
// Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == CellEditorListener.class) {
                // Lazily create the event:
                if (changeEvent == null) {
                    changeEvent = new ChangeEvent(this);
                }
                ((CellEditorListener) listeners[i + 1]).editingCanceled(changeEvent);
                System.out.println("finalyy canceled");

 
            }
        }
    }
   
}
