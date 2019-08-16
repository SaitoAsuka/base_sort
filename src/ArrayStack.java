public class ArrayStack {
    private Integer[] arr;
    private Integer index;
    private int initsize;

    public ArrayStack(int initsize) {
        this.initsize=initsize;
        if (initsize < 0) {
            /*非法参数抛出*/
            throw new IllegalArgumentException("该栈初始化大小小于0");
        }
        arr = new Integer[initsize];
        index = 0;
    }

    public Integer peek() {
        if (index == 0) {
            return null;
        }
        /*在栈结构中index会指向当前已有元素的下一个
        * 当要将栈中元素弹出时，弹出index-1指向的元素*/
        return arr[index-1];
    }
    public Integer pop(){
        if (index==0){
           throw  new ArrayIndexOutOfBoundsException("此栈为空");
        }
        return arr[--index];
    }
    public void push(Integer num){
        if (index>initsize){
            throw new ArrayIndexOutOfBoundsException("栈已满");
        }
        arr[index++]=num;
    }
}
