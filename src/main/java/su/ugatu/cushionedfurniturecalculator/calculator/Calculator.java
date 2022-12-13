package su.ugatu.cushionedfurniturecalculator.calculator;

import su.ugatu.cushionedfurniturecalculator.furniture.Furniture;

/**
 * Калькулятор для расчета стоимости производства мебели
 */
public interface Calculator {
    /**
     * Вычислить стоимость производства мебели
     *
     * @param furniture мебель
     * @return стоимость производства
     */
    Double calculate(Furniture furniture);
}
