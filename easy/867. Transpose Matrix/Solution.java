class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] transposed = new int[matrix[0].length][matrix.length];
        
        for(int r=0; r < matrix.length; r++) {
            for(int c=0; c < matrix[0].length; c++) {
                transposed[c][r] = matrix[r][c];
            }
        }
        
        return transposed;
    }
}
