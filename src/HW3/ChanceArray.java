package HW3;

public class ChanceArray {
    private int temp = 0;

    public int[] chanceArray(int[] input) throws Exception {
        if (input.length != 2) {
            throw new Exception("Массив должен быть не больше 2 элементов");
        }
        temp = input[0];
        input[0] = input[1];
        input[1] = temp;
        return input;


    }


}