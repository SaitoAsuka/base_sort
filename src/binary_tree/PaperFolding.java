package binary_tree;
/*折纸，打印一张纸条所有的折痕及其方向
* 例如折三下为：下下上 下 下上上*/
public class PaperFolding {
    public static void ProcessAll(int i, int N, boolean down) {

        Process(i,N,down);
    }

    public static void Process(int i,int N,boolean down) {
        if (i > N) {
            return;
        }
        Process(i+1, N, false);
        System.out.println(down ? "up" : "down");
        Process(i+1, N, true);
    }

    public static void main(String[] args) {
        int N = 3;
        ProcessAll(1,N,false);
    }
}
