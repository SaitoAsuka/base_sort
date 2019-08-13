
class demo extends Thread {
    public void insertsort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
          /*内部每一项都和前一项已进行对比一直向前移动，直到第一位或者前面一个要比当前项要大*/
            for (int j = i - 1; arr[j] > arr[j + 1] && j >= 0; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
/*        demo demo = new demo();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (demo) {
                    System.out.println("当前调用demo对象锁的线程为：" + Thread.currentThread().getName());
                    try {
                        demo.start();
                        demo.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("退出同步代码块，当前调用demo对象锁的为：" + Thread.currentThread().getName());
                }
            }
        }
                , "thread_A"
        );
        thread.start();*/
        char[] Random = new char[10];
        for (int i = 0; i < 10; i++) {
            Random[i] = (char) (97 + Math.random() * 25);
        }
        System.out.println(Random);
    }
}