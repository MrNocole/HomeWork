import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Player implements Comparable<Player>{
    private ArrayList<Float> scores;
    String name ;
    Player(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input player's name : ");
        name = input.next();
        scores = new ArrayList<>();
    }
    public float getScore() {
        float sum = 0;
        Collections.sort(scores);
        for (int i = 1; i < scores.size() - 1; i++) {
            sum += scores.get(i);
        }
        return sum / ((float) scores.size() - 2);
    }
    public void addScore(float score){
        scores.add(score);
    }
    @Override
    public int compareTo(Player player) {
        return getScore()>player.getScore()?1:-1;
    }
}
