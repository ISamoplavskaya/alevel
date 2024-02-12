package ua.samoplavskaya.hw_thread.task1;

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();

        Thread t2=new Thread(()-> {
            while(true) {
                System.out.println("Hello, A-Level 2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t2.start();
    }

}
class MyThread extends Thread {
    public void run() {
        while (true){
            System.out.println("Hello, A-Level");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}