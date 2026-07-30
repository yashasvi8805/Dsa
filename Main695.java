import java.util.*;

public class Main695 {

    static int dfs(int[][] grid, int row, int col) {

        if (row < 0 || col < 0 ||
            row >= grid.length || col >= grid[0].length ||
            grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;

        int area = 1;

        area += dfs(grid, row + 1, col);
        area += dfs(grid, row - 1, col);
        area += dfs(grid, row, col + 1);
        area += dfs(grid, row, col - 1);

        return area;
    }

    static int maxArea(int[][] grid) {

        int max = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int[][] grid = {
            {0, 0, 1, 0},
            {1, 1, 1, 0},
            {0, 1, 0, 0},
            {0, 0, 0, 1}
        };

        System.out.println(maxArea(grid));
    }
}