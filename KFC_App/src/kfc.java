import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class kfc   {
    public static void main(String[] args) {
        JFrame frame = new JFrame("KFC"); 

        ImageIcon frameIcon = new ImageIcon("C:\\Users\\Acer\\OneDrive\\เดสก์ท็อป\\KFC_App\\img\\kfc.png");
        frame.setIconImage(frameIcon.getImage());


           // Create a custom JPanel for background image
        JPanel backgroundPanel = new JPanel() {
            private BufferedImage backgroundImage;

            {
                try {
                    backgroundImage = ImageIO.read(new File("C:\\Users\\Acer\\OneDrive\\เดสก์ท็อป\\KFC_App\\img\\back2.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        backgroundPanel.setLayout(null); // Use null layout for absolute positioning
        

      
        JLabel label = new JLabel();
        Border border = BorderFactory.createLineBorder(Color.WHITE);
        
        label.setText("WELCOME TO KFC NEWCOMER.");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial Black", Font.BOLD, 40));
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBorder(border);
        label.setBounds(18, 50, 750, 100); 

        JLabel label2 = new JLabel();
        label2.setText("WANNA JOIN US?");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Arial Black", Font.BOLD, 35));
        label2.setVerticalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setBounds(35, 150, 700, 100); 
        
        JLabel label3 = new JLabel();
        label3.setText("If you already have an Account!");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("Arial", Font.BOLD, 15));
        label3.setVerticalAlignment(JLabel.CENTER);
        label3.setHorizontalAlignment(JLabel.LEFT);
        label3.setBounds(49, 290, 700, 100);

        JLabel label4 = new JLabel();
        label4.setText("If you don't have ONE!");
        label4.setForeground(Color.WHITE);
        label4.setFont(new Font("Arial", Font.BOLD, 15));
        label4.setVerticalAlignment(JLabel.CENTER);
        label4.setHorizontalAlignment(JLabel.LEFT);
        label4.setBounds(455, 290, 700, 100);

        JLabel label5 = new JLabel();
        label5.setText("Be part of an exclusive community register today to access premium product and opportunities. Click");
        label5.setForeground(Color.WHITE);
        label5.setFont(new Font("Arial", Font.BOLD, 12));
        label5.setVerticalAlignment(JLabel.CENTER);
        label5.setHorizontalAlignment(JLabel.CENTER);
        label5.setBounds(60, 470, 600, 100);

        JLabel label6 = new JLabel();
        label6.setText("'It's Finger Lickin' Good'");
        label6.setForeground(Color.WHITE);
        label6.setFont(new Font("Arial", Font.BOLD, 12));
        label6.setVerticalAlignment(JLabel.CENTER);
        label6.setHorizontalAlignment(JLabel.CENTER);
        label6.setBounds(195, 489, 400, 100);


        JButton joinButton = new JButton("SIGN IN NOW!") {
            @Override
            protected void paintComponent(Graphics g) {
                // Set the button's text color based on the button's state
                if (getModel().isArmed()) {
                    setForeground(Color.BLACK);// Color when pressed
                    
                      
                    
                } 
                else if (getModel().isRollover()) {
                    setForeground(Color.WHITE);  // Color when hovered
                } 
                else {
                    setForeground(Color.WHITE);  // Default text color
                }
                super.paintComponent(g);
                
            }

            @Override
            protected void paintBorder(Graphics g) {
                if(getModel().isArmed()){
                    g.setColor(Color.BLACK); 
                }
                else{
                    g.setColor(Color.WHITE);

                } // Set border color
                g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);  // Draw border
            }
        };

        Cursor handCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
        joinButton.setCursor(handCursor);/// show cursor when hover

        joinButton.setBounds(50, 275, 280, 50); // Position and size
        joinButton.setFont(new Font("Arial", Font.BOLD, 20));
        joinButton.setBackground(Color.RED); // Background color
        joinButton.setForeground(Color.WHITE); // Text color
        joinButton.setFocusPainted(false); // Remove focus outline
        joinButton.setOpaque(false);// remove background
        joinButton.setContentAreaFilled(false);// no blink on click
        joinButton.setBorderPainted(true);
        

        joinButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login LG = new Login();
                    LG.initialize();
                    frame.dispose();
            }
        }
        );


        JButton joinButton2 = new JButton("SIGN UP NOW!") {
            @Override
            protected void paintComponent(Graphics g) {
                
                if (getModel().isArmed()) {
                    setForeground(Color.BLACK); 
                   
                } 
                
                else {
                    setForeground(Color.WHITE);  
                }
                super.paintComponent(g);
            }

            @Override
            protected void paintBorder(Graphics g) {
                if(getModel().isArmed()){
                    g.setColor(Color.BLACK); 
                }
                else{
                    g.setColor(Color.WHITE);

                } 
                g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);  
            }
        };

        Cursor handCursor2 = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
        joinButton2.setCursor(handCursor2);/// show cursor when hover

        joinButton2.setBounds(455, 275, 280, 50); // Position and size
        joinButton2.setFont(new Font("Arial", Font.BOLD, 20));
        joinButton2.setBackground(Color.RED); // Background color
        joinButton2.setForeground(Color.WHITE); // Text color
        joinButton2.setFocusPainted(false); // Remove focus outline
        joinButton2.setOpaque(false);// remove background
        joinButton2.setContentAreaFilled(false);// no blink on click
        joinButton2.setBorderPainted(true);
        

        joinButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register RE = new Register();
                RE.initialize();
                frame.dispose(); 
            }
        });



        JButton joinButton3 = new JButton("Here!") {
            @Override
            protected void paintComponent(Graphics g) {
                
                if (getModel().isArmed()) {
                    setForeground(Color.BLACK);  
                } 
                
                else {
                    setForeground(Color.WHITE);  
                }
                super.paintComponent(g);
            }

           
        };

        Cursor handCursor3 = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
        joinButton3.setCursor(handCursor3);/// show cursor when hover

        joinButton3.setBounds(626, 503, 84 ,30); // Position and size
        joinButton3.setFont(new Font("Arial", Font.BOLD, 16));
        joinButton3.setBackground(Color.RED); // Background color
        joinButton3.setForeground(Color.WHITE); // Text color
        joinButton3.setFocusPainted(false); // Remove focus outline
        joinButton3.setOpaque(false);// remove background
        joinButton3.setContentAreaFilled(false);// no blink on click
        joinButton3.setBorderPainted(false);
        

        joinButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "My apologies, We don't have a web page yet. Because I'm Lazy :3");
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); 
        // frame.add(label);
        frame.setContentPane(backgroundPanel);
        backgroundPanel.add(label);
        backgroundPanel.add(label2);
        backgroundPanel.add(joinButton);
        backgroundPanel.add(joinButton2);
        backgroundPanel.add(joinButton3);
        backgroundPanel.add(label3);
        backgroundPanel.add(label4);
        backgroundPanel.add(label5);
        backgroundPanel.add(label6);
        
        
        
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//-------------end main----------------------
    
    
    
}//----------------end class--------------------

