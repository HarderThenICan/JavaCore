package HW9;

import HW9.Data.Course;
import HW9.Data.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HW9 {
    public static void main(String[] args) {
        List <Student> students = new ArrayList<>();
        students.addAll(Arrays.asList(new Student("Олег", Course.TESTING)
                ,new Student("Вася",Course.VETERINARIAN)
                ,new Student("Дима",Course.TESTING)
                ,new Student("Евгений",Course.DEVELOPMENT)));
        //Задание 1
        students.stream().map(s -> s.getCourse()).collect(Collectors.toSet()).forEach(System.out::println);

        //Задание 2
        students.stream().sorted(((o1, o2) -> o2.getCourse().compareTo(o1.getCourse())))
                .collect(Collectors.toSet()).stream().skip(students.size() -1)
                .collect(Collectors.toSet()).stream().forEach(System.out::println);
        //Задание 3
        students.stream().filter(student -> student.getCourse() == Course.TESTING).collect(Collectors.toSet()).forEach(System.out::println);
    }
}