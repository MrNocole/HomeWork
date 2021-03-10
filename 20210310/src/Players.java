import java.lang.reflect.Array;
import java.util.*;

public class Players {
    public static int judges;
    private HashMap<Integer, Player> map;
    Players(){
        Scanner input = new Scanner(System.in);
        map = new HashMap<>();
        System.out.print("Input judges cnt : ");
        int cnt = 0;
        try {
            cnt = input.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Input Error");
        }
        judges = cnt;
    }
    public void sortMap(){
        List<Player> list = new ArrayList<>(map.values());
        Collections.sort(list);
    }
    public void addPlayer(){
        map.put(map.size(),new Player());
        System.out.println("Player " + map.size() + " " + map.get(map.size()-1).name + "Added");
    }
    public void removePlay(){
        System.out.print("Input player's index to remove : ");
        Scanner input = new Scanner(System.in);
        int index = input.nextInt();
        map.remove(index);
    }
    public void JudgeAll(){
        Scanner input = new Scanner(System.in);
        float tmp ;
        for (int i = 1 ; i <= map.size() ; i ++){
            Player p = map.get(i-1);
            System.out.println("Judge player " + i + " name : " + p.name + " : ");
            for (int j = 0 ; j < judges ; j ++){
                tmp = input.nextFloat();
                p.addScore(tmp);
            }
        }
    }
    public void getScore(){
        ArrayList<Float> list = new ArrayList<>();
        sortMap();
        for (Player p : map.values()){
            System.out.println(p.getScore());
        }
    }
}
