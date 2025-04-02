import java.util.Scanner;

public class PlayFair {

    static final int SIZE = 50;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str, keystr;

        System.out.print("Enter the key: ");
        keystr = sc.nextLine().toLowerCase();
        System.out.println("Key text: " + keystr);

        System.out.print("Enter the plain text: ");
        str = sc.nextLine().toLowerCase();;
        System.out.println("Plain text: " + str);

        playfairCrypt(str, keystr);

        sc.close();
    }

    public static void playfairCrypt(String str, String keystr) {
        char[][] keyT = new char[5][5];
        int ks = keystr.length();
        int ps = str.length();

        ks = removeSpaces(keystr, ks);
        ps = removeSpaces(str, ps);
        ps = prepare(str, ps);
        generateKeyTable(keystr, ks, keyT);
        encrypt(str, keyT, ps);
        str = toUpperCase(str, ps);

        System.out.println("Cipher text: " + str);
    }

    public static String toUpperCase(String encrypt, int ps) {
        StringBuilder sb = new StringBuilder(encrypt);
        for (int i = 0; i < ps; i++) {
            char c = encrypt.charAt(i);
            if (Character.isLowerCase(c)) {
                sb.setCharAt(i, Character.toUpperCase(c));
            }
        }
        return sb.toString();
    }

    public static int removeSpaces(String str, int ps) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ps; i++) {
            if (str.charAt(i) != ' ') {
                sb.append(str.charAt(i));
            }
        }
        return sb.length();
    }

    public static void generateKeyTable(String keystr, int ks, char[][] keyT) {
        boolean[] dicty = new boolean[26];
        dicty['j' - 'a'] = true;

        int j = 0;

        for (int i = 0; i < ks; i++) {
            char c = keystr.charAt(i);
            if (Character.isLowerCase(c) && !dicty[c - 'a']) {
                dicty[c - 'a'] = true;
                keyT[j / 5][j % 5] = c;
                j++;
            }
        }

        for (int k = 0; k < 26; k++) {
            if (!dicty[k]) {
                keyT[j / 5][j % 5] = (char) ('a' + k);
                j++;
            }
        }
    }

    public static int prepare(String str, int ptrs) {
        StringBuilder sb = new StringBuilder(str);
        int subs_s = ptrs;
        for (int i = 0; i < subs_s; i += 2) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.insert(i + 1, 'x');
                subs_s++;
            }
        }

        if (subs_s % 2 != 0) {
            sb.append('z');
            subs_s++;
        }

        return subs_s;
    }

    public static void search(char[][] keyT, char a, char b, int[] arr) {
        if (a == 'j') a = 'i';
        if (b == 'j') b = 'i';

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (keyT[i][j] == a) {
                    arr[0] = i;
                    arr[1] = j;
                }
                if (keyT[i][j] == b) {
                    arr[2] = i;
                    arr[3] = j;
                }
            }
        }
    }

    public static void encrypt(String str, char[][] keyT, int ps) {
        char[] encrypted = str.toCharArray();
        int[] a = new int[4];
        for (int i = 0; i < ps; i += 2) {
            search(keyT, encrypted[i], encrypted[i + 1], a);

            if (a[0] == a[2]) {
                encrypted[i] = keyT[a[0]][(a[1] + 1) % 5];
                encrypted[i + 1] = keyT[a[0]][(a[3] + 1) % 5];
            } else if (a[1] == a[3]) {
                encrypted[i] = keyT[(a[0] + 1) % 5][a[1]];
                encrypted[i + 1] = keyT[(a[2] + 1) % 5][a[3]];
            } else {
                encrypted[i] = keyT[a[0]][a[3]];
                encrypted[i + 1] = keyT[a[2]][a[1]];
            }
        }
        System.out.println("Encrypted text: " + new String(encrypted));
    }
}
