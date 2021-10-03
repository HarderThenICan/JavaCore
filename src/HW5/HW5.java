package HW5;

import java.io.IOException;
import java.util.Arrays;

public class HW5 {
    public static void main(String[] args) throws IOException {
    AppDate appDate = new AppDate();
    appDate.load("src/HW5/File1.csv");

    System.out.println(Arrays.toString(appDate.getHeader()));
    System.out.println(Arrays.deepToString(appDate.getData()));
    appDate.save("src/HW5/File2.csv");


}
}
