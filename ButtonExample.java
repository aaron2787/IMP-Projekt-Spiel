
/**
 * Beschreiben Sie hier die Klasse Button_test.
 * 
 * @author (aaron) 
 * @version (version: 1)
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ButtonExample
{
    public ButtonExample(){
    }
    public static void main(String[] args){
        
        JFrame frame = new JFrame("Button Example");
        
        frame.setSize(400, 200);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");
        
        ImageIcon icon = new ImageIcon("path_to_your_image.jpg");  
        JLabel imageLabel = new JLabel(icon);
        
        JLabel label = new JLabel("Willkommen! Klicke auf einen der Buttons.");
        
        startButton.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e){
                label.setText("Start Button wurde geklickt!");
            }
        });
        
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Stop Button wurde geklickt! Das Fenster wird geschlossen");
                frame.dispose();
            }
        });
        
        frame.setLayout(new FlowLayout());
        
        frame.add(label);
        frame.add(startButton);
        frame.add(stopButton);
        
        frame.setVisible(true);
}}