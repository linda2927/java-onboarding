package onboarding;

import java.util.List;

class Problem1 {
    // main method for testing purposes
    public static void main(String[] args) {
        System.out.println(solution(List.of(97, 98), List.of(197, 198)));
        System.out.println(solution(List.of(131, 132), List.of(211, 212)));
        System.out.println(solution(List.of(99, 102), List.of(211, 212)));
        System.out.println(solution(List.of(1, 2), List.of(99, 100)));
    }

    public static int returnMax(int num) {
        String numStr = Integer.toString(num);
        int sum = 0;
        int mult = 1;

        for (int i = 0; i < numStr.length(); i++) {
            int currentNum = Integer.parseInt(String.valueOf(numStr.charAt(i)));
            sum += currentNum;
            mult *= currentNum;
        }
        return Integer.max(sum, mult);
    }

    public static boolean isValidList(List<Integer> numList) {
        if (numList.get(1) - numList.get(0) != 1) {
            return false;
        }
        return numList.get(0) % 2 == 1 || numList.get(1) % 2 == 0;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (!isValidList(pobi) || !isValidList(crong))
            return -1;

        int pobiMax = Integer.max(returnMax(pobi.get(0)), returnMax(pobi.get(1)));
        int crongMax = Integer.max(returnMax(crong.get(0)), returnMax(crong.get(1)));

        int answer = pobiMax > crongMax ? 1 : (pobiMax == crongMax ? 0 : 2);
        return answer;
    }
}