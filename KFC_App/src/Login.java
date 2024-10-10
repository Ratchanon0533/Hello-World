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
import java.sql.ResultSet;

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

public class Login extends JFrame {
    final private Font mainFont = new Font("Angsana New", Font.BOLD, 24);
    JTextField tfUsername;
    JPasswordField pfPassword;

    public void initialize() {
        

        
        // ส่วนหัวของฟอร์ม
        JLabel lbloginForm = new JLabel("เข้าสู่ระบบ", SwingConstants.CENTER);
        lbloginForm.setForeground(Color.WHITE);
        lbloginForm.setFont(mainFont);
        

        // ส่วนของชื่อผู้ใช้
        JLabel lbUsername = new JLabel("ชื่อผู้ใช้");
        lbUsername.setForeground(Color.WHITE);
        lbUsername.setFont(mainFont);

        tfUsername = new JTextField();
        tfUsername.setFont(mainFont);

        // ส่วนของรหัสผ่าน
        JLabel lbPassword = new JLabel("รหัสผ่าน");
        lbPassword.setForeground(Color.WHITE);
        lbPassword.setFont(mainFont);

        pfPassword = new JPasswordField();
        pfPassword.setFont(mainFont);

        // จัดเลย์เอาต์ของฟอร์ม
        JPanel formJPanel = new JPanel();
        formJPanel.setLayout(new GridLayout(0, 1, 10, 10));
        formJPanel.setBorder(BorderFactory.createEmptyBorder(60, 50, 30, 50));
        formJPanel.setOpaque(false);
        formJPanel.add(lbloginForm);
        formJPanel.add(lbUsername);
        formJPanel.add(tfUsername);
        formJPanel.add(lbPassword);
        formJPanel.add(pfPassword);


        // ปุ่ม Login
        JButton btnLogin = new JButton("เข้าสู่ระบบ");
        btnLogin.setFont(mainFont);
        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // String username = tfUsername.getText();
                // String password = String.valueOf(pfPassword.getPassword());

                // User user = getAuthenticatedUser(username, password);

                // if (user != null) {
                //     Menu me = new Menu(user);
                //     me.setVisible(true);
                //     dispose();
                // } else {
                //     JOptionPane.showMessageDialog(Login.this,
                //             "Username or password is incorrect.",
                //             "ชื่อผู้ใช้หรือรหัสผ่านไม่ถูกต้อง",
                //             JOptionPane.ERROR_MESSAGE);
                // }

                Menu menu = new Menu();
                menu.setVisible(true);
            }
        });

        // ตั้งค่าการกดปุ่ม Enter ให้ทำงานเทียบเท่ากับการกดปุ่ม Login
        getRootPane().setDefaultButton(btnLogin);

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

        // ปุ่ม Register
        JButton btnRegister = new JButton("ลงทะเบียน");
        btnRegister.setFont(mainFont);
        btnRegister.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Register register = new Register();
                register.initialize();
                
            }
        });

        // จัดเลย์เอาต์ของปุ่ม
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 3, 10, 0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(btnLogin);
        buttonsPanel.setOpaque(false);
        // buttonsPanel.add(btnRegister);
        buttonsPanel.add(btnCancel);

        // ตั้งค่าเฟรม
        add(formJPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);

        setTitle("เข้าสู่ระบบ");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 600);
        setMinimumSize(new DimensionUIResource(350, 450));
        setLocationRelativeTo(null);

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
        

        // เพิ่มไอคอน
        setIconImage(new ImageIcon("C:\\Users\\Acer\\OneDrive\\เดสก์ท็อป\\KFC_App\\img\\kfc.png").getImage());

        setVisible(true);
        setContentPane(backgroundPanel);
        backgroundPanel.add(buttonsPanel);
        backgroundPanel.add(formJPanel);
        setResizable(false);
        
    }

    // การเชื่อมต่อฐานข้อมูล
    protected User getAuthenticatedUser(String username, String password) {
        User user = null;

        // ตั้งค่าการเชื่อมต่อฐานข้อมูล
        final String DB_URL = "jdbc:mysql://localhost:3306/mystore";
        final String DB_USERNAME = "root";
        final String DB_PASSWORD = "";
 
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.name = resultSet.getString("name");
                user.username = resultSet.getString("username");
                user.email = resultSet.getString("email");
                user.password = resultSet.getString("password");
            }

            preparedStatement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "An error occurred while connecting to the database.",
                    "เกิดข้อผิดพลาดในการเชื่อมต่อฐานข้อมูล",
                    JOptionPane.ERROR_MESSAGE);
        }
        return user;
    }
    

    public static void main(String[] args) {

        
        Login log = new Login();
        log.initialize();
        
    
        
    }
}
