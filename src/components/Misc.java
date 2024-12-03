package components;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.awt.*;
import utils.Constants;

public class Misc {

    private static Color[] COLORS = Constants.COLORS;
    private static Font DEFAULT_FONT = Constants.DEFAULT_FONT;
    private static Font ITALIC_FONT = Constants.ITALIC_FONT;
    private static Font BOLD_FONT = Constants.BOLD_FONT;

    public static JButton sketchButton = createSketchButton();
    public static JButton closeButton = createCloseButton();
    public static JButton boldButton = createBoldButton();
    public static JButton italicButton = createItalicButton();
    public static JLabel wordCountField = createWordCountField();
    public static JLabel findLabel = createFindLabel();
    public static JTextField findField = createFindField();
    public static JLabel replaceLabel = createReplaceLabel();
    public static JTextField replaceField = createReplaceField();

    private static JLabel createWordCountField() {

        JLabel wordCountField = new JLabel("Character Count: 0 | Word Count: 0");
        wordCountField.setMaximumSize(new Dimension(450, 30));
        wordCountField.setMinimumSize(new Dimension(300, 30));

        wordCountField.setBackground(COLORS[0]);
        wordCountField.setForeground(COLORS[4]);
        wordCountField.setBorder(BorderFactory.createEmptyBorder());
        wordCountField.setFont(DEFAULT_FONT);

        return wordCountField;

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

        boldButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                boldButton.setForeground(COLORS[1]);

            }

            @Override
            public void mouseExited(MouseEvent e) {

                boldButton.setForeground(COLORS[2]);

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

        italicButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                italicButton.setForeground(COLORS[1]);

            }

            @Override
            public void mouseExited(MouseEvent e) {

                italicButton.setForeground(COLORS[2]);

            }

        });

        return italicButton;

    }

    private static JButton createCloseButton() {

        JButton closeButton = new JButton("✖");
        closeButton.setBackground(COLORS[0]);
        closeButton.setForeground(COLORS[1]);
        closeButton.setBorder(BorderFactory.createEmptyBorder());
        closeButton.setContentAreaFilled(false);

        closeButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                closeButton.setForeground(COLORS[2]);

            }

            @Override
            public void mouseExited(MouseEvent e) {

                closeButton.setForeground(COLORS[1]);

            }
            
        });

        closeButton.addActionListener(l -> {

            System.exit(0);

        });

        return closeButton;

    }

    private static JLabel createFindLabel() {

        JLabel findLabel = new JLabel("Find: ");
        findLabel.setFont(DEFAULT_FONT);
        findLabel.setBackground(COLORS[0]);
        findLabel.setForeground(COLORS[2]);
        findLabel.setBorder(BorderFactory.createEmptyBorder());

        return findLabel;

    }

    private static JTextField createFindField() {

        JTextField findField = new JTextField();

        findField.setMaximumSize(new Dimension(20000, 30));
        findField.setFont(DEFAULT_FONT);
        findField.setBackground(COLORS[0]);
        findField.setForeground(COLORS[1]);
        findField.setBorder(BorderFactory.createEmptyBorder());
        findField.setBorder(BorderFactory.createLineBorder(COLORS[2], 1));

        return findField;

    }

    private static JLabel createReplaceLabel() {

        JLabel replaceLabel = new JLabel("Replace: ");
        replaceLabel.setFont(DEFAULT_FONT);
        replaceLabel.setBackground(COLORS[0]);
        replaceLabel.setForeground(COLORS[2]);
        replaceLabel.setBorder(BorderFactory.createEmptyBorder());

        return replaceLabel;

    }

    private static JTextField createReplaceField() {

        JTextField replaceField = new JTextField();

        replaceField.setMaximumSize(new Dimension(20000, 30));
        replaceField.setFont(DEFAULT_FONT);
        replaceField.setBackground(COLORS[0]);
        replaceField.setForeground(COLORS[1]);
        replaceField.setBorder(BorderFactory.createEmptyBorder());
        replaceField.setBorder(BorderFactory.createLineBorder(COLORS[2], 1));

        return replaceField;

    }

    private static JButton createSketchButton() {

        JButton sketchButton = new JButton("SketchPad");
        sketchButton.setFont(DEFAULT_FONT);
        sketchButton.setBackground(COLORS[0]);
        sketchButton.setForeground(COLORS[2]);
        sketchButton.setBorder(BorderFactory.createEmptyBorder());
        sketchButton.setContentAreaFilled(false);

        sketchButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                sketchButton.setForeground(COLORS[1]);

            }

            @Override
            public void mouseExited(MouseEvent e) {

                sketchButton.setForeground(COLORS[2]);

            }

        });

        sketchButton.addActionListener(l -> {

            SketchFrame.sketchFrame.setVisible(true);

        });

        return sketchButton;

    }
    
}