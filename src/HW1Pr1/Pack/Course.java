package HW1Pr1.Pack;

public class Course {
    CourseEntity[] courseArr;
    private int loops;

    public Course(CourseEntity[] courseArr, int loops) {
        this.setCourseArr(courseArr);
        this.setLoops(loops);
    }

    public CourseEntity[] getCourseArr() {
        return courseArr;
    }

    public void setCourseArr(CourseEntity[] courseArr) {
        this.courseArr = courseArr;
    }

    public int getLoops() {
        return loops;
    }

    public void setLoops(int loops) {
        this.loops = loops;
    }
}
