import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class tomTimer {
    // Creating frames, pane and panels
    private JFrame frame = new JFrame("Pomodoro Timer");
    private JPanel cards = new JPanel(new CardLayout());
    private JPanel pomPanel = new JPanel();
    private JPanel sPanel = new JPanel();
    private JPanel lPanel = new JPanel();

    // Creating and setting labels
    private JLabel pLabel = new JLabel("Pomodoro time!");
    private JLabel sLabel = new JLabel("Short Break!");
    private JLabel lLabel = new JLabel("Long Break!");

    // Creating the display for the clock
    private JLabel timeLable = new JLabel();
    int sec = 0, min = 0, elapsed = 0;
    int pomLim = 25, sLim = 5, eLim = 30;

    // Functionality of the timer clock

    private void setLabels(JLabel l, JPanel p){
        l.setBounds(130, 50, 200, 50);
        l.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p.add(l);
    }

    // Creating a method to help create buttons
    // Passing in the button text and the actionCommand
    private JButton createButton(String name, String comm){
        JButton b = new JButton(name);
        b.setActionCommand(comm);
        b.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b.setFocusable(false);

        if (comm.equals("START")){
            // Add an ActionListener that starts and stops the timer counting
            b.setBounds(100, 200, 100, 50);
        } else if (comm.equals("RESET")){
            // ActionListener that resets timer (or whole pomodoro session)
            b.setBounds(150, 100, 100 ,50);
        } else if (comm.equals("SKIP")){
            // ActionListener that skips to the next card
            b.setBounds(200, 200, 100, 50);

        }
        b.addActionListener(e -> new bListener());
        return b;
    }

    // Implementing the button listener. Performing different actions depending on the action command
    private class bListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String comm = e.getActionCommand();

            if (comm.equals("START")){
                // Starts and stops the timer counting
            } else if (comm.equals("RESET")){
                // Resets the timer (or whole pomodoro session)
            } else if (comm.equals("SKIP")){
                // Skips to the next card
            }
        }

    }

    // Creating GUI
    private void prepareGUI(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);

        cards.setBounds(0, 0, 400, 400);

        // Nulling the default panel layout to read my bounds
        pomPanel.setLayout(null);
        sPanel.setLayout(null);
        lPanel.setLayout(null);

        // Calling setLabels to place the labels in the panels
        setLabels(pLabel, pomPanel);
        setLabels(sLabel, sPanel);
        setLabels(lLabel, lPanel);

        cards.setBounds(0, 0, 400, 400);
        cards.add(pomPanel, "pom");
        cards.add(sPanel, "short");
        cards.add(lPanel, "long");

        frame.add(cards);
    }

    public tomTimer(){
        prepareGUI();
    }

    public void showPomTimer(){
        frame.setVisible(true);
    }

}