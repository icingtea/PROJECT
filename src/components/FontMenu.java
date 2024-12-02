package components;

import javax.swing.*;
import javax.swing.text.*;
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

        JMenuItem OCRAItem = MenuItem.createMenuItem("OCR A");
        JMenuItem SimSunItem = MenuItem.createMenuItem("SimSun");
        JMenuItem CourierNewItem = MenuItem.createMenuItem("Courier New");
        JMenuItem ConsolasItem = MenuItem.createMenuItem("Consolas");

        OCRAItem.addActionListener(l -> {

            int start = EditorFrame.textPane.getSelectionStart();
            int end = EditorFrame.textPane.getSelectionEnd();

            SimpleAttributeSet attr = new SimpleAttributeSet(EditorFrame.styledDocument.getCharacterElement(start).getAttributes());
            StyleConstants.setFontFamily(attr, "OCR A Extended");
            EditorFrame.textPane.setCharacterAttributes(attr, false);
            EditorFrame.styledDocument.setCharacterAttributes(start, end - start, attr, false);
            
        });

        SimSunItem.addActionListener(l -> {

            int start = EditorFrame.textPane.getSelectionStart();
            int end = EditorFrame.textPane.getSelectionEnd();

            SimpleAttributeSet attr = new SimpleAttributeSet(EditorFrame.styledDocument.getCharacterElement(start).getAttributes());
            StyleConstants.setFontFamily(attr, "SimSun");
            EditorFrame.textPane.setCharacterAttributes(attr, false);
            EditorFrame.styledDocument.setCharacterAttributes(start, end - start, attr, false);
            
        });

        CourierNewItem.addActionListener(l -> {

            int start = EditorFrame.textPane.getSelectionStart();
            int end = EditorFrame.textPane.getSelectionEnd();
        
            SimpleAttributeSet attr = new SimpleAttributeSet(EditorFrame.styledDocument.getCharacterElement(start).getAttributes());
            StyleConstants.setFontFamily(attr, "Courier New");
            EditorFrame.textPane.setCharacterAttributes(attr, false);
            EditorFrame.styledDocument.setCharacterAttributes(start, end - start, attr, false);
            
        });
        
        ConsolasItem.addActionListener(l -> {

            int start = EditorFrame.textPane.getSelectionStart();
            int end = EditorFrame.textPane.getSelectionEnd();

            SimpleAttributeSet attr = new SimpleAttributeSet(EditorFrame.styledDocument.getCharacterElement(end).getAttributes());
            StyleConstants.setFontFamily(attr, "Consolas");
            EditorFrame.textPane.setCharacterAttributes(attr, false);
            EditorFrame.styledDocument.setCharacterAttributes(start, end - start, attr, false);
            
        });

        fontMenu.add(OCRAItem);
        fontMenu.add(SimSunItem);
        fontMenu.add(CourierNewItem);
        fontMenu.add(ConsolasItem);
        return fontMenu;

    }

}