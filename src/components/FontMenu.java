package components;

import javax.swing.*;
import javax.swing.text.*;

public class FontMenu {

    public static JMenu fontMenu = createFontMenu();

    private static JMenu createFontMenu() {

        JMenu fontMenu = new JMenu(" Font ");
        VisualHelpers.menuFormat(fontMenu);

        JMenuItem OCRAItem = VisualHelpers.createTextMenuItem("OCR A");
        JMenuItem SimSunItem = VisualHelpers.createTextMenuItem("SimSun");
        JMenuItem CourierNewItem = VisualHelpers.createTextMenuItem("Courier New");
        JMenuItem ConsolasItem = VisualHelpers.createTextMenuItem("Consolas");

        OCRAItem.addActionListener(l -> {

            generalFontListener("OCR A Extended");
            
        });

        SimSunItem.addActionListener(l -> {

            generalFontListener("SimSun");
            
        });

        CourierNewItem.addActionListener(l -> {

            generalFontListener("Courier New");
            
        });
        
        ConsolasItem.addActionListener(l -> {

            generalFontListener("Consolas");
            
        });

        fontMenu.add(OCRAItem);
        fontMenu.add(SimSunItem);
        fontMenu.add(CourierNewItem);
        fontMenu.add(ConsolasItem);
        return fontMenu;

    }

    private static void generalFontListener(String Font) {

        int start = EditorFrame.textPane.getSelectionStart();
        int end = EditorFrame.textPane.getSelectionEnd();

        SimpleAttributeSet attr = new SimpleAttributeSet(EditorFrame.styledDocument.getCharacterElement(end).getAttributes());
        StyleConstants.setFontFamily(attr, Font);
        EditorFrame.textPane.setCharacterAttributes(attr, false);
        EditorFrame.styledDocument.setCharacterAttributes(start, end - start, attr, false);

    }

}