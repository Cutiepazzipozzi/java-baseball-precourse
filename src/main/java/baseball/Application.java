package baseball;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static int madeNumber(int num) {
        for(int i=0; i<3; i++) {
            num += Math.pow(10, 2-i)*pickNumberInRange(1,9);
        }
        return num;
    }
    public static void main(String[] args) {

        int CorrectNum = 0;
        int EnterNum = 0;

        madeNumber(CorrectNum);
        EnterNum = Integer.parseInt(readLine());
    }
}
