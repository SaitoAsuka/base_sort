package sort;

public class heap {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            /*将数组整理为大顶堆*/
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, heapSize - 1);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }


    }

    /*堆化
     * 将堆大小范围内的堆，大顶堆化
     * 即调整堆*/
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            /*找左右子树哪个更大*/
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            /*确定父节点与两个子节点中的最大值*/
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index) {
                /*堆顶是否为最大值*/
                break;
            }
            /*子节点比父节点大，交换子树和堆顶*/
            swap(arr, index, largest);
            /*到下一层，并更新左孩子*/
            index = largest;
            left = index * 2 + 1;
        }
    }

    /*该方法将堆变成大顶堆*/
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            /*子节点与父节点交换位置*/
            swap(arr, index, ((index - 1) / 2));
            /*标记值变为父节点*/
            index = (index - 1) / 2;

        }
    }

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {5, 7, 3, 8, 3, 9, 5, 4, 5, 5};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
