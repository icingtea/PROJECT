package components;

import javax.swing.*;
import java.awt.*;
import utils.Constants;

public class Misc {

    private static Color[] COLORS = Constants.COLORS;
    private static Font DEFAULT_FONT = Constants.DEFAULT_FONT;

    public static JButton closeButton = createCloseButton();
    public static JLabel wordCountField = createWordCountField();
    public static JLabel fontSizeLabel = createFontSizeLabel();

    private static JLabel createWordCountField() {

        JLabel wordCountField = new JLabel("Word Count: 0");
        wordCountField.setMaximumSize(new Dimension(100, 30));
        wordCountField.setMinimumSize(new Dimension(100, 30));

        wordCountField.setBackground(COLORS[0]);
        wordCountField.setForeground(COLORS[4]);
        wordCountField.setBorder(BorderFactory.createEmptyBorder());
        wordCountField.setFont(DEFAULT_FONT);

        return wordCountField;

    }

    private static JLabel createFontSizeLabel() {
        
        JLabel fontSizeLabel = new JLabel("Font Size:");
        fontSizeLabel.setFont(DEFAULT_FONT);
        fontSizeLabel.setBackground(COLORS[0]);
        fontSizeLabel.setForeground(COLORS[2]);

        return fontSizeLabel;

    }

    private static JButton createCloseButton() {

        JButton closeButton = new JButton("✖");
        closeButton.setBackground(COLORS[0]);
        closeButton.setForeground(COLORS[2]);
        closeButton.setBorder(BorderFactory.createEmptyBorder());
        closeButton.setContentAreaFilled(false);

        closeButton.addActionListener(l -> {

            System.exit(0);

        });

        return closeButton;

    }
    
}
