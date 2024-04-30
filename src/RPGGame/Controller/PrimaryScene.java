package RPGGame.Controller;

import javax.swing.*;    //Class extends JFrame to create the main game window and manage user interactions

public final class PrimaryScene extends JFrame {
    private JPanel mainPanel;
    private JTextField userInput;
    private JButton sendButton;                        // Declaration of Swing components used in the game interface
    private JTextArea gameTextArea;
    @SuppressWarnings("unused") private JPanel textAreaPanel;
    private JScrollPane scrollBar;

    private static String lastInput;             // Static variable to hold the last input from the user
    private static final Object inputLock = new Object();
    public PrimaryScene() {
        System.out.println("PrimaryScene instance created: " + this.hashCode());
        sendButton.addActionListener(e -> {
            synchronized (inputLock) { //synchronized to prevent simultaneous editing of text area --devin
                lastInput = userInput.getText();    // Object used as a monitor for synchronization of input handling
                gameOutput(">>" + userInput.getText());  // Display the input in the game text area  
                gameOutput("");            // Blank line for better readability
                userInput.setText("");    // Clear the userInput field after getting the input
                inputLock.notifyAll();    // Notify any waiting threads that new input is available
            }
        });
    }

    public void start() {
        JFrame frame = new JFrame("SceneController");    
        frame.setContentPane(this.mainPanel);                    // Sets the main panel as the content pane of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // Set the default close operation
        frame.setTitle("ProjectRPG");                            // Set the title of the frame
        scrollBar.setViewportView(gameTextArea);                 // Set the game text area to be the view in the scroll pane
        frame.setSize(1000, 500);                                // Set the size of the frame
        frame.setResizable(false);                               // Make the window non-resizable
        frame.setVisible(true);                                  // Make the window visible
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
