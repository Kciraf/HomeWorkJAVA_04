import java.util.LinkedList;
import java.util.Random;

// Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

public class Exercise01 {
    
    public static LinkedList RndListCreate(int size, LinkedList<Integer> in) {
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            in.add(rnd.nextInt(100));
        }
        return in;
    }

    public static LinkedList ReverceList(LinkedList<Integer> in) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        for (Integer item : in) {
            result.addFirst(item);
        }
        return result;
    }
        
    public static void main(String[] args) {
        int asLarge = 11;
        LinkedList ourList = new LinkedList<Integer>();
        RndListCreate(asLarge, ourList);
        System.out.println(ourList);
        System.out.println(ReverceList(ourList));
    }
}
