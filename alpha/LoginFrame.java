import javax.swing.*;
import java.util.HashMap;
import java.io.*;


public class LoginFrame extends JFrame {

    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private static HashMap<String, String> userDatabase;

    private final File userFile = new File("kullanicilar.txt");

    public LoginFrame() {
        setTitle("Kullanıcı Girişi");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        userDatabase = new HashMap<>();
        kullanicilariYukle(); // 🔽 dosyadan yükle

        JLabel userLabel = new JLabel("Kullanıcı Adı:");
        userLabel.setBounds(30, 30, 100, 20);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(130, 30, 150, 25);
        add(usernameField);

        JLabel passLabel = new JLabel("Şifre:");
        passLabel.setBounds(30, 70, 100, 20);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(130, 70, 150, 25);
        add(passwordField);

        JButton loginButton = new JButton("Giriş Yap");
        loginButton.setBounds(30, 110, 100, 30);
        add(loginButton);

        JButton registerButton = new JButton("Kayıt Ol");
        registerButton.setBounds(180, 110, 100, 30);
        add(registerButton);

        loginButton.addActionListener(e -> {
            String user = usernameField.getText();
            String pass = new String(passwordField.getPassword());

            if (userDatabase.containsKey(user) && userDatabase.get(user).equals(pass)) {
                dispose();
                new PizzaSiparisFrame(user);
            } else {
                JOptionPane.showMessageDialog(null, "Hatalı kullanıcı adı veya şifre!", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        });

        registerButton.addActionListener(e -> new RegisterFrame(userDatabase, userFile));

        setVisible(true);
    }

    private void kullanicilariYukle() {
        try {
            if (!userFile.exists()) userFile.createNewFile();

            BufferedReader reader = new BufferedReader(new FileReader(userFile));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(":")) {
                    String[] parts = line.split(":", 2);
                    userDatabase.put(parts[0], parts[1]);
                }
            }
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Kullanıcı dosyası okunamadı!");
        }
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}