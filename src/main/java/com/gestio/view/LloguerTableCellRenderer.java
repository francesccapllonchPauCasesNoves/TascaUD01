package com.gestio.view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class LloguerTableCellRenderer extends DefaultTableCellRenderer {
    private static final Color COLOR_VERD = new Color(200, 240, 210);
    private static final Color COLOR_ROSA = new Color(255, 210, 210);

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (!isSelected) {
            // Alternar colors segons l'estat o l'índex de fila
            if (row % 2 == 0) {
                c.setBackground(COLOR_VERD);
            } else {
                c.setBackground(COLOR_ROSA);
            }
            c.setForeground(Color.BLACK);
        }
        return c;
    }
}