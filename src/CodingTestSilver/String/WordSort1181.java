package CodingTestSilver.String;

import java.io.*;

public class WordSort1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] input = new String[n];

        for (int i = 0; i < n; i++) {
            input[i] = br.readLine();
        }

        String tmp;
        if (n != 1) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (input[i].length() == input[j].length()) {
                        if (compareString(input[i], input[j]) > 0) {
                            tmp = input[i];
                            input[i] = input[j];
                            input[j] = tmp;
                        }
                    } else if (input[i].length() > input[j].length()) {
                        tmp = input[i];
                        input[i] = input[j];
                        input[j] = tmp;
                    }
                }
            }
            int j = 1;
            for (int i = 0; i < n - 1; i++, j++) {
                tmp = input[j];
                if (j != n - 1 && !tmp.equals(input[i])) {
                    sb.append(input[i]).append('\n');
                } else if (j == n - 1) {
                    if (!tmp.equals(input[j - 1])) {
                        sb.append(input[i]).append('\n');
                        sb.append(input[j]).append('\n');
                    } else {
                        sb.append(input[j]).append('\n');
                    }
                }
            }
            System.out.print(sb);
        }
        else{
            System.out.println(input[0]);
        }
    }
    public static int compareString(String a, String b){
        int result = a.compareTo(b);
        return result;
    }
}