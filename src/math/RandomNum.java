package math;

public class RandomNum {
    //4자리 랜덤 숫자 생성
    public static int[] randomNum() {
        int[] randomNum = new int[4];
        int i = 0;
        while (i < 4) {
            int num = (int) (Math.random() * 10);
            if (num != 0) {
                randomNum[i] = num;
                i++;
            }
        }
        return randomNum;
    }

    //랜덤 숫자 중복 확인
    public static boolean checkNum(int[] randomNum) {
        boolean check = true;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (randomNum[i] == randomNum[j]) {
                    check = false;
                }
            }
        }
        return check;
    }


    public static void main(String[] args) {
        int[] randomNum = randomNum();
        while (!checkNum(randomNum)) {
            randomNum = randomNum();
        }
        for (int i = 0; i < 4; i++) {
            System.out.print(randomNum[i]);
        }
    }
}
