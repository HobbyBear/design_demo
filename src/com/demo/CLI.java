package com.demo;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CLI {

    private static Scanner input = new Scanner(System.in);


    public static void main(String[] args) throws NotAPowerGeneratorException, IOException, ClassNotFoundException {
        ElectricityCompany electricity = new ElectricityCompany("UICElectricity");
        while (true) {
            String name;
            int power;
            int action = readPosInt("Type an action (total:1 add:2 get:3 more:4 less:5 quit:6):");
            if (action > 6) {
                System.out.println("Unknown action");
                continue;
            }
            switch (action) {
                case 1:
                    System.out.println("Total amount of power consumed:" + electricity.totalConsumption());
                    break;
                case 2:
                    action2(electricity);
                    break;
                case 3:
                    name = readLine("Enter the name of the consumer: ");
                    power = 0;
                    try {
                        power = electricity.getPower(name);
                    } catch (UnknownConsumerException e) {
                        System.out.println("Consumer " + name + " unknown");
                    }
                    System.out.println(name + "uses " + power + " watts");
                case 4:
                    name = readLine("Enter the name of the consumer: ");
                    power = readPosInt("Enter the amount of power: ");
                    try {
                        electricity.morePower(name,power);
                    } catch (UnknownConsumerException e) {
                        System.out.println("Consumer " + name + " unknown");
                    }
                case 5:
                    name = readLine("Enter the name of the consumer: ");
                    power = readPosInt("Enter the amount of power: ");
                    try {
                        electricity.morePower(name,-power);
                    } catch (UnknownConsumerException e) {
                        System.out.println("Consumer " + name + " unknown");
                    }
                default:
                    System.out.println("Goodbye!");
                    System.exit(0);
            }
        }
    }


    private static void action2(ElectricityCompany electricityCompany) throws NotAPowerGeneratorException {
        int consumerType = readPosInt("Type the consumer type (power plant:1 house:2 solar house:3): ");
        if (consumerType > 4) {
            System.out.println("Unknown type of consumer!");
            return;
        }
        switch (consumerType) {
            case 1:
                String name = readLine("Enter the name of the consumer:");
                int power = readPosInt("Enter the initial amount of power: ");
                electricityCompany.addConsumer(new PowerPlant(name, power));
                System.out.println("Power plant " + name + " generating " + power + " watts of power added");
                break;
            case 2:
                String houseName = readLine("Enter the name of the consumer:");
                int housePower = readPosInt("Enter the initial amount of power: ");
                electricityCompany.addConsumer(new House(houseName, housePower));
                System.out.println("House of " + houseName + " consuming " + housePower + " watts of power added");
                break;
            case 3:
                String solorName = readLine("Enter the name of the consumer:");
                int solorPower = readPosInt("Enter the initial amount of power: ");
                electricityCompany.addConsumer(new SolarHouse(solorName, solorPower));
                System.out.println("Solar house of " + solorName + " consuming " + solorPower + " watts of power added");
                break;
        }
    }

    private static String readLine(String text) {
        System.out.print(text);
        String str = input.nextLine();
        return str;
    }

    private static Integer readPosInt(String text) {
        int res;
        while (true) {
            System.out.print(text);
            try {
                res = input.nextInt();
                if (res < 0) {
                    System.out.println("Positive integers only");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("You must type an integer");
            }
        }
        return res;
    }
}
