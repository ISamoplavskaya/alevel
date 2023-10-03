public class HW2Task3 {
    public static void main(String[] args) {
        double a = 15;
        double b = -55;
        double c = 16.5;
        System.out.println(absMin(a,b,c));
    }
    public static double absMin(double a, double b, double c){
        double a1 = (a<0)? -a:a;
        double b1 = (b<0)? -b:b;
        double c1 = (c<0)? -c:c;
        if (a1<b1) {
            if (a1<c1) return a;
            else return c;
        }
        else return b;
    }
}
