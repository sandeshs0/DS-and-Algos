public class Knapsack {
    
    // Method to solve the knapsack problem using dynamic programming
    public int knapsack(int weight[], int profit[], int cap, int n) {
        // Creating a 2D array to store the results of subproblems
        int dp[][] = new int[n + 1][cap + 1];

        // Iterating through each item and each possible capacity
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= cap; w++) {
                // If there are no items or the knapsack has no capacity, profit is 0
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                }
                // If the current item's weight can be accommodated in the knapsack
                else if (weight[i - 1] <= w) {
                    // Choose the maximum of either including the current item or excluding it
                    dp[i][w] = Math.max(dp[i - 1][w], profit[i - 1] + dp[i - 1][w - weight[i - 1]]);
                }
                // If the current item's weight exceeds the capacity, exclude it
                else {
                    dp[i][w] = dp[i - 1][w];
                }
            }

            // dp[i][w]= max(dp[i-1][w], profit[i-1][w]+dp[i-1][w-weight[i-1]])
        }
        // Return the maximum profit that can be obtained using the given capacity
        return dp[n][cap];
    }

    // Main method to test the knapsack algorithm
    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        // Example profits and weights of items
        int profit[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int capacity = 50; // Capacity of the knapsack
        // Calculate and print the maximum profit
        System.out.println("Maximum profit: " + ks.knapsack(weight, profit, capacity, profit.length));
    }
}
