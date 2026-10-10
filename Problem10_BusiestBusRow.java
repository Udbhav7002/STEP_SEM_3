public class Problem10_BusiestBusRow {

    static class BusiestBusRow {
        public int[] busiestRow(int[][] grid) {
            int bestRow = 0;
            int maxTotal = -1;
            for (int i = 0; i < grid.length; i++) {
                int sum = 0;
                for (int val : grid[i]) sum += val;
                if (sum > maxTotal) {
                    maxTotal = sum;
                    bestRow = i;
                }
            }
            return new int[]{bestRow, maxTotal};
        }
    }

    public static void main(String[] args) {
        BusiestBusRow bbr = new BusiestBusRow();
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };
        int[] res = bbr.busiestRow(grid);
        System.out.println("Row " + res[0] + ", Total " + res[1]); // Expected: Row 1, Total 7
        System.out.println("---");
        int[][] grid2 = {
            {1, 2},
            {2, 1}
        };
        res = bbr.busiestRow(grid2);
        System.out.println("Row " + res[0] + ", Total " + res[1]); // Expected: Row 0, Total 3 (tie, smaller index)
        int[][] grid3 = {
            {0, 0, 0},
            {0, 0, 0}
        };
        res = bbr.busiestRow(grid3);
        System.out.println("Row " + res[0] + ", Total " + res[1]); // Expected: Row 0, Total 0
    }
}