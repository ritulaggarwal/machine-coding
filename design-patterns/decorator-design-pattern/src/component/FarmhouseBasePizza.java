package component;

public class FarmhouseBasePizza implements BasePizza {
    @Override
    public String getDescription() {
        return "It is Farmhouse Pizza";
    }

    @Override
    public double findCost() {
        return 230;
    }
}
