import java.util.Arrays;

/**
 * Task2 - sort array.
 */

public class Main {
    private static int[] defaultArray = new int[]{5, 6, 3, 2, 5, 1, 4, 9};
    private static int[] arrayWithRep = new int[]{
            52, 23, 23, 1, 4, 5, 22, 66, 22, 4, 124, 12,
            443, 55, 1, 1, 1, 233, 434, 25, 634, 7, 3, 4};

    /**
     * Test correct sort array, including repetitions.
     * @VM_Options -ea
     */
    static {
        int[] testArray = new int[]{2, 3, 4, 5, 5, 1, 8, 8, 1, 10, 9};
        int[] sortedTestArray = new int[]{1, 1, 2, 3, 4, 5, 5, 8, 8, 9, 10};
        customSort(testArray, 0, testArray.length - 1);
        assert Arrays.equals(testArray, sortedTestArray);
    }

    public static void main(String[] args) {
        sortAndShow(defaultArray);
        sortAndShow(arrayWithRep);

    }

    /**
     * Based on QuickSort algorithm.
     *
     * @param arrayToSort - int[] array we want to sort.
     * @param start       - int index of first array element.
     * @param end         - int index of last array element.
     */
    private static void customSort(int[] arrayToSort, int start, int end) {
        if (arrayToSort.length == 0) {
            return;
        }
        if (start >= end) {
            return;
        }
        int middleElement = start + ((end - start) / 2);
        int baseToSortFrom = arrayToSort[middleElement];
        int x = start;
        int y = end;
        while (x <= y) {
            while (arrayToSort[x] < baseToSortFrom) {
                x++;
            }
            while (arrayToSort[y] > baseToSortFrom) {
                y--;
            }
            if (x <= y) {
                int temp = arrayToSort[x];
                arrayToSort[x] = arrayToSort[y];
                arrayToSort[y] = temp;
                y--;
                x++;
            }
        }
        if (end > x)
            customSort(arrayToSort, x, end);
        if (start < y)
            customSort(arrayToSort, start, y);

    }

    private static void sortAndShow(int[] arrayToShow) {
        System.out.println("__________________________");
        System.out.println("Было");
        System.out.println(Arrays.toString(arrayToShow));
        System.out.println("__________________________");
        System.out.println("Стало");
        customSort(arrayToShow, 0, arrayToShow.length - 1);
        System.out.println(Arrays.toString(arrayToShow));
    }
}
