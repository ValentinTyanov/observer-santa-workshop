package santaworkshopobserver;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SantaWorkshopMain {
    public static void main(String[] args) {
        Santa santa = Santa.getInstance();
        MagicBoard board = MagicBoard.getInstance();
        ObserverDwarf dwarfOne = new Dwarf();
        ObserverDwarf dwarfTwo = new Dwarf();
        ObserverDwarf dwarfThree = new Dwarf();
        Set<ObserverDwarf> staff = Stream.of(dwarfOne, dwarfTwo, dwarfThree).collect(Collectors.toCollection(HashSet::new));

        for (ObserverDwarf dwarf : staff) {
            dwarf.produceToys();
        }

        board.subscribe(dwarfOne);
        board.subscribe(dwarfTwo);
        board.subscribe(dwarfThree);
        santa.subscribe(board);

        santa.requestToy("I need bicycles");
        santa.requestToy("I need bicycles");
        santa.requestToy("I need dolls");
        santa.requestToy("I need bicycles");
        santa.requestToy("I need dolls");

        santa.getSomeToysFromStash().forEach(
                toy -> {
                    if (toy instanceof Bicycle) {
                        toy.giveName("Magic Bike №" + toy.hashCode());
                    } else {
                        toy.giveName("Magic Doll №" + toy.hashCode());
                    }
                    System.out.printf("%s - This one has the potential to become one of my favorite toys!%n", toy.getName());
                }
        );
    }
}
