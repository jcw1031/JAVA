import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        if(nums.length <= map.keySet().size()) return nums.length;
        else{
            return map.keySet().size();
        }
    }
}

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = new int[10];
        System.out.println(nums.length);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(3, 2);
        map.put(3, 1);
        map.put(4, 3);

        System.out.println(map.keySet().size());
    }
}