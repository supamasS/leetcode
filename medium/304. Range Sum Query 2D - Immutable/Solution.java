class NumMatrix {
    int[][] sum;
    
    public NumMatrix(int[][] matrix) {
        sum = new int[matrix.length][matrix[0].length];
        
        // copy first row
        for(int c=0; c < matrix[0].length; c++) {
            sum[0][c] = matrix[0][c];
        }
        
        // sum over columns
        for(int r=0; r < matrix.length; r++) {
            sum[r][0] = matrix[r][0];
            for(int c=1; c < matrix[0].length; c++) {
                sum[r][c] = sum[r][c-1] + matrix[r][c];
            }
        }
        
        // sum over rows;
        for(int c=0; c < matrix[0].length; c++) {
            for(int r=1; r < matrix.length; r++) {
                sum[r][c] += sum[r-1][c];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sumR = sum[row2][col2];
        
        // subtract out the rows above
        if(row1 > 0)
            sumR -= sum[row1-1][col2];
        
        // subtract out the cols before
        if(col1 > 0)
            sumR -= sum[row2][col1-1];
        
        // add back the upper left corner that was subtracted out twice
        if(row1 > 0 && col1 > 0)
            sumR += sum[row1-1][col1-1];
        
        return sumR;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
