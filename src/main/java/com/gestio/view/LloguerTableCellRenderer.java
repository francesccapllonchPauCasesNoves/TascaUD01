package com.gestio.view;

import com.gestio.model.Lloguer;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class LloguerTableCellRenderer extends DefaultTableCellRenderer {
    private static final Color COLOR_VERD = new Color(200, 240, 210);  
    private static final Color COLOR_VERMELL = new Color(255, 200, 200);

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus,
        int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (!isSelected) {
            
            Object estat = table.getValueAt(row, 6);

            if ("Retornat".equals(estat)) {
                c.setBackground(COLOR_VERD);
            } else if ("Fora de Termini".equals(estat)) {
                c.setBackground(COLOR_VERMELL);
            } else {
                c.setBackground(Color.WHITE);
            }
            c.setForeground(Color.BLACK);
        }
        return c;
    }
}