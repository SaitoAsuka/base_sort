import javax.swing.plaf.synth.SynthTableUI;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/*如代码所示，如果需要比较我们编写的类的属性
 * 需要定义一个比较器，该比较器使用系统的接口Comparator<>*/
public class comparator_example {
    public static void main(String[] args) {
        student a = new student("a", 12, 1);
        student b = new student("b", 13, 2);
        student c = new student("c", 14, 3);
        student[] students = {b, a, c};
        Arrays.sort(students, new student.idAscendingComparator());
    }
}

class student {
    public static class idAscendingComparator implements Comparator<student> {
        @Override
        public int compare(student o1, student o2) {
            return o1.id - o2.id;
        }}

    public static class indecendingComparator implements Comparator<student> {

        @Override
        public int compare(student o1, student o2) {
            return o2.id-o1.id;
        }
    }

    public String name;
    public int age;
    public int id;

    public student(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    /*比较器*/
}

