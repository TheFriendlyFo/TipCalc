import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TipCalc extends JFrame implements ActionListener {
    private JTextField basePriceText, tipPercentText, splitText;
    private JButton percentIncrease, percentDecrease;
    private JButton splitIncrease, splitDecrease;
    private JPanel mainPanel;
    private JTextField tipPerPersonField, totalPerPersonField;
    private JButton saveValuesButton;
    private double basePrice;
    private int tipPercent, split;

    public TipCalc() {
        init();
    }

    public void init() {
        setTitle("Tip Calculator");
        setContentPane(mainPanel);
        setSize(600,300);
        setLocation(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        basePrice = 0.0;
        tipPercent = 20;
        split = 2;

        basePriceText.setText("0.01");
        tipPercentText.setText("20");
        splitText.setText("2");
        tipPerPersonField.setText("0.00");
        totalPerPersonField.setText("0.00");

        percentIncrease.addActionListener(this);
        percentIncrease.setName("%+");
        percentDecrease.addActionListener(this);
        percentDecrease.setName("%-");
        splitIncrease.addActionListener(this);
        splitIncrease.setName("/+");
        splitDecrease.addActionListener(this);
        splitDecrease.setName("/-");
        saveValuesButton.addActionListener(this);
        saveValuesButton.setName("save");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (((JButton) e.getSource()).getName()) {
            case "%+" -> tipPercent++;
            case "%-" -> tipPercent--;
            case "/+" -> split++;
            case "/-" -> split--;
            case "save" -> saveValues();
        }

        tipPercentText.setText(String.valueOf(tipPercent));
        splitText.setText(String.valueOf(split));

        saveValues();
    }

    private void saveValues() {
        basePrice = Double.parseDouble(basePriceText.getText());
        tipPercent = Integer.parseInt(tipPercentText.getText());
        split = Integer.parseInt(splitText.getText());
        tipPerPersonField.setText((int) (basePrice * tipPercent / 100.0 / split * 100) / 100.0 + "");
        totalPerPersonField.setText((int) (basePrice * (1 + tipPercent / 100.0) / split * 100) / 100.0 + "");
    }
}
