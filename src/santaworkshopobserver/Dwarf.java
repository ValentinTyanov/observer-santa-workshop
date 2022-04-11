package santaworkshopobserver;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dwarf implements ObserverDwarf {
    private MagicBoard magicBoard;
    private boolean servedLastRequest = false;

    @Override
    public void setObservable(Observable observable) {
        if (observable instanceof MagicBoard) {
            this.magicBoard = (MagicBoard) observable;
        }
    }

    @Override
    public void update() {
        if (servedLastRequest) {
            servedLastRequest = false;
            return;
        }
        String toyToRetrieve = magicBoard.getNextToyInLine();
        Toy toyFromWorkshop;
        if (toyToRetrieve.equals(Toy.Type.BICYCLE)) {
            toyFromWorkshop = Workshop.retrieveBicycle();
        } else {
            toyFromWorkshop = Workshop.retrieveDoll();
        }
        if (null != toyFromWorkshop) {
            Santa.toyStash.add(toyFromWorkshop);
        }
        servedLastRequest = true;
    }

    @Override
    public void produceToys() {
        Workshop.addDollsToStash(Stream.of(new Doll(), new Doll(), new Doll(), new Doll())
                .collect(Collectors.toCollection(LinkedList::new)));
        Workshop.addBicyclesToStash(Stream.of(new Bicycle(), new Bicycle(), new Bicycle(), new Bicycle())
                .collect(Collectors.toCollection(LinkedList::new)));
    }
}
