package RPGGame.Controller;
import RPGGame.Entity.Abstracts.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TODO Customize the GUI for this project, instead of just retrofitting an already-made one from a previous project
public class SceneController {
    Player player;

    SceneController(Player player) {
        this.player = player;
        this.start();
    }


    public void start() {

        // Create Frame
        JFrame frame = new JFrame("ProjectRPG");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setResizable(false);

        // Top Menu bar
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Placeholder");
        mb.add(m1);

        // Bottom Panel
        JPanel panel = new JPanel();
        JTextField tf = new JTextField(30);
        JButton send = new JButton("Send");
        panel.add(tf);
        panel.add(send);

        // Central Text Area
        JTextArea ta = new JTextArea();
        ta.setAutoscrolls(true);
        ta.setLineWrap(true);
        ta.setEditable(false);
        ta.setWrapStyleWord(true);
        ta.setAutoscrolls(true);
        JScrollPane scroll = new JScrollPane(ta);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // Attach elements to frame
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, scroll);

        // Connect Action Listeners
        send.addActionListener(new sendActionListener(tf, ta, player));

        frame.setVisible(true);
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
        ta.append("[" + player.name + "]   " + text + "\n\n");
    }
}
