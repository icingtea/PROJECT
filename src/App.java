import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;

public class App {


    private final static Color[] COLORS = {
        new Color(0x121213), //0 grey
        new Color(0xD924A5), //1 pink
        new Color(0x0ECAD1),  //2 blue
        new Color(0x3A3A3A)  //3 light grey
    };

    private final static Font defaultFont = new Font("OCR A Extended", Font.PLAIN, 16);
    private final static Font menuFont = new Font("OCR A Extended", Font.PLAIN, 16);

    private static JFileChooser saveFileChooser = new JFileChooser();
    private static JFileChooser openFileChooser = new JFileChooser();
    private static JMenu fileMenu = createFileMenu();
    private static JMenuBar menuBar = createMenuBar();
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

        JScrollBar scrollBar = scrollPane.getVerticalScrollBar();

        scrollBar.setUI(new BasicScrollBarUI() {

            @Override 
            public void configureScrollBarColors() {

                this.thumbColor = COLORS[2];
                this.trackColor = COLORS[0];
                
            }

            @Override
            public Dimension getPreferredSize(JComponent C) {

                return new Dimension(10, super.getPreferredSize(C).height);

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

    private static JMenu createFileMenu() {

        UIManager.put("Menu.selectionBackground", COLORS[3]);
        UIManager.put("Menu.selectionForeground", COLORS[2]);
        UIManager.put("MenuItem.selectionBackground", COLORS[3]);
        UIManager.put("MenuItem.selectionForeground", COLORS[2]);

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

            int option = openFileChooser.showOpenDialog(frame);

            if (option == JFileChooser.APPROVE_OPTION) {
                File file = openFileChooser.getSelectedFile();
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
        
            saveFileChooser.setFileFilter(new FileNameExtensionFilter("Text Documents (*.txt)", "txt"));
            int option = saveFileChooser.showSaveDialog(frame);

            if (option == JFileChooser.APPROVE_OPTION) {
                File file = saveFileChooser.getSelectedFile();
                FileWriter fileWriter = null;

                try {
                    fileWriter = new FileWriter(file);
                    fileWriter.write(editorPane.getText());
                    JOptionPane.showMessageDialog(null, "File saved.");
                    saveFileChooser.rescanCurrentDirectory();
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

        return fileMenu;

    }

    private static JMenuBar createMenuBar() {

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(COLORS[0]);
        menuBar.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, COLORS[2]));
        menuBar.setPreferredSize(new Dimension(600, 40));

        menuBar.add(fileMenu);

        return menuBar;

    }

}