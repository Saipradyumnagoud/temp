import java.util.Scanner;

public class VermanCipher {
    public static void main(String[] args){
		Scanner ab=new Scanner(System.in);
		System.out.println("Enter the plane text: ");
		String text=ab.nextLine();
		System.out.println("Enter the key text: ");
		String key=ab.nextLine();
		if (key.length() < text.length()) {
            System.out.println("It is not possible"); 
        }
		char[] encrypted = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            encrypted[i] = (char)((((text.charAt(i) - 'a') ^ (key.charAt(i) - 'a')) % 25) + 'a');
        }
        System.out.print("Encrypted code: ");
        System.out.println(new String(encrypted));

        char[] decrypted = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            decrypted[i] = (char)((((encrypted[i] - 'a') ^ (key.charAt(i) - 'a')) % 25) + 'a');
        }
        System.out.print("Decrypted code: ");
        System.out.println(new String(decrypted));
	}
}
