import components.EditorFrame;
import javax.swing.*;

public class App {

    public static void main(String[] args) throws Exception {

        SwingUtilities.invokeLater(() -> {

            try{
                EditorFrame.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }

}