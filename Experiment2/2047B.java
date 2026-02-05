import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {

    public static void calculate(int n, StringBuilder s) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        char maxChar = 0;
        char minChar = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= max) {
                max = entry.getValue();
                maxChar = entry.getKey();
            }
            if (entry.getValue() < min) {
                min = entry.getValue();
                minChar = entry.getKey();
            }
        }

        if (minChar == maxChar) {
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != maxChar) {
                    minChar = s.charAt(i);
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == minChar) {
                s.setCharAt(i, maxChar);
                break;
            }
        }

        System.out.println(s);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for (int i = 0; i < a; i++) {
            int n = sc.nextInt();
            StringBuilder s = new StringBuilder(sc.next());
            calculate(n, s);
        }
    }
}