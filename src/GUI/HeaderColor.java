/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author neemi
 */
public class HeaderColor extends DefaultTableCellRenderer{
    
    public HeaderColor() {
            setOpaque(true);
    }
    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            
           setForeground(new Color(255,255,255));
           setBackground(new java.awt.Color(32, 136, 203));
//you can change the color that u want 
            return this;
        }
    
}
