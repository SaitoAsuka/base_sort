package heap;

public class example_heap {
    public static void heapSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
    }

    /*堆化，用于排序*/
    public static void heapify(int[] arr, int heapSize) {
        int largest;
        int index = heapSize;
        while (index > 0) {
            largest = arr[index] > arr[index - 1] ? index : index - 1;
            largest = arr[(index - 1) / 2] > arr[largest] ? (index - 1) / 2 : largest;
            if (largest != arr[(index - 1) / 2]) {
                swap(arr, (index - 1) / 2, largest);
            }
            index = (index - 1) / 2 + 1;
        }

    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void swap(int[] arr, int x, int y) {
        int temp;
        temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
