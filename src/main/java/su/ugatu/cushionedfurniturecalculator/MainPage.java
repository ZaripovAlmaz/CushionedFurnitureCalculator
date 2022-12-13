package su.ugatu.cushionedfurniturecalculator;

import su.ugatu.cushionedfurniturecalculator.listener.CalculateListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

/**
 * Основное окно приложения
 */
public class MainPage extends JFrame {

    public MainPage() {
        super("Cushioned Furniture Calculator - Калькулятор");

        initComponents();

        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        this.add(mainPanel);

        JLabel labelTitle = new JLabel("Калькулятор расчета стоимости производства мягкой мебели");
        labelTitle.setBounds(30, 0, 450, 30);
        mainPanel.add(labelTitle);

        JLabel label1 = new JLabel("Выберите тип мягкой мебели:");
        label1.setBounds(30, 40, 300, 30);
        mainPanel.add(label1);

        String[] furnitureTypes = new String[]{"", "Диван", "Кресло"};
        JComboBox<String> comboBoxFurnitureType = new JComboBox<>(furnitureTypes);
        comboBoxFurnitureType.setBounds(30, 70, 150, 30);
        comboBoxFurnitureType.addActionListener(e -> {
        });
        mainPanel.add(comboBoxFurnitureType);

        JLabel label2 = new JLabel("Выберите тип каркаса:");
        label2.setBounds(30, 120, 300, 30);
        mainPanel.add(label2);

        String[] carcassTypes = {"", "Металл", "Дерево"};
        JComboBox<String> comboBoxCarcassType = new JComboBox<>(carcassTypes);
        comboBoxCarcassType.setBounds(30, 150, 150, 30);
        comboBoxCarcassType.addActionListener(e -> {
        });
        mainPanel.add(comboBoxCarcassType);

        JLabel label3 = new JLabel("Выберите тип обивки:");
        label3.setBounds(30, 200, 300, 30);
        mainPanel.add(label3);

        String[] fillerType = {"", "Кожа", "Текстиль"};
        JComboBox<String> comboBoxUpholsteryType = new JComboBox<>(fillerType);
        comboBoxUpholsteryType.setBounds(30, 230, 150, 30);
        comboBoxUpholsteryType.addActionListener(e -> {
        });
        mainPanel.add(comboBoxUpholsteryType);

        JCheckBox checkBox = new JCheckBox("Требуется ли срочное изготовление");
        checkBox.setBounds(30, 270, 300, 30);
        checkBox.addActionListener(e -> {
        });
        mainPanel.add(checkBox);

        JLabel label5 = new JLabel("(Для каждого типа мебели свой коэффициент срочности)");
        label5.setBounds(30, 290, 450, 30);
        mainPanel.add(label5);

        JButton buttonCalc = new JButton("Рассчитать");
        buttonCalc.setBounds(30, 330, 150, 40);

        // создаем обработчик нажатия кнопки "Рассчитать"
        ActionListener calculateListener = new CalculateListener(
                comboBoxFurnitureType,
                comboBoxCarcassType,
                comboBoxUpholsteryType,
                checkBox
        );
        buttonCalc.addActionListener(calculateListener);
        mainPanel.add(buttonCalc);
    }
}
