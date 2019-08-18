import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomPool {
    /*设计一种结构，在该结构中有以下三种功能
     * insert（key）将某个key加入到该结构中，做到不重复加入
     * delete（key） 将原本在结构中的某个key移除
     * getRandom()等概率随即返回结构中的任何一个key*/
    private int index = 0;
    HashMap<Integer, String> A = new HashMap<>();
    HashMap<String, Integer> B = new HashMap<>();

    public void insert(String value) {
        A.put(index, value);
        B.put(value, index);
        index++;
    }

    public void delete(String value) {
        /*删除目标value并将map的最后一个拿来填洞，并且index长度减小*/
        Integer temp_key = B.get(value);
        String last_value = A.get(index-1);
        System.out.println("这是该图最后的一个元素"+last_value);
        /*无需移除该key原来的value，如果插入的是相同key，后一个value会将前一个value覆盖掉*/
        A.put(temp_key, last_value);
        A.remove(index);
        B.put(value, temp_key);
        B.remove(last_value);
        index--;
    }

    public void getRandom() {
        int num = (int) (Math.random() * index);
        System.out.println(A.get(num));
    }

    public int getIndex() {
        return index;
    }

    public String getByKey(int index) {
        return A.get(index);
    }

    public static void main(String[] args) {
        RandomPool randomPool = new RandomPool();
        randomPool.insert("zuo");
        randomPool.insert("cheng");
        randomPool.insert("yun");
        randomPool.insert("Random");
        randomPool.insert("Pool");
        for (int i = 0; i < randomPool.getIndex(); i++) {
            System.out.println(randomPool.getByKey(i));
        }
        System.out.println("/*********************************/");
        randomPool.delete("Random");
        for (int i = 0; i < randomPool.getIndex(); i++) {
            System.out.println(randomPool.getByKey(i));
        }
        System.out.println("/*********************************/");

        randomPool.getRandom();
    }
}
