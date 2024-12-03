package components;

import javax.swing.*;
import javax.swing.text.StyledDocument;
import javax.swing.event.*;
import java.awt.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

import utils.Constants;

public class EditorFrame {

    private static Color[] COLORS = Constants.COLORS;
    private static Font DEFAULT_FONT = Constants.DEFAULT_FONT;

    public static JFrame frame = createFrame();
    public static JTextPane textPane = createTextPane(frame);
    public static StyledDocument styledDocument = textPane.getStyledDocument();

    private static JFrame createFrame() {

        JFrame frame = new JFrame("TEXT EDITOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 550);
        frame.setUndecorated(true);

        JRootPane rootPane = frame.getRootPane();
        rootPane.setBorder(BorderFactory.createMatteBorder(2,2,2,2, COLORS[1]));

        frame.setLocationRelativeTo(null);;

        return frame;

    }

    public static JTextPane createTextPane(JFrame frame) {

        JTextPane textPane = new JTextPane();
        textPane.setEditable(true);
        textPane.setSelectionColor(COLORS[3]);
        textPane.setSelectedTextColor(COLORS[2]);
        textPane.setBackground(COLORS[0]);
        textPane.setForeground(COLORS[1]);
        textPane.setFont(DEFAULT_FONT);
        textPane.setMargin(new Insets(20, 20, 20, 20));
        textPane.setText("");

        frame.setJMenuBar(MenuBar.menuBar);

        JScrollPane scrollPane = new JScrollPane(textPane);

        JScrollBar scrollBar = scrollPane.getVerticalScrollBar();

        scrollBar.setUI(new BasicScrollBarUI() {

            @Override 
            public void configureScrollBarColors() {

                this.thumbColor = COLORS[2];
                this.trackColor = COLORS[0];
                
            }

            @Override
            public Dimension getPreferredSize(JComponent C) {

                return new Dimension(7, super.getPreferredSize(C).height);

            }

            @Override
            protected JButton createDecreaseButton(int orientation) {

                return formattedButton();

            }

            @Override
            protected JButton createIncreaseButton(int orientation) {

                return formattedButton();

            }

            private JButton formattedButton() {

                JButton b = new JButton();
                
                Dimension dim = new Dimension(0, 0);
                b.setPreferredSize(dim);
                b.setMaximumSize(dim);

                return b;
            }

        });

        textPane.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {

                Misc.setCounts(textPane);

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                Misc.setCounts(textPane);

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

                Misc.setCounts(textPane);

            }

        });

        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setBackground(COLORS[0]);
        frame.add(scrollPane, BorderLayout.CENTER);

        return textPane;
    
    }

}