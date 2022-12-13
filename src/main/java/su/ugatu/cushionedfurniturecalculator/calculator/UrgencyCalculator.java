package su.ugatu.cushionedfurniturecalculator.calculator;

import su.ugatu.cushionedfurniturecalculator.furniture.Furniture;

/**
 * Реализация калькулятора, которая вычисляет стоимость мебели с учетом срочности изготовления
 */
public class UrgencyCalculator extends CommonCalculator {
    @Override
    public Double calculate(Furniture furniture) {
        // вычисляем стоимость производства без учета срочности
        Double priceWithoutUrgency = super.calculate(furniture);
        // умножаем на коэффициент срочности
        return priceWithoutUrgency * furniture.getUrgencyVal();
    }
}
