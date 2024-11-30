package components;

import javax.swing.*;
import java.awt.*;
import utils.Constants;

public class FontSizeManager {
    
    private static Color[] COLORS = Constants.COLORS;
    private static Font DEFAULT_FONT = Constants.DEFAULT_FONT;

    public static JLabel fontSizeField = createFontSizeField();
    public static JButton plusButton = createPlusButton();
    public static JButton minusButton = createMinusButton();
    
    private static JLabel createFontSizeField() {

        JLabel fontSizeField = new JLabel("16");
        fontSizeField.setMaximumSize(new Dimension(100, 30));
        fontSizeField.setMinimumSize(new Dimension(100, 30));

        fontSizeField.setBackground(COLORS[0]);
        fontSizeField.setForeground(COLORS[1]);
        fontSizeField.setBorder(BorderFactory.createEmptyBorder());
        fontSizeField.setFont(DEFAULT_FONT);

        return fontSizeField;

    }

    private static JButton createPlusButton() {

        JButton plusButton = new JButton("+");
        plusButton.setBackground(COLORS[0]);
        plusButton.setForeground(COLORS[2]);
        plusButton.setBorder(BorderFactory.createEmptyBorder());
        plusButton.setContentAreaFilled(false);

        plusButton.addActionListener(l -> {

            int currentSize = Integer.parseInt(fontSizeField.getText());
            if (currentSize < 30) {
                currentSize += 1;
            }

            fontSizeField.setText(Integer.toString(currentSize));

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

            int currentSize = Integer.parseInt(fontSizeField.getText());
            if (currentSize > 1) {
                currentSize -= 1;
            }

            fontSizeField.setText(Integer.toString(currentSize));

        });

        return minusButton;

    }


}
