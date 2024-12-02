package components;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
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
        closeButton.setForeground(COLORS[2]);
        closeButton.setBorder(BorderFactory.createEmptyBorder());
        closeButton.setContentAreaFilled(false);

        closeButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                closeButton.setForeground(COLORS[1]);

            }

            @Override
            public void mouseExited(MouseEvent e) {

                closeButton.setForeground(COLORS[2]);

            }
            
        });

        closeButton.addActionListener(l -> {

            SketchFrame.sketchFrame.setVisible(false);

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

        JMenuItem circleItem = createMenuItem("Circle");
        JMenuItem squareItem = createMenuItem("Square");
        JMenuItem triangleItem = createMenuItem("Triangle");
        JMenuItem rhombusItem = createMenuItem("Rhombus");

        shapeMenu.add(circleItem);
        shapeMenu.add(squareItem);
        shapeMenu.add(triangleItem);
        shapeMenu.add(rhombusItem);

        return shapeMenu;

    }

    public static JMenuItem createMenuItem(String s) {

        JMenuItem menuItem = new JMenuItem(s);
    
        menuItem.setFont(DEFAULT_FONT);
        menuItem.setBackground(COLORS[0]);
        menuItem.setForeground(COLORS[2]);
        menuItem.setBorder(BorderFactory.createEmptyBorder());
        menuItem.setPreferredSize(new Dimension(120, 30));
        menuItem.setOpaque(true);
    
        return menuItem;
    
        }

}