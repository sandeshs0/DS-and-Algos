public class MissingKthEven {
    
   public static int findMissing(int[] sortedArray, int k){
      int  count=0;
       int num=sortedArray[0];

       for(int i=0;i<sortedArray.length;i++){
            while (num<sortedArray[i]) {
                count++;
                if(count==k){
                    return num;
                }
                num+=2;
            }
            num+=2;
       }

       while (count<k) {
        count++;
        num+=2;
       }
       return num-2;

    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 10, 14};
        // int k = 1;
        System.out.println("The nd missing even number is: " + findMissing(arr, 3));

    }


}    
