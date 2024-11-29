import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;

public class App {


    private final static Color[] COLORS = {
        new Color(0x121213), //0 grey
        new Color(0xD924A5), //1 pink
        new Color(0x0ECAD1)  //2 blue
    };

    private final static Font defaultFont = new Font("OCR A Extended", Font.PLAIN, 16);
    private final static Font menuFont = new Font("OCR A Extended", Font.PLAIN, 16);

    private static JFrame frame = createFrame();
    private static JEditorPane editorPane = createEditorPane(frame);

    public static void main(String[] args) throws Exception {

        SwingUtilities.invokeLater(() -> {

            try {
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

    }

    private static JFrame createFrame() {

        JFrame frame = new JFrame("TEXT EDITOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600);
        frame.setUndecorated(true);

        JMenuBar menuBar = createMenuBar();
        frame.setJMenuBar(menuBar);

        JRootPane rootPane = frame.getRootPane();
        rootPane.setBorder(BorderFactory.createMatteBorder(2,2,2,2, COLORS[1]));

        frame.setLocationRelativeTo(null);

        return frame;

    }

    private static JEditorPane createEditorPane(JFrame frame) {

        JEditorPane editorPane = new JEditorPane();

        editorPane.setBackground(COLORS[0]);
        editorPane.setForeground(COLORS[1]);
        editorPane.setFont(defaultFont);
        editorPane.setMargin(new Insets(20, 20, 20, 20));

        JScrollPane scrollPane = new JScrollPane(editorPane);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setBackground(COLORS[0]);
        frame.add(scrollPane, BorderLayout.CENTER);

        return editorPane;

    }

    private static JMenuItem createMenuItem(String s) {

        JMenuItem menuItem = new JMenuItem(s);

        menuItem.setFont(menuFont);
        menuItem.setBackground(COLORS[0]);
        menuItem.setForeground(COLORS[1]);
        menuItem.setBorder(BorderFactory.createEmptyBorder());
        menuItem.setPreferredSize(new Dimension(80, 30));
        menuItem.setOpaque(true);

        return menuItem;

    }

    private static JMenuBar createMenuBar() {

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(COLORS[0]);
        menuBar.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, COLORS[2]));
        menuBar.setPreferredSize(new Dimension(600, 40));

        JMenu fileMenu = new JMenu("File");
        fileMenu.setFont(menuFont);
        fileMenu.setForeground(COLORS[1]);
        fileMenu.getPopupMenu().setBorder(BorderFactory.createEmptyBorder());
        fileMenu.getPopupMenu().setBorder(BorderFactory.createMatteBorder(2, 0, 2, 1, COLORS[2]));

        JMenuItem newItem = createMenuItem("New");
        JMenuItem openItem = createMenuItem("Open");
        JMenuItem saveItem = createMenuItem("Save");
        JMenuItem exitItem = createMenuItem("Exit");

        newItem.addActionListener(l -> {

            editorPane.setText("");

        });

        openItem.addActionListener(l -> {

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Text Documents (*.txt)", "txt"));
            int option = fileChooser.showOpenDialog(frame);

            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    String fileContent = Files.readString(file.toPath());
                    editorPane.setText(fileContent);
                    JOptionPane.showMessageDialog(null, "File opened.");
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Error opening file.");
                }

            }

        });

        saveItem.addActionListener(l -> {
        
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Text Documents (*.txt)", "txt"));
            int option = fileChooser.showSaveDialog(frame);

            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                FileWriter fileWriter = null;

                try {
                    fileWriter = new FileWriter(file);
                    fileWriter.write(editorPane.getText());
                    JOptionPane.showMessageDialog(null, "File saved.");
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Error saving file.");
                } finally {
                    try { 
                        fileWriter.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
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

        menuBar.add(fileMenu);

        return menuBar;

    }

}
