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
    public static int[] madeArr(int EnterNum) {
        // 사용자로부터 입력받은 수를 한자리씩 배열로 받아옴
        return new int[]{EnterNum/100, (EnterNum/10)/10, EnterNum%10};
    }

    public static void main(String[] args) {

        correctNum = createCorrectNumber();
        playerNum = madeArr(Integer.parseInt(Console.readLine()));

    }
}
