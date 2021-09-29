package HW3;

import HW3.Fruit.Apple;
import HW3.Fruit.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class HW3 {
    public static void main(String[] args) throws Exception {
        // Задание 1
        System.out.println(Arrays.toString(new ChanceArray().chanceArray( new int[]{1, 2})));

        // Задание 2
        Apple fruitOne = new Apple();
        Orange fruitTwo = new Orange();


        Box<Apple> appleBoxOne = new Box<Apple>(fruitOne, fruitOne);
        Box<Apple> appleBoxOneCopy = new Box<Apple>(fruitOne, fruitOne, fruitOne);
        Box<Orange> orangeBoxOne = new Box<Orange>(fruitTwo, fruitTwo);
        Box<Orange> orangeBoxTwoCopy = new Box<Orange>(fruitTwo, fruitTwo, fruitTwo);


        ArrayList<Box> arrayList = toArray(appleBoxOne, appleBoxOneCopy, orangeBoxOne, orangeBoxTwoCopy);
        System.out.println(arrayList.get(0)); /// Тут лежит коробка в ,которой 2 яблока
        System.out.println(arrayList.get(0).compareAverage(arrayList.get(2))); // Сравнивает вес яблока в коробке
        System.out.println(appleBoxOne); // перед добавлением 2 фрукта
        appleBoxOne.addFruit(fruitOne, fruitOne);
        System.out.println(appleBoxOne); // после 4 фрукта
        // ,если есть совпадение try , сейчас тут false потомучто сравниваются апельсины с блоком
        // appleBoxOne.transfer(orangeBoxTwoCopy); // яблоко нелья пересыпать в апельсин
        appleBoxOne.transfer(appleBoxOneCopy); // яблоко в яблко можно
        System.out.println(appleBoxOneCopy);

    }

    public static <Box> ArrayList<Box> toArray(Box... array) {
        return new ArrayList<Box>(Arrays.asList(array));
    }

}
