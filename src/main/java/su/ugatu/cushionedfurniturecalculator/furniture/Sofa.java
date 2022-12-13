package su.ugatu.cushionedfurniturecalculator.furniture;

/**
 * Диван
 */
public class Sofa extends AbstractFurniture {

    public Sofa(String carcass, String upholstery) {
        super(carcass, upholstery);
    }

    @Override
    public String getName() {
        return "Диван";
    }
}
