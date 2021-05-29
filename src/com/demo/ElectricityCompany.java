package com.demo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ElectricityCompany implements Serializable {
    private String name;

    private List<ModelListener> listeners;

    private List<Consumer> consumers;

    private List<Integer> history;

    private File file;

    public void addListener(ModelListener listener) {
        this.listeners.add(listener);
    }

    private void notifyListeners() {
        for (ModelListener listener :
                listeners) {
            listener.update();
        }
    }


    public List<Integer> getHistory(){
        return history;
    }

    public ElectricityCompany(String name) throws IOException, ClassNotFoundException {
        this.name = name;
        this.consumers = new ArrayList<>();
        this.listeners = new ArrayList<>();
        this.history = new ArrayList<>();
        history.add(0);
        this.file = new File(name+".bin");
        if (file.exists()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Object obj = ois.readObject();
            ElectricityCompany company = ElectricityCompany.class.cast(obj);
            this.history = company.history;
            this.consumers = company.consumers;
        }

    }

    public void saveData() throws IOException {
        if (!file.exists()){
            file.createNewFile();
        }
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(this);
        oos.close();
    }

    public void addConsumer(Consumer consumer) {
        this.consumers.add(consumer);
        this.history.add(totalConsumption());
        notifyListeners();
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


    public void morePower(String name, int amount) throws NotAPowerGeneratorException, UnknownConsumerException {
        for (Consumer consumer : consumers) {
            if (consumer.getName().equals(name)) {
                consumer.morePower(amount);
                this.history.add(totalConsumption());
                notifyListeners();
                return;
            }
        }
        throw new UnknownConsumerException("Consumer" + name + " unknown");
    }

}
