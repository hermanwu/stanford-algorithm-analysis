import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        //Sort sort = new Sort(new int[]{2,5,6,3,4});

        //sort.Quicksort();
        FileHandler fh = new FileHandler("src/inputFiles/QuickSort.txt");
        int[] quickSortArray = fh.convertToArray();
        System.out.println(Arrays.toString(quickSortArray));

        Sort sort =new Sort(quickSortArray);
        System.out.println(Arrays.toString(sort.Quicksort()));
    }
}
