import java.util.*;
public class VigenereCipher{
	public static void main(String[] args){
		Scanner ab=new Scanner(System.in);
		System.out.println("Enter the plane Text: ");
		String plane = ab.nextLine().toLowerCase();
		System.out.println("Enter the key: ");
		String key=ab.nextLine().toLowerCase();
		if (key.length() < plane.length()){
			StringBuilder extended=new StringBuilder(key);
				while(extended.length()<plane.length()){
					extended.append(key);
				}
			key=extended.toString();
		}
		char[] encrypted=new char[plane.length()];
		for(int i=0;i<plane.length();i++){
			encrypted[i] = (char) (((plane.charAt(i) - 'a') + (key.charAt(i) - 'a')) % 26 + 'a');
		}
		
		
		
		System.out.print("Encrypted code: ");
        System.out.println(new String(encrypted));
		
		char[] decryption = new char[plane.length()];
		for(int i=0;i<plane.length();i++){
			decryption[i] = (char) (((encrypted[i] - 'a') - (key.charAt(i) - 'a') + 26) % 26 + 'a');
		}
		
		System.out.println("Decrypted code: ");
		System.out.println(new String(decryption));
	}
}