package components;

import javax.swing.*;
import javax.swing.text.StyledDocument;

import java.awt.*;
import utils.Constants;

public class EditorFrame {

    private static Color[] COLORS = Constants.COLORS;

    public static JFrame frame = createFrame();
    public static JTextPane textPane = TextPane.createTextPane(frame);
    public static StyledDocument styledDocument = textPane.getStyledDocument();

    private static JFrame createFrame() {

        JFrame frame = new JFrame("TEXT EDITOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1150, 500);
        frame.setUndecorated(true);
        frame.setJMenuBar(MenuBar.menuBar);

        JRootPane rootPane = frame.getRootPane();
        rootPane.setBorder(BorderFactory.createMatteBorder(2,2,2,2, COLORS[1]));

        frame.setLocation(new Point(30, 100));

        return frame;

    }

}
