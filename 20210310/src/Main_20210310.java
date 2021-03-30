import java.util.InputMismatchException;
import java.util.Scanner;

public class Main_20210310 {
    public static void main(String[] args) {
        int tmp ;
        Players players = new Players();
        while ((tmp=op())!=-1){
            switch (tmp){
                case 1 : {
                    players.addPlayer();
                    break;
                }
                case 2 : {
                    players.removePlay();
                    break;
                }
                case 3 : {
                    players.getScore();
                    break;
                }
                case 4 : {
                    players.JudgeAll();
                    break;
                }
            }
        }
    }
    public static int op(){
        Scanner input = new Scanner(System.in);
        System.out.print("输入1添加选手\n输入2删除选手\n输入3输出选手得分\n输入4进行评分\n输入#退出程序\nPlease Input: ");
        int ret;
        try {
            ret = input.nextInt();
        } catch (InputMismatchException e){
            ret = -1;
        }
        return ret;
    }
}
