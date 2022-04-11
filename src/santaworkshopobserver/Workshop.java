package santaworkshopobserver;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Workshop {
    private static final Queue<Toy> dollStash = new LinkedList<>();
    private static final Queue<Toy> bicycleStash = new LinkedList<>();

    public static void addDollsToStash(List<Toy> dolls) {
        dollStash.addAll(dolls);
    }

    public static void addBicyclesToStash(List<Toy> bicycles) {
        bicycleStash.addAll(bicycles);
    }

    public static Toy retrieveBicycle() {
        return bicycleStash.poll();
    }

    public static Toy retrieveDoll() {
        return dollStash.poll();
    }
}
