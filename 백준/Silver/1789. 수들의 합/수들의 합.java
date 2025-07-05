import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long s = Long.parseLong(br.readLine());
        long sum = 0L;
        int num = 1;
        int answer = 0;

        while (sum < s) {
            sum = sum + num;
            answer++;
            num++;
        }

        if (sum == s) {
            System.out.println(answer);
        } else {
            System.out.println(answer - 1);
        }
    }
}