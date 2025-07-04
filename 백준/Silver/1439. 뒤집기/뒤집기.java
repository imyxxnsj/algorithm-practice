import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(countOfAct(br.readLine()));
    }

    public static int countOfAct(String s) {
        char prev = s.charAt(0);
        int countZero = 0;
        int countOne = 0;

        if (prev == '0') {
            countZero++;
        } else {
            countOne++;
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != prev) {
                if (s.charAt(i) == '0') {
                    countZero++;
                } else {
                    countOne++;
                }
            }
            prev = s.charAt(i);
        }

        return Math.min(countZero, countOne);
    }
}