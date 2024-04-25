package RPGGame.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class SceneController extends JFrame {
    public static Boolean gameRunning = false;
    private JPanel mainPanel;
    private JTextField userInput;
    private JButton sendButton;
    private JTextArea gameTextArea;
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
                gameTextAreaNewLine(userInput.getText());
                userInput.setText("");
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

    public void gameTextAreaClear() {
        gameTextArea.setText("");
    }

    public void gameTextAreaNewLine(String text) {
        System.out.println("it's called..." + text);
        gameTextArea.append(">> " + text + "\n");
    }
}
