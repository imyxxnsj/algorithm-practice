import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int totalRecommend = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        List<Student> photo = new LinkedList<>();

        for (int i = 0; i < totalRecommend; i++) {
            int studentNo = Integer.parseInt(input[i]);
            boolean found = false;

            for (Student s : photo) {
                if (s.studentNo == studentNo) {
                    s.recommendCnt++;
                    found = true;
                    break;
                }
            }

            if (found) {
                continue;
            }

            if (photo.size() < n) {    // 자리 비어 있음
                photo.add(new Student(studentNo, i));
            } else {
                photo.sort((a, b) -> {
                    if (a.recommendCnt != b.recommendCnt) {
                        return a.recommendCnt - b.recommendCnt;    // 추천 적은 순
                    } else {
                        return a.recommendTime - b.recommendTime;    // 오래된 순
                    }
                });

                photo.remove(0);    // 최저 추천 & 오래된 학생 제거
                photo.add(new Student(studentNo, i));    // 새 학생 추가
            }
        }

        StringBuilder sb = new StringBuilder();

        photo.sort(Comparator.comparingInt(a -> a.studentNo));
        for (int i = 0; i < Math.min(n, photo.size()); i++) {
            sb.append(photo.get(i).studentNo).append(" ");
        }
        System.out.println(sb);
    }
}

class Student {
    int studentNo;
    int recommendCnt;
    int recommendTime;

    Student(int studentNo, int recommendTime) {
        this.studentNo = studentNo;
        this.recommendCnt = 1;
        this.recommendTime = recommendTime;
    }
}