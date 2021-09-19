package HW2.Array;

public class MyArrayException extends Throwable {
    private int i;
    private int j;

    public MyArrayException( int i, int j) {
        this.i = i;
        this.j = j;
    }

    public MyArrayException() {

    }
}