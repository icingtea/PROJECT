package utils;

import java.awt.*;

import javax.swing.JFileChooser;

public class Constants {

    public final static Color[] COLORS = {
        new Color(0x151515), //0 dark grey
        new Color(0xD924A5), //1 pink
        new Color(0x0ECAD1), //2 blue
        new Color(0x212121), //3 grey
        new Color(0x414141), //4 light grey
        new Color(0X004B4A)  //5 dark blue
    };

    public final static Font DEFAULT_FONT = new Font("OCR A Extended", Font.PLAIN, 16);
    public final static Font ITALIC_FONT = new Font("OCR A Extended", Font.ITALIC,16);
    public final static Font BOLD_FONT = new Font("OCR A Extended", Font.BOLD, 16);
    public final static Font SYMBOL_FONT = new Font("OCR A Extended", Font.PLAIN, 25);

    public static JFileChooser saveFileChooser = new JFileChooser();
    public static JFileChooser openFileChooser = new JFileChooser();
    
}