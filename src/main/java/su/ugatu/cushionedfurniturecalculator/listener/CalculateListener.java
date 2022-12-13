package su.ugatu.cushionedfurniturecalculator.listener;

import su.ugatu.cushionedfurniturecalculator.calculator.CommonCalculator;
import su.ugatu.cushionedfurniturecalculator.calculator.UrgencyCalculator;
import su.ugatu.cushionedfurniturecalculator.furniture.Armchair;
import su.ugatu.cushionedfurniturecalculator.furniture.Furniture;
import su.ugatu.cushionedfurniturecalculator.furniture.Sofa;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Обработчик нажатия кнопки "Рассчитать"
 */
public class CalculateListener implements ActionListener {
    private final JComboBox<String> comboBoxFurnitureType;
    private final JComboBox<String> comboBoxCarcassType;
    private final JComboBox<String> comboBoxUpholsteryType;
    private final JCheckBox checkBox;

    private final CommonCalculator commonCalculator;
    private final UrgencyCalculator urgencyCalculator;

    public CalculateListener(
            JComboBox<String> comboBoxFurnitureType,
            JComboBox<String> comboBoxCarcassType,
            JComboBox<String> comboBoxUpholsteryType,
            JCheckBox checkBox
    ) {
        this.comboBoxFurnitureType = comboBoxFurnitureType;
        this.comboBoxCarcassType = comboBoxCarcassType;
        this.comboBoxUpholsteryType = comboBoxUpholsteryType;
        this.checkBox = checkBox;

        // создаем объекты калькуляторов
        commonCalculator = new CommonCalculator();
        urgencyCalculator = new UrgencyCalculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // вытаскиваем значения из полей
        String furnitureType = (String) comboBoxFurnitureType.getSelectedItem();
        String carcassType = (String) comboBoxCarcassType.getSelectedItem();
        String upholsteryType = (String) comboBoxUpholsteryType.getSelectedItem();

        // проверяем заполненность
        if (isEmpty(furnitureType, "Не указан тип мебели")
                || isEmpty(carcassType, "Не указан тип каркаса")
                || isEmpty(upholsteryType, "Не указан тип обивки")) {
            return;
        }

        // создаем конкретный экземпляр мебели, исходя из того какой тип был выбран
        Furniture furniture;
        if ("Диван".equals(furnitureType)) {
            furniture = new Sofa(carcassType, upholsteryType);
        } else if ("Кресло".equals(furnitureType)) {
            furniture = new Armchair(carcassType, upholsteryType);
        } else {
            throw new IllegalStateException("Несуществующий тип мебели " + furnitureType);
        }

        // считаем во сколько обойдется производство и выводим в модальное окно
        Double furniturePrice;
        String message;
        if (checkBox.isSelected()) {
            furniturePrice = urgencyCalculator.calculate(furniture);
            message = String.format("Стоимость производства изделия [%s] из каркаса с типом [%s] " +
                            "и обивкой с типом [%s] с учетом срочности изготовления составляет [%.2f у.е.]",
                    furnitureType, carcassType, upholsteryType, furniturePrice);
        } else {
            furniturePrice = commonCalculator.calculate(furniture);
            message = String.format("Стоимость производства изделия [%s] из каркаса с типом [%s] " +
                            "и обивкой с типом [%s] составляет [%.2f у.е.]",
                    furnitureType, carcassType, upholsteryType, furniturePrice);
        }
        JOptionPane.showMessageDialog(null, message, "Итоговая стоимость", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Заполнено ли поле из формы
     *
     * @param paramVal значение из формы
     * @param errorMsg текст ошибки, если поле не заполнено
     * @return true если не заполнено, иначе false
     */
    private boolean isEmpty(String paramVal, String errorMsg) {
        if (paramVal == null || paramVal.isEmpty()) {
            JOptionPane.showMessageDialog(null, errorMsg, "Ошибка", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }
}
