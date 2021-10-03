package HW4;

import HW4.Phone.PhoneCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HW4 {
    public static void main(String[] args) {
        // Задание 1
        List<String> stringList  = new ArrayList<>(Arrays.asList("orange", "orange", "apple", "table", "char", "char", "java", "tv", "men", "woman", "men"));
        stringList.stream().distinct().forEach(System.out::println);
        System.out.println("Количество элементов  уникальных элементов "+stringList.stream().distinct().count());

        // Задание 2
        PhoneCase phone = new PhoneCase();
        phone.add("Иванов","89998887766");
        phone.add("Петров","85554443322");
        phone.add("Петров","81111111111");



        System.out.println(phone.get("Иванов"));
        System.out.println(phone.get("Петров"));

    }

}