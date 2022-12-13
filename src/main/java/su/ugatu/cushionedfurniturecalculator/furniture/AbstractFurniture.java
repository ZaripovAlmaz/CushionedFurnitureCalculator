package su.ugatu.cushionedfurniturecalculator.furniture;

/**
 * Абстрактный класс "Мебель"
 * Нужен, чтобы вынести в общий класс общие поля и методы
 */
public abstract class AbstractFurniture implements Furniture {
    protected final String carcass;
    protected final String upholstery;

    public AbstractFurniture(String carcass, String upholstery) {
        this.carcass = carcass;
        this.upholstery = upholstery;
    }

    @Override
    public Double getUrgencyVal() {
        return Double.valueOf("1.3");
    }

    @Override
    public String getCarcass() {
        return carcass;
    }

    @Override
    public String getUpholstery() {
        return upholstery;
    }
}
