package HyperskillTasks.CoffeeMachine;

public class Coffee extends CoffeeFunctions {
    private String coffeeName;
    public Coffee(int waterAmount, int milkAmount, int beansAmount, int cup, int cost, String coffeeName) {
        super(waterAmount, milkAmount, beansAmount, 1, cost);
        this.coffeeName = coffeeName;
    }
}
