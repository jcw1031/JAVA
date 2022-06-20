package CodingTestBronze;

import java.util.*;

class Solution{
    public int[] solution(int N, int[] stages){
        double[] failure = new double[N];
        double[] arrival = new double[N];
        Arrays.fill(failure, 0);
        Arrays.fill(arrival, 0);

        for(int i=0;i<N;i++) {
            for(int j=0;j<stages.length;j++){
                if(i+1<=stages[j]){
                    arrival[i]++;
                }
            }
        }

        for(int i=0;i<stages.length;i++){
            if(stages[i]<N+1){
                failure[stages[i]-1]++;
            }
        }
        double max;
        int[] answer = {};
        for(int i=0;i<N;i++){
            failure[i]/=arrival[i];
        }
        max=failure[0];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(max<failure[j]){
                    max=failure[j];
                    answer[i]=j;
                }
            }
        }
        return answer;
    }
}