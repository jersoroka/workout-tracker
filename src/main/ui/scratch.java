package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//public class WorkoutLoggerAppGUI extends JFrame implements ActionListener {
//    JFrame frame;
//    JButton button;
//    JLabel label;
//    JPanel panel;
//    int count = 0;

//    public WorkoutLoggerAppGUI() {
//        frame = new JFrame();
//
//        button = new JButton("Click Here!");
//        button.addActionListener(this);
//
//        label = new JLabel("Number of clicks: 0");
//
//        panel = new JPanel();
//        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
//        panel.setLayout(new GridLayout(0, 1));
//        panel.add(button);
//        panel.add(label);
//
//        frame.add(panel, BorderLayout.CENTER);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setTitle("Our Workout Logger App");
//        frame.pack();
//        frame.setVisible(true);
//    }
//
//    public static void main(String[] args) {
//
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        count++;
//        label.setText("Number of clicks: " + count);
//    }

//    public WorkoutLoggerAppGUI() {
//        button = new JButton();
//        label = new JLabel();
//        button.setText("Click me!");
//        setTitle("Workout Logger App GUI Using Swing");
//        panel = new JPanel();
//        button.setToolTipText("Click the button to see cool things");
//
//        setSize(500, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setVisible(true); // you won't see the frame unless you set it to visible
//
//        panel.add(button);
//        panel.add(label);
//        add(panel);
//
//        button.addMouseListener(new java.awt.event.MouseAdapter() {
//            @Override
//            public void mouseClicked(java.awt.event.MouseEvent event) {
//                buttonMouseClicked(event);
//            }
//        });
//    }
//
//    private void buttonMouseClicked(java.awt.event.MouseEvent event) {
//        label.setText("Hello User!");
//    }
//
//    public static void main(String[] args) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new WorkoutLoggerAppGUI();
//            }
//        });
//    }
//}
