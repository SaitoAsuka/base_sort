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
    public void pull(int obj){
        if (size==initsize){
            throw new ArrayIndexOutOfBoundsException("队列已满");
        }
        size++;
        /*在队列中插入元素时，元素进入end指向位置，随后end变化
        * 由于一开始就判断了队列是否为满
        * 所以此处仅需要调用nextIndex方法来判断end是自增还是跳到数组开头*/
        arr[end] = obj;
        end = nextIndex(arr.length, end);

    }
    /*end和start需要循环，使用该方法进行判断*/
    public int nextIndex(int size,int index){
        /*如果index等于size-1(即数组最后一个下标）
        那么就返回0否则就返回index+1*/
        return index == size - 1 ? 0 : index + 1;
    }

}
