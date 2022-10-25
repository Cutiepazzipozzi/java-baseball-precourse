package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static int[] correctNum = new int[3];
    public static int[] playerNum = new int[3];
    public static int strikeNumber = 0;
    public static int ballNumber = 0;

    public static int[] createCorrectNumber() {
        for(int i=0; i<3; i++) {
            correctNum[i] = Randoms.pickNumberInRange(1, 9);
        }
        return correctNum;
    }

    public static boolean checkCorrectNum(String enterNum) {
        boolean setError = false;
        if(enterNum.length() != 3) setError = true;
        else if(enterNum.charAt(0) == enterNum.charAt(1)
                || enterNum.charAt(1) == enterNum.charAt(2)
                || enterNum.charAt(0) == enterNum.charAt(2)) setError = true;
        return setError;
    }

    public static int[] madeArr(String enterNum) {
        // 사용자로부터 입력받은 수를 한자리씩 배열로 받아옴
        int[] enterNumArr = new int[3];
        for(int i=0; i<3; i++) {
            enterNumArr[i] = Character.getNumericValue(enterNum.charAt(i));
        }
        return enterNumArr;
    }

    public static boolean findBallAndStrikeCal(int[] arr, int num) {
        boolean hasRepeat = false;
        for(int i=0; i<3; i++) {
            if(arr[i] == num) return true;
        }
        return hasRepeat;
    }

    public static void findBallAndStrike(int[] arr1, int[] arr2) {
        for(int i=0; i<3; i++) {
            if(findBallAndStrikeCal(arr1, arr2[i])) ballNumber++;
            if(arr1[i] == arr2[i]) strikeNumber++;
        }
        ballNumber -= strikeNumber;
    }

    public static void endOrRestart() {
        int answer = Integer.parseInt(Console.readLine());
        if(answer != 1 && answer != 2) throw new IllegalArgumentException("1과 2 중 하나만 입력해주세요!");

        if(answer == 1) Game();
        if(answer == 2) System.exit(0);
    }

    public static void tellResult() {
        if(ballNumber==0 && strikeNumber == 0) System.out.println("낫싱");
        else if(strikeNumber == 0) System.out.println(ballNumber+"볼");
        else if(ballNumber == 0) System.out.println(strikeNumber+"스트라이크");
        else if(strikeNumber > 0 && ballNumber > 0) System.out.println(ballNumber+"볼 " + strikeNumber + "스트라이크");
        else {
            System.out.println("3개의 숫자를 모두 맞히셨습니다 ! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            endOrRestart();
        }
    }

    public static void Game() {
        correctNum = createCorrectNumber();

        System.out.print("숫자를 입력해주세요 : ");
        if(checkCorrectNum(Console.readLine())) {
            throw new IllegalArgumentException("제대로 된 3자리 수를 입력해주세요!");
        }
        playerNum = madeArr(Console.readLine());
        //여기 일단 깔끔하게 고쳐보기
        findBallAndStrike(correctNum, playerNum);

        tellResult();
    }
    //재시작하거나 종료하는 코드 작성하기

    public static void main(String[] args) {
        Game();
    }
}
