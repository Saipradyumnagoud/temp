
import java.util.*;

public class MultiplicativeInverse {

    public static void main(String[] args) {
        Scanner ab = new Scanner(System.in);
        System.out.println("Enter the 1st number : ");
        int num1 = ab.nextInt();
        System.out.println("Enter the 2nd number: ");
        int num2 = ab.nextInt();

        int t1 = 0, t2 = 1;
        int t;
        int r, q;
        while (num2 != 0) {
            r = num1 % num2;
            q = num1 / num2;
            t = t1 - (q * t2);
            num1 = num2;
            num2 = r;
            t1 = t2;
            t2 = t;
        }
        System.out.println("multiplicativeinverse is: " + t1);
    }
}
