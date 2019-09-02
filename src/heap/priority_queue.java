package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/*优先级队列就是一个小根堆，如果需要转变为大根堆，通过设置比较器来完成*/
public class priority_queue {
    public static void main(String[] args) {
        PriorityQueue<Student> heap = new PriorityQueue<Student>(new StudentComparator());
        heap.add(new Student(5, 2));
    }
    public static class  StudentComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            if (o1.id < o2.id) {
                return -1;
            } else if (o1.id > o2.id) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}



class Student {
    int id;
    int age;

    public Student(int id, int age) {
        this.id = id;
        this.age = age;
    }
}
