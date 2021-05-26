package com.demo;

import java.util.List;

public class ElectricityCompany {
    private String name;

    private List<Consumer> consumers;

    public ElectricityCompany(String name) {
        this.name = name;
    }

    public void addConsumer(Consumer consumer) {
        this.consumers.add(consumer);
    }

    public int totalConsumption() {
        int res = 0;
        for (Consumer consumer : consumers) {
            res += consumer.getPower();
        }
        return res;
    }

    public int getPower(String name) throws UnknownConsumerException {
        for (Consumer consumer : consumers) {
            if (consumer.getName().equals(name)) {
                return consumer.getPower();
            }
        }
        throw new UnknownConsumerException("Consumer" + name + " unknown");
    }


    public void morePower(String name,int amount) throws NotAPowerGeneratorException, UnknownConsumerException {
        for (Consumer consumer : consumers) {
            if (consumer.getName().equals(name)) {
                 consumer.morePower(amount);
                 return;
            }
        }
        throw new UnknownConsumerException("Consumer" + name + " unknown");
    }

}
