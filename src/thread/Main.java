package thread;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // Two threads modifying the same Counter object
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
            //    System.out.println("T1 >> " + i);
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
            //    System.out.println("T2 >> " + i);
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // Expected value is 2000, but the actual value may be less due to race condition
        System.out.println("Final Count: " + counter.getCount());
    }
}
