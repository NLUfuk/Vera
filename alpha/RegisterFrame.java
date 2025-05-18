import javax.swing.*;
import java.io.*;
import java.util.Map;

public class RegisterFrame extends JFrame {

    private final JTextField newUserField;
    private final JPasswordField newPasswordField;

    public RegisterFrame(Map<String, String> userDatabase, File userFile) {

        setTitle("Kayıt Ol");
        setSize(350, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel userLabel = new JLabel("Yeni Kullanıcı Adı:");
        userLabel.setBounds(30, 30, 120, 20);
        add(userLabel);

        newUserField = new JTextField();
        newUserField.setBounds(150, 30, 150, 25);
        add(newUserField);

        JLabel passLabel = new JLabel("Yeni Şifre:");
        passLabel.setBounds(30, 70, 120, 20);
        add(passLabel);

        newPasswordField = new JPasswordField();
        newPasswordField.setBounds(150, 70, 150, 25);
        add(newPasswordField);

        JButton registerBtn = new JButton("Kayıt Ol");
        registerBtn.setBounds(110, 110, 100, 30);
        add(registerBtn);

        registerBtn.addActionListener(e -> {
            String newUser = newUserField.getText().trim();
            String newPass = new String(newPasswordField.getPassword()).trim();

            if (newUser.isEmpty() || newPass.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun.");
                return;
            }

            if (userDatabase.containsKey(newUser)) {
                JOptionPane.showMessageDialog(null, "Bu kullanıcı adı zaten kayıtlı.");
            } else {
                try (FileWriter fw = new FileWriter(userFile, true)) {
                    fw.write(newUser + ":" + newPass + "\n");
                    userDatabase.put(newUser, newPass);
                    JOptionPane.showMessageDialog(null, "Kayıt başarılı! Giriş yapabilirsiniz.");
                    dispose();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Kayıt yapılamadı!");
                }
            }
        });

        setVisible(true);
    }
}
