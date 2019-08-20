public class Circulant_matrix {
    public static void Circulant(int[][] matrix) {
        int row1;
        int col1;
        int row2;
        int col2;
        row1 = 0;
        row2 = matrix.length - 1;
        col1 = 0;
        col2 = matrix.length - 1;

        print(matrix, col1, col2, row1, row2);

    }

    public static void print(int[][] matrix, int col1, int col2, int row1, int row2) {
        int cur_row = row1;
        int cur_col = col1;
        if (col1 == col2 || row1 == row2) {
            while (cur_row != row2) {
                System.out.println(matrix[cur_row][cur_col]);
            }
        }
        if (col1 == col2 && row1 == row2) {
            System.out.println(matrix[col1][row1]);
        }/*判断越界*/ else if (row1 > row2 || col1 > col2) {
            return;/*跳出递归*/
        } else {
           /* for (int i = col1; i < col2; i++) {

                System.out.print(matrix[row1][i]);
            }
            for (int i = row1; i < row2; i++) {

                System.out.print(matrix[i][col2]);
            }
            for (int i = col2; i > col1; i--) {

                System.out.print(matrix[row2][i]);
            }
            for (int i = row2; i > row1; i--) {
                System.out.print(matrix[i][col1]);
            }
            System.out.println("\n");*/

            while (cur_col != col2) {
                int x = matrix[cur_row][cur_col];
                System.out.print(x + " ");
                cur_col++;
            }
            while (cur_row != row2) {
                int x = matrix[cur_row][cur_col];
                System.out.print(x + " ");
                cur_row++;
            }
            while (cur_col != col1) {
                int x = matrix[cur_row][cur_col];
                System.out.print(x + " ");
                cur_col--;
            }
            while (cur_row != row1) {
                int x = matrix[cur_row][cur_col];
                System.out.print(x + " ");
                cur_row--;
            }
        }
        row1++;
        col1++;
        row2--;
        col2--;
        /*递归调用*/
        print(matrix, col1, col2, row1, row2);

    }

    public static void main(String[] args) {
        int[][] matrix = {{5, 9, 7, 6}, {5, 2, 8, 3,}, {9, 7, 9, 8}, {3, 3, 4, 2}};
        Circulant(matrix);
    }
}
