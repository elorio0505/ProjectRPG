package RPGGame.Controller;

import javax.swing.*;

public class SceneController extends JFrame {
    public static Boolean gameRunning = false;
    private JPanel mainPanel;
    private JTextField userInput;
    private JButton sendButton;
    private JTextArea gameTextArea;
    private JPanel textAreaPanel;
    private JPanel statsPanel;
    private JTextArea statsTextArea;

    public void start() {
        JFrame frame = new JFrame("SceneController");
        frame.setContentPane(new SceneController().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("ProjectRPG");
        frame.setSize(1000, 500);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void gameTextAreaClear() {
    }

    public static void gameTextAreaNewLine(String text) {
    }
}
