package su.ugatu.cushionedfurniturecalculator.furniture;

/**
 * Интерфейс "Мебель"
 */
public interface Furniture {
    /**
     * Получить название мебели
     *
     * @return название мебели
     */
    String getName();

    /**
     * Получить значение коэффициента срочности
     *
     * @return значение коэффициента срочности
     */
    Double getUrgencyVal();

    /**
     * Получить тип каркаса
     *
     * @return тип каркаса
     */
    String getCarcass();

    /**
     * Получить тип обивки
     *
     * @return тип обивки
     */
    String getUpholstery();
}
