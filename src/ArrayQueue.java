public class ArrayQueue {
    private int start;
    private int end;
    private int[] arr;
    private int initsize;
    private int size = 0;

    public ArrayQueue(int initsize) {
        if (initsize < 0) {
            /*非法参数抛出*/
            throw new IllegalArgumentException("初始化大小小于零");
        }
        this.initsize = initsize;
        this.start = this.end = 0;
    }

    public Integer peek() {
        if (size == 0) {
//            throw new ArrayIndexOutOfBoundsException("该队列为空");
            return null;
        }
        return arr[start];
    }

    public  Integer poll() {
        if (size == 0) {
//            throw new ArrayIndexOutOfBoundsException("该队列为空");
            return null;
        }
        size--;
        int temp=start;
        start = nextIndex(arr.length, start);
        return arr[temp];
    }
    /*end和start需要循环，使用该方法进行判断*/
    public int nextIndex(int size,int index){
        /*如果index等于size-1(即数组最后一个下标）
        那么就返回0否则就返回index+1*/
        return index == size - 1 ? 0 : index + 1;
    }

}
