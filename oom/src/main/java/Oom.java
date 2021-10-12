import java.util.ArrayList;
import java.util.List;

public class Oom {
    public static void main(String[] args) {
        List<Brick> list = new ArrayList<Brick>();
        while (true){
            list.add(new Brick());
        }
    }
}
