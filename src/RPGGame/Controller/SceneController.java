package RPGGame.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class SceneController extends JFrame {
    public static Boolean gameRunning = false;
    private JPanel mainPanel;
    private JTextField userInput;
    private JButton sendButton;
    private static JTextArea gameTextArea;
    private JPanel textAreaPanel;
    private JPanel statsPanel;
    private JTextArea statsTextArea;

    private static String lastInput;
    public SceneController() {
        lastInput = "";
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lastInput = userInput.getText();
                userInput.setText("");
                gameTextArea.append("\n" + lastInput);
            }
        });
    }




    public void start() {
        JFrame frame = new JFrame("SceneController");
        frame.setContentPane(new SceneController().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("ProjectRPG");
        frame.setSize(1000, 500);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static String getLastInput(){
        String temp = lastInput;
        lastInput = "";
        return temp;
    }

    public static void gameTextAreaClear() {
        gameTextArea.setText("");
    }

    public static void gameTextAreaNewLine(String text) {
        gameTextArea.append("\n" + text);
    }
}
