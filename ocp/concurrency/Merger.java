package concurrency;

import java.util.concurrent.CyclicBarrier;

/**
 * Just make sure that the object that calling the start method is a class that extends thread instead of one that implements runnable
 *
 */

class ItemProcessor extends Thread {
    CyclicBarrier cb;

    public ItemProcessor(CyclicBarrier cb) {
        this.cb = cb;
    }

    public void run() {
        System.out.println("processed");
        try {
            cb.await();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

public class Merger implements Runnable {

    public void run() {
        System.out.println("Value Merged");
    }


    public static void main(String[] args) throws Exception {
        Merger m = new Merger();

        CyclicBarrier cb = new CyclicBarrier(2, m);

        ItemProcessor ip = new ItemProcessor(cb);
        ip.start(); //LINE 4 cb.await();
    }
}