package components;

import java.io.*;
import java.nio.file.Files;
import javax.swing.*;
import javax.swing.text.rtf.RTFEditorKit;

public class FileMenu {

    private static JFileChooser saveFileChooser = new JFileChooser();
    private static JFileChooser openFileChooser = new JFileChooser();

    public static JMenu fileMenu = createFileMenu();

    private static JMenu createFileMenu() {

        JMenu fileMenu = new JMenu(" File ");
        VisualHelpers.menuFormat(fileMenu);

        JMenuItem newItem = VisualHelpers.createTextMenuItem("New");
        JMenuItem openItem = VisualHelpers.createTextMenuItem("Open");
        JMenuItem saveItem = VisualHelpers.createTextMenuItem("Save");
        JMenuItem exitItem = VisualHelpers.createTextMenuItem("Exit");

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