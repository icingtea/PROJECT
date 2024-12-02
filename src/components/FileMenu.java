package components;

import java.io.*;
import java.nio.file.Files;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.rtf.RTFEditorKit;

import java.awt.*;
import utils.Constants;

public class FileMenu {

    private static Color[] COLORS = Constants.COLORS;
    private static Font DEFAULT_FONT = Constants.DEFAULT_FONT;
    private static JFileChooser saveFileChooser = new JFileChooser();
    private static JFileChooser openFileChooser = new JFileChooser();

    public static JMenu fileMenu = createFileMenu();

    private static JMenu createFileMenu() {

        UIManager.put("Menu.selectionBackground", COLORS[3]);
        UIManager.put("Menu.selectionForeground", COLORS[2]);
        UIManager.put("MenuItem.selectionBackground", COLORS[3]);
        UIManager.put("MenuItem.selectionForeground", COLORS[2]);

        JMenu fileMenu = new JMenu(" File ");
        fileMenu.setFont(DEFAULT_FONT);
        fileMenu.setForeground(COLORS[1]);
        fileMenu.setBorder(BorderFactory.createEmptyBorder());
        fileMenu.getPopupMenu().setBorder(BorderFactory.createEmptyBorder());
        fileMenu.getPopupMenu().setBorder(BorderFactory.createMatteBorder(2, 1, 2, 2, COLORS[2]));

        JMenuItem newItem = MenuItem.createMenuItem("New");
        JMenuItem openItem = MenuItem.createMenuItem("Open");
        JMenuItem saveItem = MenuItem.createMenuItem("Save");
        JMenuItem exitItem = MenuItem.createMenuItem("Exit");

        newItem.addActionListener(l -> {

            EditorFrame.textPane.setText("");

        });

        openItem.addActionListener(l -> {
            int option = openFileChooser.showOpenDialog(EditorFrame.frame);
        
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = openFileChooser.getSelectedFile();
                try {
                    if (file.getName().toLowerCase().endsWith(".rtf")) {
                        FileInputStream rtfStream = new FileInputStream(file);
                        RTFEditorKit rtfEditorKit = new RTFEditorKit();
                        rtfEditorKit.read(rtfStream, EditorFrame.textPane.getDocument(), 0);
                        rtfStream.close();
                        JOptionPane.showMessageDialog(null, "File opened.");
                    } else {
                        String fileContent = Files.readString(file.toPath());
                        EditorFrame.textPane.setText(fileContent);
                        JOptionPane.showMessageDialog(null, "File opened.");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error opening file: " + e.getMessage());
                }
            }
        });
        
        saveItem.addActionListener(l -> {
            int option = saveFileChooser.showSaveDialog(EditorFrame.frame);
        
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = saveFileChooser.getSelectedFile();
                if (!file.getName().toLowerCase().endsWith(".rtf")) {
                    file = new File(file.getAbsolutePath() + ".rtf");
                }
        
                try {
                    FileOutputStream rtfStream = new FileOutputStream(file);
                    RTFEditorKit rtfEditorKit= new RTFEditorKit();
                    rtfEditorKit.write(rtfStream, EditorFrame.textPane.getDocument(), 0, EditorFrame.textPane.getDocument().getLength());
                    rtfStream.close();
                    JOptionPane.showMessageDialog(null, "File saved.");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error saving file: " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Save cancelled.");
            }
        });
        
        exitItem.addActionListener(l -> {
            System.exit(0);
        });

        fileMenu.add(openItem);
        fileMenu.add(newItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        return fileMenu;

    }
    
}
