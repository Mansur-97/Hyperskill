package HyperskillTasks.CoffeeMachine;

import java.util.Scanner;

public class CoffeeFunctions {
    private int waterAmount;
    private int milkAmount;
    private int beansAmount;
    private int cupsAmount;
    private int moneyAmount;
    private final static int WATER_AMOUNT = 200;
    private final static int MILK_AMOUNT = 50;
    private final static int BEANS_AMOUNT = 15;
    static Scanner scanner = new Scanner(System.in);

    public CoffeeFunctions() {
        this.waterAmount = 400;
        this.milkAmount = 540;
        this.beansAmount = 120;
        this.cupsAmount = 9;
        this.moneyAmount = 550;
    }

    public CoffeeFunctions(int waterAmount, int milkAmount, int beansAmount, int cupsAmount, int moneyAmount) {
        this.waterAmount = waterAmount;
        this.milkAmount = milkAmount;
        this.beansAmount = beansAmount;
        this.cupsAmount = cupsAmount;
        this.moneyAmount = moneyAmount;
    }

    public void mainMenu() {
        System.out.println("The coffee machine has: " );
        System.out.println(getWater() + " ml of water");
        System.out.println(getMilk() + " ml of milk");
        System.out.println(getBeans() + " g of coffee beans");
        System.out.println(getCups() + " disposable cups");
        System.out.println("$" + getMoneyAmount() + " of money");
    }

    public void chooseFunction() {
        String function;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            function = scanner.nextLine();
            switch (function) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    remaining();
                    break;
            }
        } while (!function.equals("exit"));
    }

    public void buy () {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu");
        String coffeeType = scanner.nextLine();
        switch (coffeeType) {
            case "1":
                checkMachine(new Espresso());
                break;
            case "2":
                checkMachine(new Latte());
                break;
            case "3":
                checkMachine(new Cappuccino());
                break;
        }
    }

    public void fill() {
        System.out.println("Write how many ml of water you want to add:");
        int addWater = scanner.nextInt();
        setWater(getWater() + addWater);
        System.out.println("Write how many ml of milk you want to add:");
        int addMilk = scanner.nextInt();
        setMilk(getMilk() + addMilk);
        System.out.println("Write how many grams of coffee beans you want to add:");
        int addBeans = scanner.nextInt();
        setBeans(getBeans() + addBeans);
        System.out.println("Write how many disposable cups you want to add:");
        int addCups = scanner.nextInt();
        setCups(getCups() + addCups);
    }

    public void take() {
        System.out.println("I gave you $" + getMoneyAmount());
        setMoneyAmount(0);
    }

    public void remaining() {
        mainMenu();
    }

    public void checkMachine(Coffee coffeeType) {
        if (coffeeType.getWater() > getWater()) {
            System.out.println("Sorry, not enough water!");
        } else if (coffeeType.getMilk() > getMilk()) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffeeType.getBeans() > getBeans()) {
            System.out.println("Sorry, not enough coffee beans!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            setWater((getWater() - coffeeType.getWater()));
            setMilk(getMilk() - coffeeType.getMilk());
            setBeans(getBeans() - coffeeType.getBeans());
            setCups(getCups() - 1);
            setMoneyAmount(getMoneyAmount() + coffeeType.getMoneyAmount());
        }
    }

    public int getWater() {
        return waterAmount;
    }

    public void setWater(int waterAmount) {
        this.waterAmount = waterAmount;
    }

    public int getMilk() {
        return milkAmount;
    }

    public void setMilk(int milkAmount) {
        this.milkAmount = milkAmount;
    }

    public int getBeans() {
        return beansAmount;
    }

    public void setBeans(int beansAmount) {
        this.beansAmount = beansAmount;
    }

    public int getCups() {
        return cupsAmount;
    }

    public void setCups(int cupsAmount) {
        this.cupsAmount = cupsAmount;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }
}
