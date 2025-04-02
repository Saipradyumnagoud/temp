
public class Ceaser {

    public static void main(String[] args) {
        String plane = "kill him tomorrow";
        int key = 3;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < plane.length(); i++) {
            char ch = plane.charAt(i);
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char) ((ch - base + key) % 26 + base);
            }
            ans.append(ch);
        }
        System.out.println(ans);
    }
}
