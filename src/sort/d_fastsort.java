package sort;

public class d_fastsort {
    public static int[] partition(int[] arr, int L, int R){
        /*小于区是小于标记值的部分，大于区是大于标记值的部分
        * 荷兰国旗问题*/
        int less=L-1;
        /*小于区*/
        int more=R;
        /*正常来讲大于区是应该为R-1,为了避免标记值浮动，以及节省临时存储标记值的空间，此处最后有交换位置*/
        while (L<more){
            if (arr[L]<arr[R]){
                /*如果小于区右方元素小于标记值*/
                swap(arr,++less,L++);
                /*将小于区右方第一个元素与数组中左指针指的元素交换位置,交换位置后指针移动*/
            }else if (arr[L]>arr[R]){
                swap(arr,--more,L);
                /*交换位置后指针不移动*/
            }else if (arr[L]==arr[R]){
                L++;
            }
        }
        /*最后交换标记值和大于区最后一个元素的位置*/
        swap(arr,R,more);
        return new int[]{less+1,more};
        /*返回的是等于区的下标区间
        * 由于more和R交换过位置，所以原来应该为more-1的等于区右边界扩展到more*/
    }
    public static void swap(int[] arr,int L,int R){
        int temp;
        temp=arr[L];
        arr[L]=arr[R];
        arr[R]=temp;
    }
    public static void quickSort(int[] arr,int L,int R){
        if (L<R){
            swap(arr,L+(int)Math.random()*(R-L+1),R);
            int[]p =partition(arr,L,R);
            quickSort(arr,L,p[0]-1);
            quickSort(arr,p[1]+1,R);
        }
    }

    public static void main(String[] args) {
        int[] arr=new int[]{3,2,4,5,7,6,4};
/*        int[] re=partition(arr,0,arr.length-1);*/
        quickSort(arr,0,arr.length-1);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n");
  /*      System.out.println(re[0]);
        System.out.println(re[1]);
*/
    }
}
