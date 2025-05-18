import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;

public class PizzaSiparisFrame extends JFrame {

    JComboBox<String> hamurBox, pizzaBox, boyutBox, patatesBox, icecekBox, tatliBox;
    JButton siparisButton, sepeteEkleButton;
    JTextArea sonucArea;
    JLabel pizzaResimLabel = new JLabel();
    String kullaniciAdi;
    JLabel tatliResimLabel = new JLabel();
    JLabel icecekResimLabel = new JLabel();

    ArrayList<String> sepet = new ArrayList<>();
    ArrayList<Integer> fiyatlar = new ArrayList<>();

    public PizzaSiparisFrame(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
        initUI();
    }

    public PizzaSiparisFrame() {
        this("Misafir");
    }

    private void initUI() {
        setTitle("🍕 Pizza Sipariş Sistemi");
        setSize(600, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(211, 28, 28));

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

        pizzaBox = new JComboBox<>(new String[]{
                "FourCheese", "Kapadokya", "Kavurmalı",
                "Luna", "Mexican", "Margarita", "Mix", "Tavuklu", "Vegeterian",
                "🌟 Kendi Pizzanı Yarat"
        });
        pizzaBox.setBounds(200, 70, 250, 25);
        pizzaBox.setFont(boxFont);
        add(pizzaBox);

        pizzaBox.addActionListener(e -> {
            String secim = (String) pizzaBox.getSelectedItem();
            gorselGuncelle(secim);
            if ("🌟 Kendi Pizzanı Yarat".equals(secim)) {
                new CustomPizzaDialog(this);
            }
        });

        JLabel boyutLabel = new JLabel("Boyut:");
        boyutLabel.setBounds(30, 110, 150, 20);
        boyutLabel.setFont(labelFont);
        boyutLabel.setForeground(new Color(51, 51, 102));
        add(boyutLabel);

        boyutBox = new JComboBox<>(new String[]{"Küçük (22 cm)", "Orta (26 cm)", "Büyük (34 cm)"});
        boyutBox.setBounds(200, 110, 250, 25);
        boyutBox.setFont(boxFont);
        add(boyutBox);

        JLabel patatesLabel = new JLabel("Patates Seçimi:");
        patatesLabel.setBounds(30, 150, 150, 20);
        patatesLabel.setFont(labelFont);
        patatesLabel.setForeground(new Color(51, 51, 102));
        add(patatesLabel);

        patatesBox = new JComboBox<>(new String[]{"...", "Küçük", "Orta", "Büyük", "Maxi"});
        patatesBox.setBounds(200, 150, 250, 25);
        patatesBox.setFont(boxFont);
        add(patatesBox);

        JLabel icecekLabel = new JLabel("İçecek Seçimi:");
        icecekLabel.setBounds(30, 190, 150, 20);
        icecekLabel.setFont(labelFont);
        icecekLabel.setForeground(new Color(51, 51, 102));
        add(icecekLabel);

        icecekBox = new JComboBox<>(new String[]{"...","Gazoz","Cola", "Ayran", "Maden Suyu", "Fanta"});
        icecekBox.setBounds(200, 190, 250, 25);
        icecekBox.setFont(boxFont);
        add(icecekBox);
        icecekBox.addActionListener(e -> {
                    String secim = (String) icecekBox.getSelectedItem();
                    gorselGuncelle1(secim);

        });

        JLabel tatliLabel = new JLabel("Tatlı Seçimi:");
        tatliLabel.setBounds(30, 230, 150, 20);
        tatliLabel.setFont(labelFont);
        tatliLabel.setForeground(new Color(51, 51, 102));
        add(tatliLabel);

        tatliBox = new JComboBox<>(new String[]{"...","Cookie", "Brownie", "Sufle", "Special"});
        tatliBox.setBounds(200, 230, 250, 25);
        tatliBox.setFont(boxFont);
        add(tatliBox);

        tatliBox.addActionListener(e -> {
            String secim = (String) tatliBox.getSelectedItem();
            gorselGuncelle2(secim);

        });

        sepeteEkleButton = new JButton("➕ Sepete Ekle");
        sepeteEkleButton.setBounds(60, 270, 130, 30);
        sepeteEkleButton.setBackground(new Color(20, 38, 101));
        sepeteEkleButton.setForeground(Color.WHITE);
        sepeteEkleButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(sepeteEkleButton);

        siparisButton = new JButton("✔ Siparişi Tamamla");
        siparisButton.setBounds(210, 270, 180, 30);
        siparisButton.setBackground(new Color(0, 153, 76));
        siparisButton.setForeground(Color.WHITE);
        siparisButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        add(siparisButton);

        sonucArea = new JTextArea();
        sonucArea.setEditable(false);
        sonucArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(sonucArea);
        scrollPane.setBounds(30, 310, 530, 180);
        add(scrollPane);

        pizzaResimLabel.setBounds(470, 10, 100, 100);
        add(pizzaResimLabel);
        icecekResimLabel.setBounds(470, 100, 100, 100);
        add(icecekResimLabel);
        tatliResimLabel.setBounds(470, 200, 100, 100);
        add(tatliResimLabel);

        sepeteEkleButton.addActionListener(e -> sepeteEkle());
        siparisButton.addActionListener(e -> siparisiTamamla());

        setVisible(true);
    }

    private void sepeteEkle() {
        String hamur = (String) hamurBox.getSelectedItem();
        String pizza = (String) pizzaBox.getSelectedItem();
        String boyut = (String) boyutBox.getSelectedItem();
        String patates = (String) patatesBox.getSelectedItem();
        String icecek = (String) icecekBox.getSelectedItem();
        String tatli = (String) tatliBox.getSelectedItem();

        int fiyat = 0;
        if (pizza.contains("Kendi Pizzanı")) {
            pizza = kullaniciAdi + "'nin Özel Pizzası: " + String.join(", ", CustomPizzaDialog.secilenMalzemeler);
            fiyat += 75 + CustomPizzaDialog.customPizzaFiyati;
        }
        else if (pizza.contains("FourCheese")) fiyat += 175 ;
        else if (pizza.contains("Kapadokya")) fiyat += 200 ;
        else if (pizza.contains("Kavurmalı")) fiyat += 250 ;
        else if (pizza.contains("Luna")) fiyat += 100 ;
        else if (pizza.contains("Mexican")) fiyat += 150 ;
        else if (pizza.contains("Margarita")) fiyat += 100 ;
        else if (pizza.contains("Mix")) fiyat += 150 ;
        else if (pizza.contains("Tavuklu")) fiyat += 200 ;
        else if (pizza.contains("Vegeterian")) fiyat += 100 ;

        if (hamur.contains("İnce")) fiyat += 20;
        else if (hamur.contains("Klasik")) fiyat += 0;
        else fiyat += 50;


        if (boyut.contains("Küçük")) fiyat += 80;
        else if (boyut.contains("Orta")) fiyat += 110;
        else fiyat += 140;

        if (patates.contains("Küçük")) fiyat += 40;
        else if (patates.contains("Orta")) fiyat += 80;
        else if (patates.contains("Büyük")) fiyat += 110;
        else if (patates.contains("...")) fiyat += 0;
        else fiyat += 140;

        if (icecek.contains("Cola")) fiyat += 40;
        else if (icecek.contains("Gazoz")) fiyat += 30;
        else if (icecek.contains("Ayran")) fiyat += 15;
        else if (icecek.contains("Maden Suyu")) fiyat += 15;
        else if (icecek.contains("Fanta")) fiyat += 35;
        else if (icecek.contains("...")) fiyat += 0;

        if (tatli.contains("Sufle")) fiyat += 100;
        else if (tatli.contains("Cookie")) fiyat += 120;
        else if (tatli.contains("Brownie")) fiyat += 150;
        else if (tatli.contains("...")) fiyat += 0;
        else fiyat += 140;

        String urunOzet = "Pizza: " + pizza + " | Hamur: " + hamur + " | Boyut: " + boyut +
                " | Patates: " + patates + " | İçecek: " + icecek + " | Tatlı: " + tatli + " | Fiyat: " + fiyat + "₺";

        sepet.add(urunOzet);
        fiyatlar.add(fiyat);

        sonucArea.append("➕ Sepete eklendi: " + urunOzet + "\n\n");
    }

    private void siparisiTamamla() {
        sonucArea.append("=============================\n");
        sonucArea.append("🧾 Sipariş Özeti:\n\n");
        int toplam = 0;
        for (String urun : sepet) {
            sonucArea.append(urun + "\n");
        }
        for (int f : fiyatlar) {
            toplam += f;
        }
        sonucArea.append("\nToplam Tutar: " + toplam + "₺\n");
        sonucArea.append("=============================\n");
        sonucArea.append("Afiyet olsun! 🍽️\n\n");

        sepet.clear();
        fiyatlar.clear();
    }

    private void gorselGuncelle(String pizzaTuru) {
        String dosyaAdi;
        switch (pizzaTuru) {
            case "FourCheese" -> dosyaAdi = "fourcheese.png";
            case "Kapadokya" -> dosyaAdi = "kapadokya.png";
            case "Kavurmalı" -> dosyaAdi = "kavurmali.png";
            case "Luna" -> dosyaAdi = "luna.png";
            case "Mexican" -> dosyaAdi = "mexican.png";
            case "Margarita" -> dosyaAdi = "margarita.png";
            case "Mix" -> dosyaAdi = "mix.png";
            case "Tavuklu" -> dosyaAdi = "tavuklu.png";
            case "Vegeterian" -> dosyaAdi = "vegeterian.png";
            case "🌟 Kendi Pizzanı Yarat" -> dosyaAdi = "own.png";
            default -> dosyaAdi = "default.png";
        }

        try {
            URL imageURL = getClass().getClassLoader().getResource("res/" + dosyaAdi);
            if (imageURL != null) {
                ImageIcon icon = new ImageIcon(imageURL);
                Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                pizzaResimLabel.setIcon(new ImageIcon(img));
            } else {
                pizzaResimLabel.setIcon(null);
                System.out.println("⚠️ Görsel bulunamadı: res/" + dosyaAdi);
            }
        } catch (Exception e) {
            pizzaResimLabel.setIcon(null);
            System.out.println("❌ HATA: Görsel yüklenemedi → " + dosyaAdi);
        }
    }
    private void gorselGuncelle1(String icecekTuru) {
        String dosyaAdi1;
        switch (icecekTuru) {
            case "Cola" -> dosyaAdi1 = "cola.png";
            case "Ayran" -> dosyaAdi1 = "ayran.png";
            case "Maden Suyu" -> dosyaAdi1 = "soda.png";
            case "Fanta" -> dosyaAdi1 = "fanta.png";
            case "Gazoz" -> dosyaAdi1 = "gazoz.png";
            default -> dosyaAdi1 = "";
        }
        try {
            URL imageURL = getClass().getClassLoader().getResource("res/" + dosyaAdi1);
            if (imageURL != null) {
                ImageIcon icon = new ImageIcon(imageURL);
                Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                icecekResimLabel.setIcon(new ImageIcon(img));
            } else {
                icecekResimLabel.setIcon(null);
                System.out.println("⚠️ Görsel bulunamadı: res/" + dosyaAdi1);
            }
        } catch (Exception e) {
            icecekResimLabel.setIcon(null);
            System.out.println("❌ HATA: Görsel yüklenemedi → " + dosyaAdi1);
        }
    }
    private void gorselGuncelle2(String tatliTuru) {
        String dosyaAdi2;
        switch (tatliTuru) {
            case "Cookie" -> dosyaAdi2 = "cookie.png";
            case "Brownie" -> dosyaAdi2 ="browniee.png";
            case "Sufle" -> dosyaAdi2 ="sufle.png";
            case "Special" -> dosyaAdi2 ="special.png";
            default -> dosyaAdi2 ="";


        }



        try {
            URL imageURL = getClass().getClassLoader().getResource("res/" + dosyaAdi2);
            if (imageURL != null) {
                ImageIcon icon = new ImageIcon(imageURL);
                Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                tatliResimLabel.setIcon(new ImageIcon(img));
            } else {
                tatliResimLabel.setIcon(null);
                System.out.println("⚠️ Görsel bulunamadı: res/" + dosyaAdi2);
            }
        } catch (Exception e) {
            tatliResimLabel.setIcon(null);
            System.out.println("❌ HATA: Görsel yüklenemedi → " + dosyaAdi2);
        }
    }

    public static void main(String[] args) {
        new PizzaSiparisFrame();
    }
}
