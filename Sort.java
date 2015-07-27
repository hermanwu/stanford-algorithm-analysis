import java.util.Arrays;

/**
 * Created by Herman on 7/26/2015.
 */
public class Sort {
    int[] unsortedArray;
    int totalComparison;

    public Sort(int[] importArray){
        this.unsortedArray = importArray;
    }

    public int[] Quicksort(){
        totalComparison = 0;
        int[] returnArray = unsortedArray;
        QuicksortPartitionWithStartPivot(returnArray, 0, returnArray.length - 1);
        return returnArray;
    }

    public void QuicksortPartitionWithStartPivot(int[] inputArray, int leftIndex, int rightIndex){
        // if it is not a single array element
        if(leftIndex < rightIndex) {
            totalComparison = totalComparison + (rightIndex - leftIndex);
            int i = leftIndex;
            // setup the first item the pivot
            int pivot = inputArray[leftIndex];
            // i is used to track the first element that is bigger than pivot
            i = i + 1;
            // j is used to track new encountered element
            int j = i;
            // as long as j has not reached to the end of the array
            while (j <= rightIndex) {
                if (inputArray[j] < pivot) {
                    // when encounter an element that need to be moved to left part
                    // then swap this element with the first element that is biggere than pivot
                    swap(inputArray, j, i);
                    // i starts to track the next element that is bigger than pivot
                    i = i + 1;
                }
                // move to next new element
                j = j + 1;
            }
            // set pivot to the correct position
            swap(inputArray, i - 1, leftIndex);
            QuicksortPartitionWithStartPivot(inputArray, leftIndex, i - 2);
            QuicksortPartitionWithStartPivot(inputArray, i, rightIndex);
        }
    }

    public void QuicksortPartitionWithEndPivot(int[] inputArray, int leftIndex, int rightIndex) {
        if(leftIndex < rightIndex) {
            totalComparison = totalComparison + (rightIndex - leftIndex);
            swap(inputArray, leftIndex, rightIndex);
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
            QuicksortPartitionWithEndPivot(inputArray, leftIndex, i - 2);
            QuicksortPartitionWithEndPivot(inputArray, i, rightIndex);
        }
    }

    public void QuicksortPartitionWithMedianOfThreePivot(int[] inputArray, int leftIndex, int rightIndex){
        if(leftIndex < rightIndex) {
            totalComparison = totalComparison + (rightIndex - leftIndex);
            int pivotIndex = getIndexOfMedianOfThreePivot(inputArray, leftIndex, rightIndex);
            swap(inputArray, leftIndex, pivotIndex);
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
            QuicksortPartitionWithMedianOfThreePivot(inputArray, leftIndex, i - 2);
            QuicksortPartitionWithMedianOfThreePivot(inputArray, i, rightIndex);
        }
    }

    public void swap(int[] array, int indexA, int indexB){
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }

    public int getIndexOfMedianOfThreePivot(int[] inputArray, int left, int right){
        int leftEntry = inputArray[left];
        int rightEntry = inputArray[right];
        int medianEntry = inputArray[left + (right - left) / 2];
        if((leftEntry > rightEntry && leftEntry < medianEntry)
                || (leftEntry < rightEntry && leftEntry > medianEntry)){
            return left;
        }
        else if((rightEntry > leftEntry && rightEntry < medianEntry)
                || (rightEntry < leftEntry && rightEntry > medianEntry)){
            return right;
        }
        else{
            return left + (right - left) / 2;
        }
    }

}
