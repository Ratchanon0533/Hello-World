import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame {
    final private Font mainFont = new Font("TH SarabunPSK", Font.BOLD, 24);

    public void initialize(User user) {
        //-----------panel----------\\
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridBagLayout()); // ใช้ GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 5, 310); // ตั้งค่า margins ระหว่างองค์ประกอบ
        gbc.anchor = GridBagConstraints.NORTHWEST; // ชิดซ้ายบน
        infoPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY, 2),
                "ข้อมูลผู้ใช้",
                javax.swing.border.TitledBorder.LEFT,
                javax.swing.border.TitledBorder.TOP,
                mainFont,
                Color.BLACK
        ));

        // ตั้งค่าตำแหน่งของ JLabel แต่ละตัว
        JLabel lblName = new JLabel("ชื่อ:");
        lblName.setFont(mainFont);
        gbc.gridx = 0;
        gbc.gridy = 0;
        infoPanel.add(lblName, gbc);

        JLabel lblUserName = new JLabel(user.name);
        lblUserName.setFont(mainFont);
        gbc.gridx = 1;
        infoPanel.add(lblUserName, gbc);

        JLabel lblUsername = new JLabel("ชื่อบัญชี:");
        lblUsername.setFont(mainFont);
        gbc.gridx = 0;
        gbc.gridy = 1;
        infoPanel.add(lblUsername, gbc);

        JLabel lblUserUsername = new JLabel(user.username);
        lblUserUsername.setFont(mainFont);
        gbc.gridx = 1;
        infoPanel.add(lblUserUsername, gbc);

        JLabel lblEmail = new JLabel("อีเมล:");
        lblEmail.setFont(mainFont);
        gbc.gridx = 0;
        gbc.gridy = 2;
        infoPanel.add(lblEmail, gbc);

        JLabel lblUserEmail = new JLabel(user.email);
        lblUserEmail.setFont(mainFont);
        gbc.gridx = 1;
        infoPanel.add(lblUserEmail, gbc);

        // เพิ่ม infoPanel ลงใน BorderLayout.NORTH
        add(infoPanel, BorderLayout.NORTH);

        setTitle("หน้าแรก");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(900, 700); 
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon("d:\\\\Users\\\\USER\\\\Desktop\\\\งาน\\\\อื่นๆ\\\\Vscode\\\\java\\\\Login_AND_Register\\\\profile.png").getImage());
        setVisible(true);
    }

    public static void main(String[] args) {
        User testUser = new User();
        testUser.name = "John Doe";
        testUser.username = "johndoe";
        testUser.email = "johndoe@example.com";
        testUser.password = "password";

        MainFrame mainFrame = new MainFrame();
        mainFrame.initialize(testUser);
    }
}
