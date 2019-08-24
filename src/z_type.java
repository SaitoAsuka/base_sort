public class z_type {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {7, 9, 5, 2}, {6, 8, 4, 2}, {6, 9, 3, 4}};
        run(matrix);
    }

    /*获取对角线上的值*/
    public static void get_diagonal(int[][] matrix, int row1, int row2, int col1, int col2, boolean fromup) {
        if (fromup) {
            while (row1 <= row2) {
                System.out.println(matrix[row1++][col1--]);
                if (col1 < 0) {
                    break;
                }
            }
        } else {
            while (row2 != row1 - 1) {
                System.out.println(matrix[row1--][col1++]);

                if (row1 < 0) {
                    break;
                }
            }
        }
    }

    /*遍历*/
    public static void run(int[][] matrix) {
        int row1 = 0;
        int col1 = 0;
        int row2 = 0;
        int col2 = 0;
        int endr = matrix.length - 1;
        int endc = matrix[0].length - 1;
        boolean fromup = false;
        while (row1 != endr + 1) {
            /*调用对角线方法*/
            get_diagonal(matrix, row1, row2, col1, col2, fromup);
            /*判断是否到底*/
            row1 = col1 == endc ? row1++ : row1;
            col1 = col1 != endc ? col1++ : col1;
            row2 = row2 != endr ? row2++ : row2;
            col2 = row2 == endr ? col2++ : col2;
            fromup = !fromup;

        }
    }
}
