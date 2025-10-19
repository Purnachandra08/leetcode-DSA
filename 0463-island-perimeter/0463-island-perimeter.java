class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    // Each land cell contributes 4 sides initially
                    perimeter += 4;

                    // Check top neighbor
                    if (i > 0 && grid[i - 1][j] == 1)
                        perimeter -= 2; // Shared edge removes 2 sides

                    // Check left neighbor
                    if (j > 0 && grid[i][j - 1] == 1)
                        perimeter -= 2;
                }
            }
        }

        return perimeter;
    }
}
