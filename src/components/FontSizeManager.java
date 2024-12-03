package components;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

import utils.Constants;

public class FontSizeManager {
    
    private static Color[] COLORS = Constants.COLORS;
    private static Font SYMBOL_FONT = Constants.SYMBOL_FONT;

    public static JLabel fontSizeField = createFontSizeField();
    public static JButton plusButton = createPlusButton();
    public static JButton minusButton = createMinusButton();

    private static JLabel createFontSizeField() {

        JLabel fontSizeField = new JLabel("16");
        fontSizeField.setMaximumSize(new Dimension(100, 20));
        VisualHelpers.labelFormat(fontSizeField, COLORS[1]);
        fontSizeField.setBorder(BorderFactory.createLineBorder(COLORS[2], 1));

        fontSizeField.addPropertyChangeListener("text", l -> {
        
            int start = EditorFrame.textPane.getSelectionStart();
            int end = EditorFrame.textPane.getSelectionEnd();
        
            SimpleAttributeSet attr = new SimpleAttributeSet();
            StyleConstants.setFontSize(attr, Integer.parseInt(fontSizeField.getText()));
        
            if (start != end) {
                EditorFrame.styledDocument.setCharacterAttributes(start, end - start, attr, false);
            } else {
                EditorFrame.textPane.setCharacterAttributes(attr, false);
            }

        });

        return fontSizeField;

    }

    private static JButton createPlusButton() {

        JButton plusButton = new JButton("+");
        plusButton.setFont(SYMBOL_FONT);
        VisualHelpers.buttonFormat(plusButton, COLORS[2], COLORS[1]);

        plusButton.addActionListener(l -> {

            int currentSize = Integer.parseInt(fontSizeField.getText());
            fontSizeField.setText(Integer.toString(Math.min(currentSize + 1, 40)));
            
        });

        return plusButton;

    }

    private static JButton createMinusButton() {

        JButton minusButton = new JButton("-");
        minusButton.setFont(SYMBOL_FONT);
        VisualHelpers.buttonFormat(minusButton, COLORS[2], COLORS[1]);

        minusButton.addActionListener(l -> {

            int currentSize = Integer.parseInt(fontSizeField.getText());
            fontSizeField.setText(Integer.toString(Math.max(1, currentSize - 1)));
            
        });

        return minusButton;

    }

}