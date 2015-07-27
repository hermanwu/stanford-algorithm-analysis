import java.util.Arrays;

/**
 * Created by Herman on 7/26/2015.
 */
public class Sort {
    int[] unsortedArray;
    int[] sortedArray;

    public Sort(int[] importArray){
        this.unsortedArray = importArray;
    }

    public int[] Quicksort(){
        int[] returnArray = new int[]{3,6,1,4,5,2};
        QuicksortPartition(returnArray, 0, returnArray.length - 1);
        return returnArray;
    }

    public void QuicksortPartition(int[] inputArray, int leftIndex, int rightIndex){
        System.out.println(Arrays.toString(inputArray));
        if(leftIndex < rightIndex) {
            int i = leftIndex;
            int pivot = inputArray[leftIndex];
            i = i + 1;
            int j = i;
            while (j <= rightIndex) {
                if (inputArray[j] < pivot) {
                    swap(inputArray, j, i);
                    i = i + 1;
                }
                j = j + 1;
            }
            swap(inputArray, i - 1, leftIndex);
            QuicksortPartition(inputArray, leftIndex, i - 2);
            QuicksortPartition(inputArray, i, rightIndex);
        }
    }

    public void swap(int[] array, int indexA, int indexB){
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }

}
