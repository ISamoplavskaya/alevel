package ua.samoplavskaya.hw_concurrency2;

import java.util.concurrent.Semaphore;

public class IncrementWithSemaphore {
    private static int counter = 0;
    private static Semaphore semaphore = new Semaphore(1);
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
        System.out.println("Increment counter with semaphore: " + counter);
    }

    private static void increment() {
        for (int i = 0; i < 100_000; i++) {
            try {
                semaphore.acquire();
                counter++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                semaphore.release();
            }
        }
    }
}
