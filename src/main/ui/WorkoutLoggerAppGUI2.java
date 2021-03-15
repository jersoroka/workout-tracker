package ui;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkoutLoggerAppGUI2 extends JFrame implements ActionListener {
    private CardLayout cd;
    private JButton jb1;
    private JButton jb2;
    private JButton jb3;
    private Container con;

    public WorkoutLoggerAppGUI2() {
        con = getContentPane();
        cd = new CardLayout();
        con.setLayout(cd);

        JPanel homeScreen = new JPanel();
        jb1 = new JButton("Hello");
        homeScreen.add(jb1);
        jb2 = new JButton("Hey");
        jb3 = new JButton("Hi");

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);

        con.add(homeScreen, "a");
        con.add(jb2, "b");
        con.add(jb3, "c");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cd.show(con, "a");
    }

    public static void main(String[] args) {
        WorkoutLoggerAppGUI2 workoutLoggerAppGUI2 = new WorkoutLoggerAppGUI2();
        workoutLoggerAppGUI2.setTitle("Workout Logger App Card Test");
        workoutLoggerAppGUI2.setSize(800, 600);
        workoutLoggerAppGUI2.setResizable(false);
        workoutLoggerAppGUI2.setVisible(true);
        workoutLoggerAppGUI2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
