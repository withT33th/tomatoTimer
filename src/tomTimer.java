import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class tomTimer implements ActionListener {
    JFrame frame = new JFrame();

    //Creating the label that defines the mode of the cycle
    JLabel mode = new JLabel();

    //Creating the time label, the display for the clock
    JLabel timeLabel = new JLabel();
    int seconds = 0, minutes = 0, elapsedTime = 0;
    int pomMinLimit = 25, sBreakLimit = 5, eBreakLimit = 30;
    String secStr = String.format("%02d", seconds);
    String minStr = String.format("%02d", minutes);

    //then the functionality of the clock
    Timer timer = new Timer(1000, new ActionListener(){
       public void actionPerformed(ActionEvent e){
           elapsedTime += 1000;
           seconds = (elapsedTime / 1000) % 60;
           secStr = String.format("%02d", seconds);
           minutes = (elapsedTime / 60000) % pomMinLimit;
           minStr = String.format("%02d", minutes);

           timeLabel.setText(minStr + " : " + secStr);
       }
    });

    //Creating the start button
    JButton startButton = new JButton("Start");
    boolean started = false;

    //Creating a reset button to reset the timer
    JButton resetButton = new JButton("Reset");
    boolean beenReset = false;

    //Creating a configure button to configure the timer's settings
    //JButton configButton = new JButton("Config");

    //Creating cycle label that keeps track of the # of Pomodoros
    int pomCounter = 1;
    JLabel cycle = new JLabel("Pom #" + pomCounter);

    tomTimer(){
        //Setting details for the mode
        mode.setText("Pomodoro Time!");
        mode.setBounds(130, 50, 200, 50);
        mode.setFont(new Font("Tahoma", Font.PLAIN, 20));

        //Setting the details for the clock
        timeLabel.setText(minStr + " : " + secStr);
        timeLabel.setBounds(100, 100, 200, 100);
        timeLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        //Setting details for play/pause button
        startButton.setBounds(100, 200, 100, 50);
        startButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        //Setting details for the reset button
        resetButton.setBounds(200, 200, 100, 50);
        resetButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        //Setting details for cycle counter
        cycle.setBounds(165, 250, 200, 50);
        cycle.setFont(new Font("Tahoma", Font.PLAIN, 20));

        //Adding items to the frame
        frame.add(mode);
        frame.add(timeLabel);
        frame.add(startButton);
        frame.add(resetButton);
        frame.add(cycle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton){
            start();
        }
    }

    void start(){
        timer.start();
    }
    void stop(){

    }
    void reset(){

    }
}
