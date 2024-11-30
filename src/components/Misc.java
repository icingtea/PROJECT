package components;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import java.awt.*;
import utils.Constants;

public class Misc {

    private static Color[] COLORS = Constants.COLORS;
    private static Font DEFAULT_FONT = Constants.DEFAULT_FONT;
    private static Font ITALIC_FONT = Constants.ITALIC_FONT;
    private static Font BOLD_FONT = Constants.BOLD_FONT;

    public static JButton closeButton = createCloseButton();
    public static JButton boldButton = createBoldButton();
    public static JButton italicButton = createItalicButton();
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

    private static JButton createBoldButton() {

        JButton boldButton = new JButton(" B ");
        boldButton.setFont(BOLD_FONT);
        boldButton.setBackground(COLORS[0]);
        boldButton.setForeground(COLORS[2]);
        boldButton.setBorder(BorderFactory.createEmptyBorder());
        boldButton.setContentAreaFilled(false);

        boldButton.addActionListener(l -> {

            int start = EditorFrame.textPane.getSelectionStart();
            int end = EditorFrame.textPane.getSelectionEnd();
        
            if (start == end) {
                SimpleAttributeSet attr = new SimpleAttributeSet(EditorFrame.textPane.getInputAttributes());
                boolean isCurrentlyBold = StyleConstants.isBold(attr);
        
                StyleConstants.setBold(attr, !isCurrentlyBold);
                EditorFrame.textPane.setCharacterAttributes(attr, false);
            } else {
                SimpleAttributeSet attr = new SimpleAttributeSet(EditorFrame.styledDocument.getCharacterElement(start).getAttributes());
                boolean isCurrentlyBold = StyleConstants.isBold(attr);
        
                StyleConstants.setBold(attr, !isCurrentlyBold);
                EditorFrame.styledDocument.setCharacterAttributes(start, end - start, attr, false);
            }
            
        });

        return boldButton;

    }

    private static JButton createItalicButton() {

        JButton italicButton = new JButton(" I ");
        italicButton.setFont(ITALIC_FONT);
        italicButton.setBackground(COLORS[0]);
        italicButton.setForeground(COLORS[2]);
        italicButton.setBorder(BorderFactory.createEmptyBorder());
        italicButton.setContentAreaFilled(false);

        italicButton.addActionListener(l -> {

            int start = EditorFrame.textPane.getSelectionStart();
            int end = EditorFrame.textPane.getSelectionEnd();

            if (start == end) {
                SimpleAttributeSet attr = new SimpleAttributeSet(EditorFrame.textPane.getInputAttributes());
                boolean isCurrentlyItalic = StyleConstants.isItalic(attr);
        
                StyleConstants.setItalic(attr, !isCurrentlyItalic);
                EditorFrame.textPane.setCharacterAttributes(attr, false);

            } else {
                SimpleAttributeSet attr = new SimpleAttributeSet(EditorFrame.styledDocument.getCharacterElement(start).getAttributes());
                boolean isCurrentlyItalic = StyleConstants.isItalic(attr);
        
                StyleConstants.setItalic(attr, !isCurrentlyItalic);
                EditorFrame.styledDocument.setCharacterAttributes(start, end - start, attr, false);
            } 

        });

        return italicButton;

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
