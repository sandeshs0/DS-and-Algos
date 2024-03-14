import java.util.*;

public class TSP {
    static int[][] distance = {{0, 5, 10, 1},
                                {5, 0, 6, 12},
                                {10, 6, 0, 8},
                                {1, 12, 8, 0}};
    static int n = 4;
    static int allCityVisited = (1 << n) - 1;

    public static void main(String[] args) {
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[1 << n][n];

        List<Integer> shortestRoute = travellingSalesman(1, 0, ans, dp);

        // Adding the starting city to the end of the route
        shortestRoute.add(0);

        // Compute the shortest distance from the dp array
        int shortestDistance = dp[1][0]; // Starting from city 0 with bitmask 1 (representing that city 0 is visited)
        System.out.println("The shortest route to visit all the cities is: " + shortestRoute);
        System.out.println("The shortest distance is: " + shortestDistance);
    }

    public static List<Integer> travellingSalesman(int bitMask, int currCity, int ans, int[][] dp) {
        if (bitMask == allCityVisited) {
            List<Integer> route = new ArrayList<>();
            route.add(currCity); // End at current city
            // Store the distance from the last city back to the starting city
            dp[bitMask][currCity] = distance[currCity][0];
            return route;
        }

        if (dp[bitMask][currCity] != 0) {
            // If already computed, return stored result
            List<Integer> route = new ArrayList<>();
            route.add(dp[bitMask][currCity]);
            return route;
        }

        int shortestDistance = Integer.MAX_VALUE;
        List<Integer> shortestRoute = null;

        for (int city = 0; city < n; city++) {
            if ((bitMask & (1 << city)) == 0) {
                int newBitMask = bitMask | (1 << city);
                List<Integer> result = travellingSalesman(newBitMask, city, ans, dp);
                int distAns = distance[currCity][city] + dp[newBitMask][city]; // Cumulative distance

                if (distAns < shortestDistance) {
                    shortestDistance = distAns;
                    shortestRoute = new ArrayList<>(result);
                    shortestRoute.add(0, currCity); // Insert current city at the beginning
                }
            }
        }

        // Cache the result
        dp[bitMask][currCity] = shortestDistance;

        return shortestRoute;
    }
}
