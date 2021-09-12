package HW1.Master;

import HW1.Pack.Course;
import HW1.Pack.CourseEntity;
import HW1.Pack.Pool;
import HW1.Pack.Track;

public class Main {

    public static void main(String[] args) {
        Man [] teamArr = {
                new Man("Вася", 40, 0.8),
                new Man("Петя", 30, 0.5),
                new Man("Маша", 44, 0.7),
                new Man("Ира", 32, 0.5),
        };

        CourseEntity [] courseArr = {
                new Pool (100),
                new Pool (300),
                new Track(200),
                new Track(500),
        };

        Team team = new Team ("Команда мечты", teamArr);
        Course course = new Course(courseArr, 1);
        team.getInfo();
        team.play(course);
        team.getInfo();
    }
}