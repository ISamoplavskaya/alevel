package ua.samoplavskaya.hw_thread.task2;

public class Main {
    public static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                counter++;
            }
        });
        thread.start();
        thread.join();
        System.out.println("Counter=" + counter);
    }
}
