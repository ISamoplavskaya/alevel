package ua.samoplavskaya.hw_concurrency2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class ProducerConsumer {
    private static final BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(5);

    public static void main(String[] args) {
        Thread producerThread = new Thread(() -> {
            while (true) {
                produce();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread consumerThread = new Thread(() -> {
            while (true) {
                consume();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            producerThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void produce() {
        int nextInt = ThreadLocalRandom.current().nextInt(100);
        System.out.println("Producer: " + nextInt + ", buffer size: " + buffer.size());
        try {
            buffer.put(nextInt);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void consume() {
        Integer item = null;
        try {
            item = buffer.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Consumer: " + item + ", buffer size: " + buffer.size());
    }
}
