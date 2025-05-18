import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class CustomPizzaDialog extends JDialog {

    private ArrayList<JCheckBox> malzemeKutular;
    private JButton tamamBtn;
    private static final String[] MALZEMELER = {
            "Sucuk +25", "Mantar +15", "Zeytin +10", "Mozarella +20", "Domates +10", "Mısır +10", "Biber +10", "Peynir +18", "Jalapeno +20", "Sosis +15"
    };

    private static final HashMap<String, Integer> MALZEME_FIYAT = new HashMap<>() {{
        put("Sucuk", 25);
        put("Mantar", 15);
        put("Zeytin", 10);
        put("Mozarella", 20);
        put("Domates", 10);
        put("Mısır", 10);
        put("Biber", 10);
        put("Peynir", 18);
        put("Jalapeno", 22);
        put("Sosis", 15);
    }};

    public static ArrayList<String> secilenMalzemeler = new ArrayList<>();
    public static int customPizzaFiyati = 0;

    public CustomPizzaDialog(JFrame parent) {
        super(parent, "Kendi Pizzanı Oluştur", true);
        setSize(400, 400);
        setLayout(new BorderLayout());

        JPanel kutuPanel = new JPanel(new GridLayout(0, 2));
        malzemeKutular = new ArrayList<>();

        for (String malzeme : MALZEMELER) {
            JCheckBox kutu = new JCheckBox(malzeme + "  ₺");
            kutu.setActionCommand(malzeme);  // sadece ismi lazım
            malzemeKutular.add(kutu);
            kutuPanel.add(kutu);
        }

        tamamBtn = new JButton("Tamamla");
        tamamBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secilenMalzemeler.clear();
                customPizzaFiyati = 0;
                for (JCheckBox kutu : malzemeKutular) {
                    if (kutu.isSelected()) {
                        String malzeme = kutu.getActionCommand();
                        secilenMalzemeler.add(malzeme);
                        customPizzaFiyati += MALZEME_FIYAT.getOrDefault(malzeme, 0);
                    }
                }
                dispose();
            }
        });

        add(new JScrollPane(kutuPanel), BorderLayout.CENTER);
        add(tamamBtn, BorderLayout.SOUTH);
        setLocationRelativeTo(parent);
        setVisible(true);
    }
}
