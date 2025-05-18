import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PizzaSiparisFrame extends JFrame {

    JComboBox<String> hamurBox, pizzaBox, boyutBox, patatesBox, icecekBox, tatliBox;
//    JCheckBox   tatliBox;
    JButton siparisButton;
    JTextArea sonucArea;

    public PizzaSiparisFrame() {
        setTitle("🍕 Pizza Sipariş Sistemi");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        // Arka plan rengi
        getContentPane().setBackground(new Color(253, 121, 86)); // açık krem

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

        boyutBox = new JComboBox<>(new String[]{"Küçük (12 cm)", "Orta (18 cm)", "Büyük (24 cm)"});
        boyutBox.setBounds(200, 110, 250, 25);
        boyutBox.setFont(boxFont);
        add(boyutBox);

        JLabel patatesLabel = new JLabel("Patates Seçimi:");
        patatesLabel.setBounds(30, 150, 150, 20);
        patatesLabel.setFont(labelFont);
        patatesLabel.setForeground(new Color(51, 51, 102));
        add(patatesLabel);

        patatesBox = new JComboBox<>(new String[]{"Küçük", "Orta", "Büyük",  "Maxi"});
        patatesBox.setBounds(200, 150, 250, 25);
        patatesBox.setFont(boxFont);
        add(patatesBox);

        JLabel icecekLabel = new JLabel("İçecek Seçimi:");
        icecekLabel.setBounds(30, 190, 150, 20);
        icecekLabel.setFont(labelFont);
        icecekLabel.setForeground(new Color(51, 51, 102));
        add(icecekLabel);

        icecekBox = new JComboBox<>(new String[]{"Cola", "Ayran", "Maden Suyu",  "Fanta"});
        icecekBox.setBounds(200, 190, 250, 25);
        icecekBox.setFont(boxFont);
        add(icecekBox);

        //icecekBox = new JCheckBox("İçecek");
        //icecekBox.setBounds(200, 180, 200, 20);
        //icecekBox.setBackground(new Color(255, 250, 240));
        //add(icecekBox);//

//        tatliBox = new JCheckBox("Tatlı");
//        tatliBox.setBounds(200, 230, 200, 20);
//        tatliBox.setBackground(new Color(255, 250, 240));
//        add(tatliBox);

        JLabel tatliLabel = new JLabel("Tatlı Seçimi:");
        tatliLabel.setBounds(30, 230, 150, 20);
        tatliLabel.setFont(labelFont);
        tatliLabel.setForeground(new Color(51, 51, 102));
        add(tatliLabel);

        tatliBox = new JComboBox<>(new String[]{"Cookie", "Brownie", "Sufle",  "Special"});
        tatliBox.setBounds(200, 230, 250, 25);
        tatliBox.setFont(boxFont);
        add(tatliBox);

        siparisButton = new JButton("✔ Siparişi Tamamla");
        siparisButton.setBounds(200, 270, 180, 30);
        siparisButton.setBackground(new Color(0, 153, 76));
        siparisButton.setForeground(Color.WHITE);
        siparisButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        add(siparisButton);

        // Sipariş Özeti Alanı (Scroll ile)
        sonucArea = new JTextArea();
        sonucArea.setEditable(false);
        sonucArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(sonucArea);
        scrollPane.setBounds(30, 310, 530, 150);
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
        String patates = (String) patatesBox.getSelectedItem();
        String icecek = (String) icecekBox.getSelectedItem();
        String tatli = (String) tatliBox.getSelectedItem();
        int fiyat = 0;
        assert boyut != null;
        if (boyut.contains("Küçük")) fiyat += 80;
            else if (boyut.contains("Orta")) fiyat += 110;
            else fiyat += 140;


        if (patates.contains("Küçük")) fiyat += 25;
            else if (patates.contains("Orta")) fiyat += 80;
            else if (patates.contains("Büyük")) fiyat += 110;
            else fiyat += 140;

        if (icecek.contains("Cola")) fiyat +=40;
        else if (icecek.contains("Gazoz")) fiyat += 30;
        else if (icecek.contains("Ayran")) fiyat += 15;
        else if (icecek.contains("Maden Suyu")) fiyat += 15;
        else if (icecek.contains("Fanta")) fiyat += 35;
        else fiyat += 0;
        //if (tatliBox.isSelected()) fiyat += 30;

        if (tatli.contains("Sufle")) fiyat += 100;
        else if (tatli.contains("Cookie")) fiyat += 120;
        else if (tatli.contains("Brownie")) fiyat += 150;
        else fiyat += 140;

        sonucArea.setText("🍕 Sipariş Özeti:\n\n");
        sonucArea.append("Hamur Tipi   : " + hamur + "\n");
        sonucArea.append("Pizza Türü   : " + pizza + "\n");
        sonucArea.append("Boyut        : " + boyut + "\n");
        sonucArea.append("Patates      : " + patates + "\n");
        sonucArea.append("İcecek       : " + icecek + "\n");
        sonucArea.append("Tatlı        : " + tatli + "\n");
        sonucArea.append("Toplam Tutar : " + fiyat + "₺"+ "\n");
        sonucArea.append("Yine bekleriz, afiyet olsun ");


//        if (tatliBox.isSelected()) sonucArea.append("➕ Tatlı\n");


    }

    public static void main(String[] args) {
        new PizzaSiparisFrame();
    }
}
