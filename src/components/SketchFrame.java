package components;

import javax.swing.*;
import java.awt.*;

import utils.Constants;

public class SketchFrame {

    private static Color[] COLORS = Constants.COLORS;

    public static JFrame sketchFrame = createFrame();

    private static JFrame createFrame() {

        JFrame sketchFrame = new JFrame("TEXT EDITOR");
        sketchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sketchFrame.setSize(325, 500);
        sketchFrame.setUndecorated(true);
        sketchFrame.getContentPane().setBackground(COLORS[0]);
        sketchFrame.setJMenuBar(SketchMenu.menuBar);

        JRootPane rootPane = sketchFrame.getRootPane();
        rootPane.setBorder(BorderFactory.createMatteBorder(2,2,2,2, COLORS[2]));

        sketchFrame.setLocation(1000, 100);

        return sketchFrame;

    }

}