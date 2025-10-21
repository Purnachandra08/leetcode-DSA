class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] rowMax = new int[n];
        int[] colMax = new int[n];

        // Step 1: Find the maximum of each row and each column
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }

        // Step 2: Calculate the maximum possible increase
        int totalIncrease = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int newHeight = Math.min(rowMax[i], colMax[j]);
                totalIncrease += (newHeight - grid[i][j]);
            }
        }

        return totalIncrease;
    }
}
