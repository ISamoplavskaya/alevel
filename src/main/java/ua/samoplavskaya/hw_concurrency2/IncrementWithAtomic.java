package ua.samoplavskaya.hw_concurrency2;

import java.util.concurrent.atomic.AtomicInteger;

public class IncrementWithAtomic {
    private static AtomicInteger atomicInteger =new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            increment();
        });
        Thread thread2 = new Thread(() -> {
            increment();
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("Increment counter without synchronization: " + atomicInteger);
    }

    private static void increment() {
        for (int i = 0; i < 100_000; i++) {
            atomicInteger.incrementAndGet();
        }
    }
}
