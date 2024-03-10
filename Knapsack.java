public class Knapsack {
    
  public int knapsack(int weight[], int profit[], int cap, int n){
    int dp[][]= new int[n+1][cap+1];

    for(int i=0;i<=n;i++){
        for(int w=0; w<=cap; w++){
            if(i==0 || w==0){
                dp[i][w]=0;
            }
            else if(weight[i-1]<=w){
                dp[i][w]= Math.max(dp[i-1][w],profit[i-1]+dp[i-1][w-weight[i-1]]);
            }
            else{
                dp[i][w]=dp[i-1][w];
            }
        }
    }
    return dp[n][cap];
  }


    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int profit[] = new int[] { 60, 100, 120 }; 
		int weight[] = new int[] { 10, 20, 30 }; 
        int capacity = 50;
        System.out.println("Maximum profit: " + ks.knapsack(weight, profit, capacity,profit.length));
    }
}
