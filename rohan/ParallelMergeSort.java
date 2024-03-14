import java.util.Arrays;

public class ParallelMergeSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        parallelMergeSort(arr, Runtime.getRuntime().availableProcessors());
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void parallelMergeSort(int[] arr, int numThreads) {
        if (numThreads <= 1) {
            mergeSort(arr);
        } else if (arr.length >= 2) {
            int mid = arr.length / 2;

            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);

            Thread leftSorter = parallelSort(left, numThreads);
            Thread rightSorter = parallelSort(right, numThreads);

            leftSorter.start();
            rightSorter.start();

            try {
                leftSorter.join();
                rightSorter.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            merge(left, right, arr);
        }
    }

    private static Thread parallelSort(int[] arr, int numThreads) {
        return new Thread(() -> parallelMergeSort(arr, numThreads / 2));
    }

    public static void mergeSort(int[] arr) {
        if (arr.length >= 2) {
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);

            mergeSort(left);
            mergeSort(right);

            merge(left, right, arr);
        }
    }

    public static void merge(int[] left, int[] right, int[] arr) {
        int leftLength = left.length;
        int rightLength = right.length;
        int i = 0, j = 0, k = 0;

        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < leftLength) {
            arr[k++] = left[i++];
        }

        while (j < rightLength) {
            arr[k++] = right[j++];
        }
    }
}
