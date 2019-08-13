//import java.util.HashMap;
//import java.util.Map;
//import java.util.Random;
//
//class Hash_Map {
//    int size;
//    Map<String, Integer> A;
//    Map<Integer, String> B;
//
//    public Hash_Map(int size, Map<String, Integer> a, Map<Integer, String> b) {
//        this.size = size;
//        A = a;
//        B = b;
//    }
//
//    public int getSize() {
//        return size;
//    }
//
//    public void setSize(int size) {
//        this.size = size;
//    }
//
//    public Map<String, Integer> getA() {
//        return A;
//    }
//
//    public void setA(Map<String, Integer> a) {
//        A = a;
//    }
//
//    public Map<Integer, String> getB() {
//        return B;
//    }
//
//    public void setB(Map<Integer, String> b) {
//        B = b;
//    }
//
//    void insert(String string, int index) {
//        A.put(string, index);
//        B.put(index, string);
//    }
//
//    void delete(String string, int index) {
//
//        B.remove(index);
//        A.remove(string);
//        size--;
//        B.put(index,B.get(size-1));
//        A.put(B.get(size-1),index);
//        B.remove(size-1);
//        A.remove(string);
//
//    }
//
//    Map<Integer, String> getRandom() {
//        Random random = new Random();
//        int nextInt = random.nextInt(26);
//        B.get(nextInt);
//        return B;
//    }
////
////    public class Solution {
////        public static void main(String[] args) {
////
////            Map<Object, Object> A = new HashMap<>();
////            A.put()
////            new Hash_Map(26,)
////        }
////    }
////}
