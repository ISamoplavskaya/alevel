public class HW2Task2 {
    public static void main(String[] args) {
        int num=15;
        System.out.println("Number " + num + checkEven(num));

    }
    public static String checkEven(int num) {
        return (num%2==0)? " is even":" is odd";
    }

}

