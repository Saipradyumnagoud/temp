import java.util.Arrays;
import java.util.Scanner;

public class RailFence {
    public static void main(String[] agrs){
		Scanner ab=new Scanner(System.in);
		System.out.println("Enter the plane text : " );
		String pt=ab.nextLine();
		System.out.println("Enter the depth : ");
		int n = ab.nextInt();
		int m=pt.length();
		int[][] matrix=new int[n][m];
		for (int i=0; i<n;i++) {
            Arrays.fill(matrix[i], '-');
        }
		int row =0;
        boolean down =false;
        
        for (int i =0; i<m; i++) {
            matrix[row][i] = pt.charAt(i);
            
            if (row == 0 || row == n - 1) {
                down = !down;  
            }
            
            row = down ? row + 1 : row - 1;
        }
		System.out.println("Encrypted code is : ");
		
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(matrix[i][j]!= '-'){
					System.out.print((char)(matrix[i][j])+ " ");
				}
			}
		}
		
		System.out.println();
		int[][] decryption=new int[n][m];
		for(int i=0;i<n;i++){
			Arrays.fill(decryption[i],'-');
		}
		row = 0;
        down = false;
        for (int i = 0; i < m; i++) {
            if (matrix[row][i] != '-') {
                decryption[row][i] = matrix[row][i];
            }
            
            if (row == 0 || row == n - 1) {
                down = !down;
            }
            
            row = down ? row + 1 : row - 1;
        }
		System.out.println("Decrypted code is: ");
        row = 0;
        down = false;
        StringBuilder decryptedText = new StringBuilder();
        
        for (int i = 0; i < m; i++) {
            decryptedText.append((char) decryption[row][i]);
            
            if (row == 0 || row == n - 1) {
                down = !down;
            }
            
            row = down ? row + 1 : row - 1;
        }
        
        System.out.println(decryptedText.toString());
	}

}
