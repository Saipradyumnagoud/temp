import java.util.Scanner;

public class DiffieHellman {

    public static int modExp(int a, int b, int q) {
        int result = 1;
        a = a % q;
        
        while (b > 0) {
            if (b % 2 == 1) {
                result = (result * a) % q;
            }
            b = b / 2;
            a = (a * a) % q;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner ab = new Scanner(System.in);

        System.out.println("Enter the prime number q and generator a: ");
        int q = ab.nextInt();
        int a = ab.nextInt();

        int xa = q - 1;  
        int xb = q - 2;  

        int ya = modExp(a, xa, q);  
        int yb = modExp(a, xb, q);  
        System.out.println("Alice's public key: " + ya);
        System.out.println("Bob's public key: " + yb);

        int secretA = modExp(yb, xa, q);  
        int secretB = modExp(ya, xb, q);  

        System.out.println("Shared secret computed by Alice: " + secretA);
        System.out.println("Shared secret computed by Bob: " + secretB);

        if (secretA == secretB) {
            System.out.println("Key exchange successful! Shared secret: " + secretA);
        } else {
            System.out.println("Key exchange failed!");
        }

        ab.close();
    }
}
