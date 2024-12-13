package decorator;

import component.BasePizza;

public class MushroomDecorator extends PizzaDecorator {


    public MushroomDecorator(BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public String getDescription() {
        return basePizza.getDescription() + " + mushroom";
    }

    @Override
    public double findCost() {
        return basePizza.findCost() + 90;
    }

}
