public class KthMissingEven {

    public static int findMissingKthEven(int[] arr, int k) {
        int count = 0;
        int num = arr[0];
        
        for (int i = 0; i < arr.length; i++) {
            while (num < arr[i]) {
                count++;
                if (count == k) {
                    return num;
                }
                num += 2;
            }
            num += 2;
        }
        
        // If kth missing even is beyond the end of the array
        while (count < k) {
            count++;
            num += 2;
        }
        
        return num - 2;
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 10, 14};
        // int k = 1;
        System.out.println("The nd missing even number is: " + findMissingKthEven(arr, 5));
    }
}
