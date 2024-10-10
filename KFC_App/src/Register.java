import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.plaf.DimensionUIResource;

public class Register extends JFrame {
    final private Font mainFont = new Font("Angsana New", Font.BOLD, 24);
    JTextField tfName, tfUsername, tfEmail;
    JPasswordField pfPassword;
    

    public void initialize() {


        
        // ส่วนหัวของฟอร์ม
        JLabel lbRegisterForm = new JLabel("ลงทะเบียน", SwingConstants.CENTER);
        lbRegisterForm.setForeground(Color.WHITE);
        lbRegisterForm.setFont(mainFont);

        // ส่วนของชื่อ
        JLabel lbName = new JLabel("ชื่อ-นามสกุล");
        lbName.setForeground(Color.WHITE);
        lbName.setFont(mainFont);
        tfName = new JTextField();
        tfName.setFont(mainFont);

        // ส่วนของชื่อผู้ใช้
        JLabel lbUsername = new JLabel("ชื่อผู้ใช้");
        lbUsername.setForeground(Color.WHITE);
        lbUsername.setFont(mainFont);
        tfUsername = new JTextField();
        tfUsername.setFont(mainFont);

        // ส่วนของอีเมล
        JLabel lbEmail = new JLabel("ที่อยู่");
        lbEmail.setForeground(Color.WHITE);
        lbEmail.setFont(mainFont);
        tfEmail = new JTextField();
        tfEmail.setFont(mainFont);

        // ส่วนของรหัสผ่าน
        JLabel lbPassword = new JLabel("รหัสผ่าน");
        lbPassword.setForeground(Color.WHITE);
        lbPassword.setFont(mainFont);
        pfPassword = new JPasswordField();
        pfPassword.setFont(mainFont);

        // จัดเลย์เอาต์ของฟอร์ม
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(57, 50, 30, 50));
        formPanel.add(lbRegisterForm);
        formPanel.add(lbName);
        formPanel.add(tfName);
        formPanel.add(lbEmail);
        formPanel.add(tfEmail);
        formPanel.add(lbUsername);
        formPanel.add(tfUsername);
        formPanel.add(lbPassword);
        formPanel.add(pfPassword);
        formPanel.setOpaque(false);

        // ปุ่ม Register
        JButton btnRegister = new JButton("ลงทะเบียน");
        btnRegister.setFont(mainFont);
        btnRegister.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String name = tfName.getText().trim();
                String username = tfUsername.getText().trim();
                String email = tfEmail.getText().trim();
                String password = String.valueOf(pfPassword.getPassword()).trim();

                // ตรวจสอบว่ามีการกรอกข้อมูลครบทุกช่องหรือไม่
                if (name.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(Register.this,
                            "Error:Please fill in all information.",
                            "กรุณากรอกข้อมูลให้ครบทุกช่อง",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (registerUser(name, email, username, password)) {
                    JOptionPane.showMessageDialog(Register.this,
                            "Registration successful!",
                            "ลงทะเบียนสำเร็จ!",
                            JOptionPane.INFORMATION_MESSAGE);
                            kfc.main(null);
                            dispose();
                } else {
                    JOptionPane.showMessageDialog(Register.this,
                            "Registration failed",
                            "Registration failed",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // ตั้งค่าการกดปุ่ม Enter ให้ทำงานเทียบเท่ากับการกดปุ่ม Register
        getRootPane().setDefaultButton(btnRegister);

        // ปุ่ม Cancel
        JButton btnCancel = new JButton("ยกเลิก");
        btnCancel.setFont(mainFont);
        btnCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                kfc.main(null);
            }
        });

        // จัดเลย์เอาต์ของปุ่ม
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(btnRegister);
        buttonsPanel.add(btnCancel);
        buttonsPanel.setOpaque(false);

        JPanel backgroundPanel = new JPanel() {
            private BufferedImage backgroundImage;
    
            {
                try {
                    backgroundImage = ImageIO.read(new File("C:\\Users\\Acer\\OneDrive\\เดสก์ท็อป\\KFC_App\\img\\logback.jpg"));
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
        backgroundPanel.setLayout(null);
        
        // ตั้งค่าเฟรม
        add(formPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);

        setTitle("ลงทะเบียน");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 600);
        setMinimumSize(new DimensionUIResource(350, 550));
        setLocationRelativeTo(null);

        // เพิ่มไอคอน
        setIconImage(new ImageIcon("C:\\Users\\Acer\\OneDrive\\เดสก์ท็อป\\KFC_App\\img\\kfc.png").getImage());

        setVisible(true);
        setContentPane(backgroundPanel);
        backgroundPanel.add(formPanel);
        backgroundPanel.add(buttonsPanel);
        setResizable(false);
    }

    private boolean registerUser(String name, String email, String username, String password) {
        final String DB_URL = "jdbc:mysql://localhost:3306/mystore";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "INSERT INTO users (name, email, username, password) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, password);

            int rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();
            conn.close();

            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        Register reg = new Register();
        reg.initialize();
    }
}
