
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
        
        startButton.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e){
                System.out.println("Start Button clicked");
            }
        });
        
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Stop Button clicked!");
            }
        });
        
        //frame.setLayout(new FlowLayout());
        
        frame.add(startButton);
        frame.add(stopButton);  
        
        frame.setLayout(new FlowLayout());
        
        frame.setVisible(true);
}}