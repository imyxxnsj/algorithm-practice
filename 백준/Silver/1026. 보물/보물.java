import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(a);
        Arrays.sort(b);

        int answer = 0;

        for (int i = 0; i < n; i++) {
            answer = answer + (a[n - (i + 1)] * b[i]);
        }
        System.out.println(answer);
    }
}