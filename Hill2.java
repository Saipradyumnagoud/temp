public class Hill2 {
    public static void main(String[] args){
		//Scanner ab=new Scanner(System.in);
		//System.out.println("Enter the planeText : ");
		String plane="ATTACK";
		
		int key[][]={{2,3},{3,6}};
		int keyInverse[][]={{2,25},{25,18}};
		int n=plane.length();
		int[] message=new int[n];
		for(int i=0;i<n;i++){
			message[i]=plane.charAt(i)-'A';
		}
		int[] encryption=new int[n];
		for(int i=0;i<n;i+=2){
			encryption[i] = (key[0][0] * message[i] + key[0][1] * message[i + 1]) % 26;
            encryption[i + 1] = (key[1][0] * message[i] + key[1][1] * message[i + 1]) % 26;
		}
		
		
		StringBuilder encryptionmessgae=new StringBuilder();
		for(int i=0;i<n;i++){
			encryptionmessgae.append((char)(encryption[i]+'A'));
		}
		
		int[] messagedec=new int[n];
		for(int i=0;i<n;i++){
			messagedec[i]=encryptionmessgae.charAt(i)-'A';
		}
		
		
		int[] decryption=new int[n];
		for(int i=0;i<n;i+=2){
			decryption[i] = (keyInverse[0][0] * messagedec[i] + keyInverse[0][1] * messagedec[i + 1]) % 26;
            decryption[i + 1] = (keyInverse[1][0] * messagedec[i] + keyInverse[1][1] * messagedec[i + 1]) % 26;
		}
		StringBuilder decryptionMessage=new StringBuilder();
		for(int i=0;i<n;i++){
			decryptionMessage.append((char)(decryption[i]+'A'));
		}
		System.out.println("Encryption messgae : " +encryptionmessgae.toString());
		System.out.println("Decrypted message: " + decryptionMessage.toString());
	}
}
