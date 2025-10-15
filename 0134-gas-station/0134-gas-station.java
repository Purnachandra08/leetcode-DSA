class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;     // Total gas - total cost
        int currentTank = 0;   // Current fuel in tank
        int startStation = 0;  // Potential start index

        for (int i = 0; i < gas.length; i++) {
            totalTank += gas[i] - cost[i];
            currentTank += gas[i] - cost[i];

            // If current tank is negative, can't start from previous stations
            if (currentTank < 0) {
                startStation = i + 1;  // Try next station as start
                currentTank = 0;       // Reset current tank
            }
        }

        // If total gas < total cost, circuit can't be completed
        return totalTank >= 0 ? startStation : -1;
    }
}
