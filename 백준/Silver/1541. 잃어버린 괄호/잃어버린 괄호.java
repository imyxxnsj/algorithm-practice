import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split("-");
        int answer = sum(input[0].split("\\+"));

        for (int i = 1; i < input.length; i++) {
            answer = answer - sum(input[i].split("\\+"));
        }

        System.out.println(answer);
    }

    public static int sum(String[] numbers) {
        int sum = 0;

        for (String number : numbers) {
            sum = sum + Integer.parseInt(number);
        }

        return sum;
    }
}