package components;

import javax.swing.*;
import java.awt.*;
import utils.Constants;

public class MenuItem {

    private static Color[] COLORS = Constants.COLORS;
    private static Font DEFAULT_FONT = Constants.DEFAULT_FONT;

    public static JMenuItem createMenuItem(String s) {

    JMenuItem menuItem = new JMenuItem(s);

    menuItem.setFont(DEFAULT_FONT);
    menuItem.setBackground(COLORS[0]);
    menuItem.setForeground(COLORS[1]);
    menuItem.setBorder(BorderFactory.createEmptyBorder());
    menuItem.setPreferredSize(new Dimension(120, 30));
    menuItem.setOpaque(true);

    return menuItem;

    }
    
}