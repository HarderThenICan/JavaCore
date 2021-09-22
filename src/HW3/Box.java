package HW3;

import HW3.Fruit.Fruit;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<N extends Fruit> {
    private ArrayList<N> array;


    public Box(N... array) {
        this.array = new ArrayList<>(Arrays.asList(array));
    }

    public double average() {
        double avg = 0.0;
        for (int i = 0; i < array.size(); i++) {
            avg += array.get(i).getWight();
        }
        avg /= array.size();
        return avg;

    }

    public void addFruit(N fruit) {
        this.array.add(fruit);
    } // добавить один фрукт
    public  void addFruit (N ... fruit) {
        this.array.addAll(Arrays.asList(fruit));
    }

    public void transfer(Box<? super N> box) {
        box.array.addAll(array);
        this.array.clear();
    }



    public boolean compareAverage(Box<N> something) {
        return Math.abs(this.average() - something.average()) < 0.001;
    }


    @Override
    public String toString() {
        return "Box{" +
                "array=" + array +
                '}';
    }


}