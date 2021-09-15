package HW2;

import HW2.Array.ArrayMethod;
import HW2.Array.MyArrayDataException;
import HW2.Array.MyArrayException;

public class MyApp {
    public static void main(String[] args)  {
        ArrayMethod arrayMethod = new ArrayMethod();


        try {
            String[][] a = {{"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "f", "1", "1"}, {"1", "1", "1", "1"}};
            arrayMethod.arrayMethod(a);
        } catch (MyArrayException e) {
            System.out.println("Размер массива превышен");
        } catch (MyArrayDataException e) {
            System.out.println("Введены не верные символы  в ячейке " + e.getJ());

        }

    }
}