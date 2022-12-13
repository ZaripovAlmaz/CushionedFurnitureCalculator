package su.ugatu.cushionedfurniturecalculator.calculator;

import su.ugatu.cushionedfurniturecalculator.furniture.Furniture;

import java.util.Collections;
import java.util.Map;

/**
 * Реализация калькулятора, которая вычисляет стоимость мебели без учета срочности изготовления
 */
public class CommonCalculator implements Calculator {
    // мапа с ценами на компоненты для дивана
    protected final Map<String, Double> priceForSofa = Map.of(
            "Металл", 50.5,
            "Дерево", 35.6,
            "Кожа", 26.4,
            "Текстиль", 14.7
    );

    // мапа с ценами на компоненты для кресла
    protected final Map<String, Double> priceForArmchair = Map.of(
            "Металл", 41.5,
            "Дерево", 28.6,
            "Кожа", 19.4,
            "Текстиль", 8.7
    );

    @Override
    public Double calculate(Furniture furniture) {
        Map<String, Double> priceByType = getPriceByType(furniture);
        Double carcassPrice = priceByType.get(furniture.getCarcass());
        Double upholsteryPrice = priceByType.get(furniture.getUpholstery());

        return carcassPrice + upholsteryPrice;
    }

    private Map<String, Double> getPriceByType(Furniture furniture) {
        if ("Диван".equals(furniture.getName())) {
            return priceForSofa;
        } else if ("Кресло".equals(furniture.getName())) {
            return priceForArmchair;
        } else {
            return Collections.emptyMap();
        }
    }
}
