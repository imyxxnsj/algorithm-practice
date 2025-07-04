import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] meeting = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            meeting[i][0] = Integer.parseInt(input[0]);
            meeting[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(meeting, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o2[0] - o1[0];
            }
        });

        int prev = meeting[0][0];
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (meeting[i][1] <= prev) {
                prev = meeting[i][0];
                count++;
            }
        }
        
        System.out.println(count);
    }
}