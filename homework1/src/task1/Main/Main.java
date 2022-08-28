import java.security.SecureRandom;
import java.util.Random;

/**
 * Task1 - find min, max, and average in 10X10 matrix.
 */

public class Main {
    private static final int SIDE = 10;
    private static int[][] matrix = new int[SIDE][SIDE];

    /**
     * Test for correct getting and parsing min,max,average values.
     * @VM_Options -ea
     */
    static {
        int[][] testMatrix = new int[SIDE][SIDE];
        for (int i = 0; i < testMatrix.length; i++) {
            for (int j = 0; j < testMatrix[i].length; j++) {
                testMatrix[i][j] = i + j;
            }
        }
        String expected =
                """
                "Минимальное значение - " 0 "
                "Максимальное значение - " 18 "
                "Среднее арифметическое - " 9 "
                """;
        String actual =
                parseMinMaxAverageString(
                getMinMaxAverageString(testMatrix));
        assert expected.equals(actual);

    }

    public static void main(String[] args) {
        initMatrix(matrix);
        showMatrix(matrix);
        System.out.println(
                parseMinMaxAverageString(
                        getMinMaxAverageString(matrix)));
    }


    private static int customTimeHashCodeRandom(int seed) {
        Random randomSeed = new Random(System.currentTimeMillis() - seed);
        try {
            Thread.sleep(randomSeed.nextInt(Math.abs(seed)));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return (Math.abs(randomSeed.hashCode() / seed) - randomSeed.nextInt(10000000));
    }

    private static String getMinMaxAverageString(int[][] matrixArray) {
        int min = 0;
        int max = 0;
        long sum = 0;
        for (int i = 0; i < matrixArray.length; i++) {
            for (int j = 0; j < matrixArray[i].length; j++) {
                if (matrixArray[i][j] < min) {
                    min = matrixArray[i][j];
                }
                if (matrixArray[i][j] > max) {
                    max = matrixArray[i][j];
                }
                sum += matrixArray[i][j];
            }
        }
        long average = (sum / (SIDE * SIDE));
        return String.format("%d:%d:%d", min, max, average);
    }

    private static String parseMinMaxAverageString(String stringValues) {
        String[] values = stringValues.split(":");
        return String.format(
                """
                "Минимальное значение - " %s "
                "Максимальное значение - " %s "
                "Среднее арифметическое - " %s "
                """,
                values[0],
                values[1],
                values[2]);
    }

    private static void initMatrix(int[][] matrixArray){
        SecureRandom sRng = new SecureRandom();
        byte[] randomBytes = new byte[SIDE];
        sRng.nextBytes(randomBytes);
        for (int i = 0; i < matrixArray.length; i++) {
            for (int j = 0; j < matrixArray[i].length; j++) {
                matrixArray[i][j] = customTimeHashCodeRandom(randomBytes[i]);
            }
        }
    }

    private static void showMatrix(int[][] matrixArray) {

        for (int i = 0; i < matrixArray.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matrixArray[i].length; j++) {
                System.out.print(matrixArray[i][j] + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }
}
