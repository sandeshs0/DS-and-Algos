
public class MergeSortMT {
    public static void main(String[] args) {
        int[] array = {1, 5, 8, 3, 4, 9};

        mergeSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void mergeSort(int[] array) {

        int length = array.length;

        if (length <= 1) {
            return; 
        }

        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        for (int i = 0; i < middle; i++) {
            leftArray[i] = array[i];
        }
        for (int j = middle; j < length; j++) {
            rightArray[j - middle] = array[j];
        }

        Thread leftThread = new Thread(){
            public void run(){
                mergeSort(leftArray);
            }
        };
        Thread rightThread= new Thread(){
            public void run(){
                mergeSort(rightArray);
            }
        };
        leftThread.start();
        rightThread.start();
        merge(leftArray, rightArray, array);
    }

    public static void merge(int[] leftArray, int[] rightArray, int[] array) {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int i = 0; // Original array index
        int l = 0; // Left array index
        int r = 0; // Right array index

        while (l < leftSize && r < rightSize) {
            if (leftArray[l] <= rightArray[r]) {
                array[i] = leftArray[l];
                l++;
            } else {
                array[i] = rightArray[r];
                r++;
            }
            i++;
        }

        // Copy remaining elements of leftArray if any
        while (l < leftSize) {
            array[i] = leftArray[l];
            l++;
            i++;
        }

        // Copy remaining elements of rightArray if any
        while (r < rightSize) {
            array[i] = rightArray[r];
            r++;
            i++;
        }
    }
}