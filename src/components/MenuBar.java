package components;

import javax.swing.*;
import java.awt.*;

import utils.Constants;

public class MenuBar {

    private static Color[] COLORS = Constants.COLORS;

    public static JMenuBar menuBar = createMenuBar();
    
    private static JMenuBar createMenuBar() {

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(COLORS[0]);
        menuBar.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, COLORS[2]));
        menuBar.setPreferredSize(new Dimension(1150, 40));
        
        menuBar.add(FileMenu.fileMenu);
        menuBar.add(FontMenu.fontMenu);
        menuBar.add(Box.createHorizontalStrut(15));
        menuBar.add(Misc.findLabel);
        menuBar.add(Misc.findField);
        menuBar.add(Box.createHorizontalStrut(10));
        menuBar.add(Misc.replaceLabel);
        menuBar.add(Misc.replaceField);

        menuBar.add(Box.createHorizontalGlue());

        menuBar.add(Misc.sketchButton);
        menuBar.add(Box.createHorizontalStrut(20));
        menuBar.add(Misc.wordCountField);
        menuBar.add(Box.createHorizontalStrut(10));
        menuBar.add(Misc.boldButton);
        menuBar.add(Misc.italicButton);
        menuBar.add(Box.createHorizontalStrut(10));
        menuBar.add(FontSizeManager.plusButton);
        menuBar.add(Box.createHorizontalStrut(10));
        menuBar.add(FontSizeManager.fontSizeField);
        menuBar.add(Box.createHorizontalStrut(10));
        menuBar.add(FontSizeManager.minusButton);
        menuBar.add(Box.createHorizontalStrut(20));
        menuBar.add(Misc.closeButton);
        menuBar.add(Box.createHorizontalStrut(20));

        return menuBar;

    }

}