package components;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import utils.Constants;

public class FontSizeManager {
    
    private static Color[] COLORS = Constants.COLORS;
    private static Font SYMBOL_FONT = Constants.SYMBOL_FONT;
    private static Font DEFAULT_FONT = Constants.DEFAULT_FONT;

    public static JLabel fontSizeField = createFontSizeField();
    public static JButton plusButton = createPlusButton();
    public static JButton minusButton = createMinusButton();

    private static JLabel createFontSizeField() {

        JLabel fontSizeField = new JLabel("16");
        fontSizeField.setMaximumSize(new Dimension(100, 20));
        fontSizeField.setFont(DEFAULT_FONT);
        fontSizeField.setBackground(COLORS[0]);
        fontSizeField.setForeground(COLORS[1]);
        fontSizeField.setBorder(BorderFactory.createEmptyBorder());
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
        plusButton.setBackground(COLORS[0]);
        plusButton.setForeground(COLORS[2]);
        plusButton.setBorder(BorderFactory.createEmptyBorder());
        plusButton.setContentAreaFilled(false);

        plusButton.addActionListener(l -> {

        });

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

        plusButton.addActionListener(l -> {

            int currentSize = Integer.parseInt(fontSizeField.getText());
            fontSizeField.setText(Integer.toString(Math.min(currentSize + 1, 40)));
            
        });

        return plusButton;

    }

    private static JButton createMinusButton() {

        JButton minusButton = new JButton("-");
        minusButton.setFont(SYMBOL_FONT);
        minusButton.setBackground(COLORS[0]);
        minusButton.setForeground(COLORS[2]);
        minusButton.setBorder(BorderFactory.createEmptyBorder());
        minusButton.setContentAreaFilled(false);

        minusButton.addActionListener(l -> {

            int currentSize = Integer.parseInt(fontSizeField.getText());
            fontSizeField.setText(Integer.toString(Math.max(1, currentSize - 1)));
            
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
