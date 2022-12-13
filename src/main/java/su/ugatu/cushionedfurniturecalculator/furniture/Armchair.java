package su.ugatu.cushionedfurniturecalculator.furniture;

/**
 * Кресло
 */
public class Armchair extends AbstractFurniture {

    public Armchair(String carcass, String upholstery) {
        super(carcass, upholstery);
    }

    @Override
    public String getName() {
        return "Кресло";
    }
}
