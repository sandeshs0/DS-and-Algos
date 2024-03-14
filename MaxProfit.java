// Implement algorithm to maximize your profit by choosing to buy and sale a stock in single
// day
public class MaxProfit {
    static void maxProfit(int price[]) {
        int maxProfit = 0;
        int buyPrice = 0;
        int sellPrice = 0;

        for (int i = 0; i < price.length; i++) {
            for (int j =0; j < price.length; j++) {
                int profit = price[j] - price[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                    buyPrice = price[i];
                    sellPrice = price[j];
                }
            }
        }
        // return new int[]{maxProfit, buyPrice, sellPrice};
        System.out.println("Max profit:"+maxProfit);
        System.out.println("Buy Price:"+ buyPrice);
        System.out.println("Selling Price:"+ sellPrice);
    }

    public static void main(String[] args) {
        int price[] = {100,  260, 310, 40, 535, 180};
        // int[] result = maxProfit(price);
        // int maxProfit = result[0];
        // int buyPrice = result[1];
        maxProfit(price);
        // int sellPrice = result[2];
        // System.out.println("Maximum Profit: " + maxProfit);
        // System.out.println("Buy Price: " + buyPrice);
        // System.out.println("Sell Price: " + sellPrice);
    }
}