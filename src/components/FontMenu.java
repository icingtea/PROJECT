package components;

import javax.swing.*;
import java.awt.*;
import utils.Constants;

public class FontMenu {

    private static Color[] COLORS = Constants.COLORS;
    private static Font DEFAULT_FONT = Constants.DEFAULT_FONT;

    public static JMenu fontMenu = createFontMenu();

    private static JMenu createFontMenu() {

        UIManager.put("Menu.selectionBackground", COLORS[3]);
        UIManager.put("Menu.selectionForeground", COLORS[2]);
        UIManager.put("MenuItem.selectionBackground", COLORS[3]);
        UIManager.put("MenuItem.selectionForeground", COLORS[2]);

        JMenu fontMenu = new JMenu(" Font ");
        fontMenu.setFont(DEFAULT_FONT);
        fontMenu.setForeground(COLORS[1]);
        fontMenu.setBorder(BorderFactory.createEmptyBorder());
        fontMenu.getPopupMenu().setBorder(BorderFactory.createEmptyBorder());
        fontMenu.getPopupMenu().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, COLORS[2]));

        JMenuItem newItem = MenuItem.createMenuItem("OCR A");
        JMenuItem openItem = MenuItem.createMenuItem("Monospaced");
        JMenuItem saveItem = MenuItem.createMenuItem("Courier New");
        JMenuItem exitItem = MenuItem.createMenuItem("Consolas");

        fontMenu.add(openItem);
        fontMenu.add(newItem);
        fontMenu.add(saveItem);
        fontMenu.add(exitItem);
        return fontMenu;

    }

}
