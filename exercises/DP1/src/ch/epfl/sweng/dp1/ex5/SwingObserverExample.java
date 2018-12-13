package ch.epfl.sweng.dp1.ex5;

/* Code from Head First Design Pattern */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SwingObserverExample {
    JFrame frame;

    public static void main(String[] args) {
        SwingObserverExample example = new SwingObserverExample();
        example.go();
    }

    private void go() {
        frame = new JFrame();

        JButton button = new JButton("Should I do it?");

        // Your implementation
        button.addActionListener(new PositiveListener());
        button.addActionListener(new NegativeListener());

        frame.getContentPane().add(BorderLayout.CENTER, button);

        // Set frame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.CENTER, button);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public class PositiveListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Do it!");
        }
    }

    public class NegativeListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Don't do it!");
        }
    }
}