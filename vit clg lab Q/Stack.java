import java.util.Scanner;

public class Stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] vowel = new String[50];
        String[] conso = new String[50];
        int top1 = -1, top2 = -1;

        System.out.print("How many strings: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            String str = sc.next();

            char ch = str.charAt(0);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                top1++;
                vowel[top1] = str;
            } else {
                top2++;
                conso[top2] = str;
            }
        }

        System.out.println("\nVowel Stack");
        for (int i = top1; i >= 0; i--) {
            System.out.println(vowel[i]);
        }

        System.out.println("\nConsonant Stack");
        for (int i = top2; i >= 0; i--) {
            System.out.println(conso[i]);
        }
        sc.close();
    }
}