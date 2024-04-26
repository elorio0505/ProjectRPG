package RPGGame.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class PrimaryScene extends JFrame {
    public static Boolean gameRunning = false;
    private JPanel mainPanel;
    private JTextField userInput;
    private JButton sendButton;
    private JTextArea gameTextArea;
    private JPanel textAreaPanel;
    private JPanel statsPanel;
    private JTextArea statsTextArea;

    private static String lastInput;
    private static final Object inputLock = new Object();
    public PrimaryScene() {
        System.out.println("PrimaryScene instance created: " + this.hashCode());
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                synchronized (inputLock) { //synchronized to prevent simultaneous editing of text area --devin
                    lastInput = userInput.getText();
                    gameTextAreaNewLine(userInput.getText());
                    userInput.setText("");
                    inputLock.notifyAll();
                }
            }
        });
    }

    public void start() {
        JFrame frame = new JFrame("SceneController");
        frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("ProjectRPG");
        frame.setSize(1000, 500);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public String getLastInput(){ //returns last input entered by user via the UI --devin
        String temp = lastInput;
        lastInput = "";
        return temp;
    }

    public void gameTextAreaClear() { //clears text area --devin
        SwingUtilities.invokeLater(() -> {
            gameTextArea.setText("");
        });
    }

    public String waitForNewInput() throws InterruptedException { //waits for user to enter input into UI and returns it --devin
        synchronized (inputLock) {
            while (lastInput == null || lastInput.isEmpty()) {
                inputLock.wait();
            }
            String input = lastInput;
            lastInput = "";
            return input;
        }
    }
    public void gameTextAreaNewLine(String text) { //adds new line of text to UI text area --devin
        if (gameTextArea == null) {
            System.out.println("gameTextArea is null.");
        } else {
            SwingUtilities.invokeLater(() -> {
                gameTextArea.append(">> " + text + "\n");
                gameTextArea.revalidate();
                gameTextArea.repaint();
            });
        }
    }
}