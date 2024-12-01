package components;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import utils.Constants;

public class FontSizeManager {
    
    private static Color[] COLORS = Constants.COLORS;
    public static JButton plusButton = createPlusButton();
    public static JButton minusButton = createMinusButton();

    private static JButton createPlusButton() {

        JButton plusButton = new JButton("+");
        plusButton.setBackground(COLORS[0]);
        plusButton.setForeground(COLORS[2]);
        plusButton.setBorder(BorderFactory.createEmptyBorder());
        plusButton.setContentAreaFilled(false);

        plusButton.addActionListener(l -> {

        });

        plusButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                plusButton.setForeground(COLORS[1]);

            }

            @Override
            public void mouseExited(MouseEvent e) {

                plusButton.setForeground(COLORS[2]);

            }
            
        });

        return plusButton;

    }

    private static JButton createMinusButton() {

        JButton minusButton = new JButton("-");
        minusButton.setBackground(COLORS[0]);
        minusButton.setForeground(COLORS[2]);
        minusButton.setBorder(BorderFactory.createEmptyBorder());
        minusButton.setContentAreaFilled(false);

        minusButton.addActionListener(l -> {

        });

        minusButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                minusButton.setForeground(COLORS[1]);

            }

            @Override
            public void mouseExited(MouseEvent e) {

                minusButton.setForeground(COLORS[2]);

            }
            
        });

        return minusButton;

    }


}
