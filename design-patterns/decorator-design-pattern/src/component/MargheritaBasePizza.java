package component;

public class MargheritaBasePizza implements BasePizza {
    @Override
    public String getDescription() {
        return "It is Margherita Pizza";
    }

    @Override
    public double findCost() {
        return 100;
    }
}
