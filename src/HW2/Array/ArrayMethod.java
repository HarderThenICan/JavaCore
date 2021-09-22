package HW2.Array;

public class ArrayMethod {
    int countOne = 0;

    public void arrayMethod(String[][] input) throws MyArrayException, MyArrayDataException {
        if (input.length != 4) {
            throw new MyArrayException();
        } else {
            for (int i = 0; i < input.length; i++) {

                if (input[i].length != 4) {
                    throw new MyArrayException();
                } else {
                    for (int j = 0; j < input.length; j++) {
                        try {
                            countOne += Integer.parseInt(input[i][j]);
                        } catch (NumberFormatException e) {
                            throw new MyArrayDataException(i, j);
                        }

                    }
                }
            }

        }
        System.out.println("Значение 1 " + countOne);

    }
}