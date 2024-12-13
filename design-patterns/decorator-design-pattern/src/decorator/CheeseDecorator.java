package decorator;

import component.BasePizza;

public class CheeseDecorator extends PizzaDecorator {

    public CheeseDecorator(BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public String getDescription() {
        return basePizza.getDescription() + " + cheese";
    }

    @Override
    public double findCost() {
        return basePizza.findCost() + 80;
    }

}
