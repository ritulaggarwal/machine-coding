import component.BasePizza;
import component.FarmhouseBasePizza;
import decorator.CheeseDecorator;
import decorator.MushroomDecorator;
import decorator.PizzaDecorator;

public class Main {
    public static void main(String[] args) {
        BasePizza farmhousePizza = new FarmhouseBasePizza();
        System.out.println(farmhousePizza.getDescription() + " $ " + farmhousePizza.findCost());

        farmhousePizza = new CheeseDecorator(farmhousePizza);
        System.out.println(farmhousePizza.getDescription() + " $ " + farmhousePizza.findCost());

        farmhousePizza = new MushroomDecorator(farmhousePizza);
        System.out.println(farmhousePizza.getDescription() + " $ " + farmhousePizza.findCost());

    }
}