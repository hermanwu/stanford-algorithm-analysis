import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //Quicksort implementation;
        FileHandler fh = new FileHandler("src/inputFiles/QuickSort.txt");
        int[] quickSortArray = fh.convertToArray();
        System.out.println(Arrays.toString(quickSortArray));

        Sort sort =new Sort(quickSortArray);
        System.out.println(Arrays.toString(sort.Quicksort()));
    }
}
