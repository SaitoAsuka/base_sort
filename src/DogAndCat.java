import java.util.Queue;
/*问题：设计一个队列，可以使用系统队列
* 能够按顺序返回猫或者狗或者猫狗（以猫狗入队顺序）
* */
class animal{
    private String kind;
    private int num;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
public class DogAndCat {

    Queue<animal> dog;
    Queue<animal> cat;

    public void push(animal animal) {
        if (animal.getKind().equals("cat")) {
            cat.add(animal);
        } else if (animal.getKind().equals("dog")) {
            dog.add(animal);
        }
    }
    public void pollAll() {
        if (dog.peek().getNum() < cat.peek().getNum()) {
            dog.poll();
        } else {
            cat.poll();
        }
    }
}
