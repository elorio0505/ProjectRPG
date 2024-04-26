package RPGGame.Controller;

import javax.swing.*;

public final class PrimaryScene extends JFrame {
    private JPanel mainPanel;
    private JTextField userInput;
    private JButton sendButton;
    private JTextArea gameTextArea;
    @SuppressWarnings("unused") private JPanel textAreaPanel;
    private JScrollPane scrollBar;

    private static String lastInput;
    private static final Object inputLock = new Object();
    public PrimaryScene() {
        System.out.println("PrimaryScene instance created: " + this.hashCode());
        sendButton.addActionListener(e -> {
            synchronized (inputLock) { //synchronized to prevent simultaneous editing of text area --devin
                lastInput = userInput.getText();
                gameOutput(">>" + userInput.getText());
                gameOutput("");
                userInput.setText("");
                inputLock.notifyAll();
            }
        });
    }

    public void start() {
        JFrame frame = new JFrame("SceneController");
        frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("ProjectRPG");
        scrollBar.setViewportView(gameTextArea);
        frame.setSize(1000, 500);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void gameOutputClear() { //clears text area --devin
        SwingUtilities.invokeLater(() -> gameTextArea.setText(""));
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
    public void gameOutput(String text) { //adds new line of text to UI text area --devin
        if (gameTextArea == null) {
            System.out.println("gameTextArea is null.");
        } else {
            SwingUtilities.invokeLater(() -> {
                gameTextArea.append(text.replace("\n", " ") + "\n"); // replace \n with spaces so programmers can use text blocks to edit events.
                gameTextArea.revalidate();
                gameTextArea.repaint();
            });
        }
    }
}