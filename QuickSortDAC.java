public class QuickSortDAC {
    
    void sort(int array[], int start, int end){
        if(end<=start){//if end is less than start, it means there are no elements in the array.
            return;
        }
        int pivot= partition(array,start,end); // find the pivot element ko position
        sort(array, start, pivot-1); // divide to left
        sort(array, pivot+1, end); //divide and solve right
    }

    int partition(int a[], int start, int end){ //fn to move pointer and find out where to swap 
        int pivot=start; // start ma pivot
        int p=start;
        int q= end;

        while (p<q) { // until the p and q cross each other
            while (p<=end && a[p]<=a[pivot]) {  //until p reaches end and a[p] is less than pivot. if its greater we stop
                p++;
            }
            while (a[q]>a[pivot]) { // until the q is greater than pivot, if it is smaller or equal, we stopp
                q--;
            }
            if(p<q){ //if p and q did not cross
                swap(a,p,q); // then we swap p and q pointers
            }
        }
        swap(a,pivot,q); // if they crossed, means out of the loop, we finally swap the q and pivot and there we have pivot at right place.
            return q;
    }

    void swap(int array[], int a, int b){
            int temp= array[a];
            array[a]=array[b];
            array[b]=temp;
    }

    public static void main(String[] args) {
        QuickSortDAC qs= new QuickSortDAC();
        int[] array={4,9,10,8,1,3};
        qs.sort(array, 0, array.length-1);
        for(int i=0; i<=array.length-1;i++){
            System.out.print(array[i]+",");
        }
    }
}
