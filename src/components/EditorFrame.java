package components;

import javax.swing.*;
import java.awt.*;
import utils.Constants;

public class EditorFrame {

    private static Color[] COLORS = Constants.COLORS;

    public static JFrame frame = createFrame();
    public static JTextPane textPane = TextPane.createTextPane(frame);
    
    private static JFrame createFrame() {

        JFrame frame = new JFrame("TEXT EDITOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600);
        frame.setUndecorated(true);
        frame.setJMenuBar(MenuBar.menuBar);

        JRootPane rootPane = frame.getRootPane();
        rootPane.setBorder(BorderFactory.createMatteBorder(2,2,2,2, COLORS[1]));

        frame.setLocationRelativeTo(null);

        return frame;

    }

}