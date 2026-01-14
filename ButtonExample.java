
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
        
        ImageIcon icon = new ImageIcon("Acer_Wallpaper_01_3840x2400.jpg");
        JLabel imageLabel = new JLabel(icon);
        ImageIcon icon2 = new ImageIcon("dummy.jpg");
        JLabel dummy = new JLabel(icon2);
        
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
        
        imageLabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("Bild gecklickt!");
            }
        });
        frame.add(label);
        frame.add(dummy);
        frame.add(startButton);
        frame.add(stopButton);
        
        frame.setLayout(new FlowLayout());
        
        frame.setVisible(true);
}}