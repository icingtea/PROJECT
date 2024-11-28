import javax.swing.*;
import java.awt.*;
import java.io.File;

public class App {


    private final static Color[] COLORS = {

        new Color(0x0E1111), //0 grey
        new Color(0xD924A5), //1 pink
        new Color(0x0ECAD1)  //2 blue

    };

    private final static Font defaultFont = new Font("OCR A Extended", Font.PLAIN, 16);
    private final static Font menuFont = new Font("OCR A Extended", Font.PLAIN, 16);

    public static void main(String[] args) throws Exception {

        JFrame frame = createFrame();
        frame.setUndecorated(true);

        JMenuBar menuBar = createMenuBar();
        frame.setJMenuBar(menuBar);

        JEditorPane editorPane = createEditorPane(frame);

        JRootPane rootPane = frame.getRootPane();
        rootPane.setBorder(BorderFactory.createMatteBorder(2,2,2,2, COLORS[1]));

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private static JFrame createFrame() {

        JFrame frame = new JFrame("TEXT EDITOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600);

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
        JMenuItem saveItem = createMenuItem("Save");
        JMenuItem exitItem = createMenuItem("Exit");

        fileMenu.add(newItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        return menuBar;

    }
}
