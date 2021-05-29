package com.demo;

public class ControllerCreate extends Controller {
    public ControllerCreate(ElectricityCompany m) {
        super(m);
    }

    public String create(String name, String amount, int type)  {

        switch (type) {
            case 1:
                m.addConsumer(new PowerPlant(name,Integer.parseInt(amount)));
                break;
            case 2:
                try {
                    m.addConsumer(new House(name,Integer.parseInt(amount)));
                } catch (NotAPowerGeneratorException e) {
                    return e.getMessage();
                }
                break;
            case 3:
                m.addConsumer(new SolarHouse(name,Integer.parseInt(amount)));
                break;
        }
        return "";
    }
}
