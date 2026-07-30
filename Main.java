import java.util.*;

public class Main {

    static void floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];

        if (oldColor == newColor) {
            return;
        }

        dfs(image, sr, sc, oldColor, newColor);
    }

    static void dfs(int[][] image, int row, int col, int oldColor, int newColor) {

        if (row < 0 || col < 0 ||
            row >= image.length || col >= image[0].length ||
            image[row][col] != oldColor) {
            return;
        }

        image[row][col] = newColor;

        dfs(image, row + 1, col, oldColor, newColor);
        dfs(image, row - 1, col, oldColor, newColor);
        dfs(image, row, col + 1, oldColor, newColor);
        dfs(image, row, col - 1, oldColor, newColor);
    }

    public static void main(String[] args) {

        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        int sr = 1;
        int sc = 1;
        int color = 2;

        floodFill(image, sr, sc, color);

        for (int[] row : image) {
            System.out.println(Arrays.toString(row));
        }
    }
}