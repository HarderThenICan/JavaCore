package HW2.Array;

public class MyArrayDataException extends Throwable {
    private int i;
    private int j;

    public MyArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getJ() {
        return j;
    }
}