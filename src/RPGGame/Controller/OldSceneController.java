package RPGGame.Controller;
import RPGGame.Entity.Abstracts.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TODO Customize the GUI for this project, instead of just retrofitting an already-made one from a previous project - Add Stats window, make functional
@Deprecated
public final class OldSceneController {
    static Player player;
    public static Boolean gameRunning = false;
    public static String lastInput = "";
    private static boolean isStarted;
    private static JFrame frame;
    private static JMenuBar menuBar;
    private static JMenu fileMenu;
    private static JPanel bottomPanel;
    private static JTextField userInputField;
    private static JButton sendButton;
    private static JTextArea gameTextArea;
    private static JScrollPane gameTextAreaScrollbar;

    public static void start(Player sPlayer) {
        gameRunning = true;
        if (!isStarted) {
            isStarted = true;
            player = sPlayer;

            // CONSTRUCT GUI -------------------------------------------------------------------------------------------
            // Construct Frame
            frame = new JFrame("ProjectRPG");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 1000);
            frame.setResizable(false);

            // Construct Top Menu Bar
            menuBar = new JMenuBar();
            fileMenu = new JMenu("File");
            menuBar.add(fileMenu);

            // Construct Bottom Panel
            bottomPanel = new JPanel();
            userInputField = new JTextField(60);
            sendButton = new JButton("Send");
            bottomPanel.add(userInputField);
            bottomPanel.add(sendButton);

            // Construct Central Text Area
            gameTextArea = new JTextArea();
            gameTextArea.setAutoscrolls(true);
            gameTextArea.setLineWrap(true);
            gameTextArea.setEditable(false);
            gameTextArea.setWrapStyleWord(true);
            gameTextArea.setAutoscrolls(true);
            gameTextAreaScrollbar = new JScrollPane(gameTextArea);
            gameTextAreaScrollbar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

            // Attach elements to frame
            frame.getContentPane().add(BorderLayout.SOUTH, bottomPanel);
            frame.getContentPane().add(BorderLayout.NORTH, menuBar);
            frame.getContentPane().add(BorderLayout.CENTER, gameTextAreaScrollbar);

            // Connect Action Listeners
            sendButton.addActionListener(new sendActionListener(userInputField, gameTextArea, player));

            // Turn on GUI
            frame.setVisible(true);
        } // TODO: Throw an exception when trying to run an already-running SceneController.
    }

    public static void gameTextAreaClear() {
        gameTextArea.setText("");
    }

    public static void gameTextAreaNewLine(String text) {
        gameTextArea.append(text + "\n");
    }
}

class sendActionListener implements ActionListener {
    JTextField tf;
    JTextArea ta;
    Player player;

    sendActionListener(JTextField tf, JTextArea ta, Player player) {
        this.tf = tf;
        this.ta = ta;
        this.player = player;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = tf.getText();
        tf.setText("");
        ta.append("\n>> " + text + "\n");
        OldSceneController.lastInput = text;
    }
}
