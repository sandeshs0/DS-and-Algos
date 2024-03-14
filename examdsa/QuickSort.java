public class QuickSort {
    public static void main(String[] args) {
        int[] arr={3,1,5,2,8};
        sort(arr, 0, arr.length-1);
        for(int i: arr){
            System.out.println(i);
        }
    }
    static void sort(int[] arr, int low, int high){
        if(low<high){
            int pindx=partition(arr, low, high);

            sort(arr, low, pindx-1);
            sort(arr, pindx+1, high);
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot=arr[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        i++;
        int temp=arr[i];
        arr[i]=pivot;
        arr[high]=temp;
        return i;
    }
}
