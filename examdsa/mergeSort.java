
public class mergeSort {
    public static void main(String[] args) {
        int[] arr={6,4,3,7,8};
        mergeSortAlgo(arr,0,arr.length);
        for(int i:arr){
            System.out.println(i);
        }
    }
    static void mergeSortAlgo(int[] arr, int s, int e){
        if(e-s==1){
            return;
        }
        int mid=(s+e)/2;
        mergeSortAlgo(arr, s, mid);
        mergeSortAlgo(arr, mid, e);
        merge(arr,s,mid,e);
    }
    static void merge(int[] arr, int s, int mid, int e){
        int[] mix= new int[e-s];
        int i=s;
        int j=mid;
        int k=0;
        while(i<mid && j<e){
            if(arr[i]<arr[j]){
                mix[k]=arr[i];
                i++;
            }
            else{
                mix[k]=arr[j];
                j++;
            }
            k++;
        }
        while(i<mid){
            mix[k]=arr[i];
            i++;
            k++;
        }
        while(j<e){
            mix[k]=arr[j];
            j++;
            k++;
        }
        for(int l=0;l<mix.length;l++){
            arr[s+l]=mix[l];
        }
    }
}
