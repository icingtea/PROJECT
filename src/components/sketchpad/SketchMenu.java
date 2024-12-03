package components.sketchpad;

import javax.swing.*;
import java.awt.*;

import components.VisualHelpers;
import utils.Constants;

public class SketchMenu {
    
    private static Color[] COLORS = Constants.COLORS;
    private static Font DEFAULT_FONT = Constants.DEFAULT_FONT;

    private static JMenu shapeMenu = createShapeMenu();
    private static JButton closeButton = createCloseButton();
    public static JMenuBar menuBar = createMenuBar();

    private static JMenuBar createMenuBar() {

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(COLORS[0]);
        menuBar.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, COLORS[1]));
        menuBar.setPreferredSize(new Dimension(325, 40));

        menuBar.add(shapeMenu);

        menuBar.add(Box.createHorizontalGlue());

        menuBar.add(closeButton);
        menuBar.add(Box.createHorizontalStrut(20));

        return menuBar;

    }

    private static JButton createCloseButton() {
        
        JButton closeButton = new JButton("✖");
        closeButton.setBackground(COLORS[0]);
        VisualHelpers.buttonFormat(closeButton, COLORS[2], COLORS[1]);

        closeButton.addActionListener(l -> {

            System.exit(0);

        });

        return closeButton;

    }

    private static JMenu createShapeMenu() {

        UIManager.put("Menu.selectionBackground", COLORS[3]);
        UIManager.put("Menu.selectionForeground", COLORS[1]);
        UIManager.put("MenuItem.selectionBackground", COLORS[3]);
        UIManager.put("MenuItem.selectionForeground", COLORS[1]);

        JMenu shapeMenu = new JMenu(" Insert ");
        shapeMenu.setFont(DEFAULT_FONT);
        shapeMenu.setForeground(COLORS[2]);
        shapeMenu.setBorder(BorderFactory.createEmptyBorder());
        shapeMenu.getPopupMenu().setBorder(BorderFactory.createEmptyBorder());
        shapeMenu.getPopupMenu().setBorder(BorderFactory.createMatteBorder(2, 1, 2, 2, COLORS[1]));

        JMenuItem circleItem = VisualHelpers.createSketchMenuItem("Circle");
        JMenuItem squareItem = VisualHelpers.createSketchMenuItem("Square");
        JMenuItem triangleItem = VisualHelpers.createSketchMenuItem("Triangle");
        JMenuItem rhombusItem = VisualHelpers.createSketchMenuItem("Rhombus");

        shapeMenu.add(circleItem);
        shapeMenu.add(squareItem);
        shapeMenu.add(triangleItem);
        shapeMenu.add(rhombusItem);

        return shapeMenu;

    }

}