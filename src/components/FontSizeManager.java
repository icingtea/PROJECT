package components;

import javax.swing.*;
import java.awt.*;
import utils.Constants;

public class FontSizeManager {
    
    private static Color[] COLORS = Constants.COLORS;
    private static Font DEFAULT_FONT = Constants.DEFAULT_FONT;
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

        return minusButton;

    }


}
