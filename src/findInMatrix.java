public class findInMatrix {
    /*【题目】 给定一个有N*M的整型矩阵matrix和一个整数K，
    matrix的每一行和每一 列都是排好序的。实现一个函数，判断K 是否在matrix中。
    例如： 0   1   2   5 2   3   4   7 4   4   4   8 5   7   7   9 如果K为7，返回true；
    如果K为6，返 回false。 【要求】 时间复杂度为O(N+M)，额外空间复杂度为O(1)*/
    public static boolean find_key(int[][] matrix, int k) {
        int i=matrix.length-1;
        int y = 0;
        while (i >= 0) {
/*
            x=matrix[0][i]<k?i:i--;
*/
            if (matrix[0][i] > k) {
                i--;
            }else {
                y=i;
                break;
            }
        }
        int x=0;
        int j = 0;
        while (j < matrix.length) {
            if (matrix[j][y] < k) {
                j++;
            } else {
                x=j;
                break;
            }
            /*y=matrix[x][j]>k?j:j++;*/
        }
        System.out.println("横坐标为" + x);
        System.out.println("纵坐标为"+y);
        System.out.println(matrix[x][x]);
        if (matrix[x][y] == k) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 5}, {2, 3, 4, 7}, {4, 4, 4, 7}, {5, 7, 7, 9}};
        System.out.println("test");
        if (find_key(matrix, 4)) {
            System.out.println("在该矩阵中有该数");
        } else {
            System.out.println("在该矩阵中没有这个数");
        }
    }
}
