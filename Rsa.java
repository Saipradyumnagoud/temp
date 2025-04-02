
import java.math.BigInteger;
import java.util.*;

public class Rsa {

    public static void main(String[] args) {
        Scanner ab = new Scanner(System.in);
        System.out.println("Enter the 2 prime number : ");
        int p = ab.nextInt();
        int q = ab.nextInt();
        int n = p * q;
        int fiofn = (p - 1) * (q - 1);
        int e = 0;
        for (e = 2; e < fiofn; e++) {
            if (gcd(e, fiofn) == 1) {
                break;
            }
        }
        int d = dvalue(e, fiofn);
        System.out.println("Public Key (e, n): (" + e + ", " + n + ")");
        System.out.println("Private Key (d, n): (" + d + ", " + n + ")");
        BigInteger M = BigInteger.valueOf((n - 1));
        BigInteger N = BigInteger.valueOf(n);
        BigInteger E = BigInteger.valueOf(e);
        BigInteger encrypted = M.modPow(E, N);
        System.out.println("Encrypted Message: " + encrypted);
        BigInteger D = BigInteger.valueOf(d);
        BigInteger decrypted = encrypted.modPow(D, N);
        System.out.println("Decrypted Message: " + decrypted);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static int dvalue(int e, int fiofn) {
        int t1 = 0, t2 = 1;
        int t;
        int r, q;
        int num1 = fiofn, num2 = e;
        while (num2 != 0) {
            r = num1 % num2;
            q = num1 / num2;
            t = t1 - (q * t2);
            num1 = num2;
            num2 = r;
            t1 = t2;
            t2 = t;
        }
        return t1;
    }

}
