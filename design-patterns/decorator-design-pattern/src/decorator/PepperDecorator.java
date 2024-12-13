package decorator;

import component.BasePizza;

public class PepperDecorator extends PizzaDecorator {

    public PepperDecorator(BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public String getDescription() {
        return basePizza.getDescription() + " + pepper";
    }

    @Override
    public double findCost() {
        return basePizza.findCost() + 30;
    }


}
