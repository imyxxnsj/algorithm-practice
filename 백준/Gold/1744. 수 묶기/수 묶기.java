import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean zeroFound = false;

        List<Integer> negative = new ArrayList<>();
        List<Integer> positive = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                zeroFound = true;
            } else if (num < 0) {
                negative.add(num);
            } else {
                positive.add(num);
            }
        }
        negative.sort(null);
        positive.sort(null);

        int answer = 0;

        if (negative.size() % 2 == 0) {
            for (int i = 0; i < negative.size(); i = i + 2) {
                answer = answer + (negative.get(i) * negative.get(i + 1));
            }
        } else if (zeroFound) {
            for (int i = 0; i < negative.size() - 1; i = i + 2) {
                answer = answer + (negative.get(i) * negative.get(i + 1));
            }
        } else {
            for (int i = 0; i < negative.size() - 1; i = i + 2) {
                answer = answer + (negative.get(i) * negative.get(i + 1));
            }
            answer = answer + negative.get(negative.size() - 1);
        }

        if (positive.size() % 2 == 0) {
            for (int i = 0; i < positive.size(); i = i + 2) {
                answer = answer + Math.max(positive.get(i) + positive.get(i + 1), positive.get(i) * positive.get(i + 1));
            }
        } else {
            for (int i = 1; i < positive.size() - 1; i = i + 2) {
                answer = answer + Math.max(positive.get(i) + positive.get(i + 1), positive.get(i) * positive.get(i + 1));
            }
            answer = answer + positive.get(0);
        }

        System.out.println(answer);
    }
}