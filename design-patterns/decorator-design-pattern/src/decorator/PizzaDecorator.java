package decorator;

import component.BasePizza;

public abstract class PizzaDecorator implements BasePizza {
    protected BasePizza basePizza;

    public PizzaDecorator(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public String getDescription() {
        return basePizza.getDescription();
    }

    @Override
    public double findCost() {
        return basePizza.findCost();
    }




}
