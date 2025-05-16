import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PizzaSiparisFrame extends JFrame {

    JComboBox<String> hamurBox, pizzaBox, boyutBox;
    JCheckBox patatesBox, icecekBox, tatliBox;
    JButton siparisButton;
    JTextArea sonucArea;

    public PizzaSiparisFrame() {
        setTitle("🍕 Pizza Sipariş Sistemi");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        // Arka plan rengi
        getContentPane().setBackground(new Color(255, 250, 240)); // açık krem

        Font labelFont = new Font("Verdana", Font.BOLD, 13);
        Font boxFont = new Font("Verdana", Font.PLAIN, 12);

        JLabel hamurLabel = new JLabel("Hamur Seçimi:");
        hamurLabel.setBounds(30, 30, 150, 20);
        hamurLabel.setFont(labelFont);
        hamurLabel.setForeground(new Color(51, 51, 102));
        add(hamurLabel);

        hamurBox = new JComboBox<>(new String[]{"Klasik", "İnce", "Dubleks (çift kat peynir)"});
        hamurBox.setBounds(200, 30, 250, 25);
        hamurBox.setFont(boxFont);
        add(hamurBox);

        JLabel pizzaLabel = new JLabel("Pizza Türü:");
        pizzaLabel.setBounds(30, 70, 150, 20);
        pizzaLabel.setFont(labelFont);
        pizzaLabel.setForeground(new Color(51, 51, 102));
        add(pizzaLabel);

        pizzaBox = new JComboBox<>(new String[]{"Extravaganza", "Karışık", "Pizza Mexicano", "Italiano", "Turkish Pizza", "Favorite Three"});
        pizzaBox.setBounds(200, 70, 250, 25);
        pizzaBox.setFont(boxFont);
        add(pizzaBox);

        JLabel boyutLabel = new JLabel("Boyut:");
        boyutLabel.setBounds(30, 110, 150, 20);
        boyutLabel.setFont(labelFont);
        boyutLabel.setForeground(new Color(51, 51, 102));
        add(boyutLabel);

        boyutBox = new JComboBox<>(new String[]{"Küçük (1 kişi)", "Orta (2 kişi)", "Büyük (3+ kişi)"});
        boyutBox.setBounds(200, 110, 250, 25);
        boyutBox.setFont(boxFont);
        add(boyutBox);

        patatesBox = new JCheckBox("Patates Kızartması");
        patatesBox.setBounds(200, 150, 200, 20);
        patatesBox.setBackground(new Color(255, 250, 240));
        add(patatesBox);

        icecekBox = new JCheckBox("İçecek");
        icecekBox.setBounds(200, 180, 200, 20);
        icecekBox.setBackground(new Color(255, 250, 240));
        add(icecekBox);

        tatliBox = new JCheckBox("Tatlı");
        tatliBox.setBounds(200, 210, 200, 20);
        tatliBox.setBackground(new Color(255, 250, 240));
        add(tatliBox);

        siparisButton = new JButton("✔ Siparişi Tamamla");
        siparisButton.setBounds(200, 250, 180, 30);
        siparisButton.setBackground(new Color(0, 153, 76));
        siparisButton.setForeground(Color.WHITE);
        siparisButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        add(siparisButton);

        // Sipariş Özeti Alanı (Scroll ile)
        sonucArea = new JTextArea();
        sonucArea.setEditable(false);
        sonucArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(sonucArea);
        scrollPane.setBounds(30, 300, 530, 130);
        add(scrollPane);

        

        // Buton Action
        siparisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                siparisiHesapla();
            }
        });

        setVisible(true);
    }

    private void siparisiHesapla() {
        String hamur = (String) hamurBox.getSelectedItem();
        String pizza = (String) pizzaBox.getSelectedItem();
        String boyut = (String) boyutBox.getSelectedItem();

        int fiyat = 0;
        if (boyut.contains("Küçük")) fiyat += 80;
        else if (boyut.contains("Orta")) fiyat += 110;
        else fiyat += 140;

        if (patatesBox.isSelected()) fiyat += 25;
        if (icecekBox.isSelected()) fiyat += 20;
        if (tatliBox.isSelected()) fiyat += 30;

        sonucArea.setText("🍕 Sipariş Özeti:\n\n");
        sonucArea.append("Hamur Tipi   : " + hamur + "\n");
        sonucArea.append("Pizza Türü   : " + pizza + "\n");
        sonucArea.append("Boyut        : " + boyut + "\n");

        if (patatesBox.isSelected()) sonucArea.append("➕ Patates Kızartması\n");
        if (icecekBox.isSelected()) sonucArea.append("➕ İçecek\n");
        if (tatliBox.isSelected()) sonucArea.append("➕ Tatlı\n");

        sonucArea.append("\nToplam Tutar: " + fiyat + "₺");
    }

    public static void main(String[] args) {
        new PizzaSiparisFrame();
    }
}
