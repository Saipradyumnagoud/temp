public class Hill3 {
    public static void main(String[] args){
		String plane="PAYMOREMONEY";
		int key[][]={{17,17,5},{21,18,6},{2,2,19}};
		int keyInverse[][]={{4,9,15},{15,17,6},{24,0,17}};
		int n=plane.length();
		
		int[] message = new int[n];
        for (int i = 0; i < n; i++) {
            message[i] = plane.charAt(i) - 'A';
        }
		int[] encryption = new int[n];
        for (int i = 0; i < n; i += 3) {
            encryption[i] = (key[0][0] * message[i] + key[0][1] * message[i + 1] + key[0][2] * message[i + 2]) % 26;
            encryption[i + 1] = (key[1][0] * message[i] + key[1][1] * message[i + 1] + key[1][2] * message[i + 2]) % 26;
            encryption[i + 2] = (key[2][0] * message[i] + key[2][1] * message[i + 1] + key[2][2] * message[i + 2]) % 26;
        }

		
		StringBuilder encryptionMessage = new StringBuilder();
        for (int i = 0; i < n; i++) {
            encryptionMessage.append((char)(encryption[i] + 'A'));
        }
		
		int[] messagedec = new int[n];
        for (int i = 0; i < n; i++) {
            messagedec[i] = encryptionMessage.charAt(i) - 'A';
        }
		
		
		int[] decryption = new int[n];
        for (int i = 0; i < n; i += 3) {
            decryption[i] = (keyInverse[0][0] * messagedec[i] + keyInverse[0][1] * messagedec[i + 1] + keyInverse[0][2] * messagedec[i + 2]) % 26;
            decryption[i + 1] = (keyInverse[1][0] * messagedec[i] + keyInverse[1][1] * messagedec[i + 1] + keyInverse[1][2] * messagedec[i + 2]) % 26;
            decryption[i + 2] = (keyInverse[2][0] * messagedec[i] + keyInverse[2][1] * messagedec[i + 1] + keyInverse[2][2] * messagedec[i + 2]) % 26;
        }
		StringBuilder decryptionMessage = new StringBuilder();
        for (int i = 0; i < n; i++) {
            decryptionMessage.append((char)(decryption[i] + 'A'));
        }
		System.out.println("Encryption messgae : " +encryptionMessage.toString());
		System.out.println("Decrypted message: " + decryptionMessage.toString());
	}
}
