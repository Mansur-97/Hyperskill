package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        int waterAmount = 400;
        int milkAmount = 540;
        int beansAmount = 120;
        int disposableCups = 9;
        int moneyAmount = 550;
        machine(waterAmount,milkAmount, beansAmount, disposableCups, moneyAmount);
    }

    public static void machine(int waterAmount, int milkAmount, int beansAmount, int disposableCups, int moneyAmount) {
        Scanner scanner = new Scanner(System.in);

        final int espressoWater = 250;
        final int espressoBeans = 16;
        final int espressoCost = 4;

        final int latteWater = 350;
        final int latteMilk = 75;
        final int latteBeans = 20;
        final int latteCost = 7;

        final int cappuccinoWater = 200;
        final int cappuccinoMilk = 100;
        final int cappuccinoBeans = 12;
        final int cappuccinoCost = 6;

        boolean temp = true;
        int fillWater, fillMilk, fillBeans, fillCups;
        while (temp) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.next();
            switch (action) {
                case "buy":
                    System.out.println();
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                    String drink = scanner.next();
                    switch (drink) {
                        case "1":
                            if (espressoWater > waterAmount) {
                                System.out.println("Sorry, not enough water!" + "\n");
                            } else if (espressoBeans > beansAmount) {
                                System.out.println("Sorry, not enough beans!" + "\n");
                            } else if (disposableCups == 0) {
                                System.out.println("Sorry, not enough cups!" + "\n");
                            }
                            if (waterAmount >= espressoWater && beansAmount >= espressoBeans && disposableCups > 0) {
                                waterAmount -= espressoWater;
                                beansAmount -= espressoBeans;
                                disposableCups -= 1;
                                moneyAmount += espressoCost;
                                System.out.println("I have enough resources, making you a coffee!" + "\n");
                            }
                            break;
                        case "2":
                            if (latteWater > waterAmount) {
                                System.out.println("Sorry, not enough water!" + "\n");
                            } else if (latteMilk > milkAmount) {
                                System.out.println("Sorry, not enough milk!" + "\n");
                            } else if (latteBeans > beansAmount) {
                                System.out.println("Sorry, not enough beans!" + "\n");
                            } else if (disposableCups == 0) {
                                System.out.println("Sorry, not enough cups!" + "\n");
                            }
                            if (waterAmount >= latteWater && milkAmount >= latteMilk && beansAmount >= latteBeans && disposableCups > 0) {
                                waterAmount -= latteWater;
                                milkAmount -= latteMilk;
                                beansAmount -= latteBeans;
                                disposableCups -= 1;
                                moneyAmount += latteCost;
                                System.out.println("I have enough resources, making you a coffee!" + "\n");
                            }
                            break;
                        case "3":
                            if (cappuccinoWater > waterAmount) {
                                System.out.println("Sorry, not enough water!" + "\n");
                            } else if (cappuccinoMilk > milkAmount) {
                                System.out.println("Sorry, not enough milk!" + "\n");
                            } else if (cappuccinoBeans > beansAmount) {
                                System.out.println("Sorry, not enough beans!" + "\n");
                            } else if (disposableCups == 0) {
                                System.out.println("Sorry, not enough cups!" + "\n");
                            }
                            if (waterAmount >= cappuccinoWater && milkAmount >= cappuccinoMilk && beansAmount >= cappuccinoBeans && disposableCups > 0) {
                                waterAmount -= cappuccinoWater;
                                milkAmount -= cappuccinoMilk;
                                beansAmount -= cappuccinoBeans;
                                disposableCups -= 1;
                                moneyAmount += cappuccinoCost;
                                System.out.println("I have enough resources, making you a coffee!" + "\n");
                            }
                            break;
                        case "back":
                            System.out.println(action);
                            break;
                    }
                    break;
                case "fill":
                    System.out.println();
                    System.out.println("Write how many ml of water you want to add: ");
                    fillWater = scanner.nextInt();
                    System.out.println("Write how many ml of milk you want to add: ");
                    fillMilk = scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add: ");
                    fillBeans = scanner.nextInt();
                    System.out.println("Write how many disposable cups you want to add: ");
                    fillCups = scanner.nextInt();
                    System.out.println();
                    System.out.println("The coffee machine has: " );
                    waterAmount += fillWater;
                    milkAmount += fillMilk;
                    beansAmount += fillBeans;
                    disposableCups += fillCups;
                    temp = false;
                    machine(waterAmount,milkAmount, beansAmount, disposableCups, moneyAmount);
                    break;
                case "take":
                    System.out.println();
                    System.out.println("I gave you $" + moneyAmount + "\n");
                    moneyAmount = 0;
                    break;
                case "remaining":
                    System.out.println();
                    System.out.println("The coffee machine has: ");
                    System.out.println(waterAmount + " ml of water");
                    System.out.println(milkAmount + " ml of milk");
                    System.out.println(beansAmount + " g of beans");
                    System.out.println(disposableCups + " disposable cups");
                    System.out.println("$" + moneyAmount + " of money" + "\n");
                    break;
                case "exit":
                    temp = false;
                    break;
            }
        }
    }
}